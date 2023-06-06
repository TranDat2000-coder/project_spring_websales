package com.project.quanlybanhang.model;

import lombok.Data;

@Data
public class UsersModel extends BaseModel {

	private String username;
	
	private String email;

	private String password;

	private String fullName;

	 public UsersModel() {
	 }

	public UsersModel(String username, String email, String fullName, String password) {
		 super();
		this.username = username;
		this.email = email;
		this.fullName = fullName;
		this.password = password;
	}
}
