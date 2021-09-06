package com.cs.adminbackstage.controll;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cs.adminbackstage.entity.Cinema;
import com.cs.adminbackstage.mapper.CinemaMapper;
import com.cs.adminbackstage.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
@Controller
public class cinemacontroll {
    @Autowired
    private CinemaMapper cinemaMapper;
    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/cinemalist/{currPage}")
    public String cinemalist(Map<String,Object> map, @RequestParam(value="likename",required=false,defaultValue="")String likename,@RequestParam(value="cinemalikename",required=false,defaultValue="")String cinemalikename, @PathVariable("currPage")Integer currPage){
        LambdaQueryWrapper<Cinema> wrapper=new LambdaQueryWrapper<Cinema>();
        wrapper.like(Cinema::getCinemaName, likename);
        wrapper.like(Cinema::getCinemaArea, cinemalikename);
        IPage<Cinema> list= cinemaService.cinemaPage(currPage, 8, wrapper);
        map.put("lists", list.getRecords());
        map.put("currPage", list.getCurrent());
        map.put("totalPage", list.getPages());
        map.put("likename", likename);
        map.put("cinemalikename", cinemalikename);
        return "cinema/cinemalist";
    }
    @GetMapping("tocinemaadd")
    public String tomovieinsert(){
        return "cinema/cinemaadd";
    }
    @PostMapping("cinemaadd")
    public String movieinsert(Cinema cinema){
        cinemaMapper.insert(cinema);
        return "redirect:/cinemalist/1";
    }
    @GetMapping("/cinemadelete/{cinemaId}/{currPage}")
    public String moviedelete(@PathVariable("cinemaId")Long cinemaId, @PathVariable("currPage")Integer currPage) {
        cinemaMapper.deleteById(cinemaId);
        return "redirect:/cinemalist/"+currPage;
    }
    @GetMapping("/cinematoupdate/{cinemaId}/{currPage}")
    public String toUpdate(@PathVariable("cinemaId")Long cinemaId, @PathVariable("currPage")Integer currPage, Map<String,Object> map) {
        map.put("currPage", currPage);
        map.put("cinema", cinemaMapper.selectById(cinemaId));
        return "cinema/cinemaupdate";
    }
    @PostMapping("/cinemaupdate")
    public String movieupdate(Cinema cinema,Integer currPage) {
        cinemaMapper.updateById(cinema);
        return "redirect:/cinemalist/"+currPage;
    }
}
