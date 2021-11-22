package com.mantou.mantoubo.web.portal;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.kaptcha.Kaptcha;
import com.mantou.mantoubo.api.user.IUserService;
import com.mantou.mantoubo.basic.common.constant.UtilConstants;
import com.mantou.mantoubo.basic.common.encryption.Encryption;
import com.mantou.mantoubo.basic.common.response.Response;
import com.mantou.mantoubo.basic.entity.identity.User;
import com.mantou.mantoubo.config.configuration.MantouRealm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lm
 * @title: LoginController
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2114:55
 */
@RestController
@RequestMapping("/base/v1.0")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private IUserService service;

    // 验证码工具
    @Autowired
    private Kaptcha kaptcha;

    @PostMapping("/register")
    @ApiOperation(value = "注册", notes = "注册")
    @ApiImplicitParam(name = "user", value = "用户模型实体", required = true, dataType = "User")
    public @ResponseBody Response register(@RequestBody User user){
        // 查询同名用户不可注册
        User realUser = service.queryUserByName(user.getUsername());
        if(realUser != null){
            return Response.FAIL().message("用户已存在");
        }
        // 设置状态，0正常
        user.setStatus(UtilConstants.UserStatus.NORMAL);
        // 设置32为加密盐
        String salt = Encryption.getRandomString(UtilConstants.Public.SALT_LENGTH);
        user.setSalt(salt);
        user.setPassword(new SimpleHash("MD5",user.getPassword(),salt,UtilConstants.Public.ENCRYPTION_TIMES).toHex());
        user.setGenTime(LocalDateTime.now());
        try{
            service.insert(user);
            // 添加注册的普通用户角色

            return Response.OK().message("注册成功");
        }catch (Exception e){
            return Response.FAIL().message("注册失败");
        }
    }

    /**
     * 生成验证码
     */
    @GetMapping("/render")
    @ApiOperation(value = "获取图形验证码", notes = "图形验证")
    public void render() {
        kaptcha.render();
    }


    @PostMapping("/valid")
    @ApiOperation(value = "验证图形验证码", notes = "图形验证")
    @ApiImplicitParam(name = "code", value = "图形验证码", required = true, dataType = "String")
    public void validDefaultTime(@RequestBody String code) {
        //default timeout 900 seconds
        kaptcha.validate(code,300); // 设置验证码五分钟有效
    }

    @PostMapping ("/doLogin/{code}")
    @ApiOperation(value = "登录", notes = "登录")
    @ApiImplicitParam(name = "user", value = "用户模型实体", required = true, dataType = "User")
    public @ResponseBody Response doLogin(@RequestBody User user){
        logger.info("用户登录=====》》》");
        String username = user.getUsername();
        String password = user.getPassword();
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true); // 设置记住我
            subject.login(token);   // 登录
            Map<String, Object> map = new HashMap<>();
            map.put("access-token", subject.getSession().getId());
            return Response.OK().data(map);
        }catch (IncorrectCredentialsException e) {
            return Response.FAIL().message("用户名或密码错误");
        } catch (LockedAccountException e) {
            return Response.FAIL().message("该用户已被禁用");
        } catch (AuthenticationException e) {
            return Response.FAIL().message("该用户不存在");
        }
    }

    @GetMapping("/logout")
    @ApiOperation(value = "退出登录", notes = "退出登录")
    @RequiresRoles({"Customer"})
    public @ResponseBody Response logout(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return Response.OK().message("退出成功");
    }

}
