package com.cs.adminbackstage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName schedules
 */
@TableName(value ="schedules")
@Data
public class Schedules implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    private Long schedulesId;
    /**
     * 影院编号
     */
    private Long cinemaId;
    /**
     * 电影编号
     */
    private Integer movieId;

    /**
     * 放映日期
     */
    private String showDay;

    /**
     * 放映时间
     */
    private String showTime;

    /**
     * 语言类型
     */
    private String filmLanguage;

    /**
     * 影厅id
     */
    private Long hallId;

    /**
     * 价格
     */
    private Double price;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}