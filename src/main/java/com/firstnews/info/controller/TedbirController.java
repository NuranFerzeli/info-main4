package com.firstnews.info.controller;

import com.firstnews.info.entity.News;
import com.firstnews.info.entity.Tedbir;
import com.firstnews.info.model.NewsModel;
import com.firstnews.info.model.TedbirModel;
import com.firstnews.info.repo.TedbirRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TedbirController {
    private TedbirRepository tedbirRepository;
    public TedbirController(TedbirRepository tedbirRepository){
        this.tedbirRepository=tedbirRepository;
    }
    @RequestMapping(method = RequestMethod.GET , value = "/assembly")
    public String getLogin(){
        return "tedbir.html";
    }
    @RequestMapping(method = RequestMethod.GET , value = "/tedbirler")
    public ModelAndView getAssembly(){
        String key="tedbir";
        TedbirModel tedbirModel = null;
        List<Tedbir> tedbir=new ArrayList<>();
        tedbir= tedbirRepository.findAll();

        for (Tedbir t:tedbir) {
            tedbirModel = new TedbirModel();
            tedbirModel.setAssemblyName(t.getAssembleName());
            tedbirModel.setId(t.getId());
            tedbirModel.setAssembleDate(t.getCdate());
        }
        ModelAndView modelAndView = new ModelAndView("admin");
        modelAndView.addObject("key",key);
        modelAndView.addObject("Id", tedbirModel.getId());
        modelAndView.addObject("name", tedbirModel.getAssemblyName());
        modelAndView.addObject("text", tedbirModel.getAssembleText());
        modelAndView.addObject("date", tedbirModel.getAssembleDate());
        modelAndView.addObject("date", tedbirModel.getImageName());
        return modelAndView;
    }
}
