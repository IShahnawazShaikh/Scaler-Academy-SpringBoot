package com.scaler.taskmanagement.task;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "task")
public class TaskEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "task_name")
    private String taskName;

    @Column(name="is_completed")
    private Boolean isCompleted;

    @Column(name="due_date")
    private Date dueDate;

}
