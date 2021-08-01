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

<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- common -->
<link rel="stylesheet" href="../_css/common.css">
<script src='../_js/common.js'></script>

<!-- this page -->
<link rel="stylesheet" href="../_css/index.css">
<script src='../_js/index.js'></script>

<!-- this page-->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/seller_list.css"> 

<!-- SweetAlert사용설정 : 알림박스 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script type="text/javascript">

	//jQuery 초기화
	$(document).ready(function(){
		
		if('${ not empty param.search }'=='true'){
			$("#search").val('${param.search}');
			
			//전체보기면 검색어 지워라...
			if("${param.search eq 'all'}"=="true"){
				$("#search_text").val("");	
			}
		}
		
	});
	
	//고수등록 폼띄우기
	function insert_form() {
		
		//로그인여부 체크
		if('${ empty user }'=='true'){
			
			
			Swal.fire({
				  title: '고수등록',
				  html: "고수등록은 로그인후 이용가능합니다<br>로그인 하시겠습니까?",
				  icon: 'warning',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: '예',
				  cancelButtonText : "아니오"
				}).then((result) => {
				  if (result.isConfirmed) {
					//현재경로 : /photo/list.do
						location.href='${ pageContext.request.contextPath }/member/login_form.do?url=' + location.href;
				  }
				});
			
		}else{
			
			//로그인된 상태면...
			//글쓰기 폼으로 이동
			location.href = 'insert_form.do'; //PhotoInsertFormAction
			
		}

	}//end-insert_form
	
	function find() {
		
		var search      = $("#search").val();
		var search_text = $("#search_text").val().trim();
		
		//전체검색이면 검색창 내용 지워라..
		if(search=='all'){
			$("#search_text").val("");
			 location.href = "list.do"; 
			return;
		}
		
		if(search!='all' && search_text==''){
			
			alert('검색어를 입력하세요');
			$("#search_text").val("");//값 지우기
			$("#search_text").focus(); //
			return;
		}
		
		//자바스크립트 이용 요청
		//encodeURIComponent(search_text,"utf-8")
		// : search_text기 한글 또는 특수문자인 경우 인코딩해서 넘겨야 서버가 제대로 인식한다                                     
		location.href = "list.do?search=" + search + "&search_text=" + encodeURIComponent(search_text,"utf-8") ; 

	}//end-find

	
	function del_seller(s_idx) {
					
			Swal.fire({
				  title: '고수삭제',
				  html: "정말 삭제하시겠습니까?",
				  icon: 'warning',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: '예',
				  cancelButtonText : "아니오"
				}).then((result) => {
				  if (result.isConfirmed) {

					  location.href="delete.do?s_idx=" + s_idx;
				  }
				});
		
	}
	


</script>

</head>
<body>
	<div class="back_color">
	<div class="tp_layers">
		<div class="tp_button_layout">
			<%@ include file="seller_top_button.jsp" %>
		</div>
	</div>
	</div>
	<div id= "instrest_box">	
		<div id ="interest_img">			
			<div id="select_menu_box">
			</div>
			<div id="select_menu_box">
				<div class="select_main"><span><b>고수찾기</b></span></div>
				<div class="select_main2"><span class="s_main2">홈>고수찾기><b>지역,카테고리</b></span></div>
			</div>
			<div id="click_box">
				<select class="loc_cate">
					<option value="none">위치</option>
					<option>서울</option>
					<option>경기도</option>
					<option>인천</option>
					<option>대전</option>
					<option>대구</option>
					<option>부산</option>
				</select>
				<select class="loc_cate">
					<option value="none">카테고리</option>
					<option>웹</option>
					<option>디자인</option>
					<option>JAVA</option>
					<option>HTML</option>
				</select>
			</div>
			<div id="click_box">
				<div class="loc_cate1"><b>${ vo.s_count }명의 고수</b></div>
				<div class="loc_cate_null"></div>
				<select class="loc_cate2">
					<option>리뷰순</option>
					<option>별점순</option>
					<option>최신순</option>
					<option>가격순</option>
				</select>
			</div>
			<c:forEach var="vo" items="${ list }">	
				<div id="select_box">
				<a href="view.do?s_idx=${ vo.s_idx }&page=${ (empty param.page) ? 1 :  param.page }&search=${ (empty param.search) ? 'all' : param.search }&search_text=${ param.search_text }">
					<table id = "select_sub_box">
						<tr class="select_sub_box_tr">
							<td rowspan='5' class="sub_text"><img class="select_p_img" alt="" src="${ pageContext.request.contextPath }/resources/img/${ vo.s_potfolio }"></td>
							<td class="sub_text1">${ vo.s_id }</td>
							<td class="sub_text1">${ vo.s_msg }</td>
							<td class="sub_text1">${ vo.s_field }</td>
							<td class="sub_text1">${ vo.s_local }</td>
						</tr>
					</table>
				</a>
					<c:if test="${ (vo.m_idx eq user.m_idx) or (user.m_grade eq '관리자') }">
					<input type="button" id="delete_btn" class="btn btn-warning" value="삭제" 
					 	   onclick="del_seller('${ vo.s_idx }');">
					</c:if> 
				</div>
			</c:forEach>
			
			<div class ="gosu">
				<input id="gosu_btn" class="btn btn-warning" type="button" value="고수등록"
					onclick="insert_form();">
			</div>
			
		<!-- 검색메뉴 -->
		<div style="text-align: center;">
		
			<select id="search">
				<option value="all">전체보기</option>
				<option value="s_id">아이디</option>
				<option value="s_field">분야</option>
			</select>
			<input id="search_text" value="${ param.search_text }">
			<input class="btn btn-warning" style="width:60px;" type="button" value="검색" onclick="find();"> 
		
		</div>

		<!-- Page메뉴 넣기 -->
		<div style="text-align: center; font-size: 12pt;">
		
			${ pageMenu }

		</div>
			
			
		</div>
	</div>
	<div class="tp_layers">
		<div class="tp_bottom_layout">
			<%@ include file="../bottom.jsp" %>
		</div>
	</div>
</body>
</html>