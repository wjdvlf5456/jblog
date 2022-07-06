package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
		
		model.addAttribute(blogVo);
		
		return "blog/blog-main";
	};

}
