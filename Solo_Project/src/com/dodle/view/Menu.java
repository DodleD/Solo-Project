package com.dodle.view;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.dodle.controller.Controller;
import com.dodle.model.dao.Dao;
import com.dodle.temp.temp;

public class Menu {
	Scanner sc = new Scanner(System.in);
	Controller c = new Controller();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	temp t = new temp();
	
	Dao d = new Dao();
	public void mainMenu() {
		while(true) {
			System.out.println("환영합니다, 컴퓨터가게 입니다.");
			System.out.println("1. 손님");
			System.out.println("2. 관리자");
			System.out.println("9. 종료");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1:
				this.customerMenu();
				break;
			case 2:
				this.masterMenu();
				break;
			case 9:
				System.out.println("시스템 종료");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				break;
			}//end switch		
		}//end while	
	}//end mainMenu
	
	public void customerMenu() {
		while(true) {
			System.out.println("손님 메뉴입니다.");
			System.out.println("1. 컴퓨터 부품 구매");
			System.out.println("2. 구매내역 삭제");
			System.out.println("3. 장바구니 확인");
			System.out.println("9. 종료");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1:
				this.buyMenu();
				break;
			case 2:
				
				break;
			case 3:
					
				break;
			case 9:
				System.out.println("이전 메뉴로");
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				break;
			}//end switch
		}//end while
	}//end customerMenu
	
	public void buyMenu() {
		while(true) {
			System.out.println("구매 메뉴입니다. 구매하실 부품을 골라주세요");
			System.out.println("1. CPU");
			System.out.println("2. VGA");
			System.out.println("3. Mainboard");
			System.out.println("9. 이전 메뉴로");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1:
				t.buyParts("CPU");
				break;
			case 2:
				t.buyParts("VGA");
				break;
			case 3:					
				break;
			case 9:
				System.out.println("이전 메뉴로");
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				break;
			}//end switch
		}//end while
	}//end buyMenu

	
	public void masterMenu() {
		while(true) {
			System.out.println("관리자 메뉴입니다.");
			System.out.println("1. 컴퓨터 부품 추가");
			System.out.println("2. 등록된 컴퓨터 부품 수정");
			System.out.println("3. 등록된 부품 삭제");
			System.out.println("4. 부품 조회");
			System.out.println("9. 종료");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1:
				this.insertParts();				
				break;
			case 2:
				this.updateParts();			
				break;
			case 3:
				this.deleteParts();				
				break;
			case 4:
				this.selectParts();
				break;
			case 9:
				System.out.println("이전 메뉴로");
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				break;
			}//end switch
					
			
		}//end while
		
		
	}

	
	public void insertParts() {
		while(true) {
			System.out.println("부품 추가 입니다. 원하시는 메뉴를 선택해주세요.");
			System.out.println("1. CPU 추가");
			System.out.println("2. VGA 추가");
			System.out.println("3. Mainboard추가");
			System.out.println("9. 이전 메뉴로");
			
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1:
				this.cpuInputData("CPU");
				break;
			case 2:
				this.vgaInputData("VGA");
				break;
			case 3:
				
				
				break;
			case 9:
				return;
			default:
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
				break;
			}//end switch
		}//end while
	}//end insertParts
	
	public void updateParts() {
		while(true) {
			System.out.println("등록된 부품 수정 입니다. 원하시는 부품 선택해주세요. ");
			System.out.println("1. CPU");
			System.out.println("2. VGA");
			System.out.println("3. Mainboard");
			System.out.println("9. 이전 메뉴로");
			
			int menu = sc.nextInt();
					   sc.nextLine();
					   
			switch(menu) {
			case 1:
				t.updateCpu("CPU");
				break;
			case 2:
				t.updateVga("VGA");
				break;
			case 3:
//				this.updateMainboard("Mainboard");
				break;
			case 9:
				System.out.println("이전 메뉴로 이동합니다.");
				return;
			default:
				System.out.println("잘못누르셨습니다. 다시 입력해주세요");
				break;

			}//end switch			
		}//end while
	}//end updateParts
	
	public void selectParts() {
		System.out.println("조회 메뉴입니다. 원하시는 부품을 선택해주세요.");
		System.out.println("1. CPU");
		System.out.println("2. VGA");
		System.out.println("3. Mainboard");
		System.out.println("9. 이전 메뉴로");
		
		int menu = sc.nextInt();
				   sc.nextLine();
				   
		switch(menu) {
		case 1:
			c.selectCpu();
			break;
		case 2:
			c.selectVga();
			break;
		case 3:
//			c.selectMainboard();
			break;
		case 9:
			System.out.println("이전 메뉴로 이동합니다.");
			return;
		default:
			System.out.println("잘못누르셨습니다. 다시 입력해주세요");
			break;
		}//end switch
	}//end selectParts

	public void deleteParts() {
		System.out.println("삭제 메뉴입니다. 원하시는 부품을 선택해주세요.");
		System.out.println("1. CPU");
		System.out.println("2. VGA");
		System.out.println("3. Mainboard");
		System.out.println("9. 이전 메뉴로");
		
		int menu = sc.nextInt();
				   sc.nextLine();
				   
		switch(menu) {
		case 1:
			t.deleteCpu();
			break;
		case 2:
			t.deleteVga();
			break;
		case 3:
//			deleteMainboard();
			break;
		case 9:
			System.out.println("이전 메뉴로 이동합니다.");
			return;
		default:
			System.out.println("잘못누르셨습니다. 다시 입력해주세요");
			break;
		}//end switch
	}//end deleteParts
	
    /**
   
     * 데이터 input 메서드들
     */
	public void cpuInputData(String name) {
		t.InputData("CPU");
	}//end cpuInputData
	
	public void vgaInputData(String name) {
		t.InputData(name);
	}//end vgaInputData
	
	public void MainboardInputDate(String name) {
	
	}


}//end Menu

	
	
	
	
	
	