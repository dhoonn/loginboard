<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
 <script>
 function pwdCheck() {
     //비밀번호 검증을 위한 정규식
     var exp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$/;
     var pwd = document.getElementById("mpassword").value;
     var pwdch = document.getElementById("pwdch");
     if (pwd.match(exp)) {
         pwdch.style.color = "green";
         pwdch.innerHTML = "비밀번호 형식 맞음";
     } else {
         pwdch.style.color = "red";
         pwdch.innerHTML = "비밀번호 형식 틀림";
     }
 }
 function idCheck(){
	 var exp = /^[a-z]+[a-z0-9]{5,19}$/g;
     var id = document.getElementById("mid").value;
     if (id.match(exp)) {
    	 alert('완료되었습니다.');
	     }else if(id.length == 0){
	    	 alert('아이디를 입력하세요');
	    	 
	 	 }else {
	    	 alert('아이디를 6~20자로 입력하세요');
	 	 }
     }
 function phoneCheck() {
     //전화번호 유효성 검증
     var exp = /^\d{3}-\d{4}-\d{4}$/;
     var phoned = document.getElementById("mphone").value;
     var phonech = document.getElementById("phonech");
     if (phoned.match(exp)) {
         phonech.style.color = "green";
         phonech.innerHTML = "핸드폰번호 형식 맞음";
     } else {
         phonech.style.color = "red";
         phonech.innerHTML = "핸드폰번호 형식 틀림";
     }

 }
 function disapper() {
     document.getElementById("phonech").innerHTML = "";
 }
 function boardJoin(){
	 joinform.submit();
 }
     function sample6_execDaumPostcode() {
         new daum.Postcode({
             oncomplete: function (data) {
                 // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                 // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                 // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                 var addr = ''; // 주소 변수
                 var extraAddr = ''; // 참고항목 변수

                 //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                 if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                     addr = data.roadAddress;
                 } else { // 사용자가 지번 주소를 선택했을 경우(J)
                     addr = data.jibunAddress;
                 }

                 // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                 if (data.userSelectedType === 'R') {
                     // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                     // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                     if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                         extraAddr += data.bname;
                     }
                     // 건물명이 있고, 공동주택일 경우 추가한다.
                     if (data.buildingName !== '' && data.apartment === 'Y') {
                         extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                     }
                     // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                     if (extraAddr !== '') {
                         extraAddr = ' (' + extraAddr + ')';
                     }
                     // 조합된 참고항목을 해당 필드에 넣는다.
                     document.getElementById("sample6_extraAddress").value = extraAddr;

                 } else {
                     document.getElementById("sample6_extraAddress").value = '';
                 }

                 // 우편번호와 주소 정보를 해당 필드에 넣는다.
                 document.getElementById('sample6_postcode').value = data.zonecode;
                 document.getElementById("sample6_address").value = addr;
                 // 커서를 상세주소 필드로 이동한다.
                 document.getElementById("sample6_detailAddress").focus();
             }
         }).open();
     }
 </script>
</head>
<body>
<h2>MemberJoin.jsp</h2>
<form action="boardjoin" method="post" name="joinform" enctype="multipart/form-data">
		아이디<br>
			<input type="text" name="mid" id="mid"placeholder="아이디를 입력하세요" maxlength="20" size="50px">
			<!-- <button id="btn" onclick="idCheck()">아이디체크</button> -->
			<input type="button" onclick="idCheck()" value="아이디체크">
			
			<p></p>	
		비밀번호<br>
            <input type="text" name="mpassword" id="mpassword" maxlength="20" placeholder="비밀번호를 입력하세요" size="50px"onkeyup="pwdCheck()"><br>
            <span id="pwdch"></span><br>
             <p></p>	
		이름<br>
			<input type="text" name="mname" id="mname"size="50px"><br>
		  	<p></p>	
		생년월일<br>
            <input type="date" name="mbirth" id="mbirth"size="50px"><br>
            <p></p>	
		이메일<br>
			<input type="text" name="memail" id="memail"size="50px"><br>
		  	<p></p>	
		주소<br>
            <input type="text" name="maddress" id="sample6_postcode" placeholder="우편번호">
            <input type="button" name="maddress" id="btn" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
            <input type="text" name="maddress" id="sample6_address" placeholder="주소"><br>
            <input type="text" name="maddress" id="sample6_detailAddress" placeholder="상세주소">
            <input type="text" name="maddress" id="sample6_extraAddress" placeholder="참고항목">
            <p></p>	
		 휴대전화<br>
            <input type="text" id="mphone" name="mphone" placeholder="휴대폰 번호를 입력하세요" size="50px"onkeyup="phoneCheck()" onblur="disapper()"><br>
            <span id="phonech"></span>
			<p></p>	
		프로필 사진<br>
			<input type="file" name="mprofile" id="mprofile"><br>
			<p></p>	
         <button onclick="boardJoin()">가입하기</button>
	</form>

</body>
</html>