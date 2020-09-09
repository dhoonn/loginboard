<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function insert(){
	location.href="BoardWrite.jsp";
	}
	function move(){
	location.href="boardlistpaging";
	}
	function update(){
	location.href="boardupdate?bnumber="+${boardView.bnumber};
	}
	function boarddelete(){
	location.href="boarddelete?bnumber="+${boardView.bnumber};
	}
</script>
</head>
<body>
<h2>BoardView.jsp</h2>
		글번호 : ${boardView.bnumber}<br>
		글쓴이 : ${boardView.bwriter}<br>
		제목 : ${boardView.btitle}<br>
		내용 : ${boardView.bcontents}<br>
		작성일자 : ${boardView.bdate}<br>
		조회수 : ${boardView.bhits}<br>
		첨부파일  : <img src="UploadFile/${boardView.bfilename}" width="200" hight="200"><br> 
		<button onclick = "insert()">글쓰기</button>
		<button onclick = "move()">목록보기</button>
		<c:if test="${sessionScope.loginId eq boardView.bwriter }">
		<button onclick = "update()">수정</button>
		</c:if>
		<c:if test="${sessionScope.loginId eq boardView.bwriter || sessionScope.loginId eq 'admin' }">
		<button onclick = "boarddelete()">삭제하기</button>
		</c:if>
</body>
</html>