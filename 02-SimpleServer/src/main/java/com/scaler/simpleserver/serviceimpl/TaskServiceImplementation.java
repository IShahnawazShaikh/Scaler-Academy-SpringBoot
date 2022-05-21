package com.scaler.simpleserver.serviceimpl;

import com.scaler.simpleserver.dto.TaskResponseDto;
import com.scaler.simpleserver.exceptionhandling.TaskNotFoundException;
import com.scaler.simpleserver.models.Task;
import com.scaler.simpleserver.service.TaskService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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
         toReturnList.add(new TaskResponseDto(task.getId(),task.getTaskName(),task.getIsCompleted(),task.getDueBy()));
      });
       return toReturnList;
    }

    @Override
    public Task findTaskById(Integer id)  {
        AtomicReference<Task> task = new AtomicReference<>();
        taskList.forEach(t -> {
            if (t.getId() == id) { task.set(t); }
        });
        if (task.get() == null) {
            throw new TaskNotFoundException(id);
        }
        return task.get();
    }
}
