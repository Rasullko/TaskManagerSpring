package com.example.taskmanagerSpring;
import org.springframework.http.ResponseEntity;
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
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTasks(@PathVariable Long id, @RequestBody Task updatedTask){
        return taskRepository.findById(id)
                .map(task ->{
                    task.setTitle(updatedTask.getTitle());
                    task.setDescription(updatedTask.getDescription());
                    task.setCompleted(updatedTask.getCompleted());
                    Task savedTask = taskRepository.save(task);
                    return ResponseEntity.ok(savedTask);
                } )
                .orElseGet(() -> ResponseEntity.notFound().build());

    }
}
