<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">

</head>
<body>
	<div id="center-content">

		<!--메인 해더 자리 -->
		<c:import url="/WEB-INF/views/includes/main-header.jsp"></c:import>


		<form id="search-form">
			<div>
				<input type="text" name="keyword">
				<button id="btnSearch" type="submit">검색</button>
			</div>

			<div>
				<label for="rdo-title">블로그 제목</label> 
				<input id="rdo-title" type="radio" name="kwdOpt" value="optTitle"> 
				<label for="rdo-userName">블로거 이름</label> 
				<input id="rdo-userName" type="radio" name="kwdOpt" value="optName">
			</div>
		</form>

		<div id="resultList">
			<table border="1" id="resultTable">
				<colgroup>
					<col style="width: 20%;">
				</colgroup>
			<c:forEach items="${uList}" var="usersVo">
				<tbody>
					<tr>
						<c:choose>
							<c:when test="${usersVo.logoFile!=null}">
								<td height="40">
										<img id="proImg" src="${pageContext.request.contextPath}/upload/${usersVo.logoFile}">
								</td>
							</c:when>
							<c:otherwise>
								<td height="40">
									<div style = "height:100%">
										<img id="proImg" src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg">
									</div>
								</td>
							</c:otherwise>
						</c:choose>
						<td>${usersVo.blogTitle}</td>
						<td>${usersVo.userName}</td>
						<td>${usersVo.joinDate}</td>
					</tr>
				</tbody>
			</c:forEach>
			</table>
		
		</div>

		<!-- 메인 푸터  자리-->
		<c:import url="/WEB-INF/views/includes/main-footer.jsp"></c:import>


	</div>
	<!-- //center-content -->
</body>
</html>