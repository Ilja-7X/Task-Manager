package com.example.taskmanagerdemo.repository;

import com.example.taskmanagerdemo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
