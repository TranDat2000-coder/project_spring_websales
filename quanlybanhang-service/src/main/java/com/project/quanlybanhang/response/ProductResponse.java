package com.project.quanlybanhang.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse extends BaseResponse {

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
