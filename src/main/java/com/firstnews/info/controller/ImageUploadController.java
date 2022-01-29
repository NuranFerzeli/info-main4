package com.firstnews.info.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


@Controller
public class ImageUploadController{
    @RequestMapping(value ="photos/{photos}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable("photos") String photo)throws IOException{

        if(!photo.equals("")||photo!=null){
            try {
                Path fileName= Paths.get("uploads",photo);
                System.out.println(fileName);
                byte [] buffer= Files.readAllBytes(fileName);
                ByteArrayResource byteArrayResource=new ByteArrayResource(buffer);
                return ResponseEntity.ok().contentLength(buffer.length).
                        contentType(MediaType.parseMediaType("image/png")).body(byteArrayResource);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }/* */
        return ResponseEntity.badRequest().build();
    }

}
