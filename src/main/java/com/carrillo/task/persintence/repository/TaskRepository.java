package com.carrillo.task.persintence.repository;

import com.carrillo.task.persintence.entity.Task;
import com.carrillo.task.persintence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

   public List<Task> findByTaskStatus(TaskStatus status);

   //usando querys nativas de sql
   @Modifying
   @Query(value = "UPDATE TASK SET FINISHED=true WHERE id=:id", nativeQuery = true)
   public void updateFinished(@Param("id") long id);



}
