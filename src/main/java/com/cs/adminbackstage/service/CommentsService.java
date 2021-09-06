package com.cs.adminbackstage.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cs.adminbackstage.entity.Comments;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cs.adminbackstage.entity.Hall;

/**
 *
 */
public interface CommentsService extends IService<Comments> {
    IPage<Comments> commentsPage(Integer currPage, Integer totalPage, LambdaQueryWrapper<Comments> wrapper);
}
