package com.project.quanlybanhang.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.project.quanlybanhang.common.StatusErrorCode;
import com.project.quanlybanhang.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.project.quanlybanhang.convert.ProductConvert;
import com.project.quanlybanhang.entities.CateProductEntity;
import com.project.quanlybanhang.entities.ProductsEntity;
import com.project.quanlybanhang.model.ProductModel;
import com.project.quanlybanhang.repository.CateProductRepository;
import com.project.quanlybanhang.repository.ProductRepository;
import com.project.quanlybanhang.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConvert productConvert;
	
	@Autowired
	private CateProductRepository cateProductRepository;
	
	@Override
	public List<ProductModel> findAll() throws BusinessException{

		List<ProductsEntity> productsEntity = productRepository.findAll();

		List<ProductModel> productModel = new ArrayList<ProductModel>();

		if(!CollectionUtils.isEmpty(productsEntity)){
			throw new BusinessException(StatusErrorCode.DATA_NOT_EXITS);
		}else{
			for (ProductsEntity entity : productsEntity) {
				ProductModel dto = new ProductModel();
				dto = productConvert.toDTO(entity);
				productModel.add(dto);
			}
			return productModel;
		}
	}

	@Override
	public void save(ProductModel productModel, MultipartFile file, String pathFile) throws FileNotFoundException {
		
		ProductsEntity productsEntity = new ProductsEntity();
		CateProductEntity cateProductEntity = cateProductRepository.findOneById(productModel.getCateId());
		
		if(productModel.getId() != null) {
			ProductsEntity oldProduct = productRepository.findOneById(productModel.getId());
			oldProduct.setCategoryId(cateProductEntity);
			productsEntity = productConvert.toEntity(productModel, oldProduct);
		}else {
			productsEntity = productConvert.toEntity(productModel);
			productsEntity.setCategoryId(cateProductEntity);
		}
		try {
			//Lưu tệp cục bộ
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(pathFile)));
			stream.write(file.getBytes());
			stream.close();
			byte[] imageData = file.getBytes();
			productsEntity.setImage(imageData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		productsEntity = productRepository.save(productsEntity);
	}

	@Override
	public ProductModel findById(Long id) {
		ProductsEntity productsEntity = productRepository.findOneById(id);
		return productConvert.toDTO(productsEntity);
	}

	@Override
	public void deleteById(Long[] ids) {
		for(long item : ids) {
			productRepository.deleteById(item);
		}
	}

	@Override
	public Optional<ProductsEntity> getImageById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public List<ProductModel> findAllProductByCategoryId(Long id) {
		List<ProductModel> listProduct = new ArrayList<ProductModel>();
		CateProductEntity category = cateProductRepository.findOneById(id);
		List<ProductsEntity> productsEntity = productRepository.findAllProductByCategoryId(category);
		for(ProductsEntity entity : productsEntity) {
			ProductModel productModel = productConvert.toDTO(entity);
			listProduct.add(productModel);
		}
		return listProduct;
	}

	@Override
	public List<ProductModel> searchProduct(String keywordName) {
		List<ProductModel> listProduct = new ArrayList<>();
		List<ProductsEntity> listProductEntity = productRepository.findByKeyWord(keywordName);
		for(ProductsEntity product : listProductEntity) {
			ProductModel productModel = new ProductModel();
			productModel = productConvert.toDTO(product);
			listProduct.add(productModel);
		}
		return listProduct;
	}

}
