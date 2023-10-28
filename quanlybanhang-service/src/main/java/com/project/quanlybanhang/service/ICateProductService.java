package com.project.quanlybanhang.service;

import java.util.List;

import com.project.quanlybanhang.response.CategoryResponse;

public interface ICateProductService {

	List<CategoryResponse> findAll();
	
	public void addCategory(CategoryResponse cateProductDTO);
	
	CategoryResponse findById(Long id);
}
