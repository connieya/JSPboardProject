package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import board.vo.User;

public class UserDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource dataSource;

	public void setDataSource(DataSource dataSoruce) {
		this.dataSource = dataSource;

	}

	public int login(String userID, String userPassword) {
		String sql = "select userPassword from user where userID =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(userPassword)) {
					return 1; // 로그인 성공
				} else {
					return 0; // 비밀번호 불일치
				}
			}
			return -1; // 아이디가 없음
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // 데이터 베이스 오류
	}
	
	public int join(User user) throws Exception {
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(
					"insert into user(id, name, password) values(?,?,?)");
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		}finally {
		      try {if (pstmt != null) pstmt.close();} catch(Exception e) {}
		      try {if (conn != null) conn.close();} catch(Exception e) {}
		    }
	}
}
