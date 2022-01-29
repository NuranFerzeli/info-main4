package com.firstnews.info.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
@RequestMapping(method = RequestMethod.POST, value = "/admin1")
   public String getAdmin(@RequestParam(name = "username") String username, @RequestParam(name = "pass") String password){
    System.out.println(username + " " + password);
    return "admin.html";
}
}
