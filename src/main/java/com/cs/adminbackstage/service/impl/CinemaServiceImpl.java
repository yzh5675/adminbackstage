package com.cs.adminbackstage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cs.adminbackstage.entity.Cinema;
import com.cs.adminbackstage.service.CinemaService;
import com.cs.adminbackstage.mapper.CinemaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class CinemaServiceImpl extends ServiceImpl<CinemaMapper, Cinema>
implements CinemaService{
    @Autowired
    private CinemaMapper cinemaMapper;

    @Override
    public IPage<Cinema> cinemaPage(Integer currPage, Integer totalPage, LambdaQueryWrapper<Cinema> wrapper) {
        Page<Cinema> page=new Page<Cinema>(currPage,totalPage);
        IPage<Cinema> list=cinemaMapper.selectPage(page,wrapper);
        return list;
    }
}




