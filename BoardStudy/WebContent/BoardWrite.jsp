<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	function boardWrite() {
		writeform.submit();
	}
</script>
<body>
	<h2>BoardWrite.jsp</h2>
	<form action="boardwrite" method="post" name="writeform">
		작성자<br> 
		<input type="text" name="bwriter" id="bwriter" value="${sessionScope.loginId}"><br>
		<!-- 비밀번호<br> 
		<input type="text" name="bpassword" id="bpassword"><br> -->
		제목<br> 
		<input type="text" name="btitle" id="btitle"><br>
		내용<br>
		<textarea rows="10" cols="10" type="text" name="bcontents" id="bcontents"></textarea>
		첨부파일<br>
		<input type="file" name="bfile" id="bfile"><br>
		
		<br> <input type="button" onclick="boardWrite()" value="글작성">
	</form>
</body>
</html>