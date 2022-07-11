package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UsersService;
import com.javaex.vo.UsersVo;

@Controller
public class MainController {
	
	@Autowired
	private UsersService usersService;
	
	// =================================== 사이트 메인 ===================================
	@RequestMapping(value="/", method = {RequestMethod.GET,RequestMethod.POST})
	public String main(Model model) {
		System.out.println("MainController > main");
		List<UsersVo> uList =  usersService.getUserList();
		System.out.println(uList);
		
		model.addAttribute("uList",uList);
		
		return "main/index";
	}
	
}