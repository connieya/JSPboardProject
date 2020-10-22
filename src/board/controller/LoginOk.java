package board.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
	
/**
 * Servlet implementation class LoginOk
 */
@WebServlet("/LoginOk")
public class LoginOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/cony";
	private String user  ="root";
	private String pw ="1234";
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String DBpw = request.getParameter("pw");
		String query = "select * from user where  name = '"+id+"' and password= '"+DBpw+"' ";
		
		
		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				
				id = rs.getString("name");
				pw = rs.getNString("password");
			}
			
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("name", id);
			httpSession.setAttribute("pw", pw);
			
			response.sendRedirect("loginResult.jsp");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}
