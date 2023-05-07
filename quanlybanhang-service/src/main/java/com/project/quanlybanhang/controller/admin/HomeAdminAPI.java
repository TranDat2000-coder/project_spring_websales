package com.project.quanlybanhang.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeAdminAPI {
	
	@GetMapping("/login")
    public String login() {
        return "login";
    }

	@GetMapping("/admin")
	public String index() {
		return "admin/admin_index";
	}
}
