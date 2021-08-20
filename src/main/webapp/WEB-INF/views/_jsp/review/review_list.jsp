<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>





<!-- google fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Gothic+A1&display=swap"
	rel="stylesheet">

<!-- common -->
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/_css/common.css">
<script
	src='${ pageContext.request.contextPath }/resources/_js/common.js'></script>

<!-- this page -->
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/_css/review_list.css">
<script
	src='${ pageContext.request.contextPath }/resources/_js/review_list.js'></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- SweetAlert사용설정 : 알림박스 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script>
	function find() {

		var search = $("#search").val();
		var search_text = $("#search_text").val().trim();

		//전체검색이면 검색창 내용 지워라..
		if (search == 'all') {
			$("#search_text").val("");
			location.href = "list.do";
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
		/* location.href = "list.do?t_idx='${ param.t_idx }'&search=" + search
				+ "&search_text=" + encodeURIComponent(search_text, "utf-8"); */
		$.ajax({
			url  : "../review/list.do",
			data : { 't_idx' : '${ param.t_idx }',
					 'search':search,
					 'search_text':search_text
			},
			success  : function(result_data){
				//수신된 결과 데이터(댓글목록) disp에 출력
				$("#disp").html(result_data);
				
			},
			error    : function(err){
				alert(err.responseText);
			}
		});		
	}
</script>
</head>
<body>
	<h1>리뷰 목록</h1>

	<table class="table1">
		<c:if test="${empty map.reviewlist}">
			<tr>
				<td colspan="4">
					<div>리뷰가 존재하지 않습니다.</div>
				</td>
			</tr>
		</c:if>
		<c:forEach var="vo" items="${map.reviewlist}">
			<tr>
				<td class="review_td"><strong>리뷰 작성자:</strong>
					${vo.member.m_name}</td>
				<td class="review_td"><strong>별점:</strong> <c:forEach var="i"
						begin="1" end="${vo.r_star}">★</c:forEach> <c:forEach var="j"
						begin="${vo.r_star}" end="4">☆</c:forEach> <span>${vo.r_star}</span>점</td>
				<td class="review_td"><strong>리뷰 등록일:</strong> ${vo.r_regdate}</td>
				<td class="review_td"><strong>리뷰:</strong> ${vo.r_content}</td>
			</tr>
		</c:forEach>
	</table>
	<!-- 검색메뉴 -->
	<div style="text-align: center;">

		<select id="search">
			<option value="all">전체보기</option>
			<option value="name">내용</option>
			<option value="star">*점 이상의 별점만 보기</option>
		</select> <input id="search_text" value="${ param.search_text }"> <input
			class="btn btn-warning" style="width: 60px;" type="button" value="검색"
			onclick="find();">

	</div>

	<!-- Page메뉴 넣기 -->
	<div style="text-align: center; font-size: 12pt;">${ map.pageMenu }

	</div>
</body>
</html>