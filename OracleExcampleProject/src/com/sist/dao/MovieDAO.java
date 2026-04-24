package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sist.vo.MovieVO;

public class MovieDAO {
	
	//1.연결 객체
	private Connection conn;
	//2. 송수신
	private PreparedStatement ps;
	//3. url
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	public MovieDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//오라클 연동
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
		}catch(Exception ex) {}
	}
	
	//오라클 종료
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {}
	}
	
	//1. 목록
	public List<MovieVO> movieListData(int page){
		List<MovieVO> list = new ArrayList<MovieVO>();
		try {
			getConnection();
			String sql = "SELECT mno,title,genre,actor,regdate "
					+"FROM movie "
					+"ORDER BY mno "
					+"OFFSET ? ROWS FETCH NEXT 20 ROWS ONLY";
			ps = conn.prepareStatement(sql);
			
			int start = (page * 20) -20;
			ps.setInt(1, start);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MovieVO vo = new MovieVO();
				vo.setMno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setGenre(rs.getString(3));
				vo.setActor(rs.getString(4));
				vo.setRegdate(rs.getString(5));
				
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
	
	//1-1. 총 페이지
	public int movieTotalPage() {
		int total = 0;
		
		try {
			getConnection();
			String sql = "SELECT CEIL(COUNT(*)/20.0) "
					+"FROM movie";
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			total = rs.getInt(1);
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		
		return total;
	}
	
	//2. 상세보기
	public MovieVO movieDetailData(int mno) {
		MovieVO vo = new MovieVO();
		
		try {
					
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return vo;
	}
	
	//3. 검색
	public List<MovieVO> movieFindData(String col, String p){
		List<MovieVO> list = new ArrayList<MovieVO>();
		try {
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
	
}
