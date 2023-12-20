package com.project.quanlybanhang.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {

	private Long id;

	private Date createDate;
	
	private Date modifiedDate;
	
	private String createBy;
	
	private String modifiedBy;
}
