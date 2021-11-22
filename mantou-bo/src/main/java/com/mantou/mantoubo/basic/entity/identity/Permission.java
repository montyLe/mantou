package com.mantou.mantoubo.basic.entity.identity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * @author lm
 * @title: Permission
 * @projectName mantou
 * @description: TODO
 * @date 2021/10/2722:50
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Permission implements Serializable{

    /**
     * 序列号
     */
    @TableId(value = "ID",type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 属性
     */
    @TableField("AVAILABLE")
    private String available;

    /**
     * 父级序列号
     */
    @TableField("PARENT_ID")
    private String parentId;

    /**
     * 父级序列号集合
     */
    @TableField("PARENT_IDS")
    private String parentIds;

    /**
     * 权限
     */
    @TableField("PERMISSION")
    private String permission;

    /**
     * 权限名称
     */
    @TableField("PERMISSION_NAME")
    private String permissionName;

    /**
     * 来源类型
     */
    @TableField("RESOURCE_TYPE")
    private String resourceType;

    /**
     * 地址链接
     */
    @TableField("URL")
    private String url;
}

