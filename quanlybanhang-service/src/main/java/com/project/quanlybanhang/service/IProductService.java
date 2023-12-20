package com.project.quanlybanhang.service;

import com.project.quanlybanhang.entity.Products;
import com.project.quanlybanhang.request.products.GetProductRequest;
import com.project.quanlybanhang.request.products.UpdateProductRequest;
import com.project.quanlybanhang.response.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<ProductResponse> findAll(GetProductRequest productRequest);

    ProductResponse findById(Long id);

    void save(UpdateProductRequest productRequest, MultipartFile file, String pathFile) throws FileNotFoundException;

    void deleteById(Long[] id);

    Optional<Products> findImageById(Long id);

    List<ProductResponse> findAllProductByCategoryId(Long id);

    List<ProductResponse> searchProduct(String keywordName);
}
