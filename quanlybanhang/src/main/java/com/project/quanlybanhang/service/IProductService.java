package com.project.quanlybanhang.service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.project.quanlybanhang.entities.ProductsEntity;
import com.project.quanlybanhang.model.ProductModel;

public interface IProductService {

	 List<ProductModel> findAll();
	 
	 public void save(ProductModel productModel, MultipartFile file, String pathFile) throws FileNotFoundException;
	 
	 ProductModel findById(Long id);

	void deleteById(Long[] id);
	
	Optional<ProductsEntity> getImageById(Long id);
	
	List<ProductModel> findAllProductByCategoryId(Long id);
	
	List<ProductModel> searchProduct(String keywordName);
}
