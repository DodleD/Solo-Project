package com.dodle.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dodle.model.vo.CPU;

public class Dao {
	public int insertCpu(CPU cpu) {
		
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO CPU VALUES (SEQ_CPUNO.NEXTVAL, ?, ? ,? ,? ,? ,? ,? ,? ,? ,SYSDATE)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("OracleDriver 등록성공");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dodle", "dodle");
			
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
//			pstmt.setDate(10, cpu.getCpuRelease());
			
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
}
