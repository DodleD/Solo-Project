package com.dodle.temp;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.dodle.controller.Controller;

public class temp {
	Scanner sc = new Scanner(System.in);
	Controller c = new Controller();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	//======================날짜 입력받기 메서드
	public Date dateConversion(String day) {
		java.util.Date parsedDate = null;
		try {
			parsedDate = format.parse(day);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
		
		return sqlDate;
	}

	//삭제해주는 메소드
	public int deleteData(String name) {
		System.out.println(name + " 삭제 메뉴입니다.");
		System.out.println();
		c.selectVga();
		
		System.out.print("삭제하실 "+ name +"의 고유번호를 입력해주세요 : ");
		int index = sc.nextInt();
					sc.nextLine();
					
		return index;
	}

	public void InputData(String name) {
		System.out.println("***** " + name + "추가입니다 *****");
		
		System.out.print(name + " 이름 : ");
		String Name = sc.nextLine();
		
		System.out.print(name + " 가격 : ");
		int Price = sc.nextInt();
					   sc.nextLine();
		
		System.out.print(name + " 출시일(yyyy-MM-dd) : ");
		Date Date = this.dateConversion(sc.nextLine());
		
		
		System.out.print(name + " 재고 : ");
		int Stock = sc.nextInt();
					   sc.nextLine();
					   
		switch(name) {
		case "CPU":
			System.out.print(name + " 벤치점수 : ");
			int cpuCinebench = sc.nextInt();
							   sc.nextLine();
		
			System.out.print(name + " 사용 전력 : ");
			String cpuPowerusage = sc.nextLine();
			
			System.out.print(name + " 베이스 클럭 : ");
			String cpuBaseclock = sc.nextLine();
			
			System.out.print(name + " 부스트 클럭 : ");
			String cpuBoostclock = sc.nextLine();

			System.out.print(name + " 제조사(AMD/Intel) : ");
			String cpuMfrName = sc.nextLine();
			
			System.out.print(name + " 소켓 : ");
			String cpuSocket = sc.nextLine();
			
			
			c.insertCPU(Name, cpuCinebench, cpuBaseclock, cpuBoostclock, 
					cpuPowerusage, Price, cpuMfrName, cpuSocket, Stock, Date);
			break;
			
		case "VGA":
			System.out.print(name + " 베이스 클럭 : ");
			String vgaBaseclock = sc.nextLine();
			
			System.out.print(name + " 부스트 클럭 : ");
			String vgaBoostclock = sc.nextLine();
			
			System.out.print(name + " 사용 전력 : ");
			String vgaPowerusage = sc.nextLine();
			
			System.out.print(name + " 제조사(NVIDIA/AMD) : ");
			String vgaMfrName = sc.nextLine();
				   
			System.out.println(name + " 제로 팬 여부(TRUE/FALSE) : ");
			String vgaZerofan = sc.nextLine();
			
			c.insertVGA(Name, vgaBaseclock, vgaBoostclock, vgaPowerusage, 
					 Price, vgaMfrName, Stock, vgaZerofan, Date);
			break;
		case "Mainboard":
			
			break;
		}

	}//end InputData
	
	public void updateData(String name, int index) {
		ArrayList<String> choice = new ArrayList<>();
		int count = 0;
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}
