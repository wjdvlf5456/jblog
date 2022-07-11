package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.dao.UsersDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UsersVo;

@Service
public class UsersService {
	
	@Autowired
	private UsersDao usersDao;
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private CategoryDao cateDao;
	
	//로그인용 사용자번호와 이름 가져오기
	public UsersVo getUser(UsersVo usersVo) {
		UsersVo uVo = usersDao.userLogin(usersVo);
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
		CategoryVo cVo = new CategoryVo();
		
		String id = usersVo.getId();
		System.out.println(id);
		
		if (check(usersVo)==false || id.equals("")) {
			//중복된 아이디가 있을 시
			System.out.println("블로그 생성 실패");
			return 0;
			
		} else {
			System.out.println("블로그 생성");
			int count = usersDao.usersInsert(usersVo);
			
			//블로그도 생성
			blogVo.setId(usersVo.getId());
			blogVo.setBlogTitle(usersVo.getUserName()+"님의 블로그입니다.");
			blogVo.setLogoFile("");
			
			blogDao.blogInsert(blogVo);
			
			cVo.setId(usersVo.getId());
			cVo.setCateName("미분류");
			cVo.setDescription("기타내용 작성 요");
			
			int cateCnt = cateDao.cateInsert(cVo);
			System.out.println(cateCnt + "개의 카테고리 등록");

			return count;
		}
		
	};
	
	
	

}
