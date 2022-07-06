<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- 메인 로고 이미지를 링크하세요 logo.jpg -->
<a href="${pageContext.request.contextPath}/main"> <img class="logo" src="${pageContext.request.contextPath}/assets/images/logo.jpg">
</a>
<c:choose>
	<c:when test="${empty authUser}">
		<!-- 로그인 전 메뉴 -->
		<ul class="menu">
			<li><a href="${pageContext.request.contextPath}/user/loginForm">로그인</a></li>
			<li><a href="${pageContext.request.contextPath}/user/joinForm">회원가입</a></li>
		</ul>
	</c:when>
	<c:otherwise>
		<ul class="menu">
			<!-- 로그인 후 메뉴 -->
			<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
			<li><a href="${pageContext.request.contextPath}/${authUser.id}" target="_blank">내블로그</a></li>
		</ul>
	</c:otherwise>
</c:choose>