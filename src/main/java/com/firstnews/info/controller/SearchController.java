package com.firstnews.info.controller;

import org.apache.coyote.http11.filters.IdentityOutputFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(SearchController.BASE_URL)
public class SearchController {
    static final String BASE_URL = "/adm";
    @RequestMapping(method = RequestMethod.POST, value = "/search")
    public ModelAndView getSearch(@RequestParam(value = "name") String name, @RequestParam(value = "option") String option, HttpSession session){
        ModelAndView modelAndView;
        if(option.equals("tedbir")){
            System.out.println(option);
            session.setAttribute("tedbirName",name);
            System.out.println(name);
            modelAndView= new ModelAndView(new RedirectView("assembly"));
        }

        else if(option.equals("trainer")){
            System.out.println(option);
            session.setAttribute("trainerName",name);
            System.out.println(name);
            System.out.println("TrainerName");
            modelAndView= new ModelAndView(new RedirectView("trainer"));
        }
       else {
            System.out.println(option);
            session.setAttribute("sportName",name);
            System.out.println(name);
            modelAndView= new ModelAndView(new RedirectView("sport"));
        }



        return modelAndView;
    }
}
