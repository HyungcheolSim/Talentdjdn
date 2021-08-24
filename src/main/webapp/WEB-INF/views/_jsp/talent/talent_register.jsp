<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Talent Register</title>
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
	href="${ pageContext.request.contextPath }/resources/css/talent/talent_register.css">
<style type="text/css">
textarea[name='t_content'] {
	width: 60%;
	resize: none;
	border: black solid 1px;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {

	});

	/** 게시판 - 목록 페이지 이동 */
	function goBoardList() {
		location.href = "talentlist.do";
	}
	function send(f) {

		var t_title = f.t_title.value.trim();
		var t_content = f.t_content.value.trim();
		var t_big_field = f.t_big_field.value.trim();
		var t_small_field = f.t_small_field.value.trim();
		
		var t_price = f.t_price.value.trim();
		var t_local = f.t_local.value.trim();
		var t_cat = f.t_cat.value.trim();
		var s_idx=sessionStorage.getItem("s_idx");

		if (t_title == "") {
			alert("제목을 입력해주세요.");
			f.t_title.value = '';
			f.t_title.focus();
			return;
		}

		if (t_content == "") {
			alert("내용을 입력해주세요.");
			f.t_content.value = '';
			f.t_content.focus();
			return;
		}
		//
		f.action = "talentinsert"; //TalentInsertAction
		f.submit();//전송


	}
</script>
</head>
<body>
	<div class="talent_register_body_container">
		<div class="tp_layers">
			<div class="tp_button_layout">
				<%@ include file="../top_button.jsp"%>
			</div>
		</div>
		<div class="talent_register_content_container">
			<div class="talent_register_content_sidebar_container">
				<%@ include file="talent_sidebar.jsp"%>
			</div>
			<div class="table_container">
				<div class="inner">
					<form method="post" enctype="multipart/form-data">

						<div class="panel panel-warning">
							<div class="panel-heading">
								<h2>재능 등록</h2>
							</div>
							<input type="hidden" name="s_idx" value="${param.s_idx}">
							<table class="table">
								
								<caption>
									<strong><span class="t_red">*</span> 표시는 필수입력 항목입니다.</strong>
								</caption>
								<tbody id="tbody">
									<tr>
										
										<th>제목<span class="t_red">*</span></th>
										<td><input id="t_title" name="t_title" /></td>
									</tr>
									<tr>
										<th>내용<span class="t_red">*</span></th>
										<td><textarea id="t_content" name="t_content"></textarea></td>
									</tr>
									<tr>
										<th>대분류<span class="t_red">*</span></th>
										<td><select name="t_big_field" id="t_big_field">
												<option value="">대분류</option>
												<option value="디자인">디자인</option>
												<option value="IT·프로그래밍">IT·프로그래밍</option>
												<option value="영상·사진·음향">영상·사진·음향</option>
												<option value="마케팅">마케팅</option>
												<option value="번역·통역">번역·통역</option>
												<option value="레슨·실무교육">레슨·실무교육</option>
												<option value="상품">상품</option>
										</select></td>
									</tr>
									<tr>
										<th>소분류<span class="t_red">*</span></th>
										<td><input id="t_small_field" name="t_small_field" /></td>
									</tr>
									<tr>
										<th>이미지<span class="t_red">*</span></th>
										<td><input type="file" id="image" name="image" /></td>
									</tr>
									<tr>
										<th>가격<span class="t_red">*</span></th>
										<td><input id="t_price" name="t_price" /></td>
									</tr>
									<tr>
										<th>지역<span class="t_red">*</span></th>
										<td><select id="t_local" name="t_local">
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
										</select></td>
									</tr>
									<tr>
										<th>카테고리<span class="t_red">*</span></th>
										<td><select id="t_cat" name="t_cat">
												<option value="재능">재능</option>
												<option value="상품">상품</option>
										</select></td>
									</tr>

								</tbody>
							</table>
							<div class="btn_right mt15">
								<button type="button" class="btn btn-warning"
									onclick="javascript:goBoardList();">목록으로</button>
								<button type="button" class="btn btn-warning"
									onclick="send(this.form);">등록하기</button>
							</div>
						</div>
					</form>
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