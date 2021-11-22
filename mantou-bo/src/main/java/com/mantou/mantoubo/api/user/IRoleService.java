package com.mantou.mantoubo.api.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mantou.mantoubo.basic.entity.identity.Role;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author lm
 * @title: IRoleService
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2122:17
 */
public interface IRoleService extends IService<Role> {

    int insert(Role entity);

    Role queryRoleById(String id);
}
