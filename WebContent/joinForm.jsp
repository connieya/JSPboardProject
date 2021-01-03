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
		<h1>회원가입</h1>
		<form action="JoinOk" method="post">
			아이디 : <input type="text" name=id  size="20" /> <br/>
			이름 : <input type="text" name="name" size="20"  /> <br/>
			비밀번호 : <input type="password" name="pw" size="30"> <br/>
			<input type="submit" value="회원가입" />
		
		</form>

</body>
</html>