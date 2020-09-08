<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function move(){
	location.href="boardlistpaging";
	}
function update(){
	//location.href="memberupdate?mid="+${memberView.mid};
	location.href="memberupdate?mid=${sessionScope.loginId}";
	}
function memberdelete(){
	location.href="memberdelete?mid=${sessionScope.loginId}";
	}
</script>
</head>
<body>
	<h2>BoardMyPage.jsp</h2>
		아이디 : ${memberView.mid}<br>
		비밀번호 : ${memberView.mpassword}<br>
		이름 : ${memberView.mname}<br>
		생년월일 : ${memberView.mbirth}<br>
		이메일 : ${memberView.memail}<br>
		주소 : ${memberView.maddress}<br>
		휴대전화 : ${memberView.mphone}<br>
		포르필 사진 : ${memberView.mprofile}<br>
		<br>
		<button onclick = "move()">home</button>
		<button onclick = "update()">개인정보변경</button>
		<button onclick = "memberdelete()">회원탈퇴</button>
</body>
</html>