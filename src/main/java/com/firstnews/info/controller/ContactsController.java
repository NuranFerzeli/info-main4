package com.firstnews.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactsController {
    @RequestMapping(method = RequestMethod.GET , value = "/blog")
    public String getContacts(){
        return "blog.html";
    }
}
