package com.project.quanlybanhang.service;

import java.util.List;

import com.project.quanlybanhang.model.CateProductModel;

public interface ICateProductService {

	List<CateProductModel> findAll();
	
	public void addCategory(CateProductModel cateProductDTO);
	
	CateProductModel findById(Long id);
}
