package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public BlogVo getBlog(String id) {
		BlogVo blogVo = sqlSession.selectOne("blog.selectBlog",id);
		
		return blogVo;
	};
	
	public int blogInsert(BlogVo blogVo) {
		int count = sqlSession.insert("blog.blogInsert",blogVo);
		
		return count;
	};
	
	
	public int blogUpdate(BlogVo blogVo){
		int count = sqlSession.update("blog.blogUpdate",blogVo);
		
		return count;
	};

}
