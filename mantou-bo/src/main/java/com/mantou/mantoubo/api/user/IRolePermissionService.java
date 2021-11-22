package com.mantou.mantoubo.api.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mantou.mantoubo.basic.entity.identity.RolePermission;

/**
 * @author lm
 * @title: IRolePermissionService
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2123:03
 */
public interface IRolePermissionService extends IService<RolePermission> {
    int insert(RolePermission entity);
}
