package com.cs.adminbackstage.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cs.adminbackstage.entity.Cinema;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface CinemaService extends IService<Cinema> {
    IPage<Cinema> cinemaPage(Integer currPage, Integer totalPage, LambdaQueryWrapper<Cinema> wrapper);
}
