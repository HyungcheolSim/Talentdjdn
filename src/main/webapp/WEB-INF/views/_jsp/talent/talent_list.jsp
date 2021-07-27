<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Talent List</title>
<!-- common -->

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/common.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/talent/talent_sidebar.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/talent/talent_list.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
#main_box {
	width: 1000px;
	margin: auto;
	margin-top: 20px;
}

#title {
	text-align: center;
	font-size: 26pt;
	font-weight: bold;
	color: gray;
	text-shadow: 1px 1px 1px black;
}

input[type='button'] {
	width: 100px;
}

th, td {
	text-align: center;
}

#empty_message {
	text-align: center;
	color: red;
	font-size: 16pt;
	font-weight: bold;
	margin-top: 50px;
}
</style>
<script type="text/javascript">
	function goTalentInsert() {
		location.href = "inserttalent.do";
	}
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
		location.href = "talentlist.do?search=" + search + "&search_text="
				+ encodeURIComponent(search_text, "utf-8");
	}
</script>
</head>
<body>

	<div class="talent_list_body_container">
		<div class="tp_layers">
			<div class="tp_button_layout">
				<%@ include file="../top_button.jsp"%>
			</div>
		</div>
		<div class="talent_list_content_container">
			<div class="talent_list_content_sidebar_container">
				<%@ include file="talent_sidebar.jsp"%>
			</div>
			<div class="table_container">
				<table class="table">
					<thead>
						<tr class="warning">
							<th>썸네일</th>
							<th>글번호</th>
							<th width="50%">제목</th>
							<th>가격</th>
							<th>작성자</th>
							<th>카테고리</th>
						</tr>
					</thead>
					<tbody id="tbody">
						<c:if test="${ empty list }">
							<tr>
								<td colspan="5">
									<div id="empty_message">재능이 존재하지 않습니다.</div>
								</td>
							</tr>
						</c:if>

						<!-- Data있는 경우 -->
						<!-- for(TalentVo vo : list) -->
						<c:forEach var="vo" items="${ list }">
							<tr>
								<td>${ vo.t_small_image }</td>
								<td>${ vo.t_id }</td>
								<td><a href="talentdetail.do?t_id=${ vo.t_id }">${ vo.t_title }</a></td>
								<td>${ vo.t_price }</td>
								<td>${ vo.s_id }</td>
								<td>${ vo.t_cat }</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
				<button type="button" class="btn btn-warning"
					onclick="javascript:goTalentInsert();">등록하러가기</button>
				<!-- 검색메뉴 -->
				<div style="text-align: center;">

					<select id="search">
						<option value="all">전체보기</option>
						<option value="name">판매자</option>
						<option value="subject">제목</option>
						<option value="content">내용</option>
						<option value="subject_content">제목+내용</option>
					</select> <input id="search_text" value="${ param.search_text }"> <input
						class="btn btn-warning" style="width: 60px;" type="button"
						value="검색" onclick="find();">

				</div>

				<!-- Page메뉴 넣기 -->
				<div style="text-align: center; font-size: 12pt;">${ pageMenu }

				</div>
			</div>
		</div>
		<div class="tp_layers">
			<div class="tp_bottom_layout">
				<%@ include file="../bottom.jsp"%>
			</div>
		</div>

	</div>
</body>
</html>