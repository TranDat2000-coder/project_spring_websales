package com.project.quanlybanhang.model;

import com.project.quanlybanhang.entities.OrdersEntity;
import com.project.quanlybanhang.entities.ProductsEntity;
import lombok.Data;

@Data
public class OrderDetailModel extends BaseModel {

    private Double amount;

    private Double price;

    private Integer quanity;

    private OrdersEntity order;

    private ProductsEntity product;
}
