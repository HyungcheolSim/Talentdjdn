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
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/top_main.css">

</head>

<body>
	<div id ="slide_img">
	<div id = "top_main_font">
		<h1 class = "main_f"> 힘들때 언제나 가까운곳에! 
		</h1>
	</div>
	<div id="top_main_left">
		<div id="top_main_left_box">
			<div id='select_bar'>
				<select><option value='' selected>서비스 지역을 선택하세요</option>
					<option>서울</option></select>
			</div>
		</div>
		<div id = "icon_selecter">
			<div class="icon_box">
				<a href=""><img class="main_icon" alt="" src="${ pageContext.request.contextPath }/resources/img/designs.png"></a>
				<p id="font">디자인</p>
			</div>

			<div class="icon_box">
				<a href=""><img class="main_icon" alt="" src="${ pageContext.request.contextPath }/resources/img/programming.png"></a>
				<p id="font">ITㆍ프로그래밍</p>
			</div>

			<div class="icon_box">
				<a href=""><img class="main_icon" alt=""
					src="${ pageContext.request.contextPath }/resources/img/picture.png"></a>
				<p id="font">영상ㆍ사진ㆍ음향</p>
			</div>

			<div class="icon_box">
				<a href=""><img class="main_icon" alt="" src="${ pageContext.request.contextPath }/resources/img/marketing.png"></a>
				<p id="font">마케팅</p>
			</div>

			<div class="icon_box">
				<a href=""><img class="main_icon" alt="" src="${ pageContext.request.contextPath }/resources/img/transfer.png"></a>
				<p id="font">번역ㆍ통역</p>
			</div>

			<div class="icon_box">
				<a href=""><img class="main_icon" alt="" src="${ pageContext.request.contextPath }/resources/img/lesson.png"></a>
				<p id="font">레슨ㆍ실무교육</p>
			</div>

			<div class="icon_box">
				<a href=""><img class="main_icon" alt=""src="${ pageContext.request.contextPath }/resources/img/object.png"></a>
				<p id="font">상품</p>
			</div>
		</div>
	</div>
	</div>
	
	</body>

</body>
</html>