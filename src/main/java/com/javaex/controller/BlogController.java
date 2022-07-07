package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	// =================================== 블로그(메인) ===================================
	@RequestMapping(value = "/{id}")
	public String showBlog(@PathVariable("id")String id, Model model) {
		System.out.println("BlogController > showBlog");
		BlogVo blogVo = blogService.getBlog(id);
		System.out.println(blogVo);
		
		model.addAttribute("blogVo",blogVo);
		
		return "blog/blog-main";
	};
	
	// ========================== 회원가입 시 블로그 생성(ajax) ===========================
	@ResponseBody
	@RequestMapping(value = "/blogInsert",method = {RequestMethod.GET,RequestMethod.POST})
	public boolean blogInsert(@RequestBody BlogVo blogVo) {
		
		return true;
	};
	
	
	
	
	// =================================== 내 블로그 관리 ===================================
	@RequestMapping(value = "/{id}/admin/basic")
	public String adminBlog(@PathVariable("id")String id) {
		System.out.println("BlogController > adminBlog");
		
		return "blog/admin/blog-admin-basic";
	};
	
	@RequestMapping(value ="/{id}/modifyBlog",method = {RequestMethod.GET,RequestMethod.POST})
	public String modifyBlog(@PathVariable("id")String id,@RequestParam("blogTitle")String blogTitle, @RequestParam("file") MultipartFile file){
		System.out.println("BlogController > modifyBlog");
		System.out.println("id: " + ", blogTitle: " + blogTitle);
		
		int count = blogService.blogUpdate(id,blogTitle,file);
		System.out.println(count + "건 변경");
		
		return "redirect:./blog-main";
	};
	
	

}
