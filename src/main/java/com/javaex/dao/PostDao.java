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
	
	public List<PostVo> postList(){
		List<PostVo> pList = sqlSession.selectList("post.selectPostList");
		
		return pList;
	};
	
	public PostVo getPost(int postNo) {
		PostVo postVo = sqlSession.selectOne("post.getpost",postNo);
		return postVo;
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
