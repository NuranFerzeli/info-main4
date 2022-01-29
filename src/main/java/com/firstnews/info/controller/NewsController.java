package com.firstnews.info.controller;


import com.firstnews.info.entity.News;
import com.firstnews.info.model.NewsModel;
import com.firstnews.info.repo.NewsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NewsController {
    private final NewsRepository newsRepository;

    public NewsController(NewsRepository newsRepository){
        this.newsRepository=newsRepository;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/news/{id}")
    public ModelAndView getNews(@PathVariable(value="id") Long id) {
        System.out.println(id);
        ModelAndView modelAndView= new ModelAndView("newsPage");
        NewsModel newsModel=new NewsModel();
        List<News> newsList= new ArrayList<>();
        newsList.add(newsRepository.getOne(id));
        for(News n:newsList){
            newsModel.setNewsTitle(n.getNewsTitle());
            newsModel.setNewsName(n.getNewsName());
            newsModel.setImageName(n.getImagePath());
        }


        modelAndView.addObject("name", newsModel.getNewsName());
        modelAndView.addObject("tittle", newsModel.getNewsTitle());
        modelAndView.addObject("imageName", newsModel.getImageName());

        return modelAndView;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/news/save")
    public ModelAndView getSavePage(){

        ModelAndView modelAndView= new ModelAndView("insert");
        modelAndView.addObject("name","Xəbərin Adı");
        modelAndView.addObject("description","Xəbərin məzmunu");
        modelAndView.addObject("news","Xəbər");
        modelAndView.addObject("date","Xəbərin Tarixi");
        modelAndView.addObject("picture","Xəbərə Şəkil Əlavə Edin");
        return modelAndView;
    }

}
