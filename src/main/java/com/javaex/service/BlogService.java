package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.dao.PostDao;
import com.javaex.dao.UsersDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;
import com.javaex.vo.UsersVo;

@Service
public class BlogService {
	
	
	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private CategoryDao cateDao;
	
	@Autowired
	private PostDao postDao;
	
	// ===================== 해당 id 블로그 접속 시 정보 호출 =====================
	public Map<String,Object> getBlog(String id) {
		BlogVo blogVo = blogDao.getBlog(id);
		UsersVo uVo = usersDao.selectUsersInfo(id);
		List<CategoryVo> cList = cateDao.cateList(id);
		System.out.println("cList:" + cList.toString());
		
		List<PostVo> pList= postDao.postList(cList.get(0).getCateNo());
		PostVo pVo = new PostVo();
		if (pList.size()<1) {// 아직 포스트가 하나도 없을 때 오류 방지
			
		} else {	
			pVo = pList.get(0);
			
		}
		System.out.println(pVo);
		
		//블로그 메인에 넣어줄 정보들 맵으로 넣기
		Map<String,Object> pMap = new HashMap<String,Object>();
		pMap.put("blogVo", blogVo);
		pMap.put("userName", uVo.getUserName());
		pMap.put("cList", cList);
		pMap.put("pList",pList);
		pMap.put("pVo",pVo);
		
		return pMap;
	};
	
	// ===================== 관리자일 때 블로그 수정 =====================
	public int blogUpdate(String id,String blogTitle,MultipartFile file) {
		
		String saveDir = "/Users/choijungphil/javaStudy/upload";
		
		//오리지널 파일명
		String orgName = file.getOriginalFilename();
		
		//확장자명 가져오기
		String exName = orgName.substring(orgName.lastIndexOf("."));
		
		//드라이브에 저장할 파일명
		String saveName = "";
		
		BlogVo bVo = blogDao.getBlog(id);
		if (orgName.equals("")) {
			saveName = bVo.getLogoFile();
		} else {
			saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		}
		
		System.out.println(saveName);
		
		//파일경로(디렉토리+저장파일명)
		String filePath = saveDir+ "/"+ saveName;
		
		BlogVo blogVo = new BlogVo(id,blogTitle,saveName);
		
		//이전에 있던 사진은 삭제한다.
		String prevFile = saveDir + "/" + bVo.getLogoFile();
		
		System.out.println(bVo.getLogoFile());
		File deleteFile = new File(prevFile);
		
		//(1)다오로 보내서 DB 업데이트
		int count = blogDao.blogUpdate(blogVo);

		// 파일이 존재하는지 체크 존재할경우 true, 존재하지않을경우 false
		if (deleteFile.exists()) {
			// 파일을 삭제합니다.
			deleteFile.delete();
			System.out.println("파일을 삭제하였습니다.");
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
		
		//(2)파일저장
		try {
			byte[] fileData = file.getBytes();
		OutputStream os = new FileOutputStream(filePath);
		BufferedOutputStream bos = new BufferedOutputStream(os);
		
		bos.write(fileData);
		bos.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return count;
	};

}
