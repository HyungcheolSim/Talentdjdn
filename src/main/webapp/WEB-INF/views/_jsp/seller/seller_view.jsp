<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- common -->
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/common.css">

<!-- this page (경로 수정필요)-->
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/seller_view.css">

<script type="text/javascript">
	function modify_form(s_idx) {
		sessionStorage.setItem("s_idx", s_idx);
		location.href = "modify_form.do?s_idx="
				+ s_idx
				+ "&page=${ param.page }&search=${ param.search }&search_text=${ param.search_text }";

	}//end-modify_form
	function goTalentInsert(s_idx) {
		
		location.href = "../talent/inserttalent.do?s_idx="+s_idx;
	}
</script>


</head>
<body>
	<div class="back_color">
		<div class="tp_layers">
			<div class="tp_button_layout">
				<%@ include file="seller_top_button.jsp"%>
			</div>
		</div>
	</div>
	<div id="instrest_box">
		<div id="interest_img">
			<div id="select_menu_box"></div>
			<div id="select_menu_box1">
				<table id="select_sub_box" class="table">
					<tr class="select_sub_box_tr">
						<td rowspan='4' class="sub_text"><img class="select_p_img"
							alt=""
							src="displayFile?fileName=${vo.s_potfolio}&directory=seller"></td>
						<td class="sub_text1"><b>${ vo.s_id }</b>님 이력</b></td>
						<c:if
							test="${ vo.member.m_idx eq user.m_idx}">
							<td class="sub_text2"><input id="select_btn"
								class="btn btn-warning" type="button" value="정보수정"
								onclick="modify_form('${ vo.s_idx }');">
								<button type="button" class="btn btn-warning"
									onclick="javascript:goTalentInsert('${ vo.s_idx }');">등록하러가기</button>
							</td>
						</c:if>
					</tr>
				</table>
				<div id="click_box">
					<div class="loc_cate1">
						<b>소개</b>
					</div>
					<div class="loc_cate_null">${ vo.s_msg }</div>
					<input type="button" id="seller_menu" class="btn btn-warning"
						value="목록보기" onclick="location.href='list.do'">

				</div>
				<div id="select_box"></div>

				<div class="empty_box">
					<table class="detail_t">
						<tr>
							<td class="detail1">분 야 : ${ vo.s_field }</td>
							<td class="detail">경 력 : ${ vo.s_career }</td>
							<td class="detail">학 력 : ${ vo.s_education }</td>
							<td class="detail">자격증 : ${ vo.s_license }</td>
							<td class="detail">기 술 : ${ vo.s_skill }</td>
							<td class="detail">지 역 : ${ vo.s_local }</td>
							<td class="detail">이 메 일 : ${ vo.member.m_email }</td>
							<td class="detail">포트폴리오 :</br>
							</br> <img
								src="displayFile?fileName=${vo.s_potfolio}&directory=seller"
								width="500">
							</td>
						</tr>
					</table>
					<div class="button_box"></div>
				</div>
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