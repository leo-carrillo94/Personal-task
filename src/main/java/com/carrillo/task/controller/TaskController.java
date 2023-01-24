package com.carrillo.task.controller;

import com.carrillo.task.persintence.entity.Task;
import com.carrillo.task.persintence.entity.TaskStatus;
import com.carrillo.task.service.TaskService;
import com.carrillo.task.service.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private  TaskService taskService;
    @PostMapping
    public Task createTask(@RequestBody TaskDTO taskDTO){
       return taskService.createTask(taskDTO);
    }

    @GetMapping
    public List<Task> getAllTask(){
        return taskService.getAllTask();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTaskForStatus(@PathVariable("status") TaskStatus status){
        return  taskService.getTaskForStatus(status);
    }

    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id){
        taskService.taskFinished(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id){
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
