package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String login(@ModelAttribute UsersVo usersVo, HttpSession session) {
		System.out.println("UsersController > login");
		
		UsersVo authUser = usersService.getUser(usersVo);
		System.out.println(authUser);
		
		if (authUser==null) {	//로그인 실패 시
			return "redirect:/user/loginForm?result=fail";
			
		} else {	//로그인 성공 시
			session.setAttribute("authUser", authUser);
			
			return "redirect:/";
		}
		
	};
	// =================================== 로그아웃 ===================================
	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) {
		System.out.println("UsersController > logout");
		
		session.removeAttribute("authUser");
		session.invalidate();
		
		// 메인페이지로 리다이렉트
		return "redirect:/";
	}
	
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
		
		if (count>0) {
			System.out.println(count + "건 등록되었습니다.");
			return "redirect:./joinSuccess";
			
		} else {
			return "user/joinForm";

		}
		
	};
	
	// ================================ 중복체크(ajax + json) ================================
	@ResponseBody
	@RequestMapping(value = "check", method = {RequestMethod.GET, RequestMethod.POST})
	public Boolean check(@RequestBody UsersVo usersVo) {
		System.out.println("UsersController > check");
		Boolean result = usersService.check(usersVo);
		System.out.println(result);
		
		return result;
	};
	
	
	
	
	// ================================  회원가입 성공 시 ================================
	@RequestMapping(value = "joinSuccess", method = {RequestMethod.GET, RequestMethod.POST})
	public String joinSuccess() {
		System.out.println("UsersController > joinSuccess");
		
		return "user/joinSuccess";
	};
	
	
	
	

};
