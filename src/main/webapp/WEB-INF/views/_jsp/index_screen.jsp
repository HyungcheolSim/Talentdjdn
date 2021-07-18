<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
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

<!-- common -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/common.css">
<script src='../js/common.js'></script>

<!-- this page -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/index_screen.css">
<script src='../js/top_main.js'></script>

</head>

<body>
<div id="pic_box">
	<div id="pic1"></div>
	<div id="pic2"></div>
	<div id="pic3"></div>
	<div id="pic4"></div>
</div>
<div id="pic_box2">
	<div id="pic1"></div>
	<div id="pic2"></div>
	<div id="pic3"></div>
	<div id="pic4"></div>
</div>		
</body>
</html>