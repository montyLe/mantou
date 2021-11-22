package com.mantou.mantoubo.basic.mapper.identity;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mantou.mantoubo.basic.entity.identity.Role;
import com.mantou.mantoubo.basic.entity.identity.User;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author lm
 * @title: RoleMapper
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2122:22
 */
@Repository
public interface RoleMapper extends BaseMapper<Role> {

    @Override
    int insert(Role entity);

    Role queryRoleById(String id);
}
