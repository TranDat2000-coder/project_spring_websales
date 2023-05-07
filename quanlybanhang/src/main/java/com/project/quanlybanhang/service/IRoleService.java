package com.project.quanlybanhang.service;

import com.project.quanlybanhang.entities.RoleEntity;

public interface IRoleService extends IGeneralService<RoleEntity>{

    RoleEntity findByName(String name);
}
