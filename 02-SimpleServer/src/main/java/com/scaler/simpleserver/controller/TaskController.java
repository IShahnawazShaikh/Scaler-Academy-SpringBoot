package com.scaler.simpleserver.controller;

import com.scaler.simpleserver.dto.TaskResponseDto;
import com.scaler.simpleserver.service.TaskService;
import com.scaler.simpleserver.serviceimpl.TaskServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/getAllTask")
    public ResponseEntity<List<TaskResponseDto>> getAllTask(){
         var taskList=taskService.getAllTask();
         return ResponseEntity.ok(taskList);
    }
}
