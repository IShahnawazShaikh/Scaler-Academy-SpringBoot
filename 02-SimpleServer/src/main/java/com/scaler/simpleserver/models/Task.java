package com.scaler.simpleserver.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Task {
    private Integer id;
    private String taskName;
    private Boolean isCompleted;
    private Date dueBy;
}
