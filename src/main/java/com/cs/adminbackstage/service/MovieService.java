package com.cs.adminbackstage.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cs.adminbackstage.entity.Movie;

/**
 *
 */
public interface MovieService{
    IPage<Movie> moviePage(Integer currPage, Integer totalPage, LambdaQueryWrapper<Movie> wrapper);
}
