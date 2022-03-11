package com.firstnews.info.controller;



import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.firstnews.info.entity.SportMen;
import com.firstnews.info.entity.Tedbir;
import com.firstnews.info.entity.TedbirImages;
import com.firstnews.info.entity.Trainer;
import com.firstnews.info.repo.*;
import com.jcraft.jsch.*;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class Add {
	private final TedbirImagesRepository tedbirImagesRepository;
	private final TrainerRepository trainerRepository;
	private final SportRepository sportRepository;
	private final TedbirRepository tedbirRepository;
	@Autowired
	private Environment env;

	
	public Add(TedbirImagesRepository tedbirImagesRepository, TrainerRepository trainerRepository, SportRepository sportRepository, TedbirRepository tedbirRepository){
        this.tedbirImagesRepository=tedbirImagesRepository;
		this.trainerRepository = trainerRepository;
		this.sportRepository = sportRepository;
		this.tedbirRepository = tedbirRepository;

	}
	 @RequestMapping(method = RequestMethod.POST, value = "/add" )
	public ModelAndView saveNews(@RequestParam (value="name") String name ,
								 @RequestParam(value="surName",required = false) String surName, @RequestParam(value="fatherName",required = false) String fatherName,
								 @RequestParam(value="date") String date,
								 @RequestParam("image") MultipartFile[] photo,
								 @RequestParam(value = "tedbirPhoto" ,required = false) MultipartFile tedbirPhoto ,
								 @RequestParam(value="detailedİnformation") String content,
								 @RequestParam(value="shortInfo",required = false) String shortInfo,
								 @RequestParam(value="option") String option ) {
		 LocalDate date1 = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		 ModelAndView modelAndView = null;
		 List<String> imageNames=new ArrayList<>();
		 System.out.println(photo.length);
		 System.out.println(photo[0].getOriginalFilename());
		 final String serverName = env.getProperty("server.name");
		 final String serverPassword = env.getProperty("server.password");
		 for(int i=0;i<photo.length;i++){
	 		imageNames.add(photo[i].getOriginalFilename());
		 }
		 if(option.equals("tedbir")){
			 Tedbir tedbir=new Tedbir();
			 tedbir.setAssembleName(name);
			 tedbir.setShortInfo(shortInfo);
			 tedbir.setText(content);
			 tedbir.setCdate(LocalDate.now());
			 tedbir.setImagePath(tedbirPhoto.getOriginalFilename());
			 tedbir.setStatus_id(1L);
			 Path path= Paths.get("C://Users//User//Desktop//info-main//src//main//resources//uploads");
			 try {
				 InputStream inputstream=tedbirPhoto.getInputStream();
				 Files.copy(inputstream, path.resolve(tedbirPhoto.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
				 tedbir.setImagePath(tedbirPhoto.getOriginalFilename().toLowerCase());

			 } catch (Exception e) {
				 // TODO: handle exception
			 }
			 tedbirRepository.save(tedbir);
			 TedbirImages tedbirImages ;
			 System.out.println(tedbir.getId());

			 InputStream inputstream = null;
			 try {
			 	for (int i=0;i<photo.length;i++) {
					tedbirImages=new TedbirImages();
					inputstream = photo[i].getInputStream();
					System.out.println(photo[i].getOriginalFilename() + "Dovrun icindeyem image");
					Files.copy(inputstream, path.resolve(photo[i].getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
					tedbirImages.setImageName(photo[i].getOriginalFilename().toLowerCase());
					System.out.println(photo[i].getOriginalFilename());
					tedbirImages.setTedbirId(tedbir.getId());
					tedbirImages.setStatus_id(1l);
					tedbirImagesRepository.save(tedbirImages);
					System.out.println(i);
				}
			 } catch (Exception e) {
				 // TODO: handle exception
			 }

			 System.out.println("Elave edildi");
			 modelAndView= new ModelAndView(new RedirectView("trainerler"));

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
			 System.out.println("Trainer elave edildi");


			 String host = "94.20.233.141";
			 int port = 22;

			 try {
				 JSch jsch = new JSch();
				 Session session = jsch.getSession(serverName, host, port);
				 session.setPassword(serverPassword);
				 session.setConfig("StrictHostKeyChecking", "no");
				 System.out.println("Establishing Connection...");
				 session.connect();
				 System.out.println("Connection established.");
				 System.out.println("Crating SFTP Channel.");
				 ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
				 sftpChannel.connect();
				 System.out.println("SFTP Channel created.");
				 InputStream inputstream=photo[0].getInputStream();
				 sftpChannel.put( inputstream,"/home/lnmr/info-main/src/main/resources/uploads/" +photo[0].getOriginalFilename());
				 System.out.println("servere elave edildi");
				 sftpChannel.disconnect();
				 sftpChannel.exit();
				 session.disconnect();

			 } catch (SftpException | JSchException | IOException e) {
				 e.printStackTrace();
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
             sport.setDetailedInformation(content);
			 if(imageNames.size()==1){
				 sport.setImagePath(imageNames.get(0));
			 }else {
				 System.out.println("Idmanci e birden cox sekil elave edildi");
			 }
			 Path path= Paths.get("C://Users//User//Desktop//info-main//src//main//resources//uploads");
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

		return modelAndView;
	}
}
