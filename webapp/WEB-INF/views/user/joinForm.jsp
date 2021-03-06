<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>

<!-- css -->
<link href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">

<!-- js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.js"></script>

</head>
<body>
	<div id="center-content">

		<!-- 메인 해더 -->
		<c:import url="/WEB-INF/views/includes/main-header.jsp"></c:import>

		<div>
			<form id="joinForm" method="post" action="${pageContext.request.contextPath}/user/join">
				<table>
					<colgroup>
						<col style="width: 100px;">
						<col style="width: 170px;">
						<col style="">
					</colgroup>
					<tr>
						<td><label for="txtId">아이디</label></td>
						<td><input id="txtId" type="text" name="id"></td>
						<td><button id="btnIdCheck" type="button" value="result">아이디체크</button></td>
					</tr>
					<tr>
						<td></td>
						<td id="tdMsg" colspan="2"></td>
					</tr>
					<tr>
						<td><label for="txtPassword">패스워드</label></td>
						<td><input id="txtPassword" type="password" name="password" value=""></td>
						<td></td>
					</tr>
					<tr>
						<td><label for="txtUserName">이름</label></td>
						<td><input id="txtUserName" type="text" name="userName" value=""></td>
						<td></td>
					</tr>
					<tr>
						<td>
							<span>약관동의</span>
						</td>
						<td colspan="3">
							<input id="chkAgree" type="checkbox" name="agree"> 
							<label for="chkAgree">서비스 약관에 동의합니다.</label>
						</td>
					</tr>
				</table>
				<div id="btnArea">
					<button id="btnJoin" class="btn" type="submit">회원가입</button>
				</div>

			</form>

		</div>


		<!-- 메인 푸터  자리-->
		<c:import url="/WEB-INF/views/includes/main-footer.jsp"></c:import>

	</div>

</body>
<script type="text/javascript">
//아이디 중복체크
$("#btnIdCheck").on("click", function() {
	console.log("아이디 중복체크")

	var id = $("#txtId").val();

	var usersVo = {
		id : id
	};

	$.ajax({
		url : "${pageContext.request.contextPath}/user/check",
		type : "post",
		contentType : "application/json",
		data : JSON.stringify(usersVo), //js객체를 JSON문자열로 변환

		dataType : "json",
		success : function(result) {
			if (result == true) {
				$("#tdMsg").text("사용할 수 있는 아이디 입니다.").css("color","blue");
				
			} else {
				$("[name='id']").val("");
				$("#tdMsg").text("다른 아이디로 가입해 주세요").css("color","red");
			}

		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	});
	// ajax 

});
		
//====================== 회원가입 시 약관동의 미 체크시 경고창 ======================
$("#btnJoin").on("click",function(){
	//입력값들 가져오기
	var id = $("#txtId").val();
	var check = $("#tdMsg").css("color");
	var password = $("#txtPassword").val();
	var userName = $("#txtUserName").val();
	var agree = $("#chkAgree:checked").length;
	
	//콘솔창에서 확인
	console.log(id);
	console.log(check);
	console.log(password);
	console.log(userName);
	console.log(agree);
	
	if (id=="" || id == null) {
		alert("아이디를 입력해주세요");
		return false;
		
	} else if(check!="rgb(0, 0, 255)"){	//#tdMsg를 파랑색으로 css를 부여하게 했으니 파랑이면 성공
		alert("아이디 중복체크를 해주세요");
		return false;
		
	} else if(password=="" || password==null){
		alert("패스워드를 입력해주세요");
		return false;
		
	} else if(userName=="" || userName==null){
		alert("이름을 입력해주세요");
		return false;
		
	} else if(agree<1){
		alert("약관에 동의해주세요");
		return false;
	}
	
	
	
	
});


</script>
</html>