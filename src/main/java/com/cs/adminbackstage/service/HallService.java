package com.cs.adminbackstage.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cs.adminbackstage.entity.Cinema;
import com.cs.adminbackstage.entity.Hall;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 *
 */
public interface HallService extends IService<Hall> {
    IPage<Hall> hallPage(Integer currPage, Integer totalPage, LambdaQueryWrapper<Hall> wrapper);
}
