<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글쓰기 페이지</h1>


	<form action="write.do" method="post">
	제목: <input type="text" name="name" /> <br />
	내용 : <input type="text" name="content" /><br />
	<input type="submit" value="글작성" />
	</form>
</body>
</html>