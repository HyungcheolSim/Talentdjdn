<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관심 재능/상품 목록</title>
<!-- jquery -->
<script src="../resource/js/jquery-3.6.0.min.js"></script>
<!-- bootstrap -->
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- common -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/common.css">
<!-- this page (경로 수정필요)-->
<link rel="stylesheet"	href="${ pageContext.request.contextPath }/resources/css/payment_button.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/payment.css">
<script type="text/javascript">

$(document).ready(
		function() {

			$("#allCheck").click(function() {
				var chk = $("#allCheck").prop("checked");
				if (chk) {
					$(".chBox").prop("checked", true);
				} else {
					$(".chBox").prop("checked", false);
				}
			});

			$(".chBox").click(function() {
				$("#allCheck").prop("checked", false);
			});
		}
);

function deletelist() {
	var confirm_val = confirm("정말 삭제하시겠습니까?");

	if (confirm_val) {
		var checkArr = new Array();

		$("input[class='chBox']:checked").each(function() {
			checkArr.push($(this).attr("data-intNum"));
		});

		$.ajax({
			url : "deletelist.do",
			type : "post",
			data : {
				chbox : checkArr
			},
			success : function(result) {
				if (result == 1) {
					location.href = "list.do";
				} else {
					alert("삭제 실패");
				}
			}
		});
	}
}
</script>
</head>
<body>
	<div class="back_color">
		<div class="tp_layers">
			<div class="tp_button_layout">
				<%@ include file="../purchase/purchase_button.jsp"%>
			</div>
		</div>
	</div>
	<div id="instrest_box">
		<div id="interest_img">
			<div id="select_menu_box">
				<div class="select_main">
					<span><b>관심목록</b></span>
				</div>
				<div class="select_main2">
					<span class="s_main2">홈><b>관심목록</b></span>
				</div>
			</div>
			<div id="select_menu_box1">
				<div class="select_m_b">
					<span>⊙ 가격, 옵션 등 정보가 일치하지 않을 경우 주문이 변경될 수 있습니다.</span>
				</div>
				<div class="select_m_b">
					<span>⊙ 판매자의 사정으로 인해 상태가 변경해당 상품이 주문불가 할 수 있습니다.</span>
				</div>
			</div>
			<div id="select_box">
				<input id="select_btn" class="btn btn-warning" type="button" value="선택 삭제" onclick="javascript:deletelist()">
				<table id="select_sub_box" class="table">
					<tr id="select_menu1" class="warning">
						<th class="sub_text5"><input type="checkbox" name="allCheck" id="allCheck" /></th>
						<th class="sub_text">상품정보</th>
						<th class="sub_text1">내용</th>
						<th class="sub_text2">금액</th>
						<th class="sub_text2">판매자</th>
					</tr>					
					<c:forEach var="vo" items="${ list }">
					<tr>
						<td class="sub_text5"><input type="checkbox" name="chBox"
								class="chBox" data-intNum="${vo.i_idx}" /></td>
						<td class="sub_text"><img class="select_p_img" alt=""
							src="../seller/displayFile?fileName=${vo.talent.t_image}&directory=talent" />${vo.talent.t_title}</td>
						<td class="sub_text1">${vo.talent.t_content}</td>
						<td class="sub_text2">${vo.talent.t_price}</td>
						<td class="sub_text2">${vo.talent.seller.s_id}</td>
					</tr>
					</c:forEach>			
				</table>
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