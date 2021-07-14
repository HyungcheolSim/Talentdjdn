<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Talent Sidebar</title>

<!-- common -->
<link rel="stylesheet" href="../../css/common.css">
<link rel="stylesheet" href="../../css/talent/talent_sidebar.css">

</head>
<body>



<div class="sidebar_body_container">
	<div class="sidebar_header_container">
		<div class="sidebar_header_title_container">
			<h1 id="sidebar_header_title">IT·프로그래밍</h1><!-- 동적으로 바뀔 수 있게 해야함 -->
		</div>
	</div>
	<div class="sidebar_content_container">
		<div class="sidebar_content">
			<div class="sidebar_content_title_container">	
				<h2 class="sidebar_content_title">기획</h2>
			</div>
		</div>
		<div class="sidebar_content">
			<div class="sidebar_content_title_container">	
				<h2 class="sidebar_content_title">워드프레스</h2>
			</div>
			<button class="sidebar_content_dropbtn" onclick="showBtn()">
 				<span class="sidebar_content_btn_img_container">
					<svg class="sidebar_content_btn_img" viewBox="0 0 24 24">
						<path xmlns="http://www.w3.org/2000/svg" d="M7.41 8.59L12 13.17l4.59-4.58L18 10l-6 6-6-6 1.41-1.41z"></path>
						
					</svg> 
				</span>
			</button>
		</div>
		<!-- 버튼 클릭 시 visibility 변경 -->
		<div class="sidebar_hidden_content">
			<a href="#" class="hidden_content_a">전체</a>
			<a href="#" class="hidden_content_a">웹사이트 제작</a>
			<a href="#" class="hidden_content_a">웹사이트 개선·버그 수정</a>
			<a href="#" class="hidden_content_a">설치·설정</a>
 			<a href="#" class="hidden_content_a">복제·마이그레이션</a>
		</div>
		<div class="sidebar_content">
			<div class="sidebar_content_title_container">	
				<h2 class="sidebar_content_title">웹사이트 개발</h2>
			</div>
			<button class="sidebar_content_dropbtn" onclick="showBtn()">
				<span class="sidebar_content_btn_img_container">
					<svg class="sidebar_content_btn_img" viewBox="0 0 24 24">
						<path xmlns="http://www.w3.org/2000/svg" d="M7.41 8.59L12 13.17l4.59-4.58L18 10l-6 6-6-6 1.41-1.41z"></path>
					</svg>
				</span>
			</button>
		</div>
		<!-- 버튼 클릭 시 visibility 변경 -->
		<div class="sidebar_hidden_content">
			<a href="#" class="hidden_content_a">전체</a>
			<a href="#" class="hidden_content_a">웹사이트 제작</a>
			<a href="#" class="hidden_content_a">웹사이트 제작(CMS)</a>
			<a href="#" class="hidden_content_a">웹사이트 개선·버그수정</a>
 			<a href="#" class="hidden_content_a">HTML·CSS 퍼블리싱</a>
 			<a href="#" class="hidden_content_a">랜딩페이지</a>
 			<a href="#" class="hidden_content_a">겁색최적화·SEO</a>
 			<a href="#" class="hidden_content_a">애널리틱스</a>
		</div>
		<div class="sidebar_content">
			<div class="sidebar_content_title_container">	
				<h2 class="sidebar_content_title">쇼핑몰·커머스</h2>
			</div>
			<button class="sidebar_content_dropbtn" onclick="showBtn()">
				<span class="sidebar_content_btn_img_container">
					<svg class="sidebar_content_btn_img" viewBox="0 0 24 24">
						<path xmlns="http://www.w3.org/2000/svg" d="M7.41 8.59L12 13.17l4.59-4.58L18 10l-6 6-6-6 1.41-1.41z"></path>
					</svg>
				</span>
			</button>
		</div>
		<!-- 버튼 클릭 시 visibility 변경 -->
		<div class="sidebar_hidden_content">
			<a href="#" class="hidden_content_a">전체</a>
			<a href="#" class="hidden_content_a">웹사이트 제작</a>
			<a href="#" class="hidden_content_a">웹사이트 제작(CMS)</a>
			<a href="#" class="hidden_content_a">웹사이트 개선·버그수정</a>
		</div>
		<div class="sidebar_content">
			<div class="sidebar_content_title_container">	
				<h2 class="sidebar_content_title">모바일 앱</h2>
			</div>
			<button class="sidebar_content_dropbtn" onclick="showBtn()">
				<span class="sidebar_content_btn_img_container">
					<svg class="sidebar_content_btn_img" viewBox="0 0 24 24">
						<path xmlns="http://www.w3.org/2000/svg" d="M7.41 8.59L12 13.17l4.59-4.58L18 10l-6 6-6-6 1.41-1.41z"></path>
					</svg>
				</span>
			</button>
		</div>
		<!-- 버튼 클릭 시 visibility 변경 -->
		<div class="sidebar_hidden_content">
			<a href="#" class="hidden_content_a">전체</a>
			<a href="#" class="hidden_content_a">네이티브앱</a>
			<a href="#" class="hidden_content_a">하이브리드앱·웹앱</a>
			<a href="#" class="hidden_content_a">앱 개선·버그수정</a>
		</div>
		<div class="sidebar_content">
			<div class="sidebar_content_title_container">	
				<h2 class="sidebar_content_title">프로그램 개발</h2>
			</div>
			<button class="sidebar_content_dropbtn" onclick="showBtn()">
				<span class="sidebar_content_btn_img_container">
					<svg class="sidebar_content_btn_img" viewBox="0 0 24 24">
						<path xmlns="http://www.w3.org/2000/svg" d="M7.41 8.59L12 13.17l4.59-4.58L18 10l-6 6-6-6 1.41-1.41z"></path>
					</svg>
				</span>
			</button>
		</div>
		<!-- 버튼 클릭 시 visibility 변경 -->
		<div class="sidebar_hidden_content">
			<a href="#" class="hidden_content_a">전체</a>
			<a href="#" class="hidden_content_a">일반 프로그램</a>
			<a href="#" class="hidden_content_a">VBA·매크로</a>
			<a href="#" class="hidden_content_a">프로그램 개선·버그수정</a>
 			<a href="#" class="hidden_content_a">기타</a>
		</div>
		<div class="sidebar_content">
			<div class="sidebar_content_title_container">	
				<h2 class="sidebar_content_title">임베디드 HW·SW</h2>
			</div>
		</div>
		
		
		<div class="sidebar_content">
			<div class="sidebar_content_title_container">	
				<h2 class="sidebar_content_title">게임</h2>
			</div>
			<button class="sidebar_content_dropbtn" onclick="showBtn()">
				<span class="sidebar_content_btn_img_container">
					<svg class="sidebar_content_btn_img" viewBox="0 0 24 24">
						<path xmlns="http://www.w3.org/2000/svg" d="M7.41 8.59L12 13.17l4.59-4.58L18 10l-6 6-6-6 1.41-1.41z"></path>
					</svg>
				</span>
			</button>
		</div>
		<!-- 버튼 클릭 시 visibility 변경 -->
		<div class="sidebar_hidden_content">
			<a href="#" class="hidden_content_a">전체</a>
			<a href="#" class="hidden_content_a">2D·3D</a>
			<a href="#" class="hidden_content_a">AR·VR</a>
 			<a href="#" class="hidden_content_a">기타</a>
		</div>
		<div class="sidebar_content">
			<div class="sidebar_content_title_container">	
				<h2 class="sidebar_content_title">데이터베이스</h2>
			</div>
			
		</div>
		
		
		<div class="sidebar_content">
			<div class="sidebar_content_title_container">	
				<h2 class="sidebar_content_title">데이터분석·리포트</h2>
			</div>
			<button class="sidebar_content_dropbtn" onclick="showBtn()">
				<span class="sidebar_content_btn_img_container">
					<svg class="sidebar_content_btn_img" viewBox="0 0 24 24">
						<path xmlns="http://www.w3.org/2000/svg" d="M7.41 8.59L12 13.17l4.59-4.58L18 10l-6 6-6-6 1.41-1.41z"></path>
					</svg>
				</span>
			</button>
		</div>
		<!-- 버튼 클릭 시 visibility 변경 -->
		<div class="sidebar_hidden_content">
			<a href="#" class="hidden_content_a">전체</a>
			<a href="#" class="hidden_content_a">데이터 분석</a>
			<a href="#" class="hidden_content_a">인공지능·머신러닝</a>
			<a href="#" class="hidden_content_a">데이터 시각화</a>
 			<a href="#" class="hidden_content_a">데이터 입력·클리닝</a>
 			<a href="#" class="hidden_content_a">데이터 마이닝·크롤링</a>
		</div>
		
		
	</div>
</div>

<script>
//맨위에거만 열렸다 닫힘ㅋㅋ
function showBtn(){
	/* var x=document.getElementByClassName("sidebar_hidden_content")[0]; */
	var x=document.querySelector(".sidebar_hidden_content");
	if(x.style.display=="none"){
		x.style.display="flex";
		
	} else { 
		x.style.display="none";
	}
}

</script>
</body>
</html>