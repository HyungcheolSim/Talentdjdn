<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">

	#main_box{
		width: 1000px;
		margin: auto;
		margin-top: 20px;
	}

	#title{
		text-align: center;
		font-size: 26pt;
		font-weight: bold;
		color: gray;
		text-shadow: 1px 1px 1px black;
	}
	
	input[type='button']{
		width: 100px;
	}
	
	th,td{
		text-align: center;
	}
	
	#empty_message{
		text-align: center;
		color: red;
		font-size: 16pt;
		font-weight: bold;
		margin-top: 50px;
	}

</style>

<script type="text/javascript">

	function insert_form() {

		location.href = 'insert_form.do';
	}

</script>

</head>
<body>

	<div class="tp_layers">
		<div class="tp_button_layout">
			<%@ include file="../top_button.jsp"%>
		</div>
	</div>

	<div class="tp_layer">
		<div class="tp_main_layout">


			<div id="main_box">
				<div><h2>게시판</h2></div>
				<table class="table">
					<!-- 제목 -->
					<tr class="warning">
						<th>번호</th>
						<th width="50%">제목</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>조회수</th>
					</tr>
					<!-- Data없는 경우 -->
					<c:if test="${ empty list }">
						<tr>
							<td colspan="5">
								<div id="empty_message">게시물이 존재하지 않습니다.</div>
							</td>
						</tr>
					</c:if>

					<!-- Data있는 경우 -->
					<!-- for(BoardVo vo : list) -->
					<c:forEach var="vo" items="${ list }">
						<tr>
							<td>${ vo.b_idx }</td>
							<td><a href="view.do?b_idx=${ vo.b_idx }">${ vo.b_title }</a></td>
							<td>${ vo.m_id }</td>
							<td>${ vo.b_regdate }</td>
							<td>${ vo.b_readhit }</td>
						</tr>
					</c:forEach>

				</table>
				
				<!-- 새글쓰기 -->
				<div>
					<c:if test="${ user.m_grade eq '관리자' }">
						<input class="btn btn-warning" type="button" value="글쓰기"
							onclick="insert_form();">
					</c:if>	
				</div>
				
			</div>

		</div>
	</div>

	<div class="tp_layers">
		<div class="tp_bottom_layout">
			<%@ include file="../bottom.jsp"%>
		</div>
	</div>

</body>
</html>