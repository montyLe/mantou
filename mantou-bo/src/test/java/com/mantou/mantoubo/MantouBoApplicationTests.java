package com.mantou.mantoubo;

import com.mantou.mantoubo.api.user.*;
import com.mantou.mantoubo.basic.entity.identity.*;
import com.mantou.mantoubo.basic.mapper.identity.RoleMapper;
import com.mantou.mantoubo.basic.mapper.identity.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class MantouBoApplicationTests {

    @Autowired
    IUserService userService;

    @Autowired
    IRoleService roleService;

    @Autowired
    IUserRoleService userRoleService;

    @Autowired
    IPermissionService permissionService;

    @Autowired
    IRolePermissionService rolePermissionService;

    @Test
    void contextLoads() {
        String name = "monty";
        User user = userService.queryUserByName(name);
        System.out.println(user.toString());
    }

    @Test
    void addRole(){
        Role role = new Role();
        role.setRoleName("Guest");
        int i = roleService.insert(role);
        System.out.println(i);
    }

    @Test
    void addRolesForUser(){
        UserRole userRole = new UserRole();
        userRole.setUserId("1413898285550428161");
        userRole.setRoleId("1462428226403192834");

        int i = userRoleService.insert(userRole);
        System.out.println(i);
    }

    @Test
    void  addPermission(){
        Permission permission = new Permission();
        permission.setPermission("user:update");
        permission.setPermissionName("用户模块所有权限");
        permission.setResourceType("admin");

        permissionService.insert(permission);
    }

    @Test
    void addRolePermission(){
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId("1462428226403192834"); // customer
        rolePermission.setPermissionId("1462441209405747201");//
        rolePermissionService.insert(rolePermission);
    }


    @Test
    void queryPermissionByroleId(){
        String id = "1462414810250833922";

        Role role = roleService.queryRoleById(id);
        System.out.println(role.toString());
    }
}
