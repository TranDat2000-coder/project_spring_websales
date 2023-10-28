package com.project.quanlybanhang.convert;

import com.project.quanlybanhang.request.products.GetProductRequest;
import com.project.quanlybanhang.request.products.UpdateProductRequest;
import org.springframework.stereotype.Component;

import com.project.quanlybanhang.entity.Products;
import com.project.quanlybanhang.response.ProductResponse;

@Component
public class ProductConvert {

	public ProductResponse convertToModel(Products products){
		ProductResponse response = ProductResponse.builder()
				.namePhone(products.getNamePhone())
				.shortDiscription(products.getShortDiscription())
				.description(products.getDescription())
				.price(products.getPrice())
				.priceSale(products.getPriceSale())
				.system(products.getSystem())
				.cpu(products.getCpu())
				.ram(products.getRam())
				.memoryIn(products.getMemoryIn())
				.capacityPin(products.getCapacityPin())
				.cateId(products.getCategoryId().getId())
				.build();
		return response;
		
	}
	
	public Products convertToEntity(UpdateProductRequest dto){
		
		Products entity = new Products();
		
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
	
	public Products toEntity(UpdateProductRequest dto, Products entity) {
		
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
