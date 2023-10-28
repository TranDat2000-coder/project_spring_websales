package com.project.quanlybanhang.service.impl;

import java.util.Collections;
import java.util.Optional;

import com.project.quanlybanhang.common.ErrorCode;
import com.project.quanlybanhang.entity.Role;
import com.project.quanlybanhang.exception.BusinessException;
import com.project.quanlybanhang.response.UserPrinciple;
import com.project.quanlybanhang.response.UserResponse;
import com.project.quanlybanhang.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.quanlybanhang.entity.User;
import com.project.quanlybanhang.repository.UsersRepository;
import com.project.quanlybanhang.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Iterable<User> findAll() {
		return usersRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		return usersRepository.findById(id);
	}

	@Override
	public User save(User userEntity) {
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		return usersRepository.save(userEntity);
	}

	@Override
	public void remove(Long id) {
		usersRepository.deleteById(id);
	}

	@Override
	public User save(UserResponse request) {

		User username = this.findByUsername(request.getUsername()).get();
		if(!username.getUsername().isEmpty()){
			throw new BusinessException(ErrorCode.USERNAME_EXITS);
		}

		Role roles = roleRepository.findByName("ROLE_ADMIN").get();
		if(!roles.getName().isEmpty()){
			throw new BusinessException(ErrorCode.ROLE_EXITS);
		}

		User user = User.builder()
				.username(request.getUsername())
				.email(request.getEmail())
				.fullName(request.getFullName())
				.password(passwordEncoder.encode(request.getPassword()))
				.roles(Collections.singleton(roles))
				.build();
		return usersRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> userEntity = usersRepository.findByUsername(username);

		if(!userEntity.isPresent()) {
			throw new UsernameNotFoundException("Sai username or password.");
		}
		return UserPrinciple.build(userEntity.get());
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return usersRepository.findByUsername(username);
	}

}
