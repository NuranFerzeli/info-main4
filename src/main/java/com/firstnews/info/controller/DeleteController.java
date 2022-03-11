package com.firstnews.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping(DeleteController.BASE_URL)
public class DeleteController {
    static final String BASE_URL = "/adm";
        @RequestMapping(method = RequestMethod.GET , value = "/delete")
        public String getLogin(){
            return "delete.html";
        }
    }
