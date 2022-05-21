package com.scaler.simpleserver.controller;

import com.scaler.simpleserver.exceptionhandling.NotFoundErrorMessage;
import com.scaler.simpleserver.dto.TaskResponseDto;
import com.scaler.simpleserver.exceptionhandling.TaskNotFoundException;
import com.scaler.simpleserver.models.Task;
import com.scaler.simpleserver.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("findTaskById/{id}")
    public ResponseEntity<Task> findTaskById(@PathVariable("id") Integer id){
        var task=taskService.findTaskById(id);
        return new ResponseEntity<>(task,HttpStatus.OK);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<NotFoundErrorMessage> handleException(Exception ex) {
       NotFoundErrorMessage notFoundErrorMessage=new NotFoundErrorMessage(ex.getMessage());
       return new ResponseEntity<>(notFoundErrorMessage,HttpStatus.NOT_FOUND);
    }
}
