package com.cs.adminbackstage.controll;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cs.adminbackstage.entity.Comments;
import com.cs.adminbackstage.entity.SysRole;
import com.cs.adminbackstage.entity.User;
import com.cs.adminbackstage.mapper.CommentsMapper;
import com.cs.adminbackstage.mapper.SysRoleMapper;
import com.cs.adminbackstage.mapper.UserMapper;
import com.cs.adminbackstage.service.CommentsService;
import com.cs.adminbackstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class usercontroll {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private CommentsMapper commentsMapper;
    @Autowired
    private CommentsService commentsService;

    @GetMapping("/userlist/{currPage}")
    public String userlist(Map<String,Object> map, @RequestParam(value="likename",required=false,defaultValue="")String likename, @PathVariable("currPage")Integer currPage){
        LambdaQueryWrapper<User> wrapper=new LambdaQueryWrapper<User>();
        wrapper.like(User::getName, likename);
        IPage<User> list= userService.userPage(currPage, 8, wrapper);
        map.put("lists", list.getRecords());
        map.put("currPage", list.getCurrent());
        map.put("totalPage", list.getPages());
        map.put("likename", likename);
        return "user/userlist";
    }
    @GetMapping("/userdelete/{userId}/{currPage}")
    public String moviedelete(@PathVariable("userId")Long userId, @PathVariable("currPage")Integer currPage) {
        userMapper.deleteById(userId);
        return "redirect:/userlist/"+currPage;
    }
    @GetMapping("/usertoupdate/{id}/{currPage}")
    public String toUpdate(@PathVariable("id")Long id, @PathVariable("currPage")Integer currPage, Map<String,Object> map) {
        List<SysRole> list= sysRoleMapper.selectList(null);
        map.put("role", list);
        map.put("currPage", currPage);
        map.put("u", userMapper.selectById(id));
        return "user/userupdate";
    }
    @PostMapping("/userupdate")
    public String movieupdate(User user, Integer currPage) {
        userMapper.updateById(user);
        return "redirect:/userlist/"+currPage;
    }
    @GetMapping("/conmentslist/{currPage}")
    public String conmentslist(Map<String,Object> map, @RequestParam(value="likename",required=false,defaultValue="")String likename, @PathVariable("currPage")Integer currPage){
        LambdaQueryWrapper<Comments> wrapper=new LambdaQueryWrapper<Comments>();
        wrapper.like(Comments::getUserNick, likename);
        IPage<Comments> list= commentsService.commentsPage(currPage, 8, wrapper);
        map.put("lists", list.getRecords());
        map.put("currPage", list.getCurrent());
        map.put("totalPage", list.getPages());
        map.put("likename", likename);
        return "user/conmentslist";
    }
    @GetMapping("/conmentsdelete/{id}/{currPage}")
    public String conmentsdelete(@PathVariable("id")Long id, @PathVariable("currPage")Integer currPage) {
        commentsMapper.deleteById(id);
        return "redirect:/conmentslist/"+currPage;
    }
}
