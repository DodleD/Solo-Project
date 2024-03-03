package com.dodle.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dodle.model.vo.CPU;

public class Dao {
	public int insertCpu(CPU cpu) {
		
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO CPUCCC VALUES (SEQ_CPUNO.NEXTVAL, ?, ? ,? ,? ,? ,? ,? ,? ,? ,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OracleDriver 등록성공");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "DDD", "DDD");
			
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
				// TODO Auto-generated catch block
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
		
		String sql = "SELECT * FROM CPUCCC";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "DDD", "DDD");
			
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		return myCpu;
	}
	
	public int updateCpu(CPU cpu) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE CPUCCC "
				+ "SET C_NAME = ?,"
				+ "C_CINEBENCH = ?,"
				+ "C_BASECLOCK = ?,"
				+ "C_BOOSTCLOCK = ?,"
				+ "C_POWERUSAGE = ?,"
				+ "C_PRICE = ?,"
				+ "C_MFRNAME = ?,"
				+ "C_SOCKET = ?,"
				+ "C_STOCK = ?,"
				+ "C_RELEASE = ?"
				+ "WHERE C_NO = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("접속완료");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "DDD", "DDD");
			
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
			pstmt.setInt(11, cpu.getCpuNO());
			
			result = pstmt.executeUpdate();
			
			if(result >0) {
				conn.commit();
			}else {
				conn.rollback();
			}
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
	}//end updateCpu

	public int deleteCpu(int index) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM CPUCCC WHERE C_NO = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "DDD", "DDD");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
}
