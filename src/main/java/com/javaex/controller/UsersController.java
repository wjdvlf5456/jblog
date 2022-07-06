package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UsersService;

@Controller
@RequestMapping(value = "/user")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	// ======================================================================================
	// ===================================  로그인 페이지 ===================================
	@RequestMapping(value = "/loginForm",method = {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		System.out.println("UsersController > loginForm");
		
		return "user/loginForm";
	};
	
	// ===================================  로그인 ===================================
	@RequestMapping(value = "login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login() {
		System.out.println("UsersController > loginForm");
		
		return "redirect:main/index";
	};
	
	
	
	

};
