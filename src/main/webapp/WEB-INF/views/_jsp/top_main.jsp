<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헤더 메뉴 선택부분</title>
<!-- this page -->
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/top_main.css">

</head>
<script type="text/javascript">
	//엔터키를 입력하면 작동하는 함수(find()함수를 실행시킨다.)
	function enterkey() {
		if (window.event.keyCode == 13) {
			find();
		}
	}
	function find() { //검색기능을 하는 함수
		var search_text = $("#search_text").val().trim();
		if (search_text == '') {
			alert('검색어를 입력하세요');
			$("#search_text").val("");//값 지우기
			$("#search_text").focus(); //
			return;
		}
		location.href = "../talent/talentlist.do?search=subject"
				+ "&search_text=" + encodeURIComponent(search_text, "utf-8");
	}
</script>

<body>
	<div id="slide_img">
		<div id="top_main_font">
			<h1 class="main_f">힘들때 언제나 가까운곳에!</h1>
		</div>
		<div id="top_main_left">
			<div id="top_main_left_box">
				<div id='select_bar'>
					<input id="search_text" placeholder="재능을 검색해보세요!"
						onkeyup="enterkey();" />
				</div>
			</div>
			<div id="icon_selecter">
				<div class="icon_box">
					<a href="../talent/talentlist.do?search=bfield&search_text=디자인"><img
						class="main_icon" alt=""
						src="${ pageContext.request.contextPath }/resources/img/designs.png"></a>
					<p id="font">디자인</p>
				</div>

				<div class="icon_box">
					<a
						href="../talent/talentlist.do?search=bfield&search_text=IT·프로그래밍"><img
						class="main_icon" alt=""
						src="${ pageContext.request.contextPath }/resources/img/programming.png"></a>
					<p id="font">ITㆍ프로그래밍</p>
				</div>

				<div class="icon_box">
					<a
						href="../talent/talentlist.do?search=bfield&search_text=영상·사진·음향"><img
						class="main_icon" alt=""
						src="${ pageContext.request.contextPath }/resources/img/picture.png"></a>
					<p id="font">영상·사진·음향</p>
				</div>

				<div class="icon_box">
					<a href="../talent/talentlist.do?search=bfield&search_text=마케팅"><img
						class="main_icon" alt=""
						src="${ pageContext.request.contextPath }/resources/img/marketing.png"></a>
					<p id="font">마케팅</p>
				</div>

				<div class="icon_box">
					<a href="../talent/talentlist.do?search=bfield&search_text=번역·통역"><img
						class="main_icon" alt=""
						src="${ pageContext.request.contextPath }/resources/img/transfer.png"></a>
					<p id="font">번역·통역</p>
				</div>

				<div class="icon_box">
					<a href="../talent/talentlist.do?search=bfield&search_text=레슨·실무교육"><img
						class="main_icon" alt=""
						src="${ pageContext.request.contextPath }/resources/img/lesson.png"></a>
					<p id="font">레슨·실무교육</p>
				</div>

				<div class="icon_box">
					<a href="../talent/talentlist.do?search=bfield&search_text=상품"><img
						class="main_icon" alt=""
						src="${ pageContext.request.contextPath }/resources/img/object.png"></a>
					<p id="font">상품</p>
				</div>
			</div>
		</div>
	</div>

</body>

</body>
</html>