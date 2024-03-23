package com.project.quanlybanhang.controller.admin;

import com.project.quanlybanhang.response.common.ResponseData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "http://localhost:3006")
@RequestMapping("/admin")
public class HomeController {

	@GetMapping(value = "/home")
	public ResponseData<?> index() {
		return new ResponseData().success("Chào mừng đến với trang quản trị dành cho quản trị viên");
	}
}
