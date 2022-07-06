package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UsersDao;
import com.javaex.vo.UsersVo;

@Service
public class UsersService {
	
	@Autowired
	private UsersDao usersDao;
	
	//로그인용 사용자번호와 이름 가져오기
	public UsersVo getUser(UsersVo usersVo) {
		UsersVo uVo = usersDao.selectUsersInfo(usersVo);
		return uVo;
	}
	
	//회원가입시 사용자정보 저장
	public int usersInsert(UsersVo usersVo) {
		int count = usersDao.usersInsert(usersVo);
		
		return count;
	};
	
	
	

}
