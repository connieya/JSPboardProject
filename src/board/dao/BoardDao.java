package board.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import board.dto.BoardDto;

public class BoardDao {

	DataSource datasource;
	
	public BoardDao() {
	
	try {
		Context context = new InitialContext();
		datasource = (DataSource) context.lookup("javax.sql.DataSource");
			
	}catch(Exception e){
		e.printStackTrace();
	}

	
	
	} // BoardDao() 생성자 끝
	
	public ArrayList<BoardDto> list() {
		
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			
			conn = datasource.getConnection();
			
			String query ="select * from board" ;
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name"); //column 명
				String title =rs.getString("title");
				String content = rs.getString("content");
				Date date = rs.getDate("date");
				 int readCount = rs.getInt("readCount");
				 
				 BoardDto dto = new BoardDto(name,title,content,date,readCount);
				 dtos.add(dto);
			}
			
			
		}catch(Exception e) {
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
		
		return dtos;
		
	} // list() 끝
}
