<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Talent Register</title>
<!-- common -->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/common.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/talent/talent_sidebar.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/talent/talent_register.css">
<script type="text/javascript">
	$(document).ready(function() {

	});

	/** 게시판 - 목록 페이지 이동 */
	function goBoardList() {
		location.href = "talentlist.do";
	}

	/*     /* 게시판 - 작성  */
	/*     function insertBoard(){
	
	 var t_title= $("#t_title").val();
	 var t_content = $("#t_content").val();
	 var t_big_field=$("#t_big_field").val();
	 var t_small_field=$("#t_small_field").val();
	 var t_price=$("#t_price").val();
	 var t_local=$("#t_local").val();
	 var t_cat=$("#t_cat").val();
	 var s_id=$("#s_id").val();
	
	 if (t_title == ""){            
	 alert("제목을 입력해주세요.");
	 $("#t_title").focus();
	 return;
	 }
	
	 if (t_content == ""){            
	 alert("내용을 입력해주세요.");
	 $("#t_content").focus();
	 return;
	 }
	
	 var yn = confirm("게시글을 등록하시겠습니까?");        
	 if(yn){
	
	 $.ajax({    
	
	 url      : "talentinsert",
	 data     : $("#talentForm").serialize(),
	 dataType : "JSON",
	 cache    : false,
	 async    : true,
	 type     : "POST",    
	 success  : function(obj) {
	 insertBoardCallback(obj);                
	 },           
	 error    : function(xhr, status, error) {}
	
	 });
	 }
	 }
	
	 게시판 - 작성 콜백 함수 
	 function insertBoardCallback(obj){
	
	 if(obj != null){        
	
	 var result = obj.result;
	
	 if(result == "SUCCESS"){                
	 alert("게시글 등록을 성공하였습니다.");                
	 goBoardList();                 
	 } else {                
	 alert("게시글 등록을 실패하였습니다.");    
	 return;
	 } 
	
	 console.log("SOMETHING IS INSERTED");
	 goBoardList();
	 }
	 console.log("SOMETHING IS NOT INSERTED");
	 }
	 */
	function send(f) {

		var t_title = f.t_title.value.trim();
		var t_content =  f.t_content.value.trim();
		var t_big_field =  f.t_big_field.value.trim();
		var t_small_field = f.t_small_field.value.trim();
		var t_price = f.t_price.value.trim();
		var t_local =  f.t_local.value.trim();
		var t_cat =  f.t_cat.value.trim();
		var s_id =  f.s_id.value.trim();

		if (t_title == "") {
			alert("제목을 입력해주세요.");
			f.t_title.value='';
			f.t_title.focus();
		}

		if (t_content == "") {
			alert("내용을 입력해주세요.");
			f.t_content.value='';
			f.t_content.focus();
		}
		//
		f.action = "talentinsert"; //TalentInsertAction
		f.submit();//전송

		/*  goBoardList();*/

	}
</script>
</head>
<body>
<div class="talent_register_body_container">
	<div class="tp_layers">
      <div class="tp_button_layout">
         <%@ include file="../top_button.jsp" %>
      </div>
   </div>
	<div class="talent_register_content_container">
		<div class="talent_register_content_sidebar_container">
			<%@ include file="talent_sidebar.jsp" %>
		</div>
		<div class="table_container">
			<div class="inner">
				<h2>게시글 작성</h2>
				<form>
					<table>
						<caption>
							<strong><span class="t_red">*</span> 표시는 필수입력 항목입니다.</strong>
<!-- 						</caption> -->
						<colgroup>
							<col width="20%">
							<col width="*">
						</colgroup>
						<tbody id="tbody">
							<tr>
								<th>제목<span class="t_red">*</span></th>
								<td><input id="t_title" name="t_title" class="tbox01" /></td>
							</tr>
							<tr>
								<th>내용<span class="t_red">*</span></th>
								<td id="textarea_td"><textarea id="t_content" name="t_content"></textarea></td>
							</tr>
							<tr>
								<th>대분류<span class="t_red">*</span></th>
								<td><input id="t_big_field" name="t_big_field"
									class="tbox01" /></td>
							</tr>
							<tr>
								<th>소분류<span class="t_red">*</span></th>
								<td><input id="t_small_field" name="t_small_field"
									class="tbox01" /></td>
							</tr>
							<tr>
								<th>가격<span class="t_red">*</span></th>
								<td><input id="t_price" name="t_price" class="tbox01" /></td>
							</tr>
							<tr>
								<th>지역<span class="t_red">*</span></th>
								<td><input id="t_local" name="t_local" class="tbox01" /></td>
							</tr>
							<tr>
								<th>카테고리<span class="t_red">*</span></th>
								<td><input id="t_cat" name="t_cat" class="tbox01" /></td>
							</tr>
							<tr>
								<th>작성자<span class="t_red">*</span></th>
								<td><input id="s_id" name="s_id" class="tbox01" /></td>
							</tr>

						</tbody>
					</table>
				
				<div class="btn_right mt15">
					<button type="button" class="btn black mr5"
						onclick="javascript:goBoardList();">목록으로</button>
					<!-- <button type="button" class="btn black"
						onclick="javascript:insertBoard();">등록하기</button> -->
					<button type="button" class="btn black" onclick="send(this.form);">등록하기</button>
				</div>
				</form>
			</div>
		</div>
	</div>
	<div class="tp_layers">
   		<div class="tp_bottom_layout">
       		 <%@ include file="../bottom.jsp" %>
   		</div>
	</div>
</div>
</body>
</html>