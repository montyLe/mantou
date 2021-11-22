package com.mantou.mantoubo.basic.mapper.identity;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mantou.mantoubo.basic.entity.identity.RolePermission;
import org.springframework.stereotype.Repository;

/**
 * @author lm
 * @title: RolePermissionMapper
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2123:07
 */
@Repository
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

    @Override
    int insert(RolePermission entity);
}
