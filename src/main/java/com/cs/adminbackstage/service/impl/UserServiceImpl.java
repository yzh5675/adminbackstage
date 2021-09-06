package com.cs.adminbackstage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cs.adminbackstage.entity.Schedules;
import com.cs.adminbackstage.entity.User;
import com.cs.adminbackstage.mapper.SchedulesMapper;
import com.cs.adminbackstage.service.UserService;
import com.cs.adminbackstage.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<User> userPage(Integer currPage, Integer totalPage, LambdaQueryWrapper<User> wrapper) {
        Page<User> page=new Page<User>(currPage,totalPage);
        IPage<User> list=userMapper.selectPage(page,wrapper);
        return list;
    }
}




