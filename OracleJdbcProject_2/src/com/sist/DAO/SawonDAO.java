package com.sist.DAO;

import java.util.*;
import java.sql.*;

public class SawonDAO {
	//연결
	private Connection conn;
	
	//송수신
	private PreparedStatement ps;
	
	//싱글턴
	private static SawonDAO dao;
	
	//오라클 주소
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	//1.드라이버 등록
	public SawonDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//메모리 할당
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//2.싱글턴(1개 가지고 여러사람이 돌려쓰게)
	public static SawonDAO newInstance() {
		if(dao == null)
			dao = new SawonDAO();
		return dao;
	}
		
	//3.오라클 연동
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {}
	}
	
	//4.오라클 닫기
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {}
	}
}
