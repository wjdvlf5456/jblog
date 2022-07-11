package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;

@Repository
public class CategoryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<CategoryVo> cateList(String id){
		List<CategoryVo> cList = sqlSession.selectList("category.cateSelectList",id);
		
		return cList;
	};
	
	public CategoryVo getCate(int cateNo) {
		CategoryVo cVo = sqlSession.selectOne("category.getCategory",cateNo);
		
		return cVo;
	};
	
	public int cateInsert(CategoryVo cateVo) {
		int count = sqlSession.insert("category.cateInsert",cateVo);
		return count;
	};
	
	public int cateDelete(int cateNo) {
		int count = sqlSession.delete("category.cateDelete",cateNo);
		return count;
	};

}
