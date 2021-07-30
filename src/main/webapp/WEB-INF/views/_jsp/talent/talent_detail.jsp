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
<!-- <script type="text/javascript">

function add_review() {
	
	//로그인여부 체크
	if('${ empty user }'=='true'){
		
		Swal.fire({
			  title: '리뷰쓰기',
			  html: "<h5>리뷰쓰기는 로그인후 이용가능합니다<br>로그인 하시겠습니까?</h5>",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: '예',
			  cancelButtonText : "아니오"
			}).then((result) => {
			  if (result.isConfirmed) {
				//현재경로 : /talent/talentdetail.do
					location.href='${ pageContext.request.contextPath }/member/login_form.do?url=' + location.href ; //돌아올 경로
			  }
			});

	}else{
		
		//로그인된 상태면...
		
		//입력값 읽어오기
		var r_title = $("#r_title").val().trim();
		var r_content = $("#r_content").val().trim();
		var r_star = $("#r_star").val();
		
		if(r_content==''){
			alert('댓글내용을 입력하세요!!!')
			$("#r_content").val('');
			$("#r_content").focus();
			return;
		}
		
		//Ajax로 전송
		$.ajax({
			url   : '../review/insert.do',
			data  : {
					 'r_title' : r_title,
					 'r_content' : r_content,
					 'r_star' : r_star,
				     't_id' : '${ talentvo.t_id }',
				     'm_id' : '${ user.m_id }',
				     
				     },
			dataType : 'json',
			success  : function(result_data){
				//result_data = { "result" : "success" }
				//result_data = { "result" : "fail" }
				
				//이전 댓글 내용 지우기
				$("#r_content").val('');
				
				if(result_data.result == "success"){
					
					//댓글목록 읽어오기 
					review_list(1);
					
				}else{
					alert("댓글쓰기 실패!!");
				}
			},
			error    : function(err){
				alert(err.responseText);
			}
		}); //end-ajax

	}
	
}// end add_review

function review_list(page) {
	
	//Ajax로 요청
	$.ajax({
		url  : "../review/list.do",
		data : { 't_id' : '${ talentvo.t_id }' },
		success  : function(result_data){
			//수신된 결과 데이터(댓글목록) disp에 출력
			$("#disp").html(result_data);
			
		},
		error    : function(err){
			alert(err.responseText);
		}
	});
}

//jQuery초기화
$(document).ready(function(){
	//댓글목록 출력 
	review_list(1);
});
</script> -->
<script type="text/javascript">

$(document).ready(function() {
	if('${ empty reviewlist }'=='true'){
		showReviews();	
	}
	
});
function showReviews(){
	location.href="../review/reviewselectone?t_idx=${param.t_id}";
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
					<p>${talentvo.s_id }</p>
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
								<td class="review_td"><strong>리뷰 작성자:</strong>   ${vo.m_id}</td>
								<td class="review_td"><strong>별점:</strong>  	
									<c:forEach var="i" begin="1" end="${vo.r_star}">★</c:forEach><c:forEach var="j" begin="${vo.r_star}" end="4">☆</c:forEach>   <span>${vo.r_star}</span>점</td>
								<td class="review_td"><strong>리뷰 등록일:</strong>   ${vo.r_regdate}</td>
								<td class="review_td"><strong>리뷰명:</strong>   ${vo.r_title}</td>
								<td class="review_td"><strong>내용:</strong>   ${vo.r_content}</td>								
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