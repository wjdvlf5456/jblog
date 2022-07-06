package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Controller
public class BlogController {
	
	@Autowired
	private BlogDao blogDao;
	// =================================== 블로그(메인) ===================================
	@RequestMapping(value = "/{id}")
	public String showBlog(@PathVariable("id")String id, Model model) {
		System.out.println("BlogController > showBlog");
		BlogVo blogVo = blogDao.getBlog(id);
		System.out.println(blogVo);
		
		model.addAttribute("blogVo",blogVo);
		
		return "blog/blog-main";
	};
	
	// =================================== 내 블로그 관리 ===================================
	@RequestMapping(value = "/{id}/admin/basic")
	public String adminBlog(@PathVariable("id")String id) {
		System.out.println("BlogController > adminBlog");
		
		return "blog/admin/blog-admin-basic";
	};
	
	@RequestMapping(value ="/modifyBlog",method = {RequestMethod.GET,RequestMethod.POST})
	public String modifyBlog(@ModelAttribute BlogVo blogVo){
		
		
		
		
		return "redirect:./blog-main";
	};
	
	

}
