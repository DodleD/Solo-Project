package com.dodle.controller;

import java.sql.Date;
import java.util.ArrayList;

import com.dodle.model.dao.Dao;
import com.dodle.model.vo.CPU;
import com.dodle.model.vo.VGA;

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
		System.out.println("CPU 조회 결과입니다.\n");
		
		ArrayList<CPU> myCpu = new Dao().selectCpu();
		
		if(myCpu.isEmpty()) {
			System.out.println("CPU에 대한 조회 결과가 존재하지 않습니다.");
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
			System.out.println("CPU가 성공적으로 업데이트 되었습니다.");
		}else {
			System.out.println("CPU 업데이트에 실패하였습니다.");
		}
		
	}
	
	public void deleteCpu(int index) {
		
		int result = new Dao().deleteCpu(index);
		
		if(result > 0) {
			System.out.println("CPU를 정상적으로 삭제되었습니다.");
		} else {
			System.out.println("CPU 삭제에 실패했습니다.");
		}
		
	}
	
	public void insertVGA(String vgaName, String vgaBaseclock, String vgaBoostclock, String vgaPowerusage,
			 int vgaPrice, String vgaMfrName, int vgaStock, String vgaZerofan , Date vgaRelease) {
		
		VGA myVga = new VGA(vgaName, vgaBaseclock, vgaBoostclock, vgaPowerusage, vgaPrice , vgaMfrName,
				vgaStock, vgaZerofan, vgaRelease);
		
		int result = new Dao().insertVga(myVga);
		
		if(result > 0) {
			System.out.println("VGA 추가에 성공했습니다.");
		} else {
			System.out.println("VGA 추가에 실패했습니다.");
		}
	}
	
	public void selectVga() {
		System.out.println("VGA 조회 결과입니다.\n");
		
		ArrayList<VGA> myVga = new Dao().selectVga();
		
		if(myVga.isEmpty()) {
			System.out.println("VGA에 대한 조회 결과가 존재하지 않습니다.");
		}else {
			System.out.println(myVga);
		}
	}
	
	public void updateVga(int VGANO, String vgaName, String vgaBaseclock, String vgaBoostclock, String vgaPowerusage,
			 int vgaPrice, String vgaMfrName, int vgaStock, String vgaZerofan, Date vgaRelease) {
		VGA myVga = new VGA();
		
		myVga.setVgaNo(VGANO);
		myVga.setVgaName(vgaName);
		myVga.setVgaBaseclock(vgaBaseclock);
		myVga.setVgaBoostclock(vgaBoostclock);
		myVga.setVgaPowerusage(vgaPowerusage);
		myVga.setVgaPrice(vgaPrice);
		myVga.setVgaMfrName(vgaMfrName);
		myVga.setVgaStock(vgaStock);
		myVga.setVgaZerofan(vgaZerofan);
		myVga.setVgaRelease(vgaRelease);
		int result = new Dao().updateVga(myVga);
		
		if(result > 0) {
			System.out.println("VGA 성공적으로 업데이트 되었습니다.");
		}else {
			System.out.println("VGA 업데이트에 실패하였습니다.");
		}
	}
	
	public void deleteVga(int index) {
		int result = new Dao().deleteVga(index);
		
		if(result > 0) {
			System.out.println("VGA를 정상적으로 삭제되었습니다.");
		} else {
			System.out.println("VGA 삭제에 실패했습니다.");
		}
		
		
	}

	public void buyCPU(int index, int amount) {
		int result = new Dao().buyCPU(index, amount);
		
		if(result > 0) {
			System.out.println("\n"+amount + "개 구매 완료되었습니다.");
		}else {
			System.out.println("구매에 실패했습니다.(수량이 아닌 다른 이유)");
		}
	}

	public void buyVGA(int index, int amount) {
		
	}















}//end Controller
