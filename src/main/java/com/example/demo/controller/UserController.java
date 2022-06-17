package com.example.demo.controller;

import com.example.demo.form.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  /* Top */
  @GetMapping("/edit")
  public String index(UserForm userForm, Model model) {

    model.addAttribute("userForm", userForm);
    return "edit";
  }

  @PostMapping("/edit")
  public String create(Model model, @Validated @ModelAttribute UserForm userForm, BindingResult result) {
    // do nothing
    return "redirect:/items/index";
  }

}


