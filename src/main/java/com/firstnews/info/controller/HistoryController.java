package com.firstnews.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HistoryController {
@RequestMapping(method = RequestMethod.GET, value = "/history")
    public String getVideos() {
        return "sports.html";
    }
}
