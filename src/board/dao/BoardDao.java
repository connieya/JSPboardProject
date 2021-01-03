package board.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import board.dto.BoardDto;

public class BoardDao {

	DataSource datasource;
	Connection connection;
	PreparedStatement pstmt;
	
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cony";
	String user = "root";
	String pw = "1234";
	
	public BoardDao() {
	
	try {
		//Context context = new InitialContext();
		//datasource = (DataSource) context.lookup("javax.sql.DataSource");
		Class.forName(driver);
		 connection = DriverManager.getConnection(url,user,pw);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	} // BoardDao() 생성자 끝
	
	public int 글쓰기(BoardDto dto) {
	
		
		ResultSet rs = null;
		
		try {
			
			System.out.println("db연동 성공");
			String sql = "insert into board(name,title,content,password) values(?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPassword());
			int result = pstmt.executeUpdate();
			System.out.println("result 값:" +result);
		
			return result;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("오류 떴음");
		
		}finally {
			
			try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(connection != null) connection.close();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
		}
		
		return -1;
		
	}
	
	public ArrayList<BoardDto> list() {
		
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		
		ResultSet rs = null;
		
		
		try {
			
			
			
			String query ="select * from board order by no desc" ;
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name"); //column 명
				String title =rs.getString("title");
				Timestamp date = rs.getTimestamp("date");
				 int readCount = rs.getInt("readCount");
				 
				 System.out.println("no:" +no);
				 System.out.println("name:" +name);
				 System.out.println("title" +title);
				 System.out.println("date" +date);
				 System.out.println("readCount:" +readCount);
				 BoardDto dto = new BoardDto();
				 dto.setNo(no);
				 dto.setName(name);
				 dto.setTitle(title);
				 dto.setDate(date);
				 dto.setReadCount(readCount);
	
				 dtos.add(dto);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		
		}finally {
			
			try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(connection != null) connection.close();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
		}
		
		return dtos;
		
	} // list() 끝
	
	public BoardDto 글상세보기(String no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from board where no =?";
		BoardDto dto = new BoardDto();
		
		try {
			
			conn = datasource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			
			dto.setNo(rs.getInt(1));
			dto.setName(rs.getString(2));
			dto.setTitle(rs.getNString(3));
			dto.setContent(rs.getString(4));
			dto.setDate(rs.getTimestamp(5));
			dto.setReadCount(rs.getInt(6));
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			
			try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
		}
		
		
		return dto;
	}
}
