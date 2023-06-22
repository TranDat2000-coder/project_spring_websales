package com.project.quanlybanhang.controller.admin;

import com.project.quanlybanhang.model.response.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")
public class HomeAdminAPI {

	@GetMapping("/home")
	public ResponseData index() {
		return new ResponseData().success("Vào đây kooong");
	}
}
