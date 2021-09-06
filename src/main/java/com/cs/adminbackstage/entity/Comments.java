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
 * @TableName comments
 */
@TableName(value ="comments")
@Data
public class Comments implements Serializable {
    /**
     * 评论的id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 电影编号
     */
    private Integer movieId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户昵称
     */
    private String userNick;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    private String commentTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}