package com.project.quanlybanhang.response;

import java.util.Date;

import lombok.Data;

@Data	
public class BaseResponse {

	private Long id;

	private Date createDate;
	
	private Date modifiedDate;
	
	private String createBy;
	
	private String modifiedBy;
}
