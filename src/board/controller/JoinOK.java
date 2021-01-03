package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinOK
 */
@WebServlet("/JoinOk")
public class JoinOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinOK() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("do get 요청");
		actionDo(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 요청");
		actionDo(request,response);
	
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String url = "jdbc:mysql://localhost:3306/cony";
		String user = "root";
		String pw = "1234";
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("pw");
		
		String sql = "insert into user(id, name, password) values(?,?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url,user,pw);
			
			System.out.println("db연동성공");
			
			pstmt = connection.prepareStatement(sql);
			// executeUpdate는 반환 값이 있다. 그래서 int i에 값을 넣을 수 있음
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			int result = pstmt.executeUpdate();
			if(result == 1) {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원가입 완료')");
				out.println("</script>");
				
				response.sendRedirect("index.jsp");
				System.out.println("회원가입 성공");
			}else {
				System.out.println("회원가입 실패");
				response.sendRedirect("join.html");
			}
		}catch(Exception e){
				e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
				if(connection !=null) connection.close();
				
			}catch(Exception e1){
					e1.printStackTrace();
			}
		}
	}

}
