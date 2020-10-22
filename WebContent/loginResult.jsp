<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = (String)session.getAttribute("name");
		String pw = (String) session.getAttribute("pw");
		
	%>
	<%= name %>님 안녕하세요 <br/>
	<a href="modify.jsp">회원 정보 수정</a>
</body>
</html>