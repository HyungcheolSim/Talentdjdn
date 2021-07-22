<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jquery -->
<script src="../resource/js/jquery-3.6.0.min.js"></script>

<!-- bootstrap -->
<link href="../resource/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="../resource/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>

<!-- semantic ui -->
<link rel="stylesheet" href="../resource/Semantic-UI-CSS-master/semantic.css">
<script src="../resource/Semantic-UI-CSS-master/semantic.js"></script>

<!-- common -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/common.css">
<script src='../js/common.js'></script>

<!-- this page -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/top_button.css">
<script src='../js/top_button.js'></script>

</head>
<body>
	<div>
		<div>
		<a href="index.jsp"><img class="main_logo" alt="" src="${ pageContext.request.contextPath }/resources/img/logo.png"></a>
		</div>
		<ul class="main_top_button">
			<li><a href="../board/list.do">게시판</a></li>
			<li><a href="../member/insert_form.do">회원가입</a></li>
		    <li><a href="talent/talent_detail.jsp">재능찾기</a></li>
		    <c:if test="${ empty user }">
		    	<li><a href="../member/login_form.do">로그인</a></li>
		    </c:if>
		    <c:if test="${ not empty user }">
		    	<li><a href="../member/logout.do">로그아웃</a></li>
		    	<div>
					<b>[${ user.m_id }]</b>님 로그인 하셨습니다
				</div>
		    </c:if> 
		</ul>
		
	</div>

</body>
</html>