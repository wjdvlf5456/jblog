package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UsersService;
import com.javaex.vo.UsersVo;

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
	
	// ======================================================================================
	// =================================== 회원가입 페이지 ===================================
	@RequestMapping(value = "/joinForm",method = {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UsersController > joinForm");
		
		return "user/joinForm";
	};
	
	// ===================================  회원가입 ===================================
	@RequestMapping(value = "join", method = {RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UsersVo usersVo) {
		System.out.println("UsersController > join");
		System.out.println("UsersController로 받은 정보: " + usersVo);
		int count = usersService.usersInsert(usersVo);
		System.out.println(count + "건 등록되었습니다.");
		
		return "redirect:./joinSuccess";
	};
	
	
	
	

};
