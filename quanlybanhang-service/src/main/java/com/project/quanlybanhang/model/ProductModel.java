package com.project.quanlybanhang.model;

import lombok.Data;

@Data
public class ProductModel extends BaseModel {

	private String namePhone;

	private byte[] image;

	private String shortDiscription; //Mô tả ngắn

	private String description;

	private Double price;

	private Double priceSale;

	private String system; //Hệ điều hành

	private String cpu;

	private Integer ram;

	private Integer memoryIn; //Bộ nhớ trong

	private Integer capacityPin; //Dung lượng pin

	private Long cateId;
}
