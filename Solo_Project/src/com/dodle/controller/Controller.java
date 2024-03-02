package com.dodle.controller;

import java.sql.Date;

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
	
	
	
	
	
	
}//end Controller
