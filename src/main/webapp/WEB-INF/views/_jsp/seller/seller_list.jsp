<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<!-- this page-->
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/seller_list.css">

<!-- SweetAlert사용설정 : 알림박스 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<style type="text/css">
.ghost-button {
	background-color: transparent !important;
	background-image: none !important;
	border-color: transparent;
	border: none;
	color: #FFFFFF;
}

#td_thumb {
	width: 30px;
}
</style>

<script type="text/javascript">

var search_text1;
var search_text2;

	//고수등록 폼띄우기
	function insert_form() {
		
		//로그인여부 체크
		if('${ empty user }'=='true'){
			
			
			Swal.fire({
				  title: '고수등록',
				  html: "고수등록은 로그인후 이용가능합니다<br>로그인 하시겠습니까?",
				  icon: 'warning',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: '예',
				  cancelButtonText : "아니오"
				}).then((result) => {
				  if (result.isConfirmed) {
					//현재경로 : /photo/list.do
						location.href='${ pageContext.request.contextPath }/member/login_form.do?url=' + location.href;
				  }
				});
			
		}else{
			
			//로그인된 상태면...
			//글쓰기 폼으로 이동
			location.href = 'insert_form.do'; //PhotoInsertFormAction
			
		}

	}//end-insert_form
	
	function find() {
		 search_text1 = $("#search_text1").val();
		 search_text2 = $("#search_text2").val();

		if(search_text1=='' && search_text2==''){
			 location.href = "list.do"; 
			 return;
		}
		//전체검색이면 검색창 내용 지워라..
 		if(search_text1=='' &&search_text2!=''){
			location.href = "list.do?search_text2=" + encodeURIComponent(search_text2,"utf-8");
			return;
 		}
		if(search_text1!='' &&search_text2==''){
			location.href = "list.do?search_text1=" + encodeURIComponent(search_text1,"utf-8");
			return;
		}
		 
		//자바스크립트 이용 요청
		//encodeURIComponent(search_text,"utf-8")
		// : search_text기 한글 또는 특수문자인 경우 인코딩해서 넘겨야 서버가 제대로 인식한다
		if(search_text1!=''&&search_text2!='')
			location.href = "list.do?search_text1=" + encodeURIComponent(search_text1,"utf-8") + "&search_text2=" + encodeURIComponent(search_text2,"utf-8"); 
		
	}//end-find

	
	//jQuery초기화
	$(function(){

		if('${ not empty param.search_text1 }'=='true'){		
		  $("#search_text1").val('${ param.search_text1 }');
		}
		if('${ not empty param.search_text2 }'=='true'){		
			  $("#search_text2").val('${ param.search_text2 }');
			}
	});
	
	function del_seller(s_idx) {
					
			Swal.fire({
				  title: '고수삭제',
				  html: "정말 삭제하시겠습니까?",
				  icon: 'warning',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: '예',
				  cancelButtonText : "아니오"
				}).then((result) => {
				  if (result.isConfirmed) {

					  location.href="delete.do?s_idx=" + s_idx;
				  }
				});
	}
			
			
		$(document).ready(function(){
		   
		   setTimeout(show_message, 100); //0.1초후에 show_message함수 호출
		   
		});
		
		function show_message() {
			
	    	  if('${ param.is_insert }'== 'insert'){
	    		  alert('좋아요를 누르셨습니다!');
	    	  }if('${ param.is_insert }'== 'delete'){
	    		  alert('좋아요를 취소하셨습니다!');
	    	  }
		}
	
		   function thumb_insert(s_idx) {
				      
				      //로그인여부 체크
				      if('${ empty user }'=='true'){
				         
				         Swal.fire({
				              title: '좋아요',
				              html: "<h5>좋아요는 로그인후 클릭이가능합니다<br>로그인 하시겠습니까?</h5>",
				              icon: 'warning',
				              showCancelButton: true,
				              confirmButtonColor: '#3085d6',
				              cancelButtonColor: '#d33',
				              confirmButtonText: '예',
				              cancelButtonText : "아니오"
				            }).then((result) => {
				              if (result.isConfirmed) {
				               //현재경로 : /review/list.do
				                  location.href='${ pageContext.request.contextPath }/member/login_form.do?url=' + location.href ; //돌아올 경로
				              }
				            });

				      }else{
						
				          //Ajax로 전송
				          $.ajax({
				             url   : 'thumb_insert.do',
				             data  : {'s_idx' :  s_idx, 
				                      'm_idx' :  "${ user.m_idx }"
				                     },
				             dataType : 'json',
				             success  : function(result_data){
				                //result_data = { "result" : "success" }
				                //result_data = { "result" : "fail" }
				                
				                if(result_data.result == "cancle_success"){
				                   swal.fire("좋아요를 취소하셨습니다");
				                   $("#thumb_count_" + s_idx).html(result_data.count);
				                }
				                else if(result_data.result == "success"){   
				             	   swal.fire("좋아요를 누르셨습니다");
				                   //좋아요 증가
				                   $("#thumb_count_" + s_idx).html(result_data.count);
				                   
				                }else{
				             	   swal.fire("좋아요 실패");
				                }
				             },
				             error    : function(err){
				                alert(err.responseText);
				             }
				          }); //end-ajax
				    	  
				    	  
				      }
				      
				      
				      
				   }// end thumb_insert

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
			<div id="select_menu_box">
				<div class="select_main">
					<span><b>고수찾기</b></span>
				</div>
				<div class="select_main2">
					<span class="s_main2">홈>고수찾기><b>지역,카테고리</b></span>
				</div>
			</div>
			<div id="click_box">
				<select class="loc_cate" id="search_text1" onchange="find();">
					<option value="">선택</option>
					<option value="서울">서울</option>
					<option value="경기">경기</option>
					<option value="인천">인천</option>
					<option value="강원">강원</option>
					<option value="충남">충남</option>
					<option value="충북">충북</option>
					<option value="경남">경남</option>
					<option value="경북">경북</option>
					<option value="전남">전남</option>
					<option value="전북">전북</option>
					<option value="대구">대구</option>
					<option value="대전">대전</option>
					<option value="광주">광주</option>
					<option value="울산">울산</option>
					<option value="부산">부산</option>
					<option value="세종">세종</option>
					<option value="제주도">제주도</option>
				</select> <select class="loc_cate" id="search_text2" onchange="find();">
					<option value="">카테고리</option>
					<option value="디자인">디자인</option>
					<option value="IT·프로그래밍">IT·프로그래밍</option>
					<option value="영상·사진·음향">영상·사진·음향</option>
					<option value="마케팅">마케팅</option>
					<option value="번역·통역">번역·통역</option>
					<option value="레슨·실무교육">레슨·실무교육</option>
					<option value="상품">상품</option>
				</select>
			</div>

			<div id="click_box">
				<div class="loc_cate1">
					<b>${ map.s_count }명의 고수</b>
				</div>
				<div class="loc_cate_null"></div>
			</div>
			<c:forEach var="vo" items="${ map.list }">
				<div id="select_box">
					<a
						href="view.do?s_idx=${ vo.s_idx }&page=${ (empty param.page) ? 1 :  param.page }&search=${ (empty param.search) ? 'all' : param.search }&search_text=${ param.search_text }">
						<table id="select_sub_box">
							<tr class="select_sub_box_tr">
								<td rowspan='5' class="sub_text"><img class="select_p_img"
									alt=""
									src="displayFile?fileName=${vo.s_potfolio}&directory=seller"></td>
								<td class="sub_text1">${ vo.s_id }</td>
								<td class="sub_text1">${ vo.s_msg }</td>
								<td class="sub_text1">${ vo.s_field }</td>
								<td class="sub_text1">${ vo.s_local }</td>
							</tr>
						</table>
					</a>

					<button class='ghost-button' type="button">
						<img id="td_thumb"
							src="${pageContext.request.contextPath}/resources/img/thumb.png"
							onclick="thumb_insert('${vo.s_idx}');">
					</button>

					<span id="thumb_count_${vo.s_idx}">${ vo.s_tcount }</span>

					<c:if
						test="${ (vo.member.m_idx eq user.m_idx) or (user.m_grade eq '관리자') }">
						<input type="button" id="delete_btn" class="btn btn-warning"
							value="삭제" onclick="del_talent('${ vo.s_idx }');">
					</c:if>
				</div>
			</c:forEach>

			<div class="gosu">
				<input id="gosu_btn" class="btn btn-warning" type="button"
					value="고수등록" onclick="insert_form();">
			</div>


			<!-- Page메뉴 넣기 -->
			<div style="text-align: center; font-size: 12pt;">${ map.pageMenu }

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