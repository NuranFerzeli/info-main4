package com.firstnews.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SportsController {
@RequestMapping(method = RequestMethod.GET, value = "/sports")
    public String getVideos() {
        return "sports.html";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sport/save")
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
