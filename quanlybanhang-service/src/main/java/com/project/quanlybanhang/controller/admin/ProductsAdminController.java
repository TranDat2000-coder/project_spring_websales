package com.project.quanlybanhang.controller.admin;


import com.project.quanlybanhang.common.ErrorCode;
import com.project.quanlybanhang.entity.Products;
import com.project.quanlybanhang.exception.BusinessException;
import com.project.quanlybanhang.repository.ProductRepository;
import com.project.quanlybanhang.request.products.ProductRequest;
import com.project.quanlybanhang.request.products.UpdateProductRequest;
import com.project.quanlybanhang.response.ProductResponse;
import com.project.quanlybanhang.response.common.ResponseData;
import com.project.quanlybanhang.service.ICateProductService;
import com.project.quanlybanhang.service.IProductService;
import com.project.quanlybanhang.utils.CommonConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.tools.FileObject;
import javax.validation.Valid;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/admin")
public class ProductsAdminController {

    private final IProductService productService;

    @Autowired
    private ICateProductService cateProductService;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping(value = "/list-products")
    public ResponseData<List<ProductResponse>> listProduct(HttpServletResponse response,
                                                           @RequestBody @Valid ProductRequest productRequest) {

        List<ProductResponse> results = productService.findAll(productRequest);
        return new ResponseData().success(results);
    }

    @GetMapping(value = "/image/display/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void showImage(@PathVariable("id") Long id,
                                    HttpServletResponse response,
                                    Optional<Products> productEntity) throws IOException {
        productEntity = productService.findImageById(id);
        response.setContentType("image/jpg");
        response.getOutputStream().write(productEntity.get().getImage());
        response.getOutputStream().close();
    }

    @PostMapping(value = "/insert-product", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseData<?> insertProduct(@RequestBody UpdateProductRequest productRequest,
                                         @RequestParam("file") MultipartFile file) {
        try {
            String rootPath = CommonConstant.root; //By default, the image will be saved in this path
            String fileName = file.getOriginalFilename(); // Nó trả về tên thực của ảnh
            if (fileName == null || fileName.contains("..")) {
                throw new BusinessException(ErrorCode.INPUT_FILE_INVALID);
            }
            String pathFile = Paths.get(rootPath, fileName).toString();//Nó sẽ trả về vị trí chính xác trong hệ thống của chúng ta
            try {
                File dir = new File(rootPath);
                if (!dir.exists()) {
                    //Folder created
                    dir.mkdir();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            productService.save(productRequest, file, pathFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseData<>().success("Success!");
    }

    @PutMapping(value = "/update-product/{id}")
    public ResponseData<?> updateProduct(@RequestParam(value = "id") Long id,
                                         @RequestParam(value = "file") MultipartFile file,
                                         @RequestBody UpdateProductRequest productRequest) {

        productRequest.setId(id);
        try {
            productService.save(productRequest, file, null);
        } catch (FileNotFoundException e) {
            throw new BusinessException(ErrorCode.FILE_NOT_FOUND);
        }
        return new ResponseData<>().success("Success!");
    }

    @DeleteMapping(value = "/delete")
    public ResponseData<?> deleteProduct(@RequestParam(value = "id") Long[] id) {
        productService.deleteById(id);
        return new ResponseData<>().success("Delete success!");
    }

    @PostMapping(value = "/search")
    public ResponseData<List<ProductResponse>> searchProduct(@RequestParam("keyword") String keyword) {
        List<ProductResponse> response = null;
        if (keyword != null) {
            response = productService.searchProduct(keyword);
        }
        return new ResponseData().success(response);
    }
}