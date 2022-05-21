package com.scaler.simpleserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class TaskResponseDto {
    private Integer id;
    private String taskName;
    private Boolean isCompleted;
    private Date dueBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public Date getDueBy() {
        return dueBy;
    }

    public void setDueBy(Date dueBy) {
        this.dueBy = dueBy;
    }
}
