package com.firstnews.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SaveController {
    @RequestMapping(value = "save")
    public String getLogin(@RequestParam(value = "id") int id){
        switch (id){
            case 1:
                System.out.println("tedbir");
                break;
            case 2:
                System.out.println("trainer");
                break;
            case 3:
                System.out.println("sportmen");
                break;
            default:
                System.out.println("gorum bura girir?");
        }
        return "save.html";
    
}}
