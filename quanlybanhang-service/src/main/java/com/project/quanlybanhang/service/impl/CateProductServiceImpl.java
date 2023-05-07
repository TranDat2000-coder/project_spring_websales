package com.project.quanlybanhang.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.quanlybanhang.convert.CateProductConvert;
import com.project.quanlybanhang.entities.CateProductEntity;
import com.project.quanlybanhang.model.CateProductModel;
import com.project.quanlybanhang.repository.CateProductRepository;
import com.project.quanlybanhang.service.ICateProductService;

@Service
public class CateProductServiceImpl implements ICateProductService {
	
	@Autowired
	private CateProductRepository cateProductRepository;
	
	@Autowired
	private CateProductConvert cateProductConvert;

	@Override
	public List<CateProductModel> findAll() {
		
		List<CateProductEntity> productCateEntity = cateProductRepository.findAll();
		List<CateProductModel> productCateDTO = new ArrayList<>();
		
		for (CateProductEntity entity : productCateEntity) {
			CateProductModel dto = new CateProductModel();
			dto = cateProductConvert.toDTO(entity);
			productCateDTO.add(dto);
		}
		return productCateDTO;
	}

	@Override
	public void addCategory(CateProductModel cateProductDTO) {
		CateProductEntity cateProductEntity = new CateProductEntity();
		cateProductEntity = cateProductConvert.toEntity(cateProductDTO);
		cateProductEntity = cateProductRepository.save(cateProductEntity);
	}

	@Override
	public CateProductModel findById(Long id) {
		CateProductEntity cateProductEntity = cateProductRepository.findOneById(id);
		return cateProductConvert.toDTO(cateProductEntity);
	}

}
