<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
		function goLogin(){
			loginform.submit();
		}
		
</script>
</head>
<body>
<h2>BoardLogin.jsp</h2>
<form action="boardlogin" method="post" name="loginform">
		아이디 : <input type="text" name="mid" id="mid">
		비밀번호 : <input type="text" name="mpassword" id="mpassword">
	</form>
	<button onclick="goLogin()">로그인</button>
	<button onclick="location.href='BoardJoin.jsp'" >회원가입</button>
</body>
</html>