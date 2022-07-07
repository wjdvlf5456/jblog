package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	public BlogVo getBlog(String id) {
		BlogVo blogVo = blogDao.getBlog(id);
		
		return blogVo;
	};
	
	/*
	public int blogInsert(BlogVo blogVo) {
		blogVo.setLogoFile("");
		
		int count = blogDao.blogInsert(blogVo);
		
		
		return count;
	};
	*/
	
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
