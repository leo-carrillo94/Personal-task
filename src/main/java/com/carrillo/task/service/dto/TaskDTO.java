package com.carrillo.task.service.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TaskDTO {


    private String title;
    private String descrption;
    private LocalDateTime eta;



}
