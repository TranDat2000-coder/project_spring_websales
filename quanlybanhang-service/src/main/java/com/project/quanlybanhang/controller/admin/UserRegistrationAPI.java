package com.project.quanlybanhang.controller.admin;

import com.project.quanlybanhang.model.UsersModel;
import com.project.quanlybanhang.model.response.ResponseData;
import com.project.quanlybanhang.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
@AllArgsConstructor
public class UserRegistrationAPI {

	@Autowired
	private IUserService userService;

	@PostMapping
    public ResponseData<?> registerUserAccount(@RequestBody UsersModel usersModel) {
        return new ResponseData<>().success(userService.save(usersModel));
    }
}
