<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- common -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/common.css">

<!-- this page -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/index_screen.css">


</head>

<body>
	
	<c:forEach var="talent" items="${ list }" begin="1" end="12">
	<div id="pic_box">
		<img  class="index_image" src="${pageContext.request.contextPath }/resources/img/${talent.t_image}" >
		<div class="c_title"> <span class="c_name" >${ talent.t_title }</span> <span class="c_star" >${ talent.t_starscore }</span></div>
	</div>
	</c:forEach>
	
<%-- 	<c:forEach items="">
	<div id="pic_box2">
		<div id="pic1"></div>
	</div>	
	</c:forEach> --%>
	
</body>
</html>