package com.project.quanlybanhang.service;

import com.project.quanlybanhang.model.UsersModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.quanlybanhang.entities.UserEntity;

import java.util.Optional;

public interface IUserService extends IGeneralService<UserEntity>, UserDetailsService {

	Optional<UserEntity> findByUsername(String username);

	UserEntity save(UsersModel usersModel);
}
