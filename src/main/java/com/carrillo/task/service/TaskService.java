package com.carrillo.task.service;

import com.carrillo.task.exceptions.ToDoExceptions;
import com.carrillo.task.mapper.TaskDTOToTask;
import com.carrillo.task.persintence.entity.Task;
import com.carrillo.task.persintence.entity.TaskStatus;
import com.carrillo.task.persintence.repository.TaskRepository;
import com.carrillo.task.service.dto.TaskDTO;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskDTOToTask taskDTOToTask;
    @Autowired
    private TaskRepository taskRepository;

      public Task createTask(TaskDTO taskDTO){
          Task task = taskDTOToTask.map(taskDTO);
          return taskRepository.save(task);

    }
    public List<Task> getAllTask(){
          return taskRepository.findAll();
    }

    public List<Task> getTaskForStatus(TaskStatus status){
          return taskRepository.findByTaskStatus(status);
    }

    @Transactional
    public void taskFinished(Long id){
        Optional<Task> optionalTask = taskRepository.findById(id);
          if(optionalTask.isEmpty()){
              throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
          }
          taskRepository.updateFinished(id);
    }

    public void deleteById(Long id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        taskRepository.deleteById(id);
    }



}
