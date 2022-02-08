package com.firstnews.info.controller;



import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.firstnews.info.entity.SportMen;
import com.firstnews.info.entity.Trainer;
import com.firstnews.info.model.SportModel;
import com.firstnews.info.model.TrainerModel;
import com.firstnews.info.repo.SportRepository;
import com.firstnews.info.repo.TrainerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.firstnews.info.entity.News;
import com.firstnews.info.repo.NewsRepository;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class Add {
	private final NewsRepository newsRepository;
	private final TrainerRepository trainerRepository;
	private final SportRepository sportRepository;


	
	public Add(NewsRepository newsRepository, TrainerRepository trainerRepository, SportRepository sportRepository){
        this.newsRepository=newsRepository;
		this.trainerRepository = trainerRepository;
		this.sportRepository = sportRepository;
	}
	 @RequestMapping(method = RequestMethod.POST, value = "/add" )
	public ModelAndView saveNews(@RequestParam (value="name") String name ,
								 @RequestParam(value="surName",required = false) String surName, @RequestParam(value="fatherName",required = false) String fatherName,
								 @RequestParam(value="date") String date,
								 @RequestParam("image") MultipartFile[] photo, @RequestParam(value="detailedİnformation") String content,
								 @RequestParam(value="option") String option, @RequestParam(value="cinsi") String gender ) {
		 LocalDate date1 = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		 ModelAndView modelAndView = null;
		 System.out.println(option);
		 List<String> imageNames=new ArrayList<>();
		 System.out.println(photo.length);
		 System.out.println(photo[0].getOriginalFilename());
		 String cins;
		 cins=gender.equals("Kisi")?"Kisi":"Qadin";
		 System.out.println(cins);
		 for(int i=0;i<photo.length;i++){
	 		imageNames.add(photo[i].getOriginalFilename());
		 }
		 if(option.equals("tedbir")){

		 }else if(option.equals("trainer")){
			 Trainer trainer=new Trainer();
			 trainer.setName(name);
			 trainer.setSurName(surName);
			 trainer.setFatherName(fatherName);
			 trainer.setDob(date1);
			 trainer.setDetailedInformation(content);
			 trainer.setCdate(LocalDate.now());
			 trainer.setStatus_id(1L);
			 if(imageNames.size()==1){
				 trainer.setImagePath(imageNames.get(0));
			 }else {
				 System.out.println("Trainer e birden cox sekil elave edildi");
			 }

			// trainerRepository.save(trainerModel);
			 System.out.println("Trainer elave edildi");
			 Path path=Paths.get("uploads/");
			 try {
				 InputStream inputstream=photo[0].getInputStream();
				 Files.copy(inputstream, path.resolve(photo[0].getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
				 trainer.setImagePath(photo[0].getOriginalFilename().toLowerCase());

			 } catch (Exception e) {
				 // TODO: handle exception
			 }
			 trainerRepository.save(trainer);
			 System.out.println("Elave edildi");
			 modelAndView= new ModelAndView(new RedirectView("trainerler"));
		 }
		 else{
			 SportMen sport=new SportMen();
			 sport.setName(name);
			 sport.setSurName(surName);
			 sport.setFatherName(fatherName);
			 sport.setDob(date1);
			 sport.setStatus_id(1L);
			 sport.setCdate(LocalDate.now());

			 if(imageNames.size()==1){
				 sport.setImagePath(imageNames.get(0));
			 }else {
				 System.out.println("Trainer e birden cox sekil elave edildi");
			 }
			 Path path=Paths.get("uploads/");
			 try {
				 InputStream inputstream=photo[0].getInputStream();
				 Files.copy(inputstream, path.resolve(photo[0].getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
				 sport.setImagePath(photo[0].getOriginalFilename().toLowerCase());

			 } catch (Exception e) {
				 // TODO: handle exception
			 }
			 sportRepository.save(sport);
			 System.out.println("Elave edildi");
			 modelAndView= new ModelAndView(new RedirectView("idmancilar"));
		 }

//		 System.out.println(photo.getOriginalFilename());


//		System.out.println(photo.getOriginalFilename());
//		News news=new News();
//		news.setId(10L);
//		System.out.println(date + " Parsed DateTime");
//		System.out.println("Xeber Elave eEdildi");
//		System.out.println("Xeberin adi" + name);
//		news.setNewsName(name);
//		news.setImagePath(photo.getOriginalFilename());
//		news.setNewsTitle(content);
//		System.out.println("Xeberin vaxti" + newsDate);
//		Path path=Paths.get("arda");
//		try {
//		InputStream inputStream=photo.getInputStream();
//			System.out.println(photo.getOriginalFilename());
//		Files.copy(inputStream,path.resolve(photo.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
//
//
//		} catch (Exception e) {
//		}
//		newsRepository.save(news);
		
		return modelAndView;
	}
}
