package com.scaler.taskmanagement.notes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<NotesEntity,Long> {
}
