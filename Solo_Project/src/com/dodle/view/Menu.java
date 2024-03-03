package com.dodle.view;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.dodle.controller.Controller;
import com.dodle.model.vo.CPU;

public class Menu {
	Scanner sc = new Scanner(System.in);
	Controller c = new Controller();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	
	public void mainMenu() {
		while(true) {
			System.out.println("환영합니다, 원하시는 번호를 선택해주세요");
			System.out.println("1. 컴퓨터 부품 추가");
			System.out.println("2. 컴퓨터 부품 구매");
			System.out.println("3. 전체 조회");
			
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1:
				insertParts();
				
				break;
			case 2:
				
				
				break;
			case 3:
				c.selectCpu();
				
				break;
			default:
				
				
				break;

			}//end switch
			
			
			
			
			
			
			
			
		}//end while
		
		
	}//end mainMenu
	
	public void insertParts() {
		while(true) {
			System.out.println("부품 추가 입니다. 원하시는 메뉴를 선택해주세요.");
			System.out.println("1. CPU 추가");
			System.out.println("2. GPU 추가");
			System.out.println("3. Mainboard추가");
			System.out.println("9. 이전 메뉴로");
			
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1:
				this.cpuInputData("CPU");
				break;
			case 2:
		
				
				break;
			case 3:
				
				
				break;
			case 9:
				return;
			default:
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		}
	}
	
	
	
	public void cpuInputData(String name) {
		System.out.println("***** " + name + "추가입니다 *****");
		
		System.out.print(name + " 이름 : ");
		String cpuName = sc.nextLine();
		
		System.out.print(name + " 벤치점수 : ");
		int cpuCinebench = sc.nextInt();
						   sc.nextLine();
						   
		System.out.print(name + " 베이스 클럭 : ");
		String cpuBaseclock = sc.nextLine();
		
		System.out.print(name + " 부스트 클럭 : ");
		String cpuBoostclock = sc.nextLine();
		
		System.out.print(name + " 사용 전력 : ");
		String cpuPowerusage = sc.nextLine();
	
		System.out.print(name + " 가격 : ");
		int cpuPrice = sc.nextInt();
					   sc.nextLine();
		
		System.out.print(name + " 제조사 : ");
		String cpuMfrName = sc.nextLine();
		
		System.out.print(name + " 소켓 : ");
		String cpuSocket = sc.nextLine();
		
		System.out.print(name + " 출시일 : ");
		String cpuRelease = sc.nextLine();
		//날짜 입력받기 위해 사용한 것
		java.util.Date parsedDate = null;
		try {
			parsedDate = format.parse(cpuRelease);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
		
		System.out.print(name + " cpu 재고 : ");
		int cpuStock = sc.nextInt();
					   sc.nextLine();
		
		
		c.insertCPU(cpuName, cpuCinebench, cpuBaseclock, cpuBoostclock, 
				cpuPowerusage, cpuPrice, cpuMfrName, cpuSocket, cpuStock, sqlDate);
		
		
		
	}//end cpuInsert
	
	
}//end Menu
