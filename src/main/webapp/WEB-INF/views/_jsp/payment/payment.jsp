<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- jquery UI -->
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://code.jquery.com/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script
	src="${ pageContext.request.contextPath }/resources/js/jquery.mtz.monthpicker.js"></script>
<!-- common -->
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/common.css">

<!-- this page (경로 수정필요)-->
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/payment_button.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/payment.css">
<script>
	$(document).ready(
			function() {
				var options = {
					pattern : 'yyyy-mm',
					selectedYear : 2021,
					startYear : 1990,
					finalYear : 2022,
					monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
							'8월', '9월', '10월', '11월', '12월' ],
					openOnFocus : true,
					disableMonths : []
				};
				$("#monthPicker").monthpicker(options);

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

	function find() {
		month = $("#monthPicker").val();

		if (month == '') {
			location.href = "list.do";

		}
		if (month != '') {
			location.href = "list.do?month="
					+ encodeURIComponent(month, "utf-8");

		}

	}//end-find
	function deletelist() {
		var confirm_val = confirm("정말 삭제하시겠습니까?");

		if (confirm_val) {
			var checkArr = new Array();

			$("input[class='chBox']:checked").each(function() {
				checkArr.push($(this).attr("data-payNum"));
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
			<div id="select_menu_box"></div>
			<div id="select_menu_box">
				<div class="select_main">
					<span><b>구매목록</b></span>
				</div>
				<div class="select_main2">
					<span class="s_main2">홈><b>구매목록</b></span>
				</div>
			</div>
			<div id="select_menu_box1">
				<div class="select_m_b">
					<span><b>⊙ 구매목록은 최대 10일간 저장됩니다.</b></span>
				</div>
				<div class="select_m_b">
					<span>⊙ 가격, 옵션 등 정보가 일치하지 않을 경우 주문이 변경될 수 있습니다.</span>
				</div>
				<div class="select_m_b">
					<span>⊙ 판매자의 사정으로 인해 상태가 변경해당 상품이 주문불가 할 수 있습니다.</span>
				</div>
			</div>
			<div id="select_box">
				<div>
					<h2>월별 구매목록 보기</h2>
					<input type="text" id="monthPicker" name="monthPicker" style=""
						onchange="find();" />
					<input id="select_btn"
							class="btn btn-warning" type="button" value="선택 삭제" onclick="javascript:deletelist()">
				</div>
				<c:if test="${ empty map.list }">
					<tr>
						<td colspan="5">
							<div id="empty_message">아직 재능/상품을 구매하신 적이 없습니다.</div>
						</td>
					</tr>
				</c:if>

				<table id="select_sub_box" class="table">

					<tr id="select_menu1" class="warning">
						<th class="sub_text5"><input type="checkbox" name="allCheck"
							id="allCheck" /></th>
						<th class="sub_text1">상품정보</th>
						<th class="sub_text4">상품명</th>
						<th class="sub_text3">배송지/이메일</th>
						<th class="sub_text4">금액</th>
						<th class="sub_text3">판매자</th>
						<th class="sub_text4">구매일</th>
					

					</tr>

					<c:forEach var="vo" items="${ map.list }">
						<tr>
							<td class="sub_text5"><input type="checkbox" name="chBox"
								class="chBox" data-payNum="${vo.p_idx}" /></td>
							<td class="sub_text1"><img class="select_p_img" alt=""
								src="../seller/displayFile?fileName=${vo.talent.t_image}&directory=talent"></td>
								<td class="sub_text4">${vo.talent.t_title}</td>
							<c:if test="${ vo.talent.t_cat eq '상품' }">
								<td class="sub_text3">${vo.p_address}</td>
							</c:if>
							<c:if test="${ vo.talent.t_cat eq '재능' }">
								<td class="sub_text3">${vo.p_email}</td>
							</c:if>
							<td class="sub_text4">${vo.talent.t_price}</td>
							<td class="sub_text3">${vo.talent.seller.s_id}</td>
							<td class="sub_text4">${vo.p_regdate }</td>

						</tr>
					</c:forEach>
				</table>
				<tr>
					<td class="total_sum" colspan="2">총 구매금액: ${ map.totalPrice}원</td>
				</tr>
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