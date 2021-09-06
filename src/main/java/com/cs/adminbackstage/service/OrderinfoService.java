package com.cs.adminbackstage.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cs.adminbackstage.entity.Comments;
import com.cs.adminbackstage.entity.Orderinfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cs.adminbackstage.mapper.CommentsMapper;
import com.cs.adminbackstage.mapper.OrderinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
public interface OrderinfoService extends IService<Orderinfo> {
    IPage<Orderinfo> orderinfoPage(Integer currPage, Integer totalPage, LambdaQueryWrapper<Orderinfo> wrapper);

}
