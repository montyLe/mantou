package com.mantou.mantoubo.basic.mapper.identity;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mantou.mantoubo.basic.entity.identity.User;
import com.mantou.mantoubo.basic.entity.identity.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lm
 * @title: UserMapper
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2114:33
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    @Override
    int insert(User entity);

    @Override
    User selectOne(Wrapper<User> queryWrapper);

    @Override
    List<User> selectByMap(Map<String, Object> columnMap);

    User queryUserByName(String name);

    int addRoleForUser(UserRole entity);
}
