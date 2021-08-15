<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- common -->
<link rel="stylesheet"
   href="${ pageContext.request.contextPath }/resources/css/common.css">

<!-- this page -->
<link rel="stylesheet"
   href="${ pageContext.request.contextPath }/resources/css/index.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- image slider_bxslider -->
<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
   src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<script>

	$(document).ready(function() {
		$('.bxslider').bxSlider({
			auto : true,
			autoHover : true,
			speed : 500,
			pause : 3000,
			randomStart : true,
			minSlides : 4,
			maxSlides : 4,
			caption : false,
			slideWidth : 900,
			slideMargin : 10,
			touchEnabled : (navigator.maxTouchPoints > 0)
		});
	});

</script>

<style>
.bx-wrapper {
   border: 0;
   background: #fbfbfb;
   box-shadow: none;
}
</style>

</head>
<body>

	<div class="back_color">
		<div class="tp_layers">
			<div class="tp_button_layout">
				<%@ include file="top_button.jsp"%>
			</div>
		</div>
	</div>
	<div class="tp_layer">
		<div class="tp_search_layout">
			<%@ include file="top_main.jsp"%>
		</div>
	</div>
	<div class="tp_layer_main">
		<div class="tp_index_layout">


			<div id="text_box">
				<b>재능마켓 인기서비스</b>
			</div>
			<div id="tt">
				<ul class="bxslider">
					<c:forEach var="talent" items="${ map.t_list }">
						
						<li id="pic1">
						<a href="../talent/talentdetail.do?t_idx=${talent.t_idx }">
						<img class="index_image"
							src="../seller/displayFile?fileName=${talent.t_image}&directory=talent"></a>
							<div class="c_title">
								<span class="c_name">${ talent.t_title }</span> 
								<span class="c_star">${ talent.t_starscore }</span>
							</div></li>
						
					</c:forEach>
				</ul>
			</div>

			<div id="text_box">
				<b>재능마켓 인기상품</b>
			</div>
			<div>
				<ul class="bxslider">
					<c:forEach var="product" items="${ map.p_list }">
					
						<li id="pic1"><img class="index_image"
							src="../seller/displayFile?fileName=${product.t_image}&directory=talent">
							<div class="c_title">
								<span class="c_name">${ product.t_title }</span> <span
									class="c_star">${ product.t_starscore }</span>
							</div></li>

					</c:forEach>
				</ul>
			</div>

			<div id="text_box">
				<b>재능마켓 인기고수</b>
			</div>
			<div>
				<ul class="bxslider">
					<c:forEach var="seller" items="${ map.s_list }">

						<li id="pic1"><img class="index_image"
							src="displayFile?fileName=${seller.s_potfolio}&directory=seller">
							<div class="c_title">
								<span class="c_name">${ seller.s_id }</span> <span
									class="c_star">${ seller.s_tcount }</span>
							</div></li>

					</c:forEach>
				</ul>
			</div>

		</div>
	</div>
	<div class="tp_layers">
		<div class="tp_bottom_layout">
			<%@ include file="bottom.jsp"%>
		</div>
	</div>

</body>
</html>