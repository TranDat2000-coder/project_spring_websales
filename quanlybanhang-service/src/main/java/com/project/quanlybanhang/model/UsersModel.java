package com.project.quanlybanhang.model;

import lombok.Data;

@Data
public class UsersModel extends BaseModel {

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	 public UsersModel() {
	 }
	 public UsersModel(String firstName, String lastName, String email, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
