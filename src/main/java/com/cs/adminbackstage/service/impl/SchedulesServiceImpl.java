package com.cs.adminbackstage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cs.adminbackstage.entity.Hall;
import com.cs.adminbackstage.entity.Schedules;
import com.cs.adminbackstage.mapper.HallMapper;
import com.cs.adminbackstage.service.SchedulesService;
import com.cs.adminbackstage.mapper.SchedulesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class SchedulesServiceImpl extends ServiceImpl<SchedulesMapper, Schedules>
implements SchedulesService{
    @Autowired
    private SchedulesMapper schedulesMapper;

    @Override
    public IPage<Schedules> schedulesPage(Integer currPage, Integer totalPage, LambdaQueryWrapper<Schedules> wrapper) {
        Page<Schedules> page=new Page<Schedules>(currPage,totalPage);
        IPage<Schedules> list=schedulesMapper.selectPage(page,wrapper);
        return list;
    }
}




