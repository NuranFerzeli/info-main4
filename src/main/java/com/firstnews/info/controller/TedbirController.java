package com.firstnews.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TedbirController {
    @RequestMapping(method = RequestMethod.GET , value = "/assembly")
    public String getLogin(){
        return "tedbir.html";
    }
}