package com.project.quanlybanhang.response;

import lombok.Data;

import java.util.List;

@Data
public class CategoryResponse extends BaseResponse {
	
	private String name;
	
	private String code;
	
	private String content;
	
	private List<ProductResponse> lstProduct;
}
