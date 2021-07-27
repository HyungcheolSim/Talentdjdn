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
<script type="text/javascript">
var talentID=${talentvo.t_id};

$(document).ready(function() {
	
	//showReviews(talentID);
});
function showReviews(talentID){
	location.href="../review/reviewselectone?t_id="+talentID;
}

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
					<p>${talentvo.t_content }</p><br>
					<p>${talentvo.t_local}</p><br>
					<p>${talentvo.t_cat }</p><br>
					<p>${talentvo.s_id }</p><br>
				</div>
				<div class="talent_detail_review_list_container">
						<table class="table" >
						<tr>
							<th class="detail_review_header_w" scope="col">리뷰 제목</th>
							<th class="detail_review_header" scope="col">내용</th>
							<th class="detail_review_header_s" scope="col">별점</th>
							<th class="detail_review_header_r" scope="col">리뷰 등록일</th>
							<th class="detail_review_header_w" scope="col">리뷰 작성자</th>
						</tr>
						<c:if test="${empty reviewlist}">
							<tr>
								<td colspan="4">
									<div>리뷰가 존재하지 않습니다.</div>
								</td>
							</tr>
						</c:if>
						<c:forEach var="item" items="${reviewlist}">
							<tr>
								<td class="review_td">${item.r_title}</td>
								<td class="review_td">${item.r_content}</td>
								<td class="review_td">${item.r_star}</td>
								<td class="review_td">${item.r_regdate}</td>
								<td class="review_td">${item.m_id}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="talent_detail_review_register_container">
					<div class="form_container">
						<form>
							<table class="table">
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
									<td><input type="button" value="리뷰작성" class="btn btn-warning"
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