package com.mantou.mantoubo.basic.mapper.identity;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mantou.mantoubo.basic.entity.identity.Permission;
import org.springframework.stereotype.Repository;

/**
 * @author lm
 * @title: PermissionMapper
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2123:04
 */
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {
    @Override
    int insert(Permission entity);
}
