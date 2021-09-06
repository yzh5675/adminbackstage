package com.cs.adminbackstage.controll;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cs.adminbackstage.entity.Comments;
import com.cs.adminbackstage.entity.Orderinfo;
import com.cs.adminbackstage.mapper.OrderinfoMapper;
import com.cs.adminbackstage.service.OrderinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class OrderinfoControll {

    @Autowired
    private OrderinfoService orderinfoService;

    @Autowired
    private OrderinfoMapper orderinfoMapper;

    // 评论表查询分页及模糊查询[GET]
    @GetMapping("/orderinfolist/{currPage}")
    public String orderinfolist(Map<String,Object> map, @RequestParam(value="likename",required=false,defaultValue="")String likename, @PathVariable("currPage")Integer currPage){

        LambdaQueryWrapper<Orderinfo> queryWrapper = new LambdaQueryWrapper<Orderinfo>();

        queryWrapper.like(Orderinfo::getOrderId, likename);

        IPage<Orderinfo> list = orderinfoService.orderinfoPage(currPage, 8, queryWrapper);

        map.put("lists", list.getRecords());

        map.put("currPage", list.getCurrent());

        map.put("totalPage", list.getPages());

        map.put("likename", likename);

        return "orderinfo/orderinfolist";
    }

    // 评论表删除[GET]
    @GetMapping("/orderinfodelete/{id}/{currPage}")
    public String orderinfodelete(@PathVariable("id")Long id, @PathVariable("currPage")Integer currPage) {

        orderinfoMapper.deleteById(id);

        return "redirect:/orderinfolist/"+currPage;
    }
}
