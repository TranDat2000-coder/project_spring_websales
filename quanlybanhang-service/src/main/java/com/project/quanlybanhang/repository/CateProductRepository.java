package com.project.quanlybanhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.quanlybanhang.entity.Category;

@Repository
public interface CateProductRepository extends JpaRepository<Category, Long> {

	Category findOneById(Long id);
}
