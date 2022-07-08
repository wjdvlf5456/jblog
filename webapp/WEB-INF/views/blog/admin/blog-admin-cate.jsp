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
	<div id="wrap">

		<!-- 개인블로그 해더 -->
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>


		<div id="content">
			<ul id="admin-menu" class="clearfix">
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${blogVo.id}/admin/basic">기본설정</a></li>
				<li class="tabbtn selected"><a href="${pageContext.request.contextPath}/${blogVo.id}/admin/category">카테고리</a></li>
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${blogVo.id}/admin/writeForm">글작성</a></li>
			</ul>
			<!-- //admin-menu -->

			<div id="admin-content">

				<table id="admin-cate-list">
					<colgroup>
						<col style="width: 50px;">
						<col style="width: 200px;">
						<col style="width: 100px;">
						<col>
						<col style="width: 50px;">
					</colgroup>
					<thead>
						<tr>
							<th>번호</th>
							<th>카테고리명</th>
							<th>포스트 수</th>
							<th>설명</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody id="cateList">
						<!-- 리스트 영역 -->
						<!-- 리스트 영역 -->
					</tbody>
				</table>

				<table id="admin-cate-add">
					<colgroup>
						<col style="width: 100px;">
						<col style="">
					</colgroup>
					<tr>
						<td class="t">카테고리명</td>
						<td><input type="text" name="cateName" value=""></td>
					</tr>
					<tr>
						<td class="t">설명</td>
						<td><input type="text" name="description"></td>
					</tr>
				</table>

				<div id="btnArea">
					<button id="btnAddCate" class="btn_l" type="submit">카테고리추가</button>
				</div>

			</div>
			<!-- //admin-content -->
		</div>
		<!-- //content -->


		<!-- 개인블로그 푸터 -->
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>



	</div>
	<!-- //wrap -->
</body>

<script type="text/javascript">
	$(document).ready(function() {
		console.log("jquery로 데이터 받기");
		fetchList();

	});
	
	$("#btnSubmit").on("click", function() {
		console.log("저장버튼 클릭");

		// 데이터 수집
		var id = '${blogVo.id}';
		var cateName = $("[name='name']").val();
		var description = $("[name='password']").val();

		var cateVo = {
			id : id, 
			cateName : cateName, 
			description : description
		};

		console.log(cateVo);

		$.ajax({
			url : "${pageContext.request.contextPath}/addCategory",
			type : "post",
			contentType : "application/json",
			data : JSON.stringify(cateVo), 

			dataType : "json",
			success : function(gVo) {
				render(gVo, "up");

				//입력폼 초기화
				$("[name='name']").val("");
				$("[name='password']").val("");
				$("[name='content']").val("");

			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}

		});
		// ajax 

	});

	// 리스트 요청
	function fetchList() {
		var id = '${blogVo.id}';
		console.log(id);
		
		// = 없으면 오류
		var cateVo = {
			id: id
		};
		
		
		
		$.ajax({
			url : "${pageContext.request.contextPath}/cateList",
			type : "post",
			contentType : "application/json",
			data : JSON.stringify(cateVo),
			
			dataType : "json",
			success : function(cateList) {
				/*성공시 처리해야될 코드 작성*/
				console.log(cateList);
				//화면에 data + html을 그린다.
				for (var i = 0; i < cateList.length; i++) {
					render(cateList[i], "down");
				}

			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}

		})
		// ajax 
	};

	function render(cateVo, opt) {
		console.log('render()');

		var str = '';
		
		str += '<tr>';
		str += '	<td>' + cateVo.cateNo + '</td>';
		str += '	<td>' + cateVo.cateName + '</td>';
		str += '	<td>포스팅 수</td>';
		str += '	<td>' + cateVo.description + '</td>';
		str += '    <td class="text-center">';
		str += '    	<img class="btnCateDel" src="${pageContext.request.contextPath}/assets/images/delete.jpg">';
		str += '   </td>';
		str += '</tr>';

		//리스트 순서
		if (opt == "up") {
			$("#cateList").prepend(str);

		} else if (opt == "down") {
			$("#cateList").append(str);

		} else {
			console.log("opt오류");
		}

	};
	/* 
	 #("img").on("click",".btnCateDel",function(){
	 var $this = $(this).val();
	 console.log($this);
		$.ajax({
			url : "${pageContext.request.contextPath}/cateList",
			type : "post",
			contentType : "application/json",
			//data : {id: id},

			dataType : "json",
			success : function(cateList) {
				/*성공시 처리해야될 코드 작성
				console.log(cateList);
				//화면에 data + html을 그린다.
				for (var i = 0; i < cateList.length; i++) {
					render(cateList[i], "down");
				}

			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}

		})
		// ajax 
	
	 });
	  */
</script>
</html>