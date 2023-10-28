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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

	private final ProductRepository productRepository;
	
	@Autowired
	private ProductConvert productConvert;
	
	@Autowired
	private CateProductRepository cateProductRepository;

	@Override
	public List<ProductResponse> getProductList(GetProductRequest productRequest) {

		try {
			Pageable paging = PageRequest.of( Integer.parseInt(productRequest.getPageNo()) - 1, Integer.parseInt(productRequest.getPageSize()));
			Page<Products> pageResult = productRepository.findAll(paging);

			List<Products> product =  pageResult.getContent();

			List<ProductResponse> responses = product.stream()
					.map(products -> productConvert.convertToModel(products))
					.collect(Collectors.toList());

			return responses;
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
		return ProductResponse.builder()
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

	@Override
	public void save(UpdateProductRequest productRequest, MultipartFile file, String pathFile) throws FileNotFoundException {
		
		Products productsEntity = new Products();
		Category cateProductEntity = cateProductRepository.findOneById(productRequest.getCateId());
		
		if(productRequest.getId() != null) {
			Products oldProduct = productRepository.findOneById(productRequest.getId());
			oldProduct.setCategoryId(cateProductEntity);
			productsEntity = productConvert.toEntity(productRequest, oldProduct);
		}else {
			productsEntity = productConvert.convertToEntity(productRequest);
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
	public Optional<Products> getImageById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public List<ProductResponse> findAllProductByCategoryId(Long id) {
		List<ProductResponse> listProduct = new ArrayList<ProductResponse>();
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
			ProductResponse productModel = new ProductResponse();
			productModel = productConvert.convertToModel(product);
			listProduct.add(productModel);
		}
		return listProduct;
	}

}
