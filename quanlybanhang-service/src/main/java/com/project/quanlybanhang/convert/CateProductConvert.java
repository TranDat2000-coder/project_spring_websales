package com.project.quanlybanhang.convert;

import org.springframework.stereotype.Component;

import com.project.quanlybanhang.entities.CateProductEntity;
import com.project.quanlybanhang.model.CateProductModel;

@Component
public class CateProductConvert {

	public CateProductModel toDTO(CateProductEntity entity) {
		
		CateProductModel dto = new CateProductModel();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setName(entity.getName());
		dto.setCode(entity.getCode());
		dto.setContent(entity.getContent());
		
		return dto;
		
	}
	
	public CateProductEntity toEntity(CateProductModel dto) {
		
		CateProductEntity entity = new CateProductEntity();
		entity.setName(dto.getName());
		entity.setCode(dto.getCode());
		entity.setContent(dto.getContent());
		
		return entity;
		
	}
	
	public CateProductEntity toEntity(CateProductEntity entity, CateProductModel dto) {
		
		entity.setName(dto.getName());
		entity.setCode(dto.getCode());
		entity.setContent(dto.getContent());
		
		return entity;
		
	}
}
