package com.dodle.model.vo;

import java.sql.Date;

public class CPU {
	private int cpuNO;
	private String cpuName;
	private int cpuCinebench;
	private String cpuBaseclock;
	private String cpuBoostclook;
	private String cpuPowerusage;
	private Date cpuRelease;
	private int cpuPrice;
	private String cpuMfrName;
	private String cpuSocket;
	private int cpuStock;
	
	public CPU() {
		super();
	}

	public CPU(String cpuName, int cpuCinebench, String cpuBaseclock, String cpuBoostclook,
			String cpuPowerusage, int cpuPrice, String cpuMfrName, String cpuSocket, int cpuStock, Date cpuRelease) {
		super();
		this.cpuName = cpuName;
		this.cpuCinebench = cpuCinebench;
		this.cpuBaseclock = cpuBaseclock;
		this.cpuBoostclook = cpuBoostclook;
		this.cpuPowerusage = cpuPowerusage;
		this.cpuRelease = cpuRelease;
		this.cpuPrice = cpuPrice;
		this.cpuMfrName = cpuMfrName;
		this.cpuSocket = cpuSocket;
		this.cpuStock  = cpuStock;
	}

	@Override
	public String toString() {
		return cpuNO + ", CPU 이름 :  " + cpuName + ", CPU 성능테스트 점수 : " + cpuCinebench + ", CPU 베이스 클럭 : "
				+ cpuBaseclock + ", CPU 부스트 클럭 : " + cpuBoostclook + ", CPU 사용전력 : " + cpuPowerusage
				+ ", CPU 출시일 : " + ", CPU 가격 : " + cpuPrice + ", CPU 제조회사 : " + cpuMfrName
				+ ", CPU 소켓 : " + cpuSocket + ", CPU 재고 : " + cpuStock;
	}

	public final int getCpuNO() {
		return cpuNO;
	}

	public final void setCpuNO(int cpuNO) {
		this.cpuNO = cpuNO;
	}

	public final String getCpuName() {
		return cpuName;
	}

	public final void setCpuName(String cpuName) {
		this.cpuName = cpuName;
	}

	public final int getCpuCinebench() {
		return cpuCinebench;
	}

	public final void setCpuCinebench(int cpuCinebench) {
		this.cpuCinebench = cpuCinebench;
	}

	public final String getCpuBaseclock() {
		return cpuBaseclock;
	}

	public final void setCpuBaseclock(String cpuBaseclock) {
		this.cpuBaseclock = cpuBaseclock;
	}

	public final String getCpuBoostclook() {
		return cpuBoostclook;
	}

	public final void setCpuBoostclook(String cpuBoostclook) {
		this.cpuBoostclook = cpuBoostclook;
	}

	public final String getCpuPowerusage() {
		return cpuPowerusage;
	}

	public final void setCpuPowerusage(String cpuPowerusage) {
		this.cpuPowerusage = cpuPowerusage;
	}

	public final Date getCpuRelease() {
		return cpuRelease;
	}

	public final void setCpuRelease(Date cpuRelease) {
		this.cpuRelease = cpuRelease;
	}

	public final int getCpuPrice() {
		return cpuPrice;
	}

	public final void setCpuPrice(int cpuPrice) {
		this.cpuPrice = cpuPrice;
	}

	public final String getCpuMfrName() {
		return cpuMfrName;
	}

	public final void setCpuMfrName(String cpuMfrName) {
		this.cpuMfrName = cpuMfrName;
	}

	public final String getCpuSocket() {
		return cpuSocket;
	}

	public final void setCpuSocket(String cpuSocket) {
		this.cpuSocket = cpuSocket;
	}

	public final int getCpuStock() {
		return cpuStock;
	}

	public final void setCpuStock(int cpuStock) {
		this.cpuStock = cpuStock;
	}
	
	
	
}
