<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다재다능 재능 상세페이지</title>

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
	var t_idx=${param.t_idx};
	console.log(t_idx);
});

function add_cart() {
	//로그인 여부 체크
	if('${ empty user }'=='true'){	//로그인 안된상태
		
		Swal.fire({
             title: '로그인',
             html: "관심목록 담기는 로그인이 필요합니다<br> 로그인 하시겠습니까?",
             icon: 'warning',
             showCancelButton: true,
             confirmButtonColor: '#3085d6',
             cancelButtonColor: '#d33',
             confirmButtonText: '예',
             cancelButtonText: '아니오'
			}).then((result) => {
			  if (result.isConfirmed) {
			  	location.href='${ pageContext.request.contextPath }/member/login_form.do?url=' + location.href 
			  }
			});

	}else{ //로그인이 된상태			
		$.ajax({
			url		: '../interest/insert.do',	
			data	: {'t_idx' : '${param.t_idx}', 'm_idx' : '${user.m_idx}'},
			dataType: 'json',	
			success : function(result_data){
				if(result_data.result == 'success'){						
					Swal.fire(
						   '관심목록 등록 성공',
						   '관심목록에 등록되었습니다',
						   'warning'
					);
					return;
					
				}else if(result_data.result == 'exists'){
					Swal.fire(
						   '...',
						   '이미등록되었습니다',
						   'warning'
					);
					return;
				}
							
				else if(result_data.result == 'fail'){					
					Swal.fire(
								  '관심목록 등록 실패',
								  '이미 관심목록에 저장되어 있습니다',
								  'warning'
					);
					return;
				}
			},
			error	: function(err){
				alert("에러" + err.responseText);
			}
		});
	}
}
	//리뷰 추가 기능
function add_review() {
	console.log($("#r_star").val());
	//로그인여부 체크
	if('${ empty user }'=='true'){
		
		Swal.fire({
			  title: '리뷰작성',
			  html: "<h5>리뷰작성은 로그인후 이용가능합니다<br>로그인 하시겠습니까?</h5>",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: '예',
			  cancelButtonText : "아니오"
			}).then((result) => {
			  if (result.isConfirmed) {
					location.href='${ pageContext.request.contextPath }/member/login.do?url=' + location.href ; //돌아올 경로
			  }
			});

	}else{
		//입력값 읽어오기
		var r_content = $("#r_content").val().trim();
		var obj_length = document.getElementsByName("r_star").length;
  
        for (var i=0; i<obj_length; i++) {
            if (document.getElementsByName("r_star")[i].checked == true) {
                var r_star =document.getElementsByName("r_star")[i].value;
            }
        }
        if($("input:radio[name='r_star']").is(":checked")==false){
            
            alert('별점을 입력하세요!!!')
            return;
         }
		if(r_content==''){
			alert('리뷰내용을 입력하세요!!!')
			$("#r_content").val('');
			$("#r_content").focus();
			return;
		}
		
		$.ajax({
			url   : '../review/insert.do',
			data  : {'r_content' : r_content, 
					 'r_star' : r_star,
					 't_idx'  : '${ param.t_idx }',
				     'm_idx'   : '${ user.m_idx }'
				     },
			dataType : 'json',
			success  : function(result_data){
				//이전 댓글 내용 지우기
				$("#r_content").val('');
				if(result_data.result == "success"){
					//리뷰목록 읽어오기 
					location.href='${ pageContext.request.contextPath }/talent/updatestar?t_idx='+${param.t_idx};
					review_list();
					
				}else{
					alert("리뷰작성 실패!!");
				}
			},
			error    : function(err){
				alert("댓글은 300자 이내로 작성해주세요!");
			}
		}); 

	}
	
}

