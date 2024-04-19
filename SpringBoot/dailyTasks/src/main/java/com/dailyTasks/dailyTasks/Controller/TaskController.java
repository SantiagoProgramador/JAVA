package com.dailyTasks.dailyTasks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dailyTasks.dailyTasks.Service.TaskService;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Menu")
public class TaskController {

  @Autowired
  private TaskService taskService;

  
}
