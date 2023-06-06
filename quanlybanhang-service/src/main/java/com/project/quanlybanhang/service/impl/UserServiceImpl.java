package com.project.quanlybanhang.service.impl;

import java.util.Arrays;
import java.util.Optional;

import com.project.quanlybanhang.entities.RoleEntity;
import com.project.quanlybanhang.model.UserPrinciple;
import com.project.quanlybanhang.model.UsersModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.quanlybanhang.entities.UserEntity;
import com.project.quanlybanhang.repository.UsersRepository;
import com.project.quanlybanhang.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Iterable<UserEntity> findAll() {
		return usersRepository.findAll();
	}

	@Override
	public Optional<UserEntity> findById(Long id) {
		return usersRepository.findById(id);
	}

	@Override
	public UserEntity save(UserEntity userEntity) {
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		return usersRepository.save(userEntity);
	}

	@Override
	public void remove(Long id) {
		usersRepository.deleteById(id);
	}

//	public UserServiceImpl(UsersRepository userRepository) {
//        super();
//        this.usersRepository = userRepository;
//    }

	@Override
	public UserEntity save(UsersModel usersModel) {
		UserEntity user = new UserEntity(
				usersModel.getUsername(),
				usersModel.getEmail(),
				usersModel.getFullName(),
		        passwordEncoder.encode(usersModel.getPassword()),
		        Arrays.asList(new RoleEntity("ROLE_USER")));
		        return usersRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<UserEntity> userEntity = usersRepository.findByUsername(username);

		if(!userEntity.isPresent()) {
			throw new UsernameNotFoundException("Sai username or password.");
		}
		return UserPrinciple.build(userEntity.get());
	}

	@Override
	public Optional<UserEntity> findByUsername(String username) {
		return usersRepository.findByUsername(username);
	}

}
