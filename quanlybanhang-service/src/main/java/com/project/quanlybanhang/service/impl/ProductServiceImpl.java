package com.project.quanlybanhang.service.impl;

import com.project.quanlybanhang.common.ErrorCode;
import com.project.quanlybanhang.convert.ProductConvert;
import com.project.quanlybanhang.entity.Category;
import com.project.quanlybanhang.entity.Products;
import com.project.quanlybanhang.exception.BusinessException;
import com.project.quanlybanhang.repository.CateProductRepository;
import com.project.quanlybanhang.repository.ProductRepository;
import com.project.quanlybanhang.request.products.GetProductRequest;
import com.project.quanlybanhang.request.products.UpdateProductRequest;
import com.project.quanlybanhang.response.ProductResponse;
import com.project.quanlybanhang.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

	private static final Logger log = LogManager.getLogger(ProductServiceImpl.class);

	private final ProductRepository productRepository;
	private final ProductConvert productConvert;
	private final CateProductRepository cateProductRepository;

	@Override
	public List<ProductResponse> findAll(GetProductRequest productRequest) {

		try {
			Pageable paging = PageRequest.of( Integer.parseInt(productRequest.getPageNo()) - 1, Integer.parseInt(productRequest.getPageSize()));
			Page<Products> pageResult = productRepository.findAll(paging);

			List<Products> product =  pageResult.getContent();

            return product.stream()
					.map(productConvert::convertToModel)
					.collect(Collectors.toList());

		}catch (DataAccessException e){
			throw new BusinessException(ErrorCode.DATA_NOT_EXITS);
		}
	}

	@Override
	public ProductResponse findById(Long id) {
		Products products = productRepository.findOneById(id);
		if(products == null){
			throw new BusinessException(ErrorCode.DATA_NOT_EXITS);
		}
		return productConvert.convertToModel(products);
	}

	@Override
	@Transactional
	public void save(UpdateProductRequest request, MultipartFile file, String pathFile) throws FileNotFoundException {
		
		Products productsEntity;
		Category category = cateProductRepository.findOneById(request.getCateId());
		
		if(request.getId() != null) {
			Products oldProduct = productRepository.findOneById(request.getId());
			oldProduct.setCategoryId(category);
			productsEntity = productConvert.dtoToEntity(request, oldProduct);
		}else {
			productsEntity = productConvert.convertToEntity(request);
			productsEntity.setCategoryId(category);
		}
		try {
			//Lưu tệp cục bộ
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(pathFile));
			stream.write(file.getBytes());
			stream.close();
			byte[] imageData = file.getBytes();
			productsEntity.setImage(imageData);
		} catch (Exception e) {
			log.info("Exception save product: ", e);
		}
		
		productRepository.save(productsEntity);
	}

	@Override
	@Transactional
	public void deleteById(Long[] ids) {
		try {
			for(long id : ids) {
				productRepository.deleteById(id);
			}
		}catch (EmptyResultDataAccessException e){
			throw new BusinessException(ErrorCode.DATA_NOT_EXITS);
		}
	}

	@Override
	public Optional<Products> findImageById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public List<ProductResponse> findAllProductByCategoryId(Long id) {
		List<ProductResponse> listProduct = new ArrayList<>();
		Category category = cateProductRepository.findOneById(id);
		List<Products> productsEntity = productRepository.findAllProductByCategoryId(category);
		for(Products entity : productsEntity) {
			ProductResponse productModel = productConvert.convertToModel(entity);
			listProduct.add(productModel);
		}
		return listProduct;
	}

	@Override
	public List<ProductResponse> searchProduct(String keywordName) {
		List<ProductResponse> listProduct = new ArrayList<>();
		List<Products> listProductEntity = productRepository.findByKeyWord(keywordName);
		for(Products product : listProductEntity) {
			ProductResponse productModel = productConvert.convertToModel(product);
			listProduct.add(productModel);
		}
		return listProduct;
	}

}
