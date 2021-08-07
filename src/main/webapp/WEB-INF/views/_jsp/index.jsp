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
			<c:forEach var="talent" items="${ list }" begin="1" end="12">
				<div id="pic_box">
					<img class="index_image"
						src="${pageContext.request.contextPath }/resources/img/${talent.t_image}">
					<div class="c_title">
						<span class="c_name">${ talent.t_title }</span> <span
							class="c_star">${ talent.t_starscore }</span>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="tp_layers">
		<div class="tp_bottom_layout">
			<%@ include file="bottom.jsp" %>
		</div>
	</div>
</body>
</html>