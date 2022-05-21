package com.scaler.simpleserver;

import com.scaler.simpleserver.service.TaskService;
import com.scaler.simpleserver.serviceimpl.TaskServiceImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimpleServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleServerApplication.class, args);
    }

    @Bean
    public TaskService tasksService() {
        return new TaskServiceImplementation();
    }
}
