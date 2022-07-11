package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UsersVo;

@Repository
public class UsersDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<UsersVo> getUserList(){
		List<UsersVo> userList = sqlSession.selectList("users.userList");
		System.out.println(userList);
		
		return userList;
	};
	
	
	public UsersVo userLogin(UsersVo usersVo) {
		UsersVo uVo = sqlSession.selectOne("users.userLogin",usersVo);
		
		return uVo;
	};
	public UsersVo selectUsersInfo(String id) {
		UsersVo uVo = sqlSession.selectOne("users.selectUsersInfo",id);
		
		return uVo;
	};
	
	public int check(String id) {
		int count = sqlSession.selectOne("users.check",id);
		System.out.println(count + "건");
		return count;
	};
	
	
	public int usersInsert(UsersVo usersVo) {
		int count = sqlSession.insert("users.usersInsert",usersVo);
		
		return count;
	};

}
