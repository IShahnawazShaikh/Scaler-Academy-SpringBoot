package com.scaler.simpleserver.serviceimpl;

import com.scaler.simpleserver.dto.TaskResponseDto;
import com.scaler.simpleserver.models.Task;
import com.scaler.simpleserver.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskServiceImplementation implements TaskService {

    List<Task> taskList=null;
    public TaskServiceImplementation(){
        taskList=new ArrayList<Task>();
        taskList.add(new Task(1,"taks-01",false,new Date()));
        taskList.add(new Task(2, "another task", false, new Date()));
        taskList.add(new Task(3, "more tasks", false, new Date()));

    }

    @Override
    public List<TaskResponseDto> getAllTask() {
        List<TaskResponseDto> toReturnList=new ArrayList<>();
        taskList.stream().forEach(task->{
           TaskResponseDto responseDto=new TaskResponseDto();
           responseDto.setId(task.getId());
           responseDto.setTaskName(task.getTaskName());
           responseDto.setCompleted(task.getCompleted());
           responseDto.setDueBy(task.getDueBy());
         toReturnList.add(responseDto);
      });
       return toReturnList;
    }
}
