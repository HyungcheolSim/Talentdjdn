<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다재다능 재능 목록</title>
<!-- common -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/talent/talent_list.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function find() {

		var search = $("#search").val();
		var search_text = $("#search_text").val().trim();

		//전체검색이면 검색창 내용 지워라..
		if (search == 'all') {
			$("#search_text").val("");
			location.href = "talentlist.do";
			return;
		}

		if (search != 'all' && search_text == '') {

			alert('검색어를 입력하세요');
			$("#search_text").val("");//값 지우기
			$("#search_text").focus(); //
			return;
		}
		//자바스크립트 이용 요청
		//encodeURIComponent(search_text,"utf-8")
		// : search_text기 한글 또는 특수문자인 경우 인코딩해서 넘겨야 서버가 제대로 인식한다                                     
		location.href = "talentlist.do?search=" + search + "&search_text="
				+ encodeURIComponent(search_text, "utf-8");
	}
</script>
</head>
<body>
	<div class="talent_list_body_container">
		<div class="talent_list_header_container">
			<div class="header">
					<%@ include file="../top_button.jsp"%>
			</div>	
		</div>
		<div class="talent_list_content_container">
			<div class="talent_list_content_sidebar_container">
				<%@ include file="talent_sidebar.jsp"%>
			</div>
			<div class="tt_cont">
				<div class="table_container">
					<div class="container_bx">
						<c:forEach var="vo" items="${ map.list }">
							<div class="container_pr">
								<div class="p_dt">
									<a href="talentdetail.do?t_idx=${ vo.t_idx }"><img
										class="thumbnail"
										src="../seller/displayFile?fileName=${vo.t_image}&directory=talent"></a>
								</div>
								<div class="h_dt">
									<a href="talentdetail.do?t_idx=${ vo.t_idx }">${ vo.t_title }</a>
								</div>
								<div class="price_dt">
									<span><fmt:formatNumber type="number"
											maxFractionDigits="3" value="${vo.t_price}" />원</span>
								</div>
								<div class="s_dt">
									<span>${ vo.t_starscore }점</span>
								</div>
							</div>
						</c:forEach>
					</div>
					<!-- 검색메뉴 -->
					<div class="select_box" style="text-align: center;">
						<select id="search">
							<option value="all">전체보기</option>
							<option value="name">판매자</option>
							<option value="subject">제목</option>
							<option value="content">내용</option>
							<option value="bfield">카테고리</option>
							<option value="subject_content">제목+내용</option>
						</select> <input id="search_text" value="${ param.search_text }"> <input
							class="btn btn-warning" type="button"
							value="검색" onclick="find();">
						<!-- Page메뉴 넣기 -->
						<div class="pagemenu">
							${ map.pageMenu }
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="talent_detail_footer_container">
			<div class="footer">
				<%@ include file="../bottom.jsp"%>
			</div>
		</div>
	</div>
</body>
</html>