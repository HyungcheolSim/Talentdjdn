<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jquery -->
<script src="../resource/js/jquery-3.6.0.min.js"></script>

<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- common -->
<link rel="stylesheet" href="../_css/common.css">

<!-- this page -->
<link rel="stylesheet" href="../_css/index.css">

<!-- this page (경로 수정필요)-->
<link rel="stylesheet" href="../_css/2021_07_28_interest_menu.css"> 

</head>
<body>
	<div class="back_color">
	<div class="tp_layers">
		<div class="tp_button_layout">
			<%@ include file="payment_button.jsp" %>
		</div>
	</div>
	</div>
	<div id= "instrest_box">	
		<div id ="interest_img">			
			<div id="select_menu_box">
			</div>
			<div id="select_menu_box">
				<div class="select_main"><span><b>관심목록</b></span></div>
				<div class="select_main2"><span class="s_main2">홈><b>관심목록</b></span></div>
			</div>
			<div id="select_menu_box1">
				<div class="select_m_b"><span><b>⊙ 관심목록은 최대 10일간 저장됩니다.</b></span></div>
				<div class="select_m_b"><span>⊙ 가격, 옵션 등 정보가 일치하지 않을 경우 주문이 변경될 수 있습니다.</span></div>
				<div class="select_m_b"><span>⊙ 판매자의 사정으로 인해 상태가 변경해당 상품이 주문불가 할 수 있습니다.</span></div>
			</div>
			<div id="select_box">	
				<table id = "select_sub_box" class="table">
					<tr id = "select_menu1" class="warning">
						<th class="sub_text"><input id="cb1" type="checkbox">상품정보</th>
						<th class="sub_text1">옵션</th>
						<th class="sub_text2">금액</th>
						<th class="sub_text2">판매자</th>
					</tr>
					<tr>
						<td class="sub_text"><input id="cb1" type="checkbox"><img class="select_p_img" alt="" src="../_img/designs.png"> 상품</td>
						<td class="sub_text1">상품</td>
						<td class="sub_text2">상품</td>
						<td class="sub_text2">상품</td>
					</tr>
					<tr>
						<td class="sub_text"><input id="cb1" type="checkbox"><img class="select_p_img" alt="" src="../_img/designs.png"> 상품</td>
						<td class="sub_text1">상품</td>
						<td class="sub_text2">상품</td>
						<td class="sub_text2">상품</td>
					</tr>
					<tr>
						<td colspan="4">
							<input id= "select_btn" class="btn btn-default" type="button" value="선택상품 삭제">
							<input id= "select_btn" class="btn btn-warning" type="button" value="주문하기">
						</td>
					</tr>
					<tr>
						<td class="total_sum" colspan="2">총 합계금액: 30,000원</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div class="tp_layers">
		<div class="tp_bottom_layout">
			<%@ include file="../bottom.jsp" %>
		</div>
	</div>
</body>
</html>