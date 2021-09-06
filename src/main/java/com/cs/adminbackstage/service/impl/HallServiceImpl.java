package com.cs.adminbackstage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cs.adminbackstage.entity.Cinema;
import com.cs.adminbackstage.entity.Hall;
import com.cs.adminbackstage.mapper.CinemaMapper;
import com.cs.adminbackstage.service.HallService;
import com.cs.adminbackstage.mapper.HallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class HallServiceImpl extends ServiceImpl<HallMapper, Hall>
implements HallService{
    @Autowired
    private HallMapper hallMapper;

    @Override
    public IPage<Hall> hallPage(Integer currPage, Integer totalPage, LambdaQueryWrapper<Hall> wrapper) {
        Page<Hall> page=new Page<Hall>(currPage,totalPage);
        IPage<Hall> list=hallMapper.selectPage(page,wrapper);
        return list;
    }
}




