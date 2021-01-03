<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="component/header.jsp" flush="false" />
	

	<div class="container-sm p-3 border" style="margin-top:20px; border:2px solid red;">
		<h1>글쓰기 페이지</h1>
	<form action="write.do" method="post">
		<div class="form-group">
			작성자: <input class="form-control" type="text" name="name" />

		</div>
		<div class="form-group">
			제목: <input class="form-control" type="text" name="title" />

		</div>
		<div class="form-group">
			내용: <input class="form-control" type="text" name="content" />

		</div>
		<div class="form-group">
			비밀번호: <input class="form-control" type="password" name="password" />

		</div>
		<input class="btn btn-warning" type="submit" value="글작성" />
	</form>
	</div>
</body>
</html>