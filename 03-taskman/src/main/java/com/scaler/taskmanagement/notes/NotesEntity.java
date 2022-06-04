package com.scaler.taskmanagement.notes;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name="notes")
public class NotesEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "notes_name")
    private String notesName;

    @Column(name="is_completed")
    private Boolean isCompleted;

    @Column(name="due_date")
    private Date dueDate;


}
