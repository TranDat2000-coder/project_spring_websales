package com.project.quanlybanhang.model;

import lombok.Data;

import java.util.Date;

@Data
public class OrderModel extends BaseModel{

    private Integer oderNum;

    private Double amount;

    private String customerEmail;

    private String customerName;

    private String customerPhone;

    private String customerAddress;

    private Date orderDate;
}
