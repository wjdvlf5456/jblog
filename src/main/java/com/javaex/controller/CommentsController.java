package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.CommentsService;
import com.javaex.vo.CommentsVo;

@Controller
public class CommentsController {
	
	//코멘트는 ajax로 작성
	
	@Autowired
	private CommentsService commentsService;
	
	@RequestMapping(value = "/remys", method = {RequestMethod.GET,RequestMethod.POST})
	public String remys(){
		
		return "blog/blog-main";
	};
	
	// =================================== 코멘트목록(블로그 메인) ===================================
	@ResponseBody
	@RequestMapping(value = "/cmtList",method = {RequestMethod.GET, RequestMethod.POST})
	public String cmtList(@RequestBody CommentsVo commentsVo) {
		
		return "";
	};
	
	

}
