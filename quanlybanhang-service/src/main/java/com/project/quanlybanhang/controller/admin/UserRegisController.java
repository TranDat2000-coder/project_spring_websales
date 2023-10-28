package com.project.quanlybanhang.controller.admin;

import com.project.quanlybanhang.response.UserResponse;
import com.project.quanlybanhang.response.common.ResponseData;
import com.project.quanlybanhang.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
@AllArgsConstructor
public class UserRegisController {

	@Autowired
	private IUserService userService;

	@PostMapping
    public ResponseData<?> registerUserAccount(@RequestBody UserResponse usersModel) {
        return new ResponseData<>().success(userService.save(usersModel));
    }
}
