package com.firstnews.info;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfoApplication.class, args);
    }

    @Bean
    public ModelMapper getmodelMapper() {
        return new ModelMapper();
    }

}
