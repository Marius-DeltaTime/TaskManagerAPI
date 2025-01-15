package com.marius.taskmanager.controller;

import com.marius.taskmanager.entity.Task;
import com.marius.taskmanager.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController 
{

    private final TaskRepository taskRepository;

    // Constructor Injection (Spring will auto-wire if there's only one constructor)
    public TaskController(TaskRepository taskRepository) 
    {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getAllTasks() 
    {
        return taskRepository.findAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) 
    {
        return taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task)
    {
        // Fetch the task by id and update it
        task.setId(id);
        return taskRepository.save(task); // Save the updated task
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id)
    {
        taskRepository.deleteById(id);
    }
}

