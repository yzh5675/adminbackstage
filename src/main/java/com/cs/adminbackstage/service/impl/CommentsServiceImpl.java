package com.cs.adminbackstage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cs.adminbackstage.entity.Comments;
import com.cs.adminbackstage.entity.Hall;
import com.cs.adminbackstage.mapper.HallMapper;
import com.cs.adminbackstage.service.CommentsService;
import com.cs.adminbackstage.mapper.CommentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments>
implements CommentsService{
    @Autowired
    private CommentsMapper commentsMapper;

    @Override
    public IPage<Comments> commentsPage(Integer currPage, Integer totalPage, LambdaQueryWrapper<Comments> wrapper) {
        Page<Comments> page=new Page<Comments>(currPage,totalPage);
        IPage<Comments> list=commentsMapper.selectPage(page,wrapper);
        return list;
    }
}




