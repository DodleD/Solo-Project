package com.dodle.temp;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.dodle.controller.Controller;
import com.dodle.model.dao.Dao;

public class temp {
	Scanner sc = new Scanner(System.in);
	Controller c = new Controller();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	Dao d = new Dao();
	//======================날짜 입력받기 메서드
	public Date dateConversion(String day) {
		java.util.Date parsedDate = null;
		try {
			parsedDate = format.parse(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
		
		return sqlDate;
	}

	//======================삭제해주는 메소드
	public int deleteData(String name) {
		System.out.println(name + " 삭제 메뉴입니다.");
		System.out.println();
		
		switch(name) {
		case "CPU":
			c.selectCpu();
			break;
		case "VGA":
			c.selectVga();
			break;
		default:
			System.out.println("잘못누르셨습니다. 다시 입력해주세요.");
			break;
		}

		System.out.print("삭제하실 "+ name +"의 고유번호를 입력해주세요 : ");
		int index = sc.nextInt();
					sc.nextLine();
					
		return index;
	}
	//데이터 입력해주는 메소드
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
			String cpuMfrName = sc.nextLine().toUpperCase();
			
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
			String vgaMfrName = sc.nextLine().toUpperCase();
				   
			System.out.println(name + " 제로 팬 여부(TRUE/FALSE) : ");
			String vgaZerofan = sc.nextLine().toUpperCase();
			
			c.insertVGA(Name, vgaBaseclock, vgaBoostclock, vgaPowerusage, 
					 Price, vgaMfrName, Stock, vgaZerofan, Date);
			break;
		case "Mainboard":
			
			break;
		}

	}//end InputData
	

	public void buyParts(String name) {
			switch(name) {
			case "CPU":
				c.selectCpu();
				break;
			case "VGA":
				c.selectVga();
				break;
			}
		System.out.print("구매하실 "+ name +"의 고유 번호를 입력해주세요 :  ");
			int index = sc.nextInt();
						sc.nextLine();
						
			System.out.print("구매하실 수량을 입력해주세요 : ");
			int amount = sc.nextInt();
						 sc.nextLine();
			if(amount >d.selectVga().get(0).getVgaStock()) {

				System.out.println("\n재고가 부족하여 구매할 수 없습니다. 다시 입력해주세요.\n");
			}else {
				updateOfBuy(name, index, amount);
			}
	}//end buyParts
	
	public void updateOfBuy(String name, int index, int amount) {
		switch(name) {
		case "CPU":
			c.buyCPU(index, amount);
			break;
		case "VGA":
			c.buyVGA(index, amount);
			break;
		}
	}
	
	/**
	 * 데이터 update 메서드들
	 */
	public void updateCpu(String name) {
		String reName = null ;
		int reCinebench = 0 ;
		String reBaseclock = null ;
		String reBoostclock = null;
		String rePowerusage = null;
		int rePrice = 0 ;
		String reMfrname = null;
		String reSocket = null;
		int reStock = 0 ;
		Date reDate = null ;
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
				System.out.print("***변경하실 이름을 입력해주세요*** : ");
				reName = sc.nextLine(); 

			}

			else if(choice.get(count).equals("벤치")) {
				System.out.print("***변경하실 벤치 성능을 입력해주세요*** : ");
				reCinebench = sc.nextInt();
							  sc.nextLine();

			}
			else if(choice.get(count).equals("베이스클럭")){
				System.out.print("***변경하실 베이스 클럭을 입력해주세요*** : ");
				reBaseclock = sc.nextLine();


			}
			else if(choice.get(count).equals("부스트클럭")){
				System.out.print("***변경하실 부스트 클럭을 입력해주세요*** : ");
				reBoostclock = sc.nextLine();

			}	
			else if(choice.get(count).equals("사용전력")){
				System.out.print("***변경하실 사용 전력을 입력해주세요*** : ");
				rePowerusage = sc.nextLine();
			}
			else if(choice.get(count).equals("가격")){
				System.out.print("***변경하실 가격을 입력해주세요*** : ");
				rePrice = sc.nextInt();
						  sc.nextLine();
			}
			else if(choice.get(count).equals("제조사")){
				System.out.print("***변경하실 제조사를 입력해주세요*** : ");
				reMfrname = sc.nextLine();
			}
			else if(choice.get(count).equals("소켓명")){
				System.out.print("***변경하실 소켓을 입력해주세요*** : ");
				reSocket = sc.nextLine();
				
			}
			else if(choice.get(count).equals("재고")){
				System.out.print("***변경하실 재고 수량을 입력해주세요*** : ");
				reStock = sc.nextInt();
						  sc.nextLine();
			}
			else if(choice.get(count).equals("출시일")) {
				System.out.println("***변경하실 출시일을 입력해주세요*** : ");
				reDate = this.dateConversion(sc.nextLine());
			}
			
			count ++;

		}//end while
			
	c.updateCpu(index, reName, reCinebench, reBaseclock, reBoostclock, 
			rePowerusage, rePrice, reMfrname, reSocket, reStock, reDate);
	}//end updateCpu
	
	public void updateVga(String name) {
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
				System.out.print("***변경하실 이름을 입력해주세요*** : ");
				reName = sc.nextLine();
				break;
			case "재고":
				System.out.print("***변경하실 재고 수량을 입력해주세요*** : ");
				reStock = sc.nextInt();
						  sc.nextLine();
				break;
			case "베이스클럭":
				System.out.print("***변경하실 베이스클럭을 입력해주세요*** : ");
				reBaseclock = sc.nextLine();
				break;
			case "부스트클럭":
				System.out.print("***변경하실 부스트클럭을 입력해주세요*** : ");
				reBoostclock = sc.nextLine();
				break;
			case "사용전력":
				System.out.print("***변경하실 사용전력 입력해주세요*** : ");
				rePowerusage = sc.nextLine();
				break;
			case "가격":
				System.out.print("***변경하실 가격을 입력해주세요*** : ");
				rePrice = sc.nextInt();
				break;
			case "제조사":
				System.out.print("***변경하실 제조사를 입력해주세요*** : ");
				reMfrName = sc.nextLine();
				break;
			case "제로팬여부":
				reZerofan = sc.nextLine();
				break;
			case "출시일":
				reDate = this.dateConversion(sc.nextLine());
				break;
			default:
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
				break;
				
			}//end switch
			
			count ++;
		}//end while
	
		c.updateVga(index, reName, reBaseclock, reBoostclock, rePowerusage, rePrice, reMfrName, reStock, reZerofan, reDate);

	}
	
	public void updateMainboard() {
		
	}
	
	/**
	 * 데이터 delete 메서드들
	 */	
	public void deleteCpu() {
		int index = this.deleteData("CPU");
		c.deleteCpu(index);
	}
	
	public void deleteVga() {
		int index = this.deleteData("VGA");
		c.deleteVga(index);
	}
		
	public void deleteMainboard() {
		
	}
	
}//end temp
