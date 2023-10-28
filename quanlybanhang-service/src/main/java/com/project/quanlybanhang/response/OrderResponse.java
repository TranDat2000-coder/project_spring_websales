package com.project.quanlybanhang.response;

import lombok.Data;

import java.util.Date;

@Data
public class OrderResponse extends BaseResponse {

    private Integer oderNum;

    private Double amount;

    private String customerEmail;

    private String customerName;

    private String customerPhone;

    private String customerAddress;

    private Date orderDate;
}
