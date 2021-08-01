<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- common -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/common.css">


<!-- this page -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/index.css">

</head>
<body>
	<div class="back_color">
	<div class="tp_layers">
		<div class="tp_button_layout">
			<%@ include file="top_button.jsp" %>
		</div>
	</div>
	</div>
	<div class="tp_layer">
		<div class="tp_search_layout">
			<%@ include file="top_main.jsp" %>
		</div>
	</div>
	<div class="tp_layer_main">
		<div class="tp_index_layout">
			<%@ include file="index_screen.jsp" %>
		</div>
	</div>
	<div class="tp_layers">
		<div class="tp_bottom_layout">
			<%@ include file="bottom.jsp" %>
		</div>
	</div>
</body>
</html>