package com.cs.adminbackstage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName cinema
 */
@TableName(value ="cinema")
@Data
public class Cinema implements Serializable {
    /**
     * 影院编号
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long cinemaId;

    /**
     * 影院名称
     */
    private String cinemaName;

    /**
     * 影院所在区
     */
    private String cinemaArea;

    /**
     * 影院地址
     */
    private String cinemaAddress;

    /**
     * 影院类型
     */
    private String cinemaType;

    /**
     * 影院电话
     */
    private String phone;

    /**
     * 影院图片
     */
    private String cinemaImage;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}