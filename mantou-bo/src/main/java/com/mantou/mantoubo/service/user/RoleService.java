package com.mantou.mantoubo.service.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mantou.mantoubo.api.user.IRoleService;
import com.mantou.mantoubo.api.user.IUserService;
import com.mantou.mantoubo.basic.entity.identity.Role;
import com.mantou.mantoubo.basic.entity.identity.User;
import com.mantou.mantoubo.basic.mapper.identity.RoleMapper;
import com.mantou.mantoubo.basic.mapper.identity.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lm
 * @title: RoleService
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2122:21
 */
@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    RoleMapper mapper;

    @Override
    public int insert(Role entity) {
        return mapper.insert(entity);
    }

    @Override
    public Role queryRoleById(String id) {
        return mapper.queryRoleById(id);
    }
}
