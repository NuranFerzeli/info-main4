package com.firstnews.info.controller;


import com.firstnews.info.entity.Trainer;

import com.firstnews.info.model.TrainerModel;

import com.firstnews.info.repo.TrainerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

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
@RequestMapping(TrainerController.BASE_URL)
public class TrainerController {
    private TrainerRepository trainerRepository;
    static final String BASE_URL = "/adm";

    public TrainerController(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @RequestMapping(value = "trainer3", method = RequestMethod.GET)
    public String deleteCustomer(@RequestParam(value = "id") Long id, HttpSession session) {
        session.setAttribute("deleteId", id);
        return "delete1.html";
    }
    @RequestMapping(value = "trainer", method = RequestMethod.GET)
    public ModelAndView findTrainer( @RequestParam(value = "name", required=false) String name ,HttpSession session) {
        TrainerModel trainerModel;
        List<TrainerModel> trainerModels = new ArrayList<>();
        List<Trainer> trainers = new ArrayList<>();
        boolean disable2=false;

        System.out.println(session.getAttribute("trainerName"));
        if(name==null){
            name=(String) session.getAttribute("trainerName");
        }

            trainers.addAll(trainerRepository.getByNameStartsWith(name));
            System.out.println("Ifdeyem");
            System.out.println(session.getAttribute("trainerName"));
        for (Trainer t : trainers) {
            if(t.getStatus_id()==1){

                trainerModel = new TrainerModel();
                trainerModel.setId(t.getId());
                trainerModel.setName(t.getSurName() + " " + t.getName() + " " +t.getFatherName());
                trainerModel.setImageName(t.getImagePath());
                trainerModel.setDetailedInformation(t.getDetailedInformation());
                trainerModel.setDob(t.getDob());
                trainerModels.add(trainerModel);
            }
        }

        ModelAndView modelAndView = new ModelAndView("trainers");
        modelAndView.addObject("trainers", trainerModels);
        modelAndView.addObject("disable2", disable2);
        return modelAndView;
    }
    @RequestMapping(value = "trainerD", method = RequestMethod.GET)
    public ModelAndView deleteTrainer( HttpSession session) {

        Long id1 = 2L;
        Long id = (Long) session.getAttribute("deleteId");
        List<Trainer> trainers = new ArrayList<>();
        trainers.addAll(trainerRepository.getById(id));
        for (Trainer t : trainers) {
            t.setStatus_id(id1);
            trainerRepository.save(t);
        }
        ModelAndView modelAndView = new ModelAndView(new RedirectView("trainerler"));
        return modelAndView;
    }
    @RequestMapping(value = "trainer2", method = RequestMethod.GET)
    public ModelAndView updateTrainer(@RequestParam(value = "id") Long id, HttpSession session) {
        session.setAttribute("updateId", id);
        boolean deger1 = true;
        TrainerModel trainerModel;
        List<Trainer> trainers;
        List<TrainerModel> trainerModels = new ArrayList<>();
        trainers = (List<Trainer>) trainerRepository.getById(id);

        for (Trainer t : trainers) {
            if (t.getStatus_id() == 1) {
                trainerModel = new TrainerModel();
                trainerModel.setId(t.getId());
                trainerModel.setName(t.getName());
                trainerModel.setSurname(t.getSurName());
                trainerModel.setFatherName(t.getFatherName());
                trainerModel.setImageName(t.getImagePath());
                trainerModel.setDetailedInformation(t.getDetailedInformation());
                trainerModel.setDob(t.getDob());
                trainerModels.add(trainerModel);
            }
        }
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("trainers", trainerModels);
        modelAndView.addObject("deger1" , deger1);
        return modelAndView;
    }
    @RequestMapping(value = "updateTrainer", method = RequestMethod.POST)
    public ModelAndView updateTrainer(@RequestParam(value = "name") String name,@RequestParam(value = "surName") String surName,@RequestParam(value = "fatherName") String fatherName,
                               @RequestParam(value = "dob") String dob,@RequestParam(value = "imageName") String imageName,
                               @RequestParam(value = "detailedInformation") String detailedInformation, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView(new RedirectView("idmancilar"));
        Long id = (Long) session.getAttribute("updateId");
        List<Trainer> trainer = new ArrayList<>();
        TrainerModel trainerModel = null;
        trainer.addAll(trainerRepository.getById(id));
        for (Trainer t : trainer) {
            t.setName(name);
            t.setSurName(surName);
            t.setFatherName(fatherName);
            t.setImagePath(imageName);
            t.setUdate(LocalDate.now());
            t.setDob(LocalDate.parse(dob));
            t.setDetailedInformation(detailedInformation);
            trainerRepository.save(t);
        }

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET , value = "/trainerler")
    public ModelAndView getTrainers(){
        TrainerModel trainerModel;
        List<Trainer> trainers;
        List<TrainerModel> trainerModels=new ArrayList<>();
        trainers= trainerRepository.findAll();
boolean deger2=true;
        for (Trainer t:trainers) {
            if (t.getStatus_id() == 1) {
            trainerModel = new TrainerModel();
            trainerModel.setId(t.getId());
            trainerModel.setName(t.getName());
            trainerModel.setSurname(t.getSurName());
            trainerModel.setFatherName(t.getFatherName());
            trainerModel.setImageName(t.getImagePath());
            trainerModel.setDetailedInformation(t.getDetailedInformation());
            trainerModel.setDob(t.getDob());
            trainerModels.add(trainerModel);
        }
        }
        ModelAndView modelAndView = new ModelAndView("admin");
        modelAndView.addObject("trainers",trainerModels);
        modelAndView.addObject("deger2",deger2);
        return modelAndView;
    }


//    @RequestMapping(method = RequestMethod.GET, value = "/trainers"  )
//    public ModelAndView getTrainerPage(@RequestParam(value = "start", required = false) String start,
//                                       @RequestParam(value = "fetchCount", required = false) String fetchCount) {
//        int s = (start == null ? 0 : Integer.parseInt(start));
//        int f = (fetchCount == null ? 10 : Integer.parseInt(fetchCount));
//        Pageable pageable = PageRequest.of(s, f);
//        TrainerModel trainerModel;
//        List<TrainerModel> trainerModels = new ArrayList<>();
//        Page<Trainer> trainer = trainerRepository.findAll(pageable);
//        boolean disable=true;
//        boolean disable2=true;
//        if(!trainer.hasNext()
//        ){
//            System.out.println("disable dayam");
//            disable=false;
//        }
//        for (Trainer t : trainer) {
//            if (t.getStatus_id() == 1) {
//                trainerModel = new TrainerModel();
//                trainerModel.setId(t.getId());
//                trainerModel.setName(t.getSurName() + " " + t.getName() + " " +t.getFatherName());
//                trainerModel.setImageName(t.getImagePath());
//                trainerModel.setDetailedInformation(t.getDetailedInformation());
//                trainerModel.setDob(t.getDob());
//                trainerModels.add(trainerModel);
//            }
//        }
//        ModelAndView modelAndView = new ModelAndView("trainers");
//        modelAndView.addObject("trainers", trainerModels);
//
//        modelAndView.addObject("disable", disable);
//        modelAndView.addObject("disable2", disable2);
//        return modelAndView;
//    }



    @RequestMapping(method = RequestMethod.GET, value = "/trainer/save")
    public ModelAndView getSavePage(){
        System.out.println("leo");
        ModelAndView modelAndView= new ModelAndView("insert");
        modelAndView.addObject("name","Xəbərin Adı");
        modelAndView.addObject("description","Xəbərin məzmunu");
        modelAndView.addObject("news","Xəbər");
        modelAndView.addObject("date","Xəbərin Tarixi");
        modelAndView.addObject("picture","Xəbərə Şəkil Əlavə Edin");
        return modelAndView;
    }
}
