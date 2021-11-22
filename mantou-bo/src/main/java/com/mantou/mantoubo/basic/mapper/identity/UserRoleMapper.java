package com.mantou.mantoubo.basic.mapper.identity;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mantou.mantoubo.basic.entity.identity.UserRole;
import org.springframework.stereotype.Repository;

/**
 * @author lm
 * @title: UserRoleMapper
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2122:53
 */
@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {
    @Override
    int insert(UserRole entity);
}
