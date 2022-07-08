package com.javaex.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	// =================================== 블로그(메인) ===================================
	@RequestMapping(value = "/{id}")
	public String showBlog(@PathVariable("id")String id,HttpSession session,Model model) {
		System.out.println("BlogController > showBlog");
		Map<String, Object> bMap= blogService.getBlog(id);
		System.out.println("pMap: " + bMap.toString());
		
		BlogVo blogVo = (BlogVo)bMap.get("blogVo");
		
		System.out.println("blogVo로 세션값 지정 후 basic으로 보냄: " + blogVo);
		
		if (blogVo!=null) {
			session.setAttribute("blogVo", blogVo);
		}
		
		bMap.remove("blogVo");
		model.addAttribute("bMap", bMap);
		
		return "blog/blog-main";
	};
	
	/*
	// ========================== 회원가입 시 블로그 생성(ajax) ===========================
	@ResponseBody
	@RequestMapping(value = "/blogInsert",method = {RequestMethod.GET,RequestMethod.POST})
	public void blogInsert(@RequestBody BlogVo blogVo) {
		System.out.println(blogVo);
		blogService.blogInsert(blogVo);
	};
	*/
	
	
	
	// =================================== 내 블로그 관리 ===================================
	@RequestMapping(value = "/{id}/admin/basic")
	public String adminBlog(@PathVariable("id")String id) {
		System.out.println("BlogController > adminBlog");
		
		return "blog/admin/blog-admin-basic";
	};
	
	// =================================== 블로그 제목 또는 사진 변경  ===================================
	@RequestMapping(value ="/{id}/modifyBlog",method = {RequestMethod.GET,RequestMethod.POST})
	public String modifyBlog(@PathVariable("id")String id,@RequestParam("blogTitle")String blogTitle, @RequestParam("file") MultipartFile file){
		System.out.println("BlogController > modifyBlog");
		System.out.println("id: " + id +", blogTitle: " + blogTitle + ", file: " + file);
		
		int count = blogService.blogUpdate(id,blogTitle,file);
		System.out.println(count + "건 변경");
		
		return "redirect:./";
	};
	
	// =================================== 블로그 보기 종료  ===================================
	@RequestMapping(value = "/endAdmin", method = {RequestMethod.GET,RequestMethod.POST})
	public String endAdmin(HttpSession session) {
		System.out.println("BlogController > endAdmin");
		
		String id = session.getId();
		System.out.println(id);
		
		session.removeAttribute("blogVo");
		return "redirect:/";
	};
	

}
