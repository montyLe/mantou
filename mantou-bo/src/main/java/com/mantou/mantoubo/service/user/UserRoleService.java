package com.mantou.mantoubo.service.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mantou.mantoubo.api.user.IUserRoleService;
import com.mantou.mantoubo.basic.entity.identity.UserRole;
import com.mantou.mantoubo.basic.mapper.identity.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lm
 * @title: UserRoleService
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2122:54
 */
@Service
public class UserRoleService extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Autowired
    UserRoleMapper mapper;

    @Override
    public int insert(UserRole entity) {
        return mapper.insert(entity);
    }
}
