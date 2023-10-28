package com.project.quanlybanhang.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "web")
@RequestMapping("/TMDT/home")
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "web/home_index";
	}
}
