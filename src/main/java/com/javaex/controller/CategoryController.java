package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.CategoryService;
import com.javaex.vo.CategoryVo;

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
	
	@ResponseBody
	@RequestMapping(value = "/cateList", method = {RequestMethod.GET,RequestMethod.POST})
	public List<CategoryVo> cateList(@RequestBody CategoryVo cateVo){
		System.out.println("CategoryController > showCategory");
		String id = cateVo.getId();
		
		
		System.out.println("id: " + id);
		List<CategoryVo> cateList = categoryService.cateList(id);
		System.out.println(cateList);
		
		return cateList;
	};

}
