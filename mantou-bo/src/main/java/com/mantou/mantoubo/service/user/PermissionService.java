package com.mantou.mantoubo.service.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mantou.mantoubo.api.user.IPermissionService;
import com.mantou.mantoubo.basic.entity.identity.Permission;
import com.mantou.mantoubo.basic.mapper.identity.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lm
 * @title: PermissionService
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2123:05
 */
@Service
public class PermissionService extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Autowired
    PermissionMapper mapper;

    @Override
    public int insert(Permission entity) {
        return mapper.insert(entity);
    }
}
