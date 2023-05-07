package com.project.quanlybanhang.model;

import java.util.Date;

import lombok.Data;

@Data	
public class BaseModel {

	private Long id;

	private Date createDate;
	
	private Date modifiedDate;
	
	private String createBy;
	
	private String modifiedBy;
}
