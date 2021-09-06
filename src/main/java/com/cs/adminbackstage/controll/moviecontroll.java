package com.cs.adminbackstage.controll;

import com.cs.adminbackstage.entity.Movie;
import com.cs.adminbackstage.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class moviecontroll {
    @Autowired
    private MovieMapper movieMapper;

    @GetMapping("add")
    public String tomovieinsert(){
        return "movie/add";
    }
    @PostMapping("movieadd")
    public String movieinsert(Movie movie){
        movieMapper.insert(movie);
        return "redirect:/list/1";
    }
    @GetMapping("/delete/{movieId}/{currPage}")
    public String moviedelete(@PathVariable("movieId")Integer movieId, @PathVariable("currPage")Integer currPage) {
        movieMapper.deleteById(movieId);
        return "redirect:/list/"+currPage;
    }
    @GetMapping("/toupdate/{movieId}/{currPage}")
    public String toUpdate(@PathVariable("movieId")Integer movieId, @PathVariable("currPage")Integer currPage, Map<String,Object> map) {
        map.put("currPage", currPage);
        map.put("movie", movieMapper.selectById(movieId));
        return "movie/update";
    }
    @PostMapping("/update")
    public String movieupdate(Movie movie,Integer currPage) {
        movieMapper.updateById(movie);
        return "redirect:/list/"+currPage;
    }
}
