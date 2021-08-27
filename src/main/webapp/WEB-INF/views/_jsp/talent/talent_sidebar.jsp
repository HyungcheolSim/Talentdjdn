<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Talent Sidebar</title>

<!-- common -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/common.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/talent/talent_sidebar.css">

</head>
<body>
<div class="sidebar_body_container">
	<div class="sidebar_header_container">
		<div class="sidebar_header_title_container">
		
			<h1 id="sidebar_header_title">
			   <a href="../talent/talentlist.do">재능목록</a>
			</h1>
		
		</div>
	</div>
	<div class="sidebar_content_container">
		<div class="sidebar_content">
			<div class="sidebar_content_title_container">	
				<h2 class="sidebar_content_title"><a href="../talent/talentlist.do?search=bfield&search_text=IT·프로그래밍">IT·프로그래밍</a></h2>
			</div>
		</div>
		<div class="sidebar_content">
			<div class="sidebar_content_title_container">	
				<h2 class="sidebar_content_title"><a href="../talent/talentlist.do?search=bfield&search_text=디자인">디자인</a></h2>
			</div>
		</div>
		<div class="sidebar_content">
			<div class="sidebar_content_title_container">	
				<h2 class="sidebar_content_title"><a href="../talent/talentlist.do?search=bfield&search_text=영상·사진·음향">영상·사진·음향</a></h2>
			</div>
		</div>
		<div class="sidebar_content">
			<div class="sidebar_content_title_container">	
				<h2 class="sidebar_content_title"><a href="../talent/talentlist.do?search=bfield&search_text=마케팅">마케팅</a></h2>
			</div>
		</div>
		<div class="sidebar_content">
			<div class="sidebar_content_title_container">	
				<h2 class="sidebar_content_title"><a href="../talent/talentlist.do?search=bfield&search_text=번역·통역">번역·통역</a></h2>
			</div>
		</div>
		<div class="sidebar_content">
			<div class="sidebar_content_title_container">	
				<h2 class="sidebar_content_title"><a href="../talent/talentlist.do?search=bfield&search_text=레슨·실무교육">레슨·실무교육</a></h2>
			</div>
		</div>		
		<div class="sidebar_content">
			<div class="sidebar_content_title_container">	
				<h2 class="sidebar_content_title"><a href="../talent/talentlist.do?search=bfield&search_text=상품">상품</a></h2>
			</div>
		</div>	
	</div>
</div>

</body>
</html>