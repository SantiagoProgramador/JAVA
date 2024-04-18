package com.riwi.FirstWeb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.riwi.FirstWeb.Entity.Coder;
import com.riwi.FirstWeb.Services.CoderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class CoderController {
  @Autowired
  private CoderService coderService;

  @GetMapping
  public String showCoders(Model model, @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "3") int size) {
    Page<Coder> list = this.coderService.findPaginated(page - 1, size);
    model.addAttribute("Coderlist", list);
    model.addAttribute("CurrentPage", page);
    model.addAttribute("TotalPage", list.getTotalPages());

    return "Coders";
  }

  @GetMapping("CoderForm")
  public String addCoderForm(Model model) {
    Coder coder = new Coder();
    model.addAttribute("coder", coder);
    model.addAttribute("action", "path");
    return "CoderForm";
  }

  @PostMapping("path")
  public String coderToAdd(@ModelAttribute Coder coder) {
    this.coderService.addCoder(coder);

    return "redirect:/";
  }

  @GetMapping("update/{id}")
  public String showUpdateForm(@PathVariable Long id, Model model) {
    Coder coder = this.coderService.findCoderById(id);
    model.addAttribute("coder", coder);
    model.addAttribute("action", "/edit/" + id);
    return "CoderForm";
  }

  @PostMapping("/edit/{id}")
  public String coderToUpdate(@PathVariable Long id, @ModelAttribute Coder coder) {
    this.coderService.updateCoder(id, coder);

    return "redirect:/";
  }

  @GetMapping("delete/{id}")
  public String coderToDelete(@PathVariable Long id, Model model) {
    this.coderService.deleteCoder(id);
    return "redirect:/";
  }

}
