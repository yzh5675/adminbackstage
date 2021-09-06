package com.cs.adminbackstage.controll;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cs.adminbackstage.entity.Movie;
import com.cs.adminbackstage.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class logincontroll {
    @Autowired
    private MovieService movieService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/logout")
    public String logout(){
        return "login";
    }
    @GetMapping("/list/{currPage}")
    public String list(Map<String,Object> map, @RequestParam(value="likename",required=false,defaultValue="")String likename, @RequestParam(value="likeid",required=false,defaultValue="")String likeid, @PathVariable("currPage")Integer currPage){
        LambdaQueryWrapper<Movie> wrapper=new LambdaQueryWrapper<Movie>();
        wrapper.like(Movie::getMovieCnName, likename);
        wrapper.like(Movie::getMovieId, likeid);
        IPage<Movie> list= movieService.moviePage(currPage, 8, wrapper);
        map.put("lists", list.getRecords());
        map.put("currPage", list.getCurrent());
        map.put("totalPage", list.getPages());
        map.put("likename", likename);
        map.put("likeid", likeid);
        return "movie/list";
    }
}
