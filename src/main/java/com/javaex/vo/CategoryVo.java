package com.javaex.vo;

public class CategoryVo {
	
	//필드
	private int rownum;
	private int cateNo;
	private String id;
	private String cateName;
	private String description;
	private String regDate;
	
	//생성자
	public CategoryVo() {
	}
	
	
	public CategoryVo(int cateNo) {
		this.cateNo = cateNo;
	}


	public CategoryVo(String id, String cateName, String description) {
		this.id = id;
		this.cateName = cateName;
		this.description = description;
	}
	
	public CategoryVo(int rownum, int cateNo, String id, String cateName, String description, String regDate) {
		this.rownum = rownum;
		this.cateNo = cateNo;
		this.id = id;
		this.cateName = cateName;
		this.description = description;
		this.regDate = regDate;
	}


	//메소드 - gs
	public int getRownum() {
		return rownum;
	}


	public void setRownum(int rownum) {
		this.rownum = rownum;
	}


	public int getCateNo() {
		return cateNo;
	}


	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCateName() {
		return cateName;
	}


	public void setCateName(String cateName) {
		this.cateName = cateName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	//메소드 - 일반
	@Override
	public String toString() {
		return "CategoryVo [rownum=" + rownum + ", cateNo=" + cateNo + ", id=" + id + ", cateName=" + cateName
				+ ", description=" + description + ", regDate=" + regDate + "]";
	}
	

}
