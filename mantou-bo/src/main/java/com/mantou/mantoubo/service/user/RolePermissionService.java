package com.mantou.mantoubo.service.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mantou.mantoubo.api.user.IRolePermissionService;
import com.mantou.mantoubo.basic.entity.identity.RolePermission;
import com.mantou.mantoubo.basic.mapper.identity.RolePermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lm
 * @title: RolePermissionService
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2123:08
 */
@Service
public class RolePermissionService extends ServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {

    @Autowired
    RolePermissionMapper mapper;

    @Override
    public int insert(RolePermission entity) {
        return mapper.insert(entity);
    }
}
