package com.firstnews.info.controller;

import com.firstnews.info.entity.Tedbir;
import com.firstnews.info.entity.TedbirImages;
import com.firstnews.info.entity.Trainer;
import com.firstnews.info.model.TedbirImagesModel;
import com.firstnews.info.model.TedbirModel;
import com.firstnews.info.repo.TedbirImagesRepository;
import com.firstnews.info.repo.TedbirRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(TedbirController.BASE_URL)
public class TedbirController {
    static final String BASE_URL = "/adm";
    private TedbirRepository tedbirRepository;
    private TedbirImagesRepository tedbirImagesRepository;
    public TedbirController(TedbirRepository tedbirRepository,  TedbirImagesRepository tedbirImagesRepository1){
        this.tedbirRepository=tedbirRepository;
        this.tedbirImagesRepository = tedbirImagesRepository1;
    }
    @RequestMapping(method = RequestMethod.GET , value = "/assembl")
    public ModelAndView findTedbir(@RequestParam(value = "id", required=false) Long id,
                                    HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("tedbir");
        TedbirModel tedbirModel =new TedbirModel();
        List<Tedbir> tedbirs = new ArrayList<>();
        TedbirImagesModel tedbirImagesModel = null;
        List<TedbirImagesModel> tedbirImagesModels = new ArrayList<>();
        List<TedbirImages> tedbirImages = new ArrayList<>();
        List<TedbirModel> tedbirModels1=new ArrayList<>();
        String name= (String) session.getAttribute("tedbirName");
        if (!(id == null)) {
            tedbirs.addAll(tedbirRepository.getById(id));
            System.out.println("gelen id" + id);
            for (Tedbir t : tedbirs) {
                if (t.getStatus_id() == 1) {
                    tedbirModel = new TedbirModel();
                    tedbirModel.setAssemblyName(t.getAssembleName());
                    tedbirModel.setAssembleText(t.getText());
                    tedbirModel.setImageName(t.getImagePath());
                    session.setAttribute("tid", t.getId());
                    tedbirModels1.add(tedbirModel);
                }}}
        System.out.println("gelen name");
                Long tId = (Long) session.getAttribute("tid");

                tedbirImages.addAll(tedbirImagesRepository.getByTedbirId(tId));
                System.out.println(tedbirImages);
                for (TedbirImages tedbirImages1 : tedbirImages) {
                    tedbirImagesModel = new TedbirImagesModel();
                    tedbirImagesModel.setImageName(tedbirImages1.getImageName());
                    tedbirImagesModels.add(tedbirImagesModel);

                }
        modelAndView.addObject("tedbirModels1", tedbirModels1);
                modelAndView.addObject("tedbirName", tedbirModel.getAssemblyName());
                modelAndView.addObject("tedbirText", tedbirModel.getAssembleText());
                modelAndView.addObject("tedbirImagesModels", tedbirImagesModels);
                System.out.println(tedbirImagesModels.toArray());

            return modelAndView;

        }


    @RequestMapping(method = RequestMethod.GET , value = "/assembly")
    public ModelAndView getAssembly(HttpSession session){
        ModelAndView modelAndView = new ModelAndView("tedbir");
        TedbirModel tedbirModel =new TedbirModel();
        List<Tedbir> tedbirs = new ArrayList<>();
        TedbirImagesModel tedbirImagesModel = null;
        List<TedbirImagesModel> tedbirImagesModels = new ArrayList<TedbirImagesModel>();
        List<TedbirImages> tedbirImages = new ArrayList<>();
        List<TedbirModel> tedbirModels1=new ArrayList<>();
        String name= (String) session.getAttribute("tedbirName");
        if(!(name==null)) {
            tedbirs.addAll(tedbirRepository.getByAssembleName(name));
            System.out.println("Ifdeyem");
            for (Tedbir t : tedbirs) {
                if (t.getStatus_id() == 1) {
                    tedbirModel = new TedbirModel();
                    tedbirModel.setAssemblyName(t.getAssembleName());
                    tedbirModel.setAssembleText(t.getText());
                    tedbirModel.setImageName(t.getImagePath());
                    session.setAttribute("tid", t.getId());
                    System.out.println(name + "gelen");
                    System.out.println(tedbirModel.getAssemblyName() + "db dan gelen");
                    tedbirModels1.add(tedbirModel);
                }
            }
        }

    Long tId = (Long) session.getAttribute("tid");
                tedbirImages.addAll(tedbirImagesRepository.getByTedbirId(tId));
                System.out.println(tedbirImages);
                for (TedbirImages tedbirImages1 : tedbirImages) {
        tedbirImagesModel = new TedbirImagesModel();
        tedbirImagesModel.setImageName(tedbirImages1.getImageName());

        tedbirImagesModels.add(tedbirImagesModel);

    }   Collections.sort(tedbirImagesModels);
        System.out.println();

        modelAndView.addObject("tedbirModels1", tedbirModels1);
                modelAndView.addObject("tedbirName", tedbirModel.getAssemblyName());
                modelAndView.addObject("tedbirText", tedbirModel.getAssembleText());
                modelAndView.addObject("tedbirImagesModels", tedbirImagesModels);
                System.out.println(tedbirImagesModels.toArray());
        return modelAndView;
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
        return modelAndView;
    }
}
