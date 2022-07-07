package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CommentsVo;

@Repository
public class CommentsDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<CommentsVo> commentsList(){
		List<CommentsVo> cmtList = sqlSession.selectList("cmt.selectcommentsList");
		
		return cmtList;
	};
	
	public CommentsVo getComments(int cmtNo) {
		CommentsVo cmtVo = sqlSession.selectOne("cmt.getCmt",cmtNo);
		return cmtVo;
	};
	
	public int cmtInsert(CommentsVo cmtVo) {
		int count = sqlSession.insert("cmt.cmtInsert",cmtVo);
		return count;
	};
	
	public int cmtDelete(int cmtNo) {
		int count = sqlSession.delete("cmt.cmtDelete",cmtNo);
		return count;
	};

}
