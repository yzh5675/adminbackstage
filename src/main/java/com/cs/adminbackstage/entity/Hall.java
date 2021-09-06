package com.cs.adminbackstage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName hall
 */
@TableName(value ="hall")
@Data
public class Hall implements Serializable {
    /**
     * 影厅id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long hallId;

    /**
     * 影厅名称
     */
    private String hallName;

    /**
     * 容量
     */
    private Integer capacity;

    /**
     * 影院编号
     */
    private Long cinemaId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}