package com.project.quanlybanhang.service;

import com.project.quanlybanhang.response.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.quanlybanhang.entity.User;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {

	Optional<User> findByUsername(String username);

	User save(UserResponse usersModel);
}
