package com.project.quanlybanhang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.project.quanlybanhang.entity.Category;
import com.project.quanlybanhang.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

	Products findOneById(Long id);
	
	List<Products> findAllProductByCategoryId(Category cateProductEntity);
	
	@Query(value = "SELECT * FROM products p WHERE p.namephone like %?1%", nativeQuery = true)
	List<Products> findByKeyWord(String keyword);
}
