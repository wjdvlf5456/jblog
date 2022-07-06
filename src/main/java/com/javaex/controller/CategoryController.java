package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.CategoryService;

@Controller
public class CategoryController {
	
	//카테고리 페이지는 반드시 ajax로 구현할 것
	
	@Autowired
	private CategoryService categoryService;
	
	// =================================== 카테고리 메인 ===================================
	@RequestMapping(value = "/{id}/admin/category")
	public String showCategory(@PathVariable("id")String id){
		System.out.println("CategoryController > showCategory");
		
		return "blog/admin/blog-admin-cate";
	};

}
