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
 * @TableName orderinfo
 */
@TableName(value ="orderinfo")
@Data
public class Orderinfo implements Serializable {
    /**
     * 订单编号
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long orderId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 影片id
     */
    private Integer movieId;

    /**
     * 影片id
     */
    private Long schedulesId;

    /**
     * 影院名称
     */
    private String cinemaName;

    /**
     * 影厅名称
     */
    private String hallName;

    /**
     * 座位
     */
    private String seat;

    /**
     * 下单时间
     */
    private String orderTime;

    /**
     * 观影日期
     */
    private String movieDate;

    /**
     * 付款金额
     */
    private Double price;

    /**
     * 订单状态
     */
    private String orderStatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}