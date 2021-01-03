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
	<h2> 게시판</h2>
<div class="container">
  
  <table class="table table-striped">
    <thead>
      <tr>
      	<th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>현재시간</th>
        <th>조회수</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="boardlist">
      <tr>
      	<td>${boardlist.no}</td>
        <td>${boardlist.title}</td>
        <td>${boardlist.name}</td>
        <td>${boardlist.date}</td>
        <td>${boardlist.readCount}</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
  <a class="btn btn-primary" href="write.jsp">글쓰기</a>
</div>
</body>
</html>