package com.firstnews.info.controller;

import com.firstnews.info.entity.News;
import com.firstnews.info.repo.TrainerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class TrainerController {
    private TrainerRepository trainerRepository;

    public TrainerController(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/trainers")
    public String getVideos() {
        return "trainers.html";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addTrainer" )
    public String  saveNews(@RequestParam(value="newsName") String newsName ,
                            @RequestParam(value="newsDescription") String newsDescription, @RequestParam(value="newsDate") String newsDate,
                            @RequestParam("image") MultipartFile photo, @RequestParam(value="content") String content) {
        LocalDateTime datetime = LocalDateTime.parse(newsDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
        System.out.println(photo.getOriginalFilename());
        News news = new News();
        news.setId(10L);
        System.out.println(datetime + " Parsed DateTime");
        System.out.println("Xeber Elave eEdildi");
        System.out.println("Xeberin adi" + newsName);
        news.setNewsName(newsName);
        news.setImagePath(photo.getOriginalFilename());
        news.setNewsTitle(content);
        System.out.println("Xeberin vaxti" + newsDate);
        Path path = Paths.get("arda");
        try {
            InputStream inputStream = photo.getInputStream();
            System.out.println(photo.getOriginalFilename());
            Files.copy(inputStream, path.resolve(photo.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);


        } catch (Exception e) {
            // TODO: handle exception
        }
        //trainerRepository.save(news);

        return "admin.html";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/trainer/save")
    public ModelAndView getSavePage(){

        ModelAndView modelAndView= new ModelAndView("insert");
        modelAndView.addObject("name","Xəbərin Adı");
        modelAndView.addObject("description","Xəbərin məzmunu");
        modelAndView.addObject("news","Xəbər");
        modelAndView.addObject("date","Xəbərin Tarixi");
        modelAndView.addObject("picture","Xəbərə Şəkil Əlavə Edin");
        return modelAndView;
    }
}
