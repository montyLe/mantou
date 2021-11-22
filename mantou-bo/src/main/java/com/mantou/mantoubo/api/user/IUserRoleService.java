package com.mantou.mantoubo.api.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mantou.mantoubo.basic.entity.identity.UserRole;

/**
 * @author lm
 * @title: IUserRoleService
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2122:52
 */
public interface IUserRoleService extends IService<UserRole> {
    int insert(UserRole entity);
}
