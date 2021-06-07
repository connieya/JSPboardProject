<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#container{
		text-align: center;
		margin-top:20px;
	}
</style>
</head>
<body>
<jsp:include page="../component/header.jsp" flush="false" />
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-16">
	<div class="jumbotron" id="container">	
	<h1 class="display-4">로그인 화면</h1>
	<form action="/board/user/login.do" method="post">
		<div class="form-group">
		 <input class="form-control" type="text" name="id" placeholder="아이디"/> 
		</div>
		<div class="form-group">
		 <input class="form-control"  type="password" name="pw" placeholder="비밀번호"/> 
		</div>
		<input class="btn btn-primary btn-lg"  type="submit" value="로그인"/>
	</form>
			</div>
		</div>
		
	</div>
</body>
</html>