function review_list(page) {                                    	
	$.ajax({
		url  : "../review/list.do",
		data : { 't_idx' : '${ param.t_idx }',
				 'page'  : page
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

function modify_form(t_idx) {
	location.href="modify_form.do?t_idx=" + t_idx;
}

function del_talent(t_idx) {
	Swal.fire({
		  title: '재능삭제',
		  html: "정말 삭제하시겠습니까?",
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: '예',
		  cancelButtonText : "아니오"
		}).then((result) => {
		  if (result.isConfirmed) {
			  location.href="delete.do?t_idx=" + t_idx;
		  }
		});
}
//jQuery초기화
$(document).ready(function(){
	//리뷰목록 출력 
	review_list();
});
</script>

</head>
<body>
	<div class="talent_detail_body_container">
		<div class="talent_detail_header_container">
			<div class="header">
					<%@ include file="../top_button.jsp"%>
			</div>
		</div>
		<div class="tt_cont">
			<div class="talent_detail_content_container">
				<div class="talent_detail_content">
					<div class="buy_contents">
						<div class="contents_img">
							<img class="thumbnail"
								src="../seller/displayFile?fileName=${talentvo.t_image}&directory=talent">
						</div>
						<div class="detail_empty"></div>
						<div class="contents_dt1">
							<br>
							<h2>분야</h2>
							<p>${talentvo.t_big_field }</p>
							<br>
							<h2>서비스 가능 지역</h2>
							<p>${talentvo.t_local}</p>
							<br>
							<c:if test="${talentvo.t_cat}=='재능'">
								<h2>카테고리(재능/상품)</h2>
								<p>${talentvo.t_cat }</p>
								<br>
							</c:if>
							<h2>판매자명</h2>
							<p>${talentvo.seller.s_id }</p>
							<br>
							<h2>별점 평균</h2>
							<p>${talentvo.t_starscore}</p>
						</div>
					</div>
					<div class="buy_detail">
						<div class="detail1">
							<h2 id="talent_detail_title">${talentvo.t_title}</h2>
						</div>
						<div class="detail2">
							<h2 class="price_h2">
								<fmt:formatNumber type="number" maxFractionDigits="3"
									value="${talentvo.t_price}" />원	</h2>
						</div>
						<div class="detail3">
							<div class="dd1">
								<img id="cart"
									src="${ pageContext.request.contextPath }/resources/img/cart.png"
									onclick="add_cart()">
								<button class="purchasebtn"
									onclick="location.href='../purchase/purchaselist.do?t_idx=${param.t_idx}'">구매하기</button>
							</div>
						</div>
						<div class="detail_empty"></div>
						<div class="detail4">서비스 제공이 완료된 이후에 전문가에게 결제 대금이 전달됩니다.</div>
						<div class="detail_empty"></div>
						<div class="detail5">
							<h2>세부 설명</h2>
							<p>${talentvo.t_content }</p>
						</div>
					</div>


					<div class="talent_detail_title_container">
						<c:if
							test="${ (talentvo.seller.s_id eq user.m_id) or (user.m_grade eq '관리자') }">
							<td class="sub_text2"><input id="select_btn"
								class="btn btn-warning" type="button" value="정보수정"
								onclick="modify_form('${ talentvo.t_idx }');"></td>
						</c:if>
						<c:if
							test="${ talentvo.seller.s_id eq user.m_id }">
							<td class="sub_text2"><input type="button" id="delete_btn"
								class="btn btn-warning" value="삭제"
								onclick="del_talent('${ param.t_idx }');"></td>
						</c:if>
					</div>
					<div class="talent_detail_review_register_container">
						<div class="form_container">
							<form>
								<table class="table">
									<tr>
										<th>한줄 리뷰</th>
										<td><input name="r_content" id="r_content"></td>
									</tr>
									<tr>
										<th>별점</th>
										<td class="star-rating"><input type="radio" name="r_star"
											id="5r_star" value="5" /> <label for="5r_star" class="star">&#9733;</label>
											<input type="radio" name="r_star" id="4r_star" value="4" />
											<label for="4r_star" class="star">&#9733;</label> <input
											type="radio" name="r_star" id="3r_star" value="3" /> <label
											for="3r_star" class="star">&#9733;</label> <input
											type="radio" name="r_star" id="2r_star" value="2" /> <label
											for="2r_star" class="star">&#9733;</label> <input
											type="radio" name="r_star" id="1r_star" value="1" /> <label
											for="1r_star" class="star">&#9733;</label></td>
									</tr>
									<tr>
										<td><input type="button" value="리뷰작성"
											class="btn btn-warning" onclick="add_review();"></td>
									</tr>
								</table>
							</form>
						</div>
					</div>
					<div class="talent_detail_review_list_container">
						<div id="disp"></div>
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