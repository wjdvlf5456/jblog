package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.CategoryService;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UsersVo;

@Controller
public class CategoryController {
	
	//카테고리 페이지는 반드시 ajax로 구현할 것
	
	@Autowired
	private CategoryService categoryService;
	
	// =================================== 카테고리 메인 ===================================
	@RequestMapping(value = "/{id}/admin/category")
	public String showCategory(@PathVariable("id")String id,HttpSession session){
		System.out.println("CategoryController > showCategory");
		
		UsersVo authUser = (UsersVo)session.getAttribute("authUser");
		//현재 접속중인 유저의 아이디
		String crtId = authUser.getId();
	
		System.out.println(crtId);
		
		if (crtId.equals(id)) {
			return "blog/admin/blog-admin-cate";
		} else {
			return "redirect:/error";
		}
	};
	
	
	// ========================== 카테고리리스트(ajax+json)=========================
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
	
	// ========================== 카테고리 등록 =========================
	@ResponseBody
	@RequestMapping(value = "/addCategory", method = {RequestMethod.GET, RequestMethod.POST})
	public CategoryVo addCategory(@RequestBody CategoryVo categoVo){
		System.out.println("CategoryController > addCategory");
		System.out.println("카테고리 추가 데이터: " + categoVo);
		
		CategoryVo cVo = categoryService.cateInsert(categoVo);
		
		System.out.println("ajax로 돌려주는 값: " + cVo);
		
		return cVo;
	};
	
	// ========================== 카테고리 삭제 =========================
	@ResponseBody
	@RequestMapping(value = "/delCategory", method = {RequestMethod.GET, RequestMethod.POST})
	public String delCategory(@RequestBody CategoryVo deleteVo){
		System.out.println("CategoryController > delCategory");
		System.out.println("deleteVo: " + deleteVo);
		int cateNo = deleteVo.getCateNo();
		
		String result = categoryService.cateDelete(cateNo);
		
		System.out.println(result);
		return result;
	};
	
	
	

}
