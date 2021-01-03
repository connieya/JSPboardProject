package board.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	ResultSet rs;
	
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
			String sql = "insert into board(name,title,content,password,readCount) values(?,?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPassword());
			pstmt.setInt(5, 0);
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
				String title =rs.getString("title");
				Timestamp date = rs.getTimestamp("date");
				String name = rs.getString("name"); //column 명
				 int readCount = rs.getInt("readCount");
				 
//				 System.out.println("no:" +no);
//				 System.out.println("name:" +name);
//				 System.out.println("title" +title);
//				 System.out.println("date" +date);
//				 System.out.println("readCount:" +readCount);
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
		System.out.println("글 상세보기 호출");
		
		
		ResultSet rs = null;
		
		String sql = "select * from board where no =?";
		BoardDto dto = new BoardDto();
		
		try {
			
			
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				조회수증가(no);
				System.out.println("ㅎㅎ");
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getNString(3));
				dto.setContent(rs.getString(4));
				dto.setDate(rs.getTimestamp(5));
				dto.setReadCount(rs.getInt(6));
				
				return dto;
			}
			
			
			
		}catch(Exception e){
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
		
		return null;
		
	}
	public void 조회수증가(String no) {
		String sql = "update board set readCount = readCount +1 where no =?";
		System.out.println("조회수 증가 메서드");
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, no);
			int result = pstmt.executeUpdate();
			
			System.out.println("결과는 : " + result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		
		
		
	}
	
	public int 글삭제하기(String no ) {
		
		System.out.println("삭제하기 메서드 호출");
		
		
		String sql = "delete from board where no = ?";
		
			try {
			
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, no);
				int result =pstmt.executeUpdate();
				System.out.println("result 값:" +result);
			}catch(Exception e) {
				e.printStackTrace();
				
			}finally {
				
				try {
					
						if(pstmt != null) pstmt.close();
						if(connection != null) connection.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
			return -2; // DB 오류
		
	}
	
	public int 삭제인증(String no ,String password) {
		
		
		String sql = "select password from board where no = ?";
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			if(rs.getString(1).equals(password)) {
				System.out.println("비밀번호 일치");
				return 1;
			}else {
				System.out.println("비밀번호 틀림");
				
				return 0;
			}
		}catch(Exception e){
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
		
		return -2;
		
	}
}
