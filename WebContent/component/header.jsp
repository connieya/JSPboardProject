<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="/board//index.jsp">Home <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="/board/user/join.do">회원가입</a>
      <a class="nav-item nav-link" href="/board/auth/login.do">로그인</a>
      <a class="nav-item nav-link " href="/board/board/list.do">게시판</a>
    <c:if test="${!empty sessionScope.user}" >
    <a class="nav-item nav-link" href="/board/user/detail.do">회원수정</a>
    <a class="nav-item nav-link" href="/board/auth/logout.do">로그아웃</a>
    </c:if>
    </div>
  </div>
</nav>
</body>
</html>