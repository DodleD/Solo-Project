package com.dodle.model.vo;

import java.sql.Date;

public class Mainboard {
	private int mbNo;
	private String mbName;
	private String mbMfrName;
//	private Date mbRelease;
	private int mbPrice;
	
	
	public Mainboard() {
		super();
	}


	public Mainboard(int mbNo, String mbName, String mbMfrName, int mbPrice) {
		super();
		this.mbNo = mbNo;
		this.mbName = mbName;
		this.mbMfrName = mbMfrName;
//		this.mbRelease = mbRelease;
		this.mbPrice = mbPrice;
	}


	@Override
	public String toString() {
		return mbNo + ", 메인보드 이름 : " + mbName + ", 메인보드 제조회사 이름 : " + mbMfrName + ", 메인보드 출시일 : "
				 + ", 메인보드 가격 : " + mbPrice + "]";
	}


	public final int getMbNo() {
		return mbNo;
	}


	public final void setMbNo(int mbNo) {
		this.mbNo = mbNo;
	}


	public final String getMbName() {
		return mbName;
	}


	public final void setMbName(String mbName) {
		this.mbName = mbName;
	}


	public final String getMbMfrName() {
		return mbMfrName;
	}


	public final void setMbMfrName(String mbMfrName) {
		this.mbMfrName = mbMfrName;
	}


//	public final Date getMbRelease() {
//		return mbRelease;
//	}
//
//
//	public final void setMbRelease(Date mbRelease) {
//		this.mbRelease = mbRelease;
//	}


	public final int getMbPrice() {
		return mbPrice;
	}


	public final void setMbPrice(int mbPrice) {
		this.mbPrice = mbPrice;
	}
	
	
	
	
	
}
