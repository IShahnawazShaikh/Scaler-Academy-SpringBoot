package com.scaler.simpleserver.service;

import com.scaler.simpleserver.dto.TaskResponseDto;
import com.scaler.simpleserver.models.Task;
import com.scaler.simpleserver.serviceimpl.TaskServiceImplementation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    List<TaskResponseDto> getAllTask();
    Task findTaskById(Integer id);
}
