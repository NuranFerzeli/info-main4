package com.firstnews.info.controller;


import com.firstnews.info.entity.News;
import com.firstnews.info.model.NewsModel;
import com.firstnews.info.repo.NewsRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class IndexController {
    private final NewsRepository newsRepository;

    public IndexController(NewsRepository newsRepository){
        this.newsRepository=newsRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView getIndex(){
        NewsModel newsModel = null;
        List<News> news= newsRepository.findAll();

        for (News n:news) {
            newsModel = new NewsModel();
            newsModel.setId(n.getId());
            newsModel.setNewsName(n.getNewsName());
            newsModel.setNewsTitle(n.getNewsTitle());
            newsModel.setImageName(n.getImagePath());
        }
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("news",news);
        modelAndView.addObject("newsId", newsModel.getId());
        modelAndView.addObject("newsId1", newsModel.getId()-1);
        modelAndView.addObject("newsId2", newsModel.getId()-4);
        modelAndView.addObject("name", newsModel.getNewsName());
        modelAndView.addObject("tittle", newsModel.getNewsTitle());
        modelAndView.addObject("imageName", newsModel.getImageName());
        System.out.println(newsModel.getImageName());
        return modelAndView;
    }
}
