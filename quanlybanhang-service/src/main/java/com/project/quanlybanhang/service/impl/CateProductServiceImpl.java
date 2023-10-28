package com.project.quanlybanhang.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quanlybanhang.convert.CateProductConvert;
import com.project.quanlybanhang.entity.Category;
import com.project.quanlybanhang.response.CategoryResponse;
import com.project.quanlybanhang.repository.CateProductRepository;
import com.project.quanlybanhang.service.ICateProductService;

@Service
public class CateProductServiceImpl implements ICateProductService {
	
	@Autowired
	private CateProductRepository cateProductRepository;
	
	@Autowired
	private CateProductConvert cateProductConvert;

	@Override
	public List<CategoryResponse> findAll() {
		return cateProductRepository.findAll().stream()
				.map(category ->{
					CategoryResponse cateProductModel = new CategoryResponse();
					cateProductModel.setId(category.getId());
					cateProductModel.setName(category.getName());
					cateProductModel.setCode(category.getCode());
					cateProductModel.setContent(category.getContent());
					return cateProductModel;
				}).collect(Collectors.toList());
	}

	@Override
	public void addCategory(CategoryResponse cateProductDTO) {
		Category cateProductEntity = new Category();
		cateProductEntity = cateProductConvert.toEntity(cateProductDTO);
		cateProductEntity = cateProductRepository.save(cateProductEntity);
	}

	@Override
	public CategoryResponse findById(Long id) {
		Category cateProductEntity = cateProductRepository.findOneById(id);
		return cateProductConvert.toDTO(cateProductEntity);
	}

}
