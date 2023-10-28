package com.project.quanlybanhang.response;

import com.project.quanlybanhang.entity.Orders;
import com.project.quanlybanhang.entity.Products;
import lombok.Data;

@Data
public class OrderDetailResponse extends BaseResponse {

    private Double amount;

    private Double price;

    private Integer quanity;

    private Orders order;

    private Products product;
}
