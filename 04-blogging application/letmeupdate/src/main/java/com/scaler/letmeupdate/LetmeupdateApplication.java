package com.scaler.letmeupdate;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LetmeupdateApplication {

    public static void main(String[] args) {
        SpringApplication.run(LetmeupdateApplication.class, args);
    }
   @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
   }
}
