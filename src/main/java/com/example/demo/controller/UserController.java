package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.UserForm;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	/* Top */
	@GetMapping("/edit")
	public String index(UserForm userForm, Model model) {

		model.addAttribute("userForm", userForm);
		return "edit";
	}

	@PostMapping("/edit")
	public String create(Model model, @Validated @ModelAttribute UserForm userForm, BindingResult result) {

		userService.insertOne(userForm);
		return "redirect:/index";
	}

	/* ユーザー一覧ページ */
	@GetMapping("/user")
	public String user(UserForm userForm, Model model) {

		model.addAttribute("userList", userService.getUserList());
		return "user";
	}

	/* ADMIN専用ユーザー一覧ページ */
	@GetMapping("/admin")
	public String admin(UserForm userForm, Model model) {

		model.addAttribute("userList", userService.getUserList());
		return "admin";
	}
	
	/* 削除 */
	@PostMapping("/delete/id={id}")
	public String delete(@PathVariable("id") int id) {
		userService.deleteOne(id);
		return "redirect:/admin";
	}

}

