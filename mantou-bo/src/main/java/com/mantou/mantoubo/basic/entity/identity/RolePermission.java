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
 * @title: RolePermission
 * @projectName mantou
 * @description: TODO
 * @date 2021/10/2722:52
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RolePermission implements Serializable {

    /**
     * 序列号
     */
    @TableId(value = "ID",type = IdType.ID_WORKER_STR)
    private String id;

    /**
     * 角色id
     */
    @TableField("ROLE_ID")
    private String roleId;

    /**
     * 权限id
     */
    @TableField("PERMISSION_ID")
    private String permissionId;
}


