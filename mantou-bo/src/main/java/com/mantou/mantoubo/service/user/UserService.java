package com.mantou.mantoubo.service.user;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mantou.mantoubo.api.user.IUserService;
import com.mantou.mantoubo.basic.entity.identity.User;
import com.mantou.mantoubo.basic.entity.identity.UserRole;
import com.mantou.mantoubo.basic.mapper.identity.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lm
 * @title: UserService
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2114:43
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper mapper;

    @Override
    public int insert(User entity) {
        return mapper.insert(entity);
    }

    @Override
    public User selectOne(Wrapper<User> queryWrapper) {
        return mapper.selectOne(queryWrapper);
    }

    @Override
    public List<User> selectByMap(Map<String, Object> columnMap) {
        return mapper.selectByMap(columnMap);
    }

    @Override
    public User queryUserByName(String name) {
        return mapper.queryUserByName(name);
    }

    @Override
    public int addRoleForUser(UserRole entity) {
        return mapper.addRoleForUser(entity);
    }
}
