package com.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConn {
	// Field
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="scott";
	String pass="tiger";
	ResultSet rs;
	Statement stmt;
	PreparedStatement pstmt;
	Connection conn;
	
	// Constructor
	public DBConn() {
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url,user,pass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 3단계 : Statement
	public void getStatement() {
		try {
			stmt = conn.createStatement();
			System.out.println("---> 3단계 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 3단계 : PreparedStatement
	public void getPreparedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			// 7. Close - 객체 종료
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}//class





