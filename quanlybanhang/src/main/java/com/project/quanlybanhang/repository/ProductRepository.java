package com.project.quanlybanhang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.quanlybanhang.entities.CateProductEntity;
import com.project.quanlybanhang.entities.ProductsEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductsEntity, Long> {

	ProductsEntity findOneById(Long id);
	
	List<ProductsEntity> findAllProductByCategoryId(CateProductEntity cateProductEntity);
	
	@Query(value = "SELECT * FROM products p WHERE p.namephone like %?1%", nativeQuery = true)
	List<ProductsEntity> findByKeyWord(String keyword);
}
