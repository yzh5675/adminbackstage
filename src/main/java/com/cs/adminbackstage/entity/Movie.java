package com.cs.adminbackstage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

/**
 * 
 * @TableName movie
 */
@TableName(value ="movie")
@Data
@ToString
public class Movie implements Serializable {
    /**
     * 电影编号
     */
    @TableId(type = IdType.AUTO)
    private Integer movieId;

    /**
     * 电影名称（中文）
     */
    private String movieCnName;

    /**
     * 电影名称（外语）
     */
    private String movieFgName;

    /**
     * 电影演职人员
     */
    private String movieActor;

    /**
     * 电影导演
     */
    private String movieDirector;

    /**
     * 电影详情
     */
    private String movieDetail;

    /**
     * 电影时长
     */
    private String movieDuration;

    /**
     * 电影类型
     */
    private String movieType;

    /**
     * 电影评分 默认为0
     */
    private Double movieScore;

    /**
     * 电影票房 默认为0
     */
    private Double movieBoxoffice;

    /**
     * 电影参评人数 默认为0
     */
    private Integer movieCommentcount;

    /**
     * 电影上映时间
     */
    private String movieReleasedate;

    /**
     * 电影制片地区
     */
    private String movieCountry;

    /**
     * 电影海报
     */
    private String moviePicture;

    /**
     * 电影状态 0: 即将上映, 1：在映,3:下架
     */
    private Byte movieState;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}