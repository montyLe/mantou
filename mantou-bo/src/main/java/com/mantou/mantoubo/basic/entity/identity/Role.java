package com.mantou.mantoubo.basic.entity.identity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.LinkedList;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author lm
 * @title: Role
 * @projectName mantou
 * @description: TODO
 * @date 2021/10/2722:49
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Role implements Serializable {

    /**
     * 角色ID
     */
    @TableId(value = "ID",type = IdType.ID_WORKER_STR)
    private String id;

    @TableField("PARENT_ID")
    private String parentId;

    /**
     * 角色名称
     */
    @TableField("ROLE_NAME")
    private String roleName;

    /**
     * 创建时间
     */
    @TableField("GEN_TIME")
    private LocalDateTime genTime;

    /**
     * 角色描述
     */
    @TableField("DESCRIPTION")
    private String description;

    private LinkedList<Permission> Permissions;
}

