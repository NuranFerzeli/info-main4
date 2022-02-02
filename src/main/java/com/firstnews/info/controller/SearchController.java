package com.firstnews.info.controller;

import org.apache.coyote.http11.filters.IdentityOutputFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
    @RequestMapping(method = RequestMethod.POST, value = "/search")
    public ModelAndView getError(){
        System.out.println("Nuran Keo");
        ModelAndView mv= new ModelAndView("error");
        System.out.println("Arda");
        String text="Axtarış Tapılmadı";
        mv.addObject("text4",text);
        return mv;
    }
}
