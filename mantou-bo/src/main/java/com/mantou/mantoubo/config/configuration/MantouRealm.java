package com.mantou.mantoubo.config.configuration;

import com.mantou.mantoubo.api.user.IRolePermissionService;
import com.mantou.mantoubo.api.user.IRoleService;
import com.mantou.mantoubo.api.user.IUserService;
import com.mantou.mantoubo.basic.entity.identity.Permission;
import com.mantou.mantoubo.basic.entity.identity.Role;
import com.mantou.mantoubo.basic.entity.identity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;

/**
 * @author lm
 * @title: MantouRealm
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2120:19
 */
@Slf4j
public class MantouRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(MantouRealm.class);

    @Autowired
    private IUserService service;

    @Autowired
    private IRoleService roleService;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("执行Shiro的授权=========>");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 此时的principalCollection.getPrimaryPrincipal为认证时，SimpleAuthenticationInfo放入的
        User user = (User) principalCollection.getPrimaryPrincipal();
        logger.debug("执行Shiro的授权=========>:"+user.toString());
        System.out.println(user.toString());
        LinkedList<Role> roles = user.getRoles();
        // 获取当前subject角色，添加
        if(roles.size() > 0){
            for (Role role : roles) {
                info.addRole(role.getRoleName());
                // 根据role的id获取权限
                System.out.println("role.getId()==>:"+role.getId());
                Role roleTemp = roleService.queryRoleById(role.getId());
                LinkedList<Permission> permissions = roleTemp.getPermissions();
                // 获取当前subject权限，添加
                if(permissions.size() >0){
                    for (Permission permission : permissions) {
                        info.addStringPermission(permission.getPermission());
                    }
                }
            }
        }
        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("执行Shiro的认证=========>");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String name = usernamePasswordToken.getUsername();
        User user = service.queryUserByName(name);
        if(user ==null){
            return null;
        }
        if(user.getStatus() == 1){
            throw new LockedAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                getName()
        );
        return authenticationInfo;
    }
}
