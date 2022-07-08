package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.PostService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	// ===================================  내 블로그 post 관리(글 작성폼) ===================================
	@RequestMapping(value = "/{id}/admin/writeForm",method = {RequestMethod.GET, RequestMethod.POST})
	public String writeForm(@PathVariable("id")String id, Model model) {
		System.out.println("PostController > writeForm");
		System.out.println(id);
		List<CategoryVo> cateList = postService.getPostCateList(id);
		model.addAttribute("cateList",cateList);
		
		return "blog/admin/blog-admin-write";
	};

	// ===================================  내 블로그 글작성하기 ===================================
	@RequestMapping(value = "/post",method = {RequestMethod.GET, RequestMethod.POST})
	public String post(@ModelAttribute PostVo postVo,HttpSession session) {
		System.out.println("PostController > post"); 
		
		int count = postService.postInsert(postVo);
		System.out.println(count + "개의 글을 등록하였습니다.");
		
		//blogVo 세션으로 id 불러와 리다이렉트
		BlogVo bVo = (BlogVo)session.getAttribute("blogVo");
		String id = bVo.getId();
		
		return "redirect:/"+ id +"/admin/writeForm";
	};
	
}
