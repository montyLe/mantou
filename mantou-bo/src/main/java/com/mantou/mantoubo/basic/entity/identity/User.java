package com.mantou.mantoubo.basic.entity.identity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author lm
 * @title: User
 * @projectName mantou
 * @description: TODO
 * @date 2021/10/2722:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Getter
@Setter
public class User implements Serializable {
    /**
     * 用户ID
     */
    @TableId(value = "ID",type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 用户名称
     */
    @TableField("USERNAME")
    private String username;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 手机号码
     */
    @TableField("MOBILE")
    private String mobile;

    /**
     * 电子邮箱
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 昵称
     */
    @TableField("NICKNAME")
    private String nickname;

    /**
     * 盐
     */
    @TableField("SALT")
    private String salt;

    /**
     * 状态
     */
    @TableField("STATUS")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField("GEN_TIME")
    private LocalDateTime genTime;

    /**
     * 登录时间
     */
    @TableField("LOGIN_TIME")
    private LocalDateTime loginTime;

    /**
     * 最后登录时间
     */
    @TableField("LAST_LOGIN_TIME")
    private LocalDateTime lastLoginTime;

    /**
     * 登录次数
     */
    @TableField("LOGIN_COUNT")
    private Long loginCount;

    private LinkedList<Role> Roles;
}

