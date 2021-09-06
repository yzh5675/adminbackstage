package com.cs.adminbackstage.controll;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cs.adminbackstage.entity.Cinema;
import com.cs.adminbackstage.entity.Hall;
import com.cs.adminbackstage.entity.Movie;
import com.cs.adminbackstage.entity.Schedules;
import com.cs.adminbackstage.mapper.CinemaMapper;
import com.cs.adminbackstage.mapper.HallMapper;
import com.cs.adminbackstage.mapper.MovieMapper;
import com.cs.adminbackstage.mapper.SchedulesMapper;
import com.cs.adminbackstage.service.SchedulesService;
import com.cs.adminbackstage.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class schedulescontroll {
    @Autowired
    private HallMapper hallMapper;
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private SchedulesMapper schedulesMapper;
    @Autowired
    private SchedulesService schedulesService;
    @Autowired
    private CinemaMapper cinemaMapper;

    @GetMapping("/scheduleslist/{currPage}")
    public String scheduleslist(Map<String,Object> map, @RequestParam(value="likename",required=false,defaultValue="")String likename, @PathVariable("currPage")Integer currPage){
        LambdaQueryWrapper<Schedules> wrapper=new LambdaQueryWrapper<Schedules>();
        wrapper.like(Schedules::getCinemaId, likename);
        IPage<Schedules> list= schedulesService.schedulesPage(currPage, 8, wrapper);
        map.put("lists", list.getRecords());
        map.put("currPage", list.getCurrent());
        map.put("totalPage", list.getPages());
        map.put("likename", likename);
        return "schedules/scheduleslist";
    }
    @GetMapping("toschedulesadd")
    public String tomovieinsert(Map<String,Object> map){
        List<Movie> movielist=movieMapper.selectList(null);
        List<Hall> halllist=hallMapper.selectList(null);
        List<Cinema> cinemalist=cinemaMapper.selectList(null);
        map.put("movies",movielist);
        map.put("hall",halllist);
        map.put("cinemas",cinemalist);
        return "schedules/schedulesadd";
    }
    @GetMapping("/hall")
    @ResponseBody
    public BaseResult<Hall> hallAjax(@RequestParam("cinemaname")String cinemaname){
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("cinema_id",cinemaname);
        List<Hall> halllist=hallMapper.selectList(wrapper);
        return new BaseResult(0, "SUCCESS", null,halllist);
    }
    @PostMapping("schedulesadd")
    public String movieinsert(Schedules schedules){
        schedulesMapper.insert(schedules);
        return "redirect:/scheduleslist/1";
    }
    @GetMapping("/schedulesdelete/{schedulesId}/{currPage}")
    public String moviedelete(@PathVariable("schedulesId")Long schedulesId, @PathVariable("currPage")Integer currPage) {
        schedulesMapper.deleteById(schedulesId);
        return "redirect:/scheduleslist/"+currPage;
    }
    @GetMapping("/schedulestoupdate/{schedulesId}/{currPage}")
    public String toUpdate(@PathVariable("schedulesId")Long schedulesId,Long cinemaId, @PathVariable("currPage")Integer currPage, Map<String,Object> map) {
        List<Movie> movielist=movieMapper.selectList(null);
        List<Hall> halllist=hallMapper.selectList(null);
        List<Cinema> cinemalist=cinemaMapper.selectList(null);
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("cinema_id",cinemaId);
        List<Hall> halls=hallMapper.selectList(wrapper);
        map.put("halls",halls);
        map.put("cinemas",cinemalist);
        map.put("movies",movielist);
        map.put("hall",halllist);
        map.put("currPage", currPage);
        map.put("schedules", schedulesMapper.selectById(schedulesId));
        return "schedules/schedulesupdate";
    }
    @PostMapping("/schedulesupdate")
    public String movieupdate(Schedules schedules, Integer currPage) {
        schedulesMapper.updateById(schedules);
        return "redirect:/scheduleslist/"+currPage;
    }
}
