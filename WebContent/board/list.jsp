<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시판 목록</h1>
	<table    border="1">
	<button>글쓰기</button>
	<tr>
		<td>작성자</td>
		<td>제목</td>
		<td>내용</td>
		<td>날짜</td>
		<td>조회수</td>
	
	</tr>
	<c:forEach items="${list}" var="dto">
		<td>${dto.name}</td>
		<td>${dto.title}</td>
		<td>${dto.content}</td>
		<td>${dto.date}</td>
		<td>${dto.readcount}</td>
	
	</c:forEach>
	</table>
</body>
</html>