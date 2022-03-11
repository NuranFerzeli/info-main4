package com.firstnews.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(SaveController.BASE_URL)
public class SaveController {
    static final String BASE_URL = "/adm";
    @RequestMapping(value = "save")
    public ModelAndView getLogin(@RequestParam(value = "id") int id){
        ModelAndView mv=new ModelAndView("save");
        boolean deger=false;
        boolean deger1=false;
        switch (id){
            case 1:
                System.out.println("tedbir");
                deger1=true;
                break;
            case 2:
                System.out.println("trainer");
                deger=true;
                break;
            case 3:
                deger=true;
                System.out.println("sportmen");
                break;
            default:
                System.out.println("gorum bura girir?");
        }
        mv.addObject("deger",deger);
        mv.addObject("deger1",deger1);
        return mv;
    
}}
