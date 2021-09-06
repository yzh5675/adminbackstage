package com.cs.adminbackstage.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cs.adminbackstage.entity.Hall;
import com.cs.adminbackstage.entity.Schedules;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface SchedulesService extends IService<Schedules> {
    IPage<Schedules> schedulesPage(Integer currPage, Integer totalPage, LambdaQueryWrapper<Schedules> wrapper);
}
