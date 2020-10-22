<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!
	Connection conn;
	Statement statement;
	ResultSet resultset;

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cony";
	String user = "root";
	String pw = "1234";
	String query = "select * from user";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		try {
		Class.forName(driver);
		Connection	conn = DriverManager.getConnection(url, user, pw);
		Statement statement = conn.createStatement();
		ResultSet resultset = statement.executeQuery(query);

		while (resultset.next()) {
			int id = resultset.getInt("id");
			String pw = resultset.getString("password"); //DB에 있는 컬럼 이름과 일치
			String name = resultset.getString("name");

			out.println("아이디: " + id + "이름: " + name + "패스워드: " + pw + "<br/>");
		}

	} catch (Exception e) {
		e.printStackTrace();

	} finally {
		try {
			if (resultset != null)
				resultset.close();
			if (statement != null)
				statement.close();
			if (conn != null)
				conn.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	%>

</body>
</html>