package com.dailyTasks.dailyTasks.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

  public List<Task> findAll() {
    return this.taskRepository.findAll();
  }

  public Task addTask(Task task) {
    return this.taskRepository.save(task);
  }

  public Task updateTask(Long id, Task task) {
    Task taskUpdate = findTaskById(id);

    if (taskUpdate == null) {
      return null;
    }
    taskUpdate = task;
    return this.taskRepository.save(taskUpdate);
  }

  public Task deleteTask(Long id) {
    Task taskDelete = findTaskById(id);

    if (taskDelete == null) {
      return null;
    }
    this.taskRepository.delete(taskDelete);
    return taskDelete;
  }
  
  public Page<Task> findPaginated(int page, int size) {
    if (page < 0) {
      page = 1;
    }

    Pageable pageable = PageRequest.of(page, size);

    return this.taskRepository.findAll(pageable);
  }
}

