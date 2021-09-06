package com.cs.adminbackstage.controll;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cs.adminbackstage.entity.Cinema;
import com.cs.adminbackstage.entity.Hall;
import com.cs.adminbackstage.mapper.CinemaMapper;
import com.cs.adminbackstage.mapper.HallMapper;
import com.cs.adminbackstage.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class hallcontroll {
    @Autowired
    private CinemaMapper cinemaMapper;
    @Autowired
    private HallMapper hallMapper;
    @Autowired
    private HallService hallService;

    @GetMapping("/halllist/{currPage}")
    public String halllist(Map<String,Object> map, @RequestParam(value="likename",required=false,defaultValue="")String likename, @PathVariable("currPage")Integer currPage){
        LambdaQueryWrapper<Hall> wrapper=new LambdaQueryWrapper<Hall>();
        wrapper.like(Hall::getHallName, likename);
        IPage<Hall> list= hallService.hallPage(currPage, 8, wrapper);
        map.put("lists", list.getRecords());
        map.put("currPage", list.getCurrent());
        map.put("totalPage", list.getPages());
        map.put("likename", likename);
        return "hall/halllist";
    }
    @GetMapping("tohalladd")
    public String tomovieinsert(Map<String,Object> map){
        List<Cinema> list=cinemaMapper.selectList(null);
        map.put("cinema",list);
        return "hall/halladd";
    }
    @PostMapping("halladd")
    public String movieinsert(Hall hall){
        hallMapper.insert(hall);
        return "redirect:/halllist/1";
    }
    @GetMapping("/halldelete/{hallId}/{currPage}")
    public String moviedelete(@PathVariable("hallId")Long hallId, @PathVariable("currPage")Integer currPage) {
        hallMapper.deleteById(hallId);
        return "redirect:/halllist/"+currPage;
    }
    @GetMapping("/halltoupdate/{hallId}/{currPage}")
    public String toUpdate(@PathVariable("hallId")Long hallId, @PathVariable("currPage")Integer currPage, Map<String,Object> map) {
        List<Cinema> list=cinemaMapper.selectList(null);
        map.put("cinema",list);
        map.put("currPage", currPage);
        map.put("hall", hallMapper.selectById(hallId));
        return "hall/hallupdate";
    }
    @PostMapping("/hallupdate")
    public String movieupdate(Hall hall,Integer currPage) {
        hallMapper.updateById(hall);
        return "redirect:/halllist/"+currPage;
    }
}
