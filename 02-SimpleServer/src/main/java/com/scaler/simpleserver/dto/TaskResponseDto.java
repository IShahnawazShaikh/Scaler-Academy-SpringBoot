package com.scaler.simpleserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class TaskResponseDto {
    private Integer id;
    private String taskName;
    private Boolean isCompleted;
    private Date dueBy;
}
