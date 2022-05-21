package com.scaler.simpleserver.service;

import com.scaler.simpleserver.dto.TaskResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    List<TaskResponseDto> getAllTask();
}
