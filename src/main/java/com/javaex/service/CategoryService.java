package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.dao.PostDao;
import com.javaex.vo.CategoryVo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private PostDao postDao;
	
	
	// ===================== 관리자 카테고리 리스트 불러오기 =====================
	public List<CategoryVo> cateList(String id){
		List<CategoryVo> cateList = categoryDao.cateList(id);
		System.out.println(cateList);
		//처음 카테고리 생성시 로우넘 0에서 1로 교체
		if (cateList.get(0).getRownum()==0) {
			cateList.get(0).setRownum(1);
		}
		
		//각 카테고리마다 포스트 수 세어오기
		for (int i = 0; i < cateList.size(); i++) {
			cateList.get(i).setCountPost(postDao.countPost(cateList.get(i).getCateNo()));
		}
		
		return cateList;
	};
	
	// ===================== 관리자 새 카테고리 등록 =====================
	public CategoryVo cateInsert(CategoryVo cateVo) {
		int count = categoryDao.cateInsert(cateVo);
		System.out.println(count + "개의 카테고리 추가");
		
		//id값으로 마지막에 있는 cateNo 가져와 return
		List<CategoryVo> cateList = categoryDao.cateList(cateVo.getId());
		int cateNo = cateList.get(0).getCateNo();
		int rowNum = cateList.get(0).getRownum();
		
		cateVo.setCateNo(cateNo);
		
		CategoryVo cVo = categoryDao.getCate(cateVo);
		//ajax로 화면에 띄울 때 다음 로우넘을 넣어준다.
		cVo.setRownum(rowNum);
		
		return cVo;
	};
	
	// ===================== 관리자 카테고리 삭제 =====================
	public String cateDelete(int cateNo) {
		int count = categoryDao.cateDelete(cateNo);
		String result = "fail";
		if (count>0) {
			result = "true";
		}
		
		return result;
	};

}
