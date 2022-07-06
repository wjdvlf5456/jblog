package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	// ===================================  내 블로그 관리(글 작성폼) ===================================
	@RequestMapping(value = "/{id}/admin/writeForm",method = {RequestMethod.GET, RequestMethod.POST})
	public String writeForm(@PathVariable("id")String id) {
		System.out.println("PostController > writeForm");
		System.out.println(id);
		
		return "blog/admin/blog-admin-write";
	};

}
