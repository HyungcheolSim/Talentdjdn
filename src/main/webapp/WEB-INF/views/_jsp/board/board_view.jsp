<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- SweetAlert사용설정 : 알림박스 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


<style type="text/css">

	#box{
		width: 700px;
		margin: auto;
		margin-top: 50px;
	}
	
	#title,#content,#regdate{
		width:  500px;
		margin: 2px;
		border: 1px solid gray;
		padding: 5px;
	}
	
	#content{
		min-height: 200px;  
	}
	
	input[type='button']{
		width: 100px;
	}
	
</style>

<script type="text/javascript">
$(document).ready(function(){
	sessionStorage.setItem("show",true);
});
	//삭제
	function del(b_idx){
		alert('정말 삭제하시겠습니까?');
		location.href="delete.do?b_idx=" + b_idx;
		
	}//end-del
	
	function golist(){
		sessionStorage.removeItem("show");
		location.href="list.do";
	}
	function modify_form(b_idx) {
		
		location.href="modify_form.do?b_idx=" + b_idx;
		
	}//end-modify_form

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

			<div id="box">
				<div class="panel panel-warning">
					<div class="panel-heading">
						<h5>${ vo.member.m_id }님이작성한 글:</h5>
					</div>
					<div class="panel-body">
						<table class="table">
							<tr>
								<th>제목</th>
								<td><div id="title">${ vo.b_title }</div></td>
							</tr>

							<tr>
								<th>내용</th>
								<td><div id="content">${ vo.b_content }</div></td>
							</tr>

							<tr>
								<th>작성일자</th>
								<td><div id="regdate">${ vo.b_regdate }</div></td>
							</tr>

							<tr>
								<td colspan="2" align="center"><input
									class="btn btn-warning" type="button" value="목록보기"
									onclick="golist();"> <!-- 본인 또는 관리자 --> 
									<c:if test="${ user.m_grade eq '관리자' }">
										<input class="btn btn-warning" type="button" value="수정"
											onclick="modify_form('${ vo.b_idx }');">
										<input class="btn btn-warning" type="button" value="삭제"
											onclick="del('${ vo.b_idx }');">
									</c:if></td>
							</tr>
						</table>
					</div>
				</div>

			</div>
		</div>

		<div class="tp_layers">
			<div class="tp_bottom_layout">
				<%@ include file="../bottom.jsp"%>
			</div>
		</div>

	</div>
</body>
</html>