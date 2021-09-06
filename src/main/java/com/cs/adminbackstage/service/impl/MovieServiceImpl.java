package com.cs.adminbackstage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cs.adminbackstage.entity.Movie;
import com.cs.adminbackstage.service.MovieService;
import com.cs.adminbackstage.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public IPage<Movie> moviePage(Integer currPage, Integer totalPage, LambdaQueryWrapper<Movie> wrapper) {
        Page<Movie> page=new Page<Movie>(currPage,totalPage);
        IPage<Movie> list=movieMapper.selectPage(page,wrapper);
        return list;
    }
}




