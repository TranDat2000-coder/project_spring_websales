package com.project.quanlybanhang.controller.admin;

import com.project.quanlybanhang.response.common.ResponseData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController(value = "admin")
@RequestMapping("/admin")
public class HomeController {

	@GetMapping("/home")
	public ResponseData<?> index() {
		return new ResponseData().success("Chào mừng đến với trang quản trị dành cho quản trị viên");
	}
}
