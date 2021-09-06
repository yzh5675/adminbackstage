package com.cs.adminbackstage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName sys_permission
 */
@TableName(value ="sys_permission")
@Data
public class SysPermission implements Serializable {
    /**
     * 权限id
     */
    @TableId(type = IdType.AUTO)
    private Integer pid;

    /**
     * 权限名字
     */
    private String name;

    /**
     * 权限编码
     */
    private String code;

    /**
     * 权限路径
     */
    private String url;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}