package com.firstnews.info.controller;


import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
	public String  saveNews(@RequestParam (value="newsName") String newsName ,
			@RequestParam(value="newsDescription") String newsDescription,@RequestParam(value="newsDate") String newsDate,
			@RequestParam("image") MultipartFile photo,@RequestParam(value="content") String content) {
		 LocalDateTime datetime = LocalDateTime.parse(newsDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
		System.out.println(photo.getOriginalFilename());
		News news=new News();
		news.setId(10L);
		System.out.println(datetime + " Parsed DateTime");
		System.out.println("Xeber Elave eEdildi");
		System.out.println("Xeberin adi" + newsName);
		news.setNewsName(newsName);
		news.setImagePath(photo.getOriginalFilename());
		news.setNewsTitle(content);
		System.out.println("Xeberin vaxti" + newsDate);
		Path path=Paths.get("arda");
		try {
		InputStream inputStream=photo.getInputStream();
			System.out.println(photo.getOriginalFilename());
		Files.copy(inputStream,path.resolve(photo.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		newsRepository.save(news);
		
		return "admin.html";
	}
}
