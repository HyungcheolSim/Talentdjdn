<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- common -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/common.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/talent/talent_sidebar.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/talent/talent_detail.css">
<script type="text/javascript">
$(document).ready(function() {
	/* getOneTalentCon(); */
});
/* 
function getOneTalentCon() {

	$.ajax({
		type : "GET",
		url : "onetalent",
		dataType : "JSON",
		success : function(obj) {
			getTalentListCallback(obj);
		},
		error : function(xhr, status, error) {
		}
	});
}

function getOneTalentCallback(obj) {

	var list = obj;
	var listLen = obj.length;

	console.log(list);
	console.log(listLen);
	if (listLen > 0) {

		for (var a = 0; a < listLen; a++) {

			var talentId = list[a].t_id;
			var talentTitle = list[a].t_title;
			var talentContent = list[a].t_content;
			var talentBigField = list[a].t_big_field;
			var talentSmallField = list[a].t_small_field;
			var talentPrice = list[a].t_price;
			var talentLocal = list[a].t_local;
			var talentCategory = list[a].t_cat;
			var talentBigImage = list[a].t_big_image;
			var talentSmallImage = list[a].t_small_image;
			var talentSellerId = list[a].s_id;
		}

	}
} */
function send(f) {
    
    var r_title  = f.r_title.value.trim();
    var r_content= f.r_content.value.trim();
    var r_star= f.r_star.value.trim();
    
    if(r_title==''){
       alert('제목를 입력하세요!!');
       f.r_title.value='';
       f.r_title.focus();
       return;
    }
    
    if(r_content==''){
       alert('비밀번호를 입력하세요!!');
       f.r_content.value='';
       f.r_content.focus();
       return;
    }
    
    f.action="reviewinsert"; //review insert
    f.submit(); //전송
    
 }
</script>

</head>
<body>
	<div class="talent_detail_body_container">
		<div class="talent_detail_header_container">
			<div class="tp_layers">
				<div class="tp_button_layout">
					<%@ include file="../top_button.jsp"%>
				</div>
			</div>
		</div>
		<div class="talent_detail_content_container">
			<div class="talent_detail_content_sidebar_container">
				<%@ include file="talent_sidebar.jsp"%>
			</div>
			<div class="talent_detail_content">
				<div class="talent_detail_title_container">
					<h2 id="talent_detail_title">"(t_title)평점 5점 압도적인리뷰" 모던, 감각적인
						로고 제작해드립니다.</h2>
				</div>
				<div class="talent_detail_price_purchasebtn_container">
					<div class="talent_detail_price_container">
						<h2 class="price_h2">(t_price)가격 1,000,000원</h2>
					</div>
					<div class="talent_detail_purchasebtn_container">
						<button class="purchasebtn">구매하기</button>
					</div>
				</div>
				<div class="talent_detail_infomation">
					<p>(t_content)</p>
					<p>(t_local)</p>
					<p>(t_cat)</p>
					<p>(s_id)</p>
				</div>
				<div class="talent_detail_review_list_container">
					<table class="review_list_table" width="100%" border="1"
						cellspacing="0" cellpadding="0">
						<tr>
							<th class="detail_review_header_w" scope="col">리뷰 제목</th>
							<th class="detail_review_header" scope="col">내용</th>
							<th class="detail_review_header_s" scope="col">별점</th>
							<th class="detail_review_header_r" scope="col">리뷰 등록일</th>
							<th class="detail_review_header_w" scope="col">리뷰 작성자</th>
						</tr>
						<c:if test="${empty list}">
							<tr>
								<td colspan="4">
									<div>리뷰가 존재하지 않습니다.</div>
								</td>
							</tr>
						</c:if>
						<c:forEach var="vo" items="${list}">
							<tr>
								<td class="review_td">{vo.r_title}</td>
								<td class="review_td">{vo.r_content}</td>
								<td class="review_td">{vo.r_star}</td>
								<td class="review_td">{vo.r_regdate}</td>
								<td class="review_td">{vo.m_id}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="talent_detail_review_register_container">
					<div class="form_container">
						<form>
							<table>
								<tr>
									<th>제목</th>
									<td><input name="r_title" id="r_title"></td>
								</tr>
								<tr>
									<th>내용</th>
									<td><input name="r_content" id="r_content"></td>
								</tr>
								<tr>
									<th>별점</th>
									<td><select name="r_star" id="r_star">
											<option value="">선택</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
									</select></td>
								</tr>
								<tr>
									<td><input type="button" value="리뷰작성"
										onclick="send(this.form);"></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="talent_detail_footer_container">
			<div class="tp_layers">
				<div class="tp_bottom_layout">
					<%@ include file="../bottom.jsp"%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>