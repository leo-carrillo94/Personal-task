package com.carrillo.task.mapper;

import com.carrillo.task.persintence.entity.Task;
import com.carrillo.task.persintence.entity.TaskStatus;
import com.carrillo.task.service.dto.TaskDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class TaskDTOToTask implements IMapper<TaskDTO, Task>{
    @Override
    public Task map(TaskDTO taskDTO) {
        Task task = new Task();

        task.setTitle(taskDTO.getTitle());
        task.setDescrption(taskDTO.getDescrption());
        task.setEta(taskDTO.getEta());
        task.setCreateData(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);

        return task;
    }
}
