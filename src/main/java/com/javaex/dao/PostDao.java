package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PostVo;

@Repository
public class PostDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<PostVo> postList(int cateNo){
		List<PostVo> pList = sqlSession.selectList("post.selectPostList",cateNo);
		
		return pList;
	};
	
	public PostVo getPost(int cateNo) {
		PostVo postVo = sqlSession.selectOne("post.getpost",cateNo);
		return postVo;
	};
	
	public int countPost(int cateNo){
		int count = sqlSession.selectOne("post.countPost",cateNo);
		
		return count;
	};
	
	
	public int postInsert(PostVo postVo) {
		int count = sqlSession.insert("post.postInsert",postVo);
		return count;
	};
	
	public int postDelete(int postNo) {
		int count = sqlSession.delete("post.postDelete",postNo);
		return count;
	};

}
