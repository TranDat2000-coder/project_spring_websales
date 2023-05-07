package com.project.quanlybanhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.quanlybanhang.entities.CateProductEntity;

@Repository
public interface CateProductRepository extends JpaRepository<CateProductEntity, Long> {

	CateProductEntity findOneById(Long id);
}
