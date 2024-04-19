package com.dailyTasks.dailyTasks.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dailyTasks.dailyTasks.Entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}