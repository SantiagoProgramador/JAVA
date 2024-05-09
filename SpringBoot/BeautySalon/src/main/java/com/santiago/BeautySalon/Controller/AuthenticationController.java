package com.santiago.BeautySalon.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthenticationController {

  @PostMapping(path = "/auth/login")
  public String login() {
    return "Loggin in...";
  }

  @PostMapping(path = "/auth/register")
  public String register() {
    return "Registering...";
  }
}
