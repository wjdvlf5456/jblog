package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	public List<CategoryVo> cateList(String id){
		List<CategoryVo> cateList = categoryDao.cateList(id);
		System.out.println(cateList);
		
		return cateList;
	};
	
	public CategoryVo cateInsert(CategoryVo cateVo) {
		int count = categoryDao.cateInsert(cateVo);
		System.out.println(count + "개의 카테고리 추가");
		
		//id값으로 마지막에 있는 cateNo 가져와 return
		List<CategoryVo> cateList = categoryDao.cateList(cateVo.getId());
		int cateNo = cateList.get(cateList.size()-1).getCateNo();
		
		CategoryVo cVo = categoryDao.getCate(cateNo);
		
		return cVo;
	};

}
