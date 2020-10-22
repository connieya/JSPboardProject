package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDao {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private DataSource datasource;
	//int n;
	
	//String url = "jdbc:mysql://localhost:3306/cony";
	//String user = "root";
	//String pw = "1234"
	
	public UserDao() {
	try {
		String query = "insert into user(name,password) values(?,?)";
		Context context = new InitialContext();
		datasource = (DataSource) context.lookup("javax.sql.DataSource");
		//Class.forName("com.mysql.jdbc.Driver");
		//conn = DriverManager.getConnection(url,user,pw);
		pstmt = conn.prepareStatement(query);
		int n = pstmt.executeUpdate();
		
		
	}catch(Exception e) {
		e.printStackTrace();
		
	}
}

}
