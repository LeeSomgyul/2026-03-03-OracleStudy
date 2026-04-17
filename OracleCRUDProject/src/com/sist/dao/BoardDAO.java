package com.sist.dao;

import java.util.*;

import com.sist.vo.BoardVO;

import java.sql.*;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static BoardDAO dao;
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	public BoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {}
	}
	
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {}
	}
	
	public static BoardDAO newInstance() {
		if(dao == null)
			dao = new BoardDAO();
		return dao;
	}
	//--------------------공통사항-----------------------------
	//<기능>
	
	public List<BoardVO> boardListData(int page){
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			getConnection();
			String sql = "SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday, hit "
					+"FROM board "
					+"ORDER BY no DESC "
					+"OFFSET ? ROWS FETCH NEXT 10 ROWS ONLY";
			
			ps = conn.prepareStatement(sql);
			
			int rowSize = 10;
			int start = (page * rowSize) - rowSize;
			
			ps.setInt(1, start);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setDbday(rs.getString(4));
				vo.setHit(rs.getShort(5));
				list.add(vo);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
	
	//1. 총페이지 구하기
	public int boardTotalPate() {
		int total = 0;
		
		try {
			//연결
			getConnection();
			
			String sql = "SELECT CEIL(COUNT(*)/10.0) FROM board";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			total = rs.getInt(1);
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			//닫기
			disConnection();
		}
		return total;
	}
}
