package com.dodle.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.dodle.model.vo.CPU;
import com.dodle.model.vo.VGA;

public class Dao {
private Properties prop = new Properties();
	
	public Dao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
			prop.load(new FileInputStream("resources/driver.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int insertCpu(CPU cpu) {
		
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertCpu");
		
		try {
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cpu.getCpuName());
			pstmt.setInt(2, cpu.getCpuCinebench());
			pstmt.setString(3, cpu.getCpuBaseclock());
			pstmt.setString(4, cpu.getCpuBoostclook());
			pstmt.setString(5, cpu.getCpuPowerusage());
			pstmt.setInt(6, cpu.getCpuPrice());
			pstmt.setString(7, cpu.getCpuMfrName());
			pstmt.setString(8, cpu.getCpuSocket());
			pstmt.setInt(9, cpu.getCpuStock());
			pstmt.setDate(10, cpu.getCpuRelease());
			
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public ArrayList<CPU> selectCpu(){
		
		ArrayList<CPU> myCpu = new ArrayList<CPU>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCpu");
		
		try {
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				CPU c = new CPU();
				c.setCpuNO(rset.getInt("C_NO"));
				c.setCpuName(rset.getString("C_NAME"));
				c.setCpuCinebench(rset.getInt("C_CINEBENCH"));
				c.setCpuBaseclock(rset.getString("C_BASECLOCK"));
				c.setCpuBoostclook(rset.getString("C_BOOSTCLOCK"));
				c.setCpuPowerusage(rset.getString("C_POWERUSAGE"));
				c.setCpuPrice(rset.getInt("C_PRICE"));
				c.setCpuMfrName(rset.getString("C_MFRNAME"));
				c.setCpuSocket(rset.getString("C_SOCKET"));
				c.setCpuStock(rset.getInt("C_STOCK"));
				c.setCpuRelease(rset.getDate("C_RELEASE"));
				
				myCpu.add(c);
				
			}
				
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		return myCpu;
	}//end selectCpu
	
	public int updateCpu(CPU cpu) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateCpu");
		int[] num = new int[CPU.class.getDeclaredFields().length];
		int count=1;
		if(cpu.getCpuName()!=null) {
			sql += "C_NAME = ?";
			num[0] = count;
			count ++;
		}
		if(cpu.getCpuCinebench()!=0) {
			sql += ", C_CINEBENCH = ?";
			num[1] = count;
			count++;
		}
		if(cpu.getCpuBaseclock()!=null) {
			sql+= ", C_BASECLOCK = ?";
			num[2] = count;
			count++;
		}
		if(cpu.getCpuBoostclook()!=null) {
			sql+= ", C_BOOSTCLOCK = ?";
			num[3] = count;
			count++;
		}
		if(cpu.getCpuPowerusage()!=null) {
			sql+= ", C_POWERUSAGE = ?";
			num[4] = count;
			count++;
		}
		if(cpu.getCpuPrice()!=0) {
			sql+= ", C_PRICE = ?";
			num[5] = count;
			count++;
		}
		if(cpu.getCpuMfrName()!=null) {
			sql+=", C_MFRNAME = ?";
			num[6] = count;
			count++;
		}
		if(cpu.getCpuSocket()!=null) {
			sql+=", C_SOCKET = ?";
			num[7] = count;
			count++;
		}
		if(cpu.getCpuStock()!=0){
			sql+=", C_STOCK = ?";
			num[8] = count;
			count++;
		}
		if(cpu.getCpuRelease()!=null) {
			sql+=", C_RELEASE = ?";
			num[9] = count;
			count++;
		}
		num[10]=count;
		sql+=" WHERE C_NO = ?";

		try {
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
			
			pstmt = conn.prepareStatement(sql);
		
			if(num[0]!=0)
				pstmt.setString(num[0], cpu.getCpuName());
			if(num[1]!=0)
				pstmt.setInt(num[1], cpu.getCpuCinebench());
			if(num[2]!=0)
				pstmt.setString(num[2], cpu.getCpuBaseclock());
			if(num[3]!=0)	
				pstmt.setString(num[3], cpu.getCpuBoostclook());
			if(num[4]!=0)
				pstmt.setString(num[4], cpu.getCpuPowerusage());
			if(num[5]!=0)
				pstmt.setInt(num[5], cpu.getCpuPrice());
			if(num[6]!=0)
				pstmt.setString(num[6], cpu.getCpuMfrName());
			if(num[7]!=0)
				pstmt.setString(num[7], cpu.getCpuSocket());
			if(num[8]!=0)
				pstmt.setInt(num[8], cpu.getCpuStock());
			if(num[9]!=0)
				pstmt.setDate(num[9], cpu.getCpuRelease());
			if(num[10]!=0)
				pstmt.setInt(num[10], cpu.getCpuNO());
			
			result = pstmt.executeUpdate();
			
			if(result >0) {
				conn.commit();
			}else {
				conn.rollback();
			}
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}//end updateCpu

	public int deleteCpu(int index) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteCpu");
		
		try {
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}//end deleteCpu

	public int insertVga(VGA vga) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertVga");
		
		try {
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vga.getVgaName());
			pstmt.setString(2, vga.getVgaBaseclock());
			pstmt.setString(3, vga.getVgaBoostclock());
			pstmt.setString(4, vga.getVgaPowerusage());
			pstmt.setInt(5, vga.getVgaPrice());
			pstmt.setString(6, vga.getVgaMfrName());
			pstmt.setInt(7, vga.getVgaStock());
			pstmt.setString(8, vga.getVgaZerofan());
			pstmt.setDate(9, vga.getVgaRelease());
			
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}//end insertVga

	public ArrayList<VGA> selectVga(){
		
		ArrayList<VGA> myVga = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectVga");
		
		try {
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"), prop.getProperty("password"));
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				VGA v = new VGA();
				v.setVgaNo((rset.getInt("V_NO")));
				v.setVgaName(rset.getString("V_NAME"));
				v.setVgaBaseclock(rset.getString("V_BASECLOCK"));
				v.setVgaBoostclock(rset.getString("V_BOOSTCLOCK"));
				v.setVgaPowerusage(rset.getString("V_POWERUSAGE"));
				v.setVgaPrice(rset.getInt("V_PRICE"));
				v.setVgaMfrName(rset.getString("V_MFRNAME"));
				v.setVgaStock(rset.getInt("V_STOCK"));
				v.setVgaZerofan(rset.getString("V_ZEROFAN"));
				v.setVgaRelease(rset.getDate("V_RELEASE"));
				
				myVga.add(v);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return myVga;
	}//end selectVga

	public int updateVga(VGA vga) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		String sql = prop.getProperty("updateVga");
	
		
		try {
			Class.forName(prop.getProperty("driver"));
			System.out.println("접속완료");
			
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vga.getVgaName());
			pstmt.setString(2, vga.getVgaBaseclock());
			pstmt.setString(3, vga.getVgaBoostclock());
			pstmt.setString(4, vga.getVgaPowerusage());
			pstmt.setInt(5, vga.getVgaPrice());
			pstmt.setString(6, vga.getVgaMfrName());
			pstmt.setInt(7, vga.getVgaStock());
			pstmt.setString(8, vga.getVgaZerofan());
			pstmt.setDate(9, vga.getVgaRelease());
			pstmt.setInt(10, vga.getVgaNo());
			
			result = pstmt.executeUpdate();
			
			if(result >0) {
				conn.commit();
			}else {
				conn.rollback();
			}
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}//end updateVga

	public int deleteVga(int index) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteVga");
		
		try {
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"), prop.getProperty("password"));
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}//end deleteVga
	
	public int buyCPU(int index, int amount) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int stock = this.selectCpu().get(0).getCpuStock();
		
		String sql = prop.getProperty("buyCPU");

		try {
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"), prop.getProperty("password"));
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, stock - amount);
			pstmt.setInt(2, index);
			result = pstmt.executeUpdate();
			
			if(result >0) {
				conn.commit();
			}else {
				conn.rollback();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	

}//end Dao
