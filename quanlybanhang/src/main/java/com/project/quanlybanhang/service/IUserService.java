package com.project.quanlybanhang.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.quanlybanhang.entities.UserEntity;

import java.util.Optional;

public interface IUserService extends IGeneralService<UserEntity>, UserDetailsService {

	Optional<UserEntity> findByUsername(String username);
}
