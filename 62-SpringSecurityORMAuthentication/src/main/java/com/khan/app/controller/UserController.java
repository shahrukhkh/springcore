package com.khan.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khan.app.entity.User;
import com.khan.app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String showReg()
	{
		return "UserRegister";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute User user,Model model)
	{
		Integer id = userService.saveUser(user);
		String msg="User '"+id+"' Created!";
		model.addAttribute("msg", msg);
		return "UserRegister";
	}
}
