<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function boardUpdateProcess(){
	/* 	//비밀번호 입력칸에 비밀번호를 입력받아서 db에 저장된 비밀번호와 일치하면 정보수정을 진행
		//일치하지 않으면 일치하지 않는다는 alert창을 띄움
		var pw = document.getElementById("bpassword").value;
		var pwdb = '${boardUpdate.bpassword}';
		console.log(pw);
		console.log(pwdb);
		if(pw.length != 0){
			if(pw==pwdb){
				updateform.submit();
			}else{
				alert('비밀번호가 틀립니다.')
			}
		} else{
			alert('비밀번호를 입력해주세요')
		}
	 */
	 updateform.submit();
	}
</script>
</head>
<body>
<h2>BoardUpdate.jsp</h2>
	<form action="boardupdateprocess" method="post" name="updateform">
		글번호<br>
		<input type="text" name="bnumber" id="bnumber" value="${boardUpdate.bnumber}" readonly><br>
		글쓴이<br>
		<input type="text" name="bwriter" id="bwriter" value="${boardUpdate.bwriter}"><br>
		제목<br>
		<input type="text" name="btitle" id="btitle" value="${boardUpdate.btitle}"><br>
		내용<br>
		<textarea cols="30" rows="10" type="text" name="bcontents" id="bcontents">${boardUpdate.bcontents}</textarea><br>
	<!-- 	비밀번호 확인<br>
		<input type="text" name="bpassword" id="bpassword"><br> -->
	</form>
	<button onclick="boardUpdateProcess()">수정</button>
</body>
</html>