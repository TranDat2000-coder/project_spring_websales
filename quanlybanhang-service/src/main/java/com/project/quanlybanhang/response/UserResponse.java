package com.project.quanlybanhang.response;

import lombok.Data;

@Data
public class UserResponse extends BaseResponse {

	private String username;
	
	private String email;

	private String password;

	private String fullName;

	 public UserResponse() {
	 }

	public UserResponse(String username, String email, String fullName, String password) {
		 super();
		this.username = username;
		this.email = email;
		this.fullName = fullName;
		this.password = password;
	}
}
