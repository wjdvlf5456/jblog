package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UsersVo;

@Repository
public class UsersDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public UsersVo selectUsersInfo(UsersVo usersVo) {
		UsersVo uVo = sqlSession.selectOne("users.selectUsersInfo",usersVo);
		
		return uVo;
	};
	
	
	public int usersInsert(UsersVo usersVo) {
		int count = sqlSession.insert("users.usersInsert",usersVo);
		
		return count;
	};

}
