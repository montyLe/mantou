package com.mantou.mantoubo.api.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mantou.mantoubo.basic.entity.identity.Permission;

/**
 * @author lm
 * @title: IPermissionService
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2123:02
 */
public interface IPermissionService extends IService<Permission> {
    int insert(Permission entity);
}
