package com.dailyTasks.dailyTasks.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailyTasks.dailyTasks.Entity.Task;
import com.dailyTasks.dailyTasks.Repository.TaskRepository;

@Service
public class TaskService {

  @Autowired
  private TaskRepository taskRepository;

  public Task findTaskById(Long id) {

    return this.taskRepository.findById(id).orElse(null);
  }

  public List<Task> filterTasks(String title) {

    return this.taskRepository.findAll();
  }

}
