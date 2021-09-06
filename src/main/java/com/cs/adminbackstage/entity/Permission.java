package com.cs.adminbackstage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName permission
 */
@TableName(value ="permission")
@Data
public class Permission implements Serializable {
    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 权限id
     */
    private Integer pid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}