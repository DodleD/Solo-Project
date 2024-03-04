package com.dodle.model.vo;

import java.sql.Date;

public class VGA {

	private int vgaNo;
	private String vgaName;
	private String vgaBaseclock;
	private String vgaBoostclock;
	private String vgaPowerusage;
	private int vgaPrice;
	private String vgaMfrName;
	private int vgaStock;
	private String vgaZerofan;
	private Date vgaRelease;

	public VGA() {
		super();
	}

	public VGA(String vgaName, String vgaBaseclock, String vgaBoostclock, String vgaPowerusage, int vgaPrice,
			String vgaMfrName, int vgaStock, String vgaZerofan, Date vgaRelease) {
		super();
		this.vgaName = vgaName;
		this.vgaBaseclock = vgaBaseclock;
		this.vgaBoostclock = vgaBoostclock;
		this.vgaPowerusage = vgaPowerusage;
		this.vgaPrice = vgaPrice;
		this.vgaMfrName = vgaMfrName;
		this.vgaStock = vgaStock;
		this.vgaZerofan = vgaZerofan;
		this.vgaRelease = vgaRelease;
	}

	@Override
	public String toString() {
		return "VGA 고유번호 : "+vgaNo + ", VGA 이름 : " + vgaName + ", VGA 베이스 클럭 : " + vgaBaseclock + ", VGA 부스트 클럭 : "
				+ vgaBoostclock + ", VGA 사용전력 : " + vgaPowerusage + ",\n VGA 출시일 : " + ", VGA 가격 : "
				+ vgaPrice + ", VGA 제조회사 : " + vgaMfrName + ", VGA 재고 "+vgaStock + ", 제로팬 기능여부 : " +vgaZerofan+"\n\n";
	}

	public int getVgaNo() {
		return vgaNo;
	}

	public void setVgaNo(int vgaNo) {
		this.vgaNo = vgaNo;
	}

	public String getVgaName() {
		return vgaName;
	}

	public void setVgaName(String vgaName) {
		this.vgaName = vgaName;
	}

	public String getVgaBaseclock() {
		return vgaBaseclock;
	}

	public void setVgaBaseclock(String vgaBaseclock) {
		this.vgaBaseclock = vgaBaseclock;
	}

	public String getVgaBoostclock() {
		return vgaBoostclock;
	}

	public void setVgaBoostclock(String vgaBoostclock) {
		this.vgaBoostclock = vgaBoostclock;
	}

	public String getVgaPowerusage() {
		return vgaPowerusage;
	}

	public void setVgaPowerusage(String vgaPowerusage) {
		this.vgaPowerusage = vgaPowerusage;
	}

	public int getVgaPrice() {
		return vgaPrice;
	}

	public void setVgaPrice(int vgaPrice) {
		this.vgaPrice = vgaPrice;
	}

	public String getVgaMfrName() {
		return vgaMfrName;
	}

	public void setVgaMfrName(String vgaMfrName) {
		this.vgaMfrName = vgaMfrName;
	}

	public int getVgaStock() {
		return vgaStock;
	}

	public void setVgaStock(int vgaStock) {
		this.vgaStock = vgaStock;
	}

	public String getVgaZerofan() {
		return vgaZerofan;
	}

	public void setVgaZerofan(String vgaZerofan) {
		this.vgaZerofan = vgaZerofan;
	}

	public Date getVgaRelease() {
		return vgaRelease;
	}

	public void setVgaRelease(Date vgaRelease) {
		this.vgaRelease = vgaRelease;
	}

	
	

}
