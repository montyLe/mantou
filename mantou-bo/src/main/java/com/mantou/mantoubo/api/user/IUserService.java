package com.mantou.mantoubo.api.user;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mantou.mantoubo.basic.entity.identity.User;
import com.mantou.mantoubo.basic.entity.identity.UserRole;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lm
 * @title: IUserService
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2114:41
 */
public interface IUserService  extends IService<User> {

    int insert(User entity);

    User selectOne(Wrapper<User> queryWrapper);

    List<User> selectByMap(Map<String, Object> columnMap);

    User queryUserByName(String name);

    int addRoleForUser(UserRole entity);
}
