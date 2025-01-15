package com.marius.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marius.taskmanager.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}