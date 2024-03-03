package com.dodle.view;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.dodle.controller.Controller;
import com.dodle.model.dao.Dao;
import com.dodle.model.vo.CPU;

public class Menu {
	Scanner sc = new Scanner(System.in);
	Controller c = new Controller();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	Dao d = new Dao();
	public void mainMenu() {
		while(true) {
			System.out.println("환영합니다, 원하시는 번호를 선택해주세요");
			System.out.println("1. 컴퓨터 부품 추가");
			System.out.println("2. 등록된 컴퓨터 부품 수정");
			System.out.println("3. 등록된 부품 삭제");
			System.out.println("4. 부품 조회");
			System.out.println("9. 종료");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1:
				insertParts();				
				break;
			case 2:
				updateParts();			
				break;
			case 3:
				deleteParts();				
				break;
			case 4:
				selectParts();
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
				this.vgaInputData("VGA");
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
				this.updateCpu("CPU");
				break;
			case 2:
				this.updateVga();
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
		
	}

	
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
			deleteCpu();
			break;
		case 2:
			deleteVga();
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
	}
    /**
   
     * 데이터 input 메서드들
     */
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
		Date sqlDate = dateConversion(sc.nextLine());
		
		
		System.out.print(name + " 재고 : ");
		int cpuStock = sc.nextInt();
					   sc.nextLine();
		
		
		c.insertCPU(cpuName, cpuCinebench, cpuBaseclock, cpuBoostclock, 
				cpuPowerusage, cpuPrice, cpuMfrName, cpuSocket, cpuStock, sqlDate);
		
		
		
	}//end cpuInputData
	
	public void vgaInputData(String name) {
		System.out.println("***** " + name + "추가입니다 *****");
		
		System.out.print(name + " 이름 : ");
		String vgaName = sc.nextLine();
							   
		System.out.print(name + " 베이스 클럭 : ");
		String vgaBaseclock = sc.nextLine();
		
		System.out.print(name + " 부스트 클럭 : ");
		String vgaBoostclock = sc.nextLine();
		
		System.out.print(name + " 사용 전력 : ");
		String vgaPowerusage = sc.nextLine();
	
		System.out.print(name + " 가격 : ");
		int vgaPrice = sc.nextInt();
					   sc.nextLine();
		
		System.out.print(name + " 제조사(NVIDIA/AMD) : ");
		String vgaMfrName = sc.nextLine();
		
		System.out.print(name + " 재고 : ");
		int vgaStock = sc.nextInt();
					   sc.nextLine();
					   
		System.out.println(name + " 제로 팬 여부(TRUE/FALSE) : ");
		String vgaZerofan = sc.nextLine();
		
		System.out.print(name + " 출시일 : ");
		Date sqlDate = dateConversion(sc.nextLine());
		
		c.insertVGA(vgaName, vgaBaseclock, vgaBoostclock, vgaPowerusage, 
				 vgaPrice, vgaMfrName, vgaStock, vgaZerofan, sqlDate);
		

	}//end vgaInputData
	
	public void MainboardInputDate(String name) {
	
	}
	
	
	
	/**
	 * 데이터 update 메서드들
	 */
	public void updateCpu(String name) {
		String reName = d.selectCpu().get(0).getCpuName();
		int reCinebench = d.selectCpu().get(0).getCpuCinebench();
		String reBaseclock = d.selectCpu().get(0).getCpuBaseclock();
		String reBoostclock = d.selectCpu().get(0).getCpuBoostclook();
		String rePowerusage = d.selectCpu().get(0).getCpuPowerusage();
		int rePrice = d.selectCpu().get(0).getCpuPrice();
		String reMfrname = d.selectCpu().get(0).getCpuMfrName();
		String reSocket = d.selectCpu().get(0).getCpuSocket();
		int reStock = d.selectCpu().get(0).getCpuStock();
		Date reDate = d.selectCpu().get(0).getCpuRelease();
		System.out.println("***** " + name + "수정 입니다. *****");
		c.selectCpu(); 
		
		System.out.print("\n수정하실 CPU 고유번호를 입력해주세요 : ");		
		int index = sc.nextInt();
					sc.nextLine();
					
		ArrayList<String> choice = new ArrayList<>();
		int count = 0;
		
		while(true) {	
			System.out.println("\n수정하고 싶은 것들을 입력해주세요.[ 이름, 벤치, 베이스클럭, 부스트클럭, 사용전력"
					+ "가격, 제조사, 소켓명, 재고 ]");
			System.out.println("입력을 종료하시려면 exit을 입력해주세요.");
			choice.add(count, sc.nextLine());
			if(choice.get(count).equals("exit")) {
				choice.remove(count);
				break;
			}// 이어받기
			
			if(choice.get(count).equals("이름")) {
				System.out.print("변경하실 이름을 입력해주세요 : ");
				reName = sc.nextLine();
			}

			else if(choice.get(count).equals("벤치")) {
				System.out.print("변경하실 벤치 성능을 입력해주세요 : ");
				reCinebench = sc.nextInt();
							  sc.nextLine();
			}
			else if(choice.get(count).equals("베이스클럭")){
				System.out.print("변경하실 베이스 클럭을 입력해주세요 : ");
				reBaseclock = sc.nextLine();

			}
			else if(choice.get(count).equals("부스트클럭")){
				System.out.print("변경하실 부스트 클럭을 입력해주세요 : ");
				reBoostclock = sc.nextLine();
			}	
			else if(choice.get(count).equals("사용전력")){
				System.out.print("변경하실 사용 전력을 입력해주세요 : ");
				rePowerusage = sc.nextLine();
			}
			else if(choice.get(count).equals("가격")){
				System.out.print("변경하실 가격을 입력해주세요 : ");
				rePrice = sc.nextInt();
						  sc.nextLine();
			}
			else if(choice.get(count).equals("제조사")){
				System.out.print("변경하실 제조사를 입력해주세요 : ");
				reMfrname = sc.nextLine();
			}
			else if(choice.get(count).equals("소켓명")){
				System.out.print("변경하실 소켓을 입력해주세요 : ");
				reSocket = sc.nextLine();
				
			}
			else if(choice.get(count).equals("재고")){
				System.out.print("변경하실 재고 수량을 입력해주세요 : ");
				reStock = sc.nextInt();
						  sc.nextLine();
			}
			else if(choice.get(count).equals("출시일")) {
				System.out.println("변경하실 출시일을 입력해주세요 : ");
				reDate = dateConversion(sc.nextLine());
			}
			
			count ++;

		}//end while
			
	c.updateCpu(index, reName, reCinebench, reBaseclock, reBoostclock, rePowerusage, rePrice, reMfrname, reSocket, reStock, reDate);
	}//end updateCpu
	
	public void updateVga() {
		String reName = d.selectVga().get(0).getVgaName();
		String reBaseclock = d.selectVga().get(0).getVgaBaseclock();
		String reBoostclock = d.selectVga().get(0).getVgaBoostclock();
		String rePowerusage = d.selectVga().get(0).getVgaPowerusage();
		Date reDate = d.selectVga().get(0).getVgaRelease();
		int rePrice = d.selectVga().get(0).getVgaPrice();
		String reMfrName = d.selectVga().get(0).getVgaMfrName();
		int reStock = d.selectVga().get(0).getVgaStock();
		String reZerofan = d.selectVga().get(0).getVgaZerofan();
		
		c.selectVga(); 
		
		System.out.print("\n수정하실 VGA 고유번호를 입력해주세요 : ");		
		int index = sc.nextInt();
					sc.nextLine();
					
		ArrayList<String> choice = new ArrayList<>();
		int count = 0;
		
		
		while(true) {	
			System.out.println("\n수정하고 싶은 것들을 입력해주세요.[ 이름, 베이스클럭, 부스트클럭, 사용전력"
					+ "가격, 제조사, 제로팬여부, 재고, 출시일 ]");
			System.out.println("입력을 종료하시려면 exit을 입력해주세요.");
			choice.add(count, sc.nextLine());
			if(choice.get(count).equals("exit")) {
				choice.remove(count);
				break;
			}// 이어받기
			
			switch(choice.get(count)) {
			case "이름":
				System.out.print("변경하실 이름을 입력해주세요 : ");
				reName = sc.nextLine();
				break;
			case "재고":
				System.out.print("변경하실 재고 수량을 입력해주세요 : ");
				reStock = sc.nextInt();
						  sc.nextLine();
				break;
			case "베이스클럭":
				System.out.print("변경하실 베이스클럭을 입력해주세요 : ");
				reBaseclock = sc.nextLine();
				break;
			case "부스트클럭":
				System.out.print("변경하실 부스트클럭을 입력해주세요 : ");
				reBoostclock = sc.nextLine();
				break;
			case "사용전력":
				System.out.print("변경하실 사용전력 입력해주세요 : ");
				rePowerusage = sc.nextLine();
				break;
			case "가격":
				System.out.print("변경하실 가격을 입력해주세요 : ");
				rePrice = sc.nextInt();
				break;
			case "제조사":
				System.out.print("변경하실 제조사를 입력해주세요 : ");
				reMfrName = sc.nextLine();
				break;
			case "제로팬여부":
				reZerofan = sc.nextLine();
				break;
			case "출시일":
				reDate = dateConversion(sc.nextLine());
				break;
			default:
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
				break;
				
			}//end switch
			
			count ++;
		}//end while
		System.out.println(index+ " " +reName+ " " +reBaseclock+ " " +reBoostclock+ " " +rePowerusage+ " " +
		rePrice+ " " + reMfrName+ " " +reStock+ " " +reZerofan+ " " + reDate);
		
		
		c.updateVga(index, reName, reBaseclock, reBoostclock, rePowerusage, rePrice, reMfrName, reStock, reZerofan, reDate);
		
		
		
		
	}
	
	public void updateMainboard() {
		
	}
	
	
	
	
	/**
	 * 데이터 delete 메서드들
	 */	
	public void deleteCpu() {
		System.out.println("CPU 삭제 메뉴입니다.");
		System.out.println();
		c.selectCpu();
		
		System.out.print("삭제하실 CPU의 고유번호를 입력해주세요 : ");
		int index = sc.nextInt();
					sc.nextLine();
					
		c.deleteCpu(index);
	}
	
	public void deleteVga() {
		System.out.println("VGA 삭제 메뉴입니다.");
		System.out.println();
		c.selectVga();
		
		System.out.print("삭제하실 VGA의 고유번호를 입력해주세요 : ");
		int index = sc.nextInt();
					sc.nextLine();
					
		c.deleteVga(index);
	}
		
	public void deleteMainboard() {
		
	}
		
	
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
}//end Menu

	
	
	
	
	
	