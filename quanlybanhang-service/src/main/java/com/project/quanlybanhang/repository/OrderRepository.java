package com.project.quanlybanhang.repository;

import com.project.quanlybanhang.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDetail, Long> {
}
