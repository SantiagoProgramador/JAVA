package com.riwi.helloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/controller")
public class HelloWorld {

  @GetMapping("/helloWorld")
  @ResponseBody
  public String showMessage() {
    return """
          <h1 style='color: red;'>Hello World!</h1>
          <p> I am santiago </p>
          <h2>Portfolio</h2>
          <p>I can program in java, html, css, js</p>
        """ + "<p style='color: blue;'> " + sum() + "</p>";
  }

  @GetMapping("/sum")
  @ResponseBody
  public String sum() {
    int a = 123, b = 3;

    return String.valueOf(a + b);
  }
}
