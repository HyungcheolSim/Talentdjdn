<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- common -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/common.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/talent/talent_sidebar.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/talent/talent_detail.css">
<!-- SweetAlert사용설정 : 알림박스 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script type="text/javascript">
$(document).ready(function() {
	if('${ empty reviewlist }'=='true'){
		showReviews();	
	}
});
function showReviews(){
	location.href="../review/reviewselectone?t_idx=${param.t_idx}";
}
function send(f) {

    var r_content= f.r_content.value.trim();
    var r_star= f.r_star.value.trim();
    
    if(r_content==''){
       alert('비밀번호를 입력하세요!!');
       f.r_content.value='';
       f.r_content.focus();
       return;
    }
    
    f.action="../review/reviewinsert"; //review insert
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
					<h2 id="talent_detail_title">${talentvo.t_title}</h2>
				</div>
				<div class="talent_detail_price_purchasebtn_container">
					<div class="talent_detail_price_container">
						<h2 class="price_h2">${talentvo.t_price}</h2>
					</div>
					<div class="talent_detail_purchasebtn_container">
						<button class="purchasebtn">구매하기</button>
					</div>
				</div>
				<div class="talent_detail_infomation">
					<h2>세부 설명</h2>
					<p>${talentvo.t_content }</p>
					<br>
					<h2>서비스 가능 지역</h2>
					<p>${talentvo.t_local}</p>
					<br>
					<h2>카테고리(재능/상품)</h2>
					<p>${talentvo.t_cat }</p>
					<br>
					<h2>판매자명</h2>
					<p>${talentvo.s_idx }</p>
					<br>
					<h2>별점 평균</h2>
					<p>${talentvo.t_starscore}</p>
					<br>
				</div>
				<div class="talent_detail_review_list_container">
					<h1>리뷰 목록</h1>
					<table class="table1">
						<c:if test="${empty reviewlist}">
							<tr>
								<td colspan="4">
									<div>리뷰가 존재하지 않습니다.</div>
								</td>
							</tr>
						</c:if>
						<c:forEach var="vo" items="${reviewlist}">
							<tr>
								<td class="review_td"><strong>리뷰 작성자:</strong>   ${vo.m_idx}</td>
								<td class="review_td"><strong>별점:</strong>  	
									<c:forEach var="i" begin="1" end="${vo.r_star}">★</c:forEach><c:forEach var="j" begin="${vo.r_star}" end="4">☆</c:forEach>   <span>${vo.r_star}</span>점</td>
								<td class="review_td"><strong>리뷰 등록일:</strong>   ${vo.r_regdate}</td>
								<td class="review_td"><strong>리뷰:</strong>   ${vo.r_content}</td>								
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="talent_detail_review_register_container">
					<div class="form_container">
						<form>
							<table class="table">
								<!-- <tr>
									<th>제목</th>
									<td><input name="r_title" id="r_title"></td>
								</tr> -->
								<tr>
									<th>리뷰</th>
									<td><input name="r_content" id="r_content"></td>
								</tr>
								<tr>
									<th>별점</th>
									<td class="star-rating">
										<input type="radio" name="r_star"id="5r_star" value="5" />
										<label for="5r_star" class="star">&#9733;</label>
										<input type="radio" name="r_star" id="4r_star" value="4" /> 
										<label for="4r_star" class="star">&#9733;</label> 
										<input type="radio"	name="r_star" id="3r_star" value="3" /> 
										<label for="3r_star" class="star">&#9733;</label> 
										<input type="radio" name="r_star" id="2r_star" value="2" /> 
										<label for="2r_star" class="star">&#9733;</label>
										<input type="radio" name="r_star" id="1r_star" value="1" /> 
										<label for="1r_star" class="star">&#9733;</label></td>
								</tr>
								<tr>
									<td><input type="button" value="리뷰작성"
										class="btn btn-warning" onclick="send(this.form);"></td>
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