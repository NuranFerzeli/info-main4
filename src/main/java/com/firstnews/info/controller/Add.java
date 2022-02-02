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
	public String  saveNews(@RequestParam (value="name") String name ,
			@RequestParam(value="surName") String surName,@RequestParam(value="surName") String fatherName,@RequestParam(value="date") String date,
		    @RequestParam("image") MultipartFile[] photo,@RequestParam(value="detailedİnformation") String content,
							@RequestParam(value="option") String option ) {
		 LocalDate date1 = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		 System.out.println(option);
		 List<String> imageNames=new ArrayList<>();
		 System.out.println(photo.length);
		 System.out.println(photo[0].getOriginalFilename());
		 for(int i=0;i<photo.length;i++){
	 		imageNames.add(photo[i].getOriginalFilename());
		 }
		 if(option.equals("tedbir")){
		 }else if(option.equals("trainer")){
			 TrainerModel trainerModel=new TrainerModel();
			 trainerModel.setName(name);
			 trainerModel.setSurname(surName);
			 trainerModel.setFatherName(fatherName);
			 trainerModel.setDob(date1);
			 trainerModel.setDetailedInformation(content);
			 if(imageNames.size()==1){
				 trainerModel.setImageName(imageNames.get(0));
			 }else {
				 System.out.println("Trainer e birden cox sekil elave edildi");
			 }
			// trainerRepository.save(trainerModel);
			 System.out.println("Trainer elave edildi");
		 }
		 else{
			 SportModel sportModel=new SportModel();
			 sportModel.setName(name);
			 sportModel.setSurname(surName);
			 sportModel.setFatherName(fatherName);
			 sportModel.setDob(date1);
			 if(imageNames.size()==1){
				 sportModel.setImageName(imageNames.get(0));
			 }else {
				 System.out.println("Trainer e birden cox sekil elave edildi");
			 }
		 }
		 System.out.println(name);
		 System.out.println(name);
		 System.out.println(fatherName);
		 System.out.println(content);
		 System.out.println(date1);
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
//			// TODO: handle exception
//		}
//		newsRepository.save(news);
		
		return "admin.html";
	}
}
