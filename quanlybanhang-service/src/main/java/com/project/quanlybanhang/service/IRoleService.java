package com.project.quanlybanhang.service;

import com.project.quanlybanhang.entity.Role;

public interface IRoleService extends IGeneralService<Role>{

    Role findByName(String name);
}
