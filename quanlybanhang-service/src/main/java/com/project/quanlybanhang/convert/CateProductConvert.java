package com.project.quanlybanhang.convert;

import org.springframework.stereotype.Component;

import com.project.quanlybanhang.entity.Category;
import com.project.quanlybanhang.response.CategoryResponse;

@Component
public class CateProductConvert {

	public CategoryResponse toDTO(Category entity) {
		
		CategoryResponse dto = new CategoryResponse();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setName(entity.getName());
		dto.setCode(entity.getCode());
		dto.setContent(entity.getContent());
		
		return dto;
		
	}
	
	public Category toEntity(CategoryResponse dto) {
		
		Category entity = new Category();
		entity.setName(dto.getName());
		entity.setCode(dto.getCode());
		entity.setContent(dto.getContent());
		
		return entity;
		
	}
	
	public Category toEntity(Category entity, CategoryResponse dto) {
		
		entity.setName(dto.getName());
		entity.setCode(dto.getCode());
		entity.setContent(dto.getContent());
		
		return entity;
		
	}
}
