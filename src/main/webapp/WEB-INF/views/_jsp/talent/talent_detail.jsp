<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- common -->
<link rel="stylesheet" href="../../css/common.css">
<link rel="stylesheet" href="../../css/talent/talent_sidebar.css">
<link rel="stylesheet" href="../../css/talent/talent_detail.css">
</head>
<body>
	<div class="talent_detail_body_container">
		<div class="talent_detail_header_container">
		</div>
		<div class="talent_detail_content_container">
			<div class="talent_detail_content_sidebar_container">
				<%@ include file="talent_sidebar.jsp" %>
			</div>
			<div class="talent_detail_content">
				<div class="talent_detail_title_container">
					<h2 id="talent_detail_title">"평점 5점 압도적인리뷰" 모던, 감각적인 로고 제작해드립니다.</h2>
				</div>
				<div class="talent_detail_price_purchasebtn_container">
					<div class="talent_detail_price_container">
						<h2 class="price_h2">가격  1,000,000원</h2>
					</div>
					<div class="talent_detail_purchasebtn_container">
						<button class="purchasebtn">구매하기</button>
					</div>
				</div>
				<div class="talent_detail_infomation">
					<p>재능에 대한 설명 쫘라락</p>
				</div>
				<div class="talent_detail_review_list_container">
					<table class="review_list_table" width="100%" border="1" cellspacing="0"
					cellpadding="0">
						<tr>
							<th class="detail_review_header" scope="col">리뷰 제목</th>
							<th class="detail_review_header_w" scope="col">리뷰 작성자</th>
							<th class="detail_review_header_s" scope="col">별점</th>
							<th class="detail_review_header_r" scope="col">리뷰 등록일</th>
							
						</tr>
						<tr>
							<td>이거 다 자동으로 들어가게 수정해야됨</td>
							<td class="review_td">심형철씨</td>
							<td class="review_td">3</td>
							<td class="review_td">오늘</td>
						</tr>
						<tr>
							<td>이거 다 자동으로 들어가게 수정해야됨</td>
							<td class="review_td">심형철씨</td>
							<td class="review_td">3</td>
							<td class="review_td">오늘</td>
						</tr>
						<tr>
							<td>이거 다 자동으로 들어가게 수정해야됨</td>
							<td class="review_td">심형철씨</td>
							<td class="review_td">3</td>
							<td class="review_td">오늘</td>
						</tr>
					</table>
				</div>
				<div class="talent_detail_review_register_container">
				</div>
			</div>
		</div>
		<div class="talent_detail_footer_container">
		</div>
	</div>
</body>
</html>