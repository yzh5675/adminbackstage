package com.cs.adminbackstage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cs.adminbackstage.entity.Orderinfo;
import com.cs.adminbackstage.service.OrderinfoService;
import com.cs.adminbackstage.mapper.OrderinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class OrderinfoServiceImpl extends ServiceImpl<OrderinfoMapper, Orderinfo>
implements OrderinfoService{
    @Autowired
    private OrderinfoMapper orderinfoMapper;

    @Override
    public IPage<Orderinfo> orderinfoPage(Integer currPage, Integer totalPage, LambdaQueryWrapper<Orderinfo> wrapper) {
        Page<Orderinfo> page=new Page<Orderinfo>(currPage,totalPage);
        IPage<Orderinfo> list=orderinfoMapper.selectPage(page,wrapper);
        return list;
    }
}




