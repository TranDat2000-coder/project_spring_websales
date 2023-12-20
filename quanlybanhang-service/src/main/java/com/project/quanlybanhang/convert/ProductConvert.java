package com.project.quanlybanhang.convert;

import com.project.quanlybanhang.entity.Products;
import com.project.quanlybanhang.request.products.UpdateProductRequest;
import com.project.quanlybanhang.response.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductConvert {

    public ProductResponse convertToModel(Products products) {

        return ProductResponse.builder()
                .id(products.getId())
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

    }

    public Products convertToEntity(UpdateProductRequest dto) {

        return Products.builder()
                .namePhone(dto.getNamePhone())
                .price(dto.getPrice())
                .priceSale(dto.getPriceSale())
                .shortDiscription(dto.getShortDiscription())
                .description(dto.getDescription())
                .system(dto.getSystem())
                .cpu(dto.getCpu())
                .ram(dto.getRam())
                .memoryIn(dto.getMemoryIn())
                .capacityPin(dto.getCapacityPin())
                .build();

    }

    public Products dtoToEntity(UpdateProductRequest request, Products entity) {

        return entity = Products.builder()
                .namePhone(request.getNamePhone())
                .price(request.getPrice())
                .priceSale(request.getPriceSale())
                .shortDiscription(request.getShortDiscription())
                .description(request.getDescription())
                .system(request.getSystem())
                .cpu(request.getCpu())
                .ram(request.getRam())
                .memoryIn(request.getMemoryIn())
                .capacityPin(request.getCapacityPin())
                .build();

//        entity.setNamePhone(request.getNamePhone());
//        entity.setPrice(request.getPrice());
//        entity.setPriceSale(request.getPriceSale());
//        entity.setDescription(request.getDescription());
//        entity.setShortDiscription(request.getShortDiscription());
//        entity.setSystem(request.getSystem());
//        entity.setCpu(request.getCpu());
//        entity.setRam(request.getRam());
//        entity.setMemoryIn(request.getMemoryIn());
//        entity.setCapacityPin(request.getCapacityPin());

    }
}
