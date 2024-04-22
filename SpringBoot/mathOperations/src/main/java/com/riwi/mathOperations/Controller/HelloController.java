package com.riwi.mathOperations.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/api/v1/greet")
public class HelloController {
  @GetMapping
  @ResponseBody
  public String getMethodName() {
    return "Hello world";
  }

}
