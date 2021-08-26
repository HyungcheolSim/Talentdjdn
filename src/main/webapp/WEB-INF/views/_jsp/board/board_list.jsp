<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css">
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

	function insert_form() {

		location.href = 'insert_form.do';
	}
	
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
</script>
</head>
<body>
	<div class="tp_layers">
		<div class="tp_button_layout">
			<%@ include file="../top_button.jsp"%>
		</div>
	</div>
	<div class="tp_layer">
		<div class="tp_main_layout">
			<div id="main_box">
				<div><h2>게시판</h2></div>
				<table class="table">
					<!-- 제목 -->
					<tr class="warning">
						<th>번호</th>
						<th width="50%">제목</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>조회수</th>
					</tr>
					<!-- Data없는 경우 -->
					<c:if test="${ empty map.list }">
						<tr>
							<td colspan="5">
								<div id="empty_message">게시물이 존재하지 않습니다.</div>
							</td>
						</tr>
					</c:if>
					<!-- Data있는 경우 -->
					<c:forEach var="vo" items="${ map.list }">
						<tr>
							<td>${ vo.b_idx }</td>
							<td><a href="view.do?b_idx=${ vo.b_idx }">${ vo.b_title }</a></td>
							<td>${ vo.member.m_name }</td>
							<td>${ vo.b_regdate }</td>
							<td>${ vo.b_readhit }</td>
						</tr>
					</c:forEach>
				</table>
				<!-- 새글쓰기 -->
				<div>
					<c:if test="${ user.m_grade eq '관리자' }">
						<input class="btn btn-warning" type="button" value="글쓰기"
							onclick="insert_form();">
					</c:if>	
				</div>
			</div>
		<!-- 검색메뉴 -->
		<div style="text-align: center;">		
			<select id="search">
				<option value="all">전체보기</option>
				<option value="name">이름</option>
				<option value="subject">제목</option>
				<option value="content">내용</option>
				<option value="subject_content">제목+내용</option>
			</select>
			<input id="search_text" value="${ param.search_text }">
			<input class="btn btn-warning" style="width:60px;" type="button" value="검색" onclick="find();"> 		
		</div>
		<!-- Page메뉴 넣기 -->
		<div style="text-align: center; font-size: 12pt;">	
			${ map.pageMenu }
		</div>
		</div>
	</div>
	<div class="tp_layers">
		<div class="tp_bottom_layout">
			<%@ include file="../bottom.jsp"%>
		</div>
	</div>
</body>
</html>