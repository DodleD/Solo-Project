package com.dodle.controller;

import java.sql.Date;
import java.util.ArrayList;

import com.dodle.model.dao.Dao;
import com.dodle.model.vo.CPU;

public class Controller {
	
	public void insertCPU(String cpuName, int cpuCinebench, String cpuBaseclock, String cpuBoostclock,
			String cpuPowerusage, int cpuPrice, String cpuMfrName, String cpuSocket, int cpuStock, Date sqlDate) {
		
		CPU myCpu = new CPU(cpuName, cpuCinebench, cpuBaseclock, cpuBoostclock,
				cpuPowerusage,cpuPrice, cpuMfrName, cpuSocket, cpuStock, sqlDate);
		
		int result = new Dao().insertCpu(myCpu);
		
		if(result > 0 ) {
			System.out.println("정상적으로 추가되었습니다.");
		}else {
			System.out.println("추가 실패하였습니다.");
		}
		
	}
	
	public void selectCpu() {
		System.out.println("cpu 조회 결과입니다.");
		
		ArrayList<CPU> myCpu = new Dao().selectCpu();
		
		if(myCpu.isEmpty()) {
			System.out.println("전체조회결과 없슴");
		}else {
			System.out.println(myCpu);
		}
	}
	
	public void updateCpu(int CPUNO, String cpuName, int cpuCinebench, String cpuBaseclock, String cpuBoostclock,
			String cpuPowerusage, int cpuPrice, String cpuMfrName, String cpuSocket, int cpuStock, Date cpuRelease) {
		CPU myCpu = new CPU();
		
		myCpu.setCpuName(cpuName);
		myCpu.setCpuCinebench(cpuCinebench);
		myCpu.setCpuBaseclock(cpuBaseclock);
		myCpu.setCpuBoostclook(cpuBoostclock);
		myCpu.setCpuPowerusage(cpuPowerusage);
		myCpu.setCpuPrice(cpuPrice);
		myCpu.setCpuMfrName(cpuMfrName);
		myCpu.setCpuSocket(cpuSocket);
		myCpu.setCpuStock(cpuStock);
		myCpu.setCpuNO(CPUNO);
		myCpu.setCpuRelease(cpuRelease);
		int result = new Dao().updateCpu(myCpu);
		
		if(result > 0) {
			System.out.println("성공적으로 업데이트 되었습니다.");
		}else {
			System.out.println("업데이트에 실패하였습니다.");
		}
		
	}
	
	public void deleteCpu(int index) {
		
		int result = new Dao().deleteCpu(index);
		
		if(result > 0) {
			System.out.println("정상적으로 삭제되었습니다.");
		} else {
			System.out.println("삭제에 실패했습니다.");
		}
		
	}
	
}//end Controller
