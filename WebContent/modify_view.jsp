<%@page import="board.dto.BoardDto"%>
<%@page import="board.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
	<jsp:include page="component/header.jsp" flush="false" />
	
	<% 
	String no = request.getParameter("no");
	BoardDao dao =new BoardDao();
		BoardDto dto = dao.글상세보기(no);
	%>
	<h2> 게시판</h2>
<div class="container">
				<form action="modify.do?no=<%=dto.getNo() %>" method="post">
  <table class="table table-striped" style="text-align :center; border: 1px solid #dddddd">
				
				<thead>
					<tr>
						<th>번호&nbsp;<%=dto.getNo() %></th>
						<th colspan="3" style="background-color: #eeeeee; text-align: center;">상세보기</th>
					</tr>
				</thead>
				<tbody>
			
				<tr>
				 	<td>작성자</td>
				 	<td><%=dto.getName() %></td>
				 	<td>조회수</td>
				 	<td><%= dto.getReadCount() %></td>
				</tr>
				<tr>
				 	<td>제목</td>
				 	<td><input type="text" value="<%=dto.getTitle() %>" name="title" /></td>
				 	<td>날짜</td>
				 	<td><%=dto.getDate() %></td>
				</tr>
				<tr>
				 	<td>내용</td>
				 	<td colspan="4"><textarea name="content" id="" cols="100" rows="10" ><%=dto.getContent() %></textarea></td>
				</tr>
				
				</tbody>
				</table>
  
  <button type="submit" class="btn btn-primary" >수정</button>
   <a class="btn btn-danger"  href="content_view.do?no=<%=dto.getNo() %>" >목록</a>
				</form>


</div>
</body>
</html>