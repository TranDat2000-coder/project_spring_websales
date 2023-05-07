package com.project.quanlybanhang.repository;

import com.project.quanlybanhang.entities.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDetailEntity, Long> {
}
