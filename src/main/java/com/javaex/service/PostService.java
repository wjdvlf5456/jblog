package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.dao.PostDao;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;

@Service
public class PostService {
	
	@Autowired
	private PostDao postDao;
	@Autowired
	private CategoryDao categoryDao;
	
	//글 등록
	public int postInsert(PostVo postVo) {
		int count = postDao.postInsert(postVo);
		
		return count;
	};
	
	//글 등록폼 불러올 시 카테고리리스트 불러오기
	public List<CategoryVo> getPostCateList(String id) {
		List<CategoryVo> cateList =  categoryDao.cateList(id);
		
		return cateList;
	};

}
