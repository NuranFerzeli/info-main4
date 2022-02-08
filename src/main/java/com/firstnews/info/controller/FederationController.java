package com.firstnews.info.controller;

import com.firstnews.info.entity.Federation;
import com.firstnews.info.repo.FederationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FederationController {
    private final FederationRepository federationRepository;

    public FederationController(FederationRepository federationRepository) {
        this.federationRepository = federationRepository;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/federation")
    public ModelAndView getPage() {
        ModelAndView modelAndView= new ModelAndView("federation");
        Federation federation=new Federation();
        List<Federation> newsList= new ArrayList<>();

        newsList.addAll( federationRepository.findAll());
        for(Federation n:newsList){
            // federation.setImagePath(n.getNewsTitle());
            federation.setName(n.getName());
            federation.setText(n.getText());
            federation.setImagePath(n.getImagePath());
        }

        System.out.println(federation.getText());
        System.out.println(federation.getName());
        System.out.println(federation.getImagePath());


        modelAndView.addObject("name", federation.getName());
        modelAndView.addObject("text", federation.getText());
        modelAndView.addObject("imageName", federation.getImagePath());

        return modelAndView;

    }
}
