package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import board.dto.BoardDto;
import board.dto.MemberVo;

public class MemberDao {
	
	DataSource datasource;
	
	
	public MemberDao() {
	
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("javax.sql.DataSource");
				
		}catch(Exception e){
			e.printStackTrace();
		}
		
	
	}// 생성자 닫음
	
	public void insert() {
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		
		/*
		 * try { int n ; String sql = "insert into member(name,password) values(?,?)";
		 * conn = datasource.getConnection();
		 * 
		 * if(n=1) { pstmt = conn.prepareStatement(sql); }
		 * 
		 * }catch(Exception e) { e.printStackTrace(); }
		 */
	} // insert 메서드 닫힘
	
	

}
