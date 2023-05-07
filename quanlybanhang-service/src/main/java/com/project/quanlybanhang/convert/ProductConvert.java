package com.project.quanlybanhang.convert;

import org.springframework.stereotype.Component;

import com.project.quanlybanhang.entities.ProductsEntity;
import com.project.quanlybanhang.model.ProductModel;

@Component
public class ProductConvert {

	public ProductModel toDTO(ProductsEntity entity){
		
		ProductModel dto = new ProductModel();
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setNamePhone(entity.getNamePhone());
		dto.setPrice(entity.getPrice());
		dto.setPriceSale(entity.getPriceSale());
		dto.setDescription(entity.getDescription());
		dto.setShortDiscription(entity.getShortDiscription());
		dto.setSystem(entity.getSystem());
		dto.setCpu(entity.getCpu());
		dto.setRam(entity.getRam());
		dto.setMemoryIn(entity.getMemoryIn());
		dto.setCapacityPin(entity.getCapacityPin());
		dto.setCateId(entity.getCategoryId().getId());
		return dto;
		
	}
	
	public ProductsEntity toEntity(ProductModel dto){
		
		ProductsEntity entity = new ProductsEntity();
		
		entity.setNamePhone(dto.getNamePhone());
		entity.setPrice(dto.getPrice());
		entity.setPriceSale(dto.getPriceSale());
		entity.setDescription(dto.getDescription());
		entity.setShortDiscription(dto.getShortDiscription());
		entity.setSystem(dto.getSystem());
		entity.setCpu(dto.getCpu());
		entity.setRam(dto.getRam());
		entity.setMemoryIn(dto.getMemoryIn());
		entity.setCapacityPin(dto.getCapacityPin());
		return entity;
		
	}
	
	public ProductsEntity toEntity(ProductModel dto, ProductsEntity entity) {
		
		entity.setNamePhone(dto.getNamePhone());
		entity.setPrice(dto.getPrice());
		entity.setPriceSale(dto.getPriceSale());
		entity.setDescription(dto.getDescription());
		entity.setShortDiscription(dto.getShortDiscription());
		entity.setSystem(dto.getSystem());
		entity.setCpu(dto.getCpu());
		entity.setRam(dto.getRam());
		entity.setMemoryIn(dto.getMemoryIn());
		entity.setCapacityPin(dto.getCapacityPin());
		return entity;
		
	}
}
