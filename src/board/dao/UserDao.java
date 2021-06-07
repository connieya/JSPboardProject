package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import board.vo.User;

public class UserDao {
	DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	public User login(String userID, String userPassword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from user where id =? and password =?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, userPassword);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new User().setName(rs.getString("name")).setId(rs.getString("id"));
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return null;
	}

	public int join(User user) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("ds = "+ds);
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("insert into user(id, name, password,create_date, mod_date) values(?,?,?,now(),now())");
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());

			return pstmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}
	
	public int delete(int no) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ds.getConnection();
			conn.prepareStatement("delete * from user where no = ? ");
			stmt.setInt(1, no);
			
			return stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		      try {if (stmt != null) stmt.close();} catch(Exception e) {}
		      try {if (conn != null) conn.close();} catch(Exception e) {}
		    }
		return -1;
	}
	
	public User selectOne(int no) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			conn.prepareStatement("select * from user where id =?");
			stmt.setInt(1, no);
			stmt.executeQuery();
			if(rs.next()) {
				return new User()
						.setId(rs.getString("id"))
						.setName(rs.getString("name"))
						.setPassword(rs.getString("password"))
						.setNo(rs.getInt("no"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public int update(User user) {
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement(
					"update user set name =? , password =? mod_date =now() where no =?"
					);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPassword());
			stmt.setInt(3, user.getNo());
			return stmt.executeUpdate();
		} catch (Exception e) {
			
		} finally {
		      try {if (stmt != null) stmt.close();} catch(Exception e) {}
		      try {if (connection != null) connection.close();} catch(Exception e) {}
		    }
		return -1;
	}
}
