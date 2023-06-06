package com.project.quanlybanhang.controller.admin;

import com.project.quanlybanhang.model.response.ResponseData;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.project.quanlybanhang.model.UsersModel;
import com.project.quanlybanhang.service.IUserService;

@RestController
@RequestMapping("/registration")
@AllArgsConstructor
public class UserRegistrationAPI {

	@Autowired
	private IUserService userService;
	
//	public UserRegistrationAPI(IUserService userService) {
//		super();
//		this.userService = userService;
//	}
//
//	@ModelAttribute("user")
//	public UsersModel userDTO() {
//		return new UsersModel();
//	}
//
//	@GetMapping
//    public String showRegistrationForm() {
//        return "registration";
//    }
	
	@PostMapping
    public ResponseData<?> registerUserAccount(@RequestBody UsersModel usersModel) {
        return new ResponseData<>().success(userService.save(usersModel));
    }
}
