package com.project.quanlybanhang.service.impl;

import com.project.quanlybanhang.entities.RoleEntity;
import com.project.quanlybanhang.repository.RoleRepository;
import com.project.quanlybanhang.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Iterable<RoleEntity> findAll() {

        return roleRepository.findAll();
    }

    @Override
    public Optional<RoleEntity> findById(Long id) {

        return roleRepository.findById(id);
    }

    @Override
    public RoleEntity save(RoleEntity roleEntity) {

        return roleRepository.save(roleEntity);
    }

    @Override
    public void remove(Long id) {

        roleRepository.deleteById(id);
    }

    @Override
    public RoleEntity findByName(String name) {
        return roleRepository.findByName(name).get();
    }
}
