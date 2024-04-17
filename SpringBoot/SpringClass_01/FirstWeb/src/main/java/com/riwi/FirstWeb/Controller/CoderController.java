package com.riwi.FirstWeb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.riwi.FirstWeb.Entity.Coder;
import com.riwi.FirstWeb.Services.CoderService;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/")
public class CoderController {
  @Autowired
  private CoderService coderService;

  @GetMapping
  public String showCoders(Model model) {
    List<Coder> list = this.coderService.findAll();
    model.addAttribute("Coderlist", list);
    return "Coders";
  }

  // @GetMapping
  // public String addCoder(Model model) {
  // model.addAttribute("Coder", new Coder());
  // return "CoderForm";
  // }
}
