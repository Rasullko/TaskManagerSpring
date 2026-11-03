package com.example.taskmanagerSpring;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    public final TaskRepository taskRepository;
    public TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }
    @PostMapping
    public Task createTasks(@RequestBody Task task){
        return taskRepository.save(task);
    }
    @DeleteMapping("/{id}")
    public void deleteTasks(@PathVariable Long id){
        taskRepository.deleteById(id);
    }
}
