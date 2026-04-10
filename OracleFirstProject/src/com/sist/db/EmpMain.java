package com.sist.db;

import java.sql.*;
import java.util.*;

public class EmpMain {

	public static void main(String[] args) throws Exception{
		
		Scanner scan = new Scanner(System.in);
		System.out.print("직위입력: ");
		String job = scan.next();
		
		//드라이버 가져오기
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		//오라클과 연결하기
		Connection conn = DriverManager.getConnection(url, "hr", "happy");
		
		//명령문 보내기
		String sql = "SELECT empno,ename,job "
				+ "FROM emp "
				+ "WHERE job LIKE '%"+job+"%'";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		//쿼리 실행 결과값
		ResultSet rs = ps.executeQuery();
		
		//출력(값이 있을때 계속 가져와라)
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " "
					+rs.getString(2) + " "
					+rs.getString(3));
		}
		
		rs.close();
		ps.close();
		conn.close();
	}

}
