package com.project.quanlybanhang.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.quanlybanhang.model.UsersModel;
import com.project.quanlybanhang.service.IUserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationAPI {

	@Autowired
	private IUserService userService;
	
	public UserRegistrationAPI(IUserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
	public UsersModel userDTO() {
		return new UsersModel();
	}
	
	@GetMapping
    public String showRegistrationForm() {
        return "registration";
    }
	
//	@PostMapping
//    public String registerUserAccount(@ModelAttribute UsersDTO usersDTO) {
//        userService.save(usersDTO);
//        return "redirect:/registration?success";
//    }
}
