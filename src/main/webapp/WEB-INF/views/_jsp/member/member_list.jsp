<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- this page -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/member_list.css">

<script type="text/javascript">

function del(m_idx) {
	
	if(confirm('정말 탈퇴 시키시겠습니까?')==false) return; 
	
	//삭제정보 전송
	location.href="delete.do?m_idx=" + m_idx; 
}

</script>

</head>
<body>

	<div class="tp_layers">
      <div class="tp_button_layout">
         <%@ include file="../top_button.jsp" %>
      </div>
   </div>


	<div id="box">
		<div class="panel panel-warning">
			<div class="panel-heading">회원관리</div>
			<div class="panel-body">
			
				<table class="table">
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>이름</th>
					<th>주민번호</th>
					<th>주소</th>
					<th>이메일</th>
					<th>전화번호</th>
					<th>지역</th>
					<th>가입일자</th>
				</tr>
				
				<!-- data가 비어있으면 -->
				<c:if test="${ empty list }">
					<tr>
						<td colspan="9">
							<p style="text-align: center; color:red;'">데이터가 없습니다</p>
						</td>
					</tr>
				</c:if>
				
				<c:forEach var="vo" items="${ list }">
					<tr>
						<td>${ vo.m_idx }</td>
						<td>${ vo.m_id }</td>
						<td>${ vo.m_name }</td>
						<td>${ vo.m_jumin }</td>
						<td>${ vo.m_addr }${ vo.m_detail_addr }</td>
						<td>${ vo.m_email }</td>
						<td>${ vo.m_phone }</td>
						<td>${ vo.m_local }</td>
						<td>${ vo.m_regdate }</td>
						<td>
							<input class="btn btn-danger" type="button" value="탈퇴" 
							                              onclick="del('${vo.m_idx}');">
						</td>
					</tr>
				</c:forEach>
				
			</table>
			
			</div>
		</div>
	</div>

	<div class="tp_layers">
      <div class="tp_bottom_layout">
         <%@ include file="../bottom.jsp" %>
      </div>
   </div>

</body>
</html>