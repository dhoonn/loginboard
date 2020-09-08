<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function boardMDeleteProcess(){
	var pw = document.getElementById("mpassword").value;
	var pwdb = '${boardMDelete.mpassword}';
	console.log(pw);
	console.log(pwdb);
	if(pw.length != 0){
		if(pw==pwdb){
			deleteform.submit();
		}else{
			alert('비밀번호가 틀립니다.')
		}
	} else{
		alert('비밀번호를 입력해주세요')
	}
}
</script>
</head>
<body>
<h2>BoardMDelete.jsp</h2>
	<form action="memberdeleteprocess" method="post" name="deleteform">
	비밀번호 확인<br>
		<input type="text" name="mpassword" id="mpassword"><br>
	</form>
	<button onclick="boardMDeleteProcess()">탈퇴</button>
</body>
</html>