package com.firstnews.info.controller;

import com.firstnews.info.entity.SportMen;
import com.firstnews.info.model.SportModel;
import com.firstnews.info.repo.SportRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SportsController {
    private final SportRepository sportRepository;

    public SportsController(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sports")
    public String getVideos() {
        return "sports.html";
    }

    @RequestMapping(value = "sport3", method = RequestMethod.GET)
    public String deleteSportMen(@RequestParam(value = "id") Long id, HttpSession session) {
        session.setAttribute("deleteId", id);
        return "delete.html";
    }

    @RequestMapping(value = "sport2", method = RequestMethod.GET)
    public ModelAndView updateSportMen(@RequestParam(value = "id") Long id, HttpSession session) {
        session.setAttribute("updateId", id);
        boolean deger1 = true;
        SportModel sportModel;
        List<SportMen> sportMen;
        List<SportModel> sportModels = new ArrayList<>();
        sportMen = sportRepository.findAll();

        for (SportMen s : sportMen) {
            if (s.getStatus_id() == 1) {
                sportModel = new SportModel();
                sportModel.setId(s.getId());
                sportModel.setName(s.getName());
                sportModel.setSurname(s.getSurName());
                sportModel.setFatherName(s.getFatherName());
                sportModel.setImageName(s.getImagePath());
                sportModel.setDetailedInformation(s.getDetailedInformation());
                sportModel.setDob(s.getDob());
                sportModels.add(sportModel);
            }
        }
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("sports", sportModels);
        modelAndView.addObject("deger1", deger1);
        return modelAndView;
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam(value = "name") String name,@RequestParam(value = "surName") String surName,@RequestParam(value = "fatherName") String fatherName,
                               @RequestParam(value = "dob") String dob,@RequestParam(value = "imageName") String imageName,
                               @RequestParam(value = "detailedInformation") String detailedInformation, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView(new RedirectView("idmancilar"));
        Long id = (Long) session.getAttribute("updateId");
        List<SportMen> sportMen = new ArrayList<>();
        sportMen.addAll(sportRepository.getById(id));
        for (SportMen s : sportMen) {
            s.setName(name);
            s.setSurName(surName);
            s.setFatherName(fatherName);
            s.setImagePath(imageName);
            s.setUdate(LocalDate.now());
            s.setDob(LocalDate.parse(dob));
            s.setDetailedInformation(detailedInformation);
            sportRepository.save(s);
        }

        return modelAndView;
    }

    @RequestMapping(value = "sportD", method = RequestMethod.GET)
    public ModelAndView deleteUser(Model model, HttpSession session) {
        //    log.info("that is deleteuser" + session.getAttribute("deleteId"));
        Long id1 = 2L;
        Long id = (Long) session.getAttribute("deleteId");
        List<SportMen> sportMen = new ArrayList<>();
        sportMen.addAll(sportRepository.getById(id));
        for (SportMen s : sportMen) {
            s.setStatus_id(id1);
            sportRepository.save(s);
        }
        System.out.println(sportMen + " 12");
        ModelAndView modelAndView = new ModelAndView(new RedirectView("idmancilar"));
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/idmancilar")
    public ModelAndView getAssembly() {
        String key = "sport";
        boolean deger1 = true;
        SportModel sportModel;
        List<SportMen> sportMen;
        List<SportModel> sportModels = new ArrayList<>();
        sportMen = sportRepository.findAll();

        for (SportMen s : sportMen) {
            if (s.getStatus_id() == 1) {
                sportModel = new SportModel();
                sportModel.setId(s.getId());
                sportModel.setName(s.getName());
                sportModel.setSurname(s.getSurName());
                sportModel.setFatherName(s.getFatherName());
                sportModel.setImageName(s.getImagePath());
                sportModel.setDetailedInformation(s.getDetailedInformation());
                sportModel.setDob(s.getDob());
                sportModels.add(sportModel);
            }
        }
        ModelAndView modelAndView = new ModelAndView("admin");
        modelAndView.addObject("sports", sportModels);
        modelAndView.addObject("deger1", deger1);
        return modelAndView;
    }
}
