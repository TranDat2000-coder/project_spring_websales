package com.project.quanlybanhang.controller.admin;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import com.project.quanlybanhang.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.project.quanlybanhang.entities.ProductsEntity;
import com.project.quanlybanhang.model.ProductModel;
import com.project.quanlybanhang.repository.ProductRepository;
import com.project.quanlybanhang.service.ICateProductService;
import com.project.quanlybanhang.service.IProductService;
import com.project.quanlybanhang.utils.CommonConstant;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
@RestController
public class ProductsController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICateProductService cateProductService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping(value = "/danh-sach-san-pham")
	public ResponseData<?> listProduct(Model model) {
		List<ProductModel> results = productService.findAll();
		return new ResponseData().success(results);
	}
	
//	@GetMapping(value = "/san-pham")
//	public String product(Model model, @RequestParam(value = "id", required = false)Long id) {
//		ProductModel productModel = new ProductModel();
//		if(id != null) {
//			model.addAttribute("addProduct", productService.findById(id));
//		}
//		model.addAttribute("products", productModel);
//		model.addAttribute("listCategory", cateProductService.findAll());
//		return "admin/product/insert_product";
//	}
	
	@GetMapping(value = "/image/display/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public void showImage(@PathVariable("id") Long id, HttpServletResponse response, 
							Optional<ProductsEntity> productEntity) throws ServletException, IOException{
		productEntity = productService.getImageById(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(productEntity.get().getImage());
		response.getOutputStream().close();
	}
	
	@PostMapping(value = "/san-pham")
	public String insertProduct(Model model, @ModelAttribute ProductModel productModel,
											@RequestParam("file")MultipartFile file) {
		try {
			String rootPath = CommonConstant.root; //By default the image will be saved in this path
			String fileName = file.getOriginalFilename(); // Nó trả về tên thực của ảnh
			if(fileName == null || fileName.contains("..")) {
				model.addAttribute("invalid", "Sorry! Filename contains invalid path sequence \" + fileName");
				//return new ResponseEntity<>("Sorry! Filename contains invalid path sequence " + fileName, HttpStatus.BAD_REQUEST);
			}
			String pathFile = Paths.get(rootPath, fileName).toString();//Nó sẽ trả về vị trí chính xác trên hệ thống của chúng ta
			try {
				File dir = new File(rootPath);
				if(!dir.exists()) {
					//Folder created
					dir.mkdir();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			productService.save(productModel, file, pathFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/danh-sach-san-pham?success";
	}
	
	@PutMapping(value = "/san-pham/{id}")
	public String updateProduct(@RequestParam(value = "id")Long id,
								@RequestParam(value = "file")MultipartFile file,
								@ModelAttribute ProductModel productModel) {
		
		productModel.setId(id);
		try {
			productService.save(productModel, file, null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return "redirect:/admin/danh-sach-san-pham?success";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteProduct(@PathVariable Long[] id) {
		productService.deleteById(id);
		return "redirect:/admin/danh-sach-san-pham?success";
	}
	
	@PostMapping(value = "/search")
	public String searchProduct(Model model, @RequestParam("keyword")String keyword) {
		if(keyword != null) {
			model.addAttribute("listProduct", productService.searchProduct(keyword));
		}
		return "admin/product/list_products";
	}
}
