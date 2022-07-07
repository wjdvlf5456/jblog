package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.UsersDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UsersVo;

@Service
public class UsersService {
	
	@Autowired
	private UsersDao usersDao;
	@Autowired
	private BlogDao blogDao;
	
	//로그인용 사용자번호와 이름 가져오기
	public UsersVo getUser(UsersVo usersVo) {
		UsersVo uVo = usersDao.selectUsersInfo(usersVo);
		return uVo;
	}
	
	public boolean check(UsersVo usersVo) {
		int count = usersDao.check(usersVo.getId());
		
		if (count>0) {//이미 id가 있을 때
			return false;
		} else { //중복된 아이디가 없을 때
			return true;
		}
	};
	
	//회원가입시 사용자정보 저장
	public int usersInsert(UsersVo usersVo) {
		
		BlogVo blogVo = new BlogVo();
		
		if (check(usersVo)==false) {
			//중복된 아이디가 있을 시
			return 0;
			
		} else {
			int count = usersDao.usersInsert(usersVo);
			
			//블로그도 생성
			blogVo.setId(usersVo.getId());
			blogVo.setBlogTitle(usersVo.getUserName()+"님의 블로그입니다.");
			blogVo.setLogoFile("");
			
			blogDao.blogInsert(blogVo);

			return count;
		}
		
	};
	
	
	

}
