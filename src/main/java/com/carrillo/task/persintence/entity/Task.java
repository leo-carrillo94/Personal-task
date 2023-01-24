package com.carrillo.task.persintence.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String descrption;
    private LocalDateTime createData;
    private LocalDateTime eta;
    //eta siglas en ingles de fecha terminacion estimada
    private boolean finished;
    private TaskStatus taskStatus;


}
