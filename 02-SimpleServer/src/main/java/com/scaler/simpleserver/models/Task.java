package com.scaler.simpleserver.models;

import jdk.jfr.DataAmount;
import lombok.*;

import java.util.Date;

public class Task {
    private Integer id;
    private String taskName;
    private Boolean isCompleted;
    private Date dueBy;

    public Task(Integer id, String taskName, Boolean isCompleted, Date dueBy) {
        this.id = id;
        this.taskName = taskName;
        this.isCompleted = isCompleted;
        this.dueBy = dueBy;
    }

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
