<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jquery -->
<script src="../resource/js/jquery-3.6.0.min.js"></script>

<!-- bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- common -->
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/common.css">

<!-- this page (경로 수정필요)-->
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/payment_button.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/payment.css">

<script type="text/javascript">
	$(document).ready(function() {
		$(".cbx_chkAll").click(function() {
			if ($(".cbx_chkAll").is(":checked"))
				$("input[name=chk]").prop("checked", true);
			else
				$("input[name=chk]").prop("checked", false);
		});

		$("input[name=chk]").click(function() {
			var total = $("input[name=chk]").length;
			var checked = $("input[name=chk]:checked").length;

			if (total != checked)
				$(".cbx_chkAll").prop("checked", false);
			else
				$(".cbx_chkAll").prop("checked", true);
		});
	});

/* 	function new_addr() {

		document.getElementById('newaddr').style.display = 'block'
		//document.getElementById('addr').style.display='none'
	}

	function new_email() {
		document.getElementById('newemail').style.display = 'block'
		// document.getElementById('email').style.display='none'
	} */

	function send(f) {

		//var addr = f.newaddr.value.trim();

		var email = f.newemail.value.trim();
		console.log(addr);
		alert(addr);
		console.log(email);
		alert(email);
		//var newaddr=f.newaddr.value.trim();

		//var newemail=f.newemail.value.trim();
		//var email=document.getElementById('email').innerHTML;

		/*  var addr;
		if(f.newaddr.value.trim()=='')
				addr= $('#addr').text();
		else{
		   addr=f.newaddr.value.trim();
		}
		var email;
		if(f.newemail.value.trim()=='')
				email= $('#email').text();
		else{
		   email=f.newaddr.value.trim();
		} */
		var t_idx = "${ param.t_idx }";

		/* 	   if(addr=='' && email==''){
		 alert('주소또는 이메일을 입력하세요!!')
		 f.addr.value = '';
		 f.addr.focus();
		
		 return;
		 } */

		f.action ="insert.do";
		f.submit();
	}
</script>

</head>
<body>
	<div class="back_color">
		<div class="tp_layers">
			<div class="tp_button_layout">
				<%@ include file="purchase_button.jsp"%>
			</div>
		</div>
	</div>
	<div id="instrest_box">
		<div id="interest_img">
			<div id="select_menu_box">
				<div class="select_main">
					<span><b>결제목록</b></span>
				</div>
				<div class="select_main2">
					<span class="s_main2">홈><b>결제목록</b></span>
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
				<table id="select_sub_box" class="table">
					<tr id="select_menu1" class="warning">
						<th class="sub_text"><input id="cb1" class="cbx_chkAll"
							type="checkbox">상품정보</th>
						<th class="sub_text1">내용</th>
						<th class="sub_text2">금액</th>
						<th class="sub_text2">판매자</th>
					</tr>

					<tr>
						<td class="sub_text"><input id="cb1" name="chk"
							type="checkbox"> <img class="select_p_img" alt=""
							src="../seller/displayFile?fileName=${map.tv.t_image}&directory=talent" />${map.tv.t_title}</td>
						<td class="sub_text1">${map.tv.t_content}</td>
						<td class="sub_text2">${map.tv.t_price}</td>
						<td class="sub_text2">${map.tv.seller.s_id}</td>
					</tr>


					<!--                <tr>
                  <td colspan="4">
                     <input id= "select_btn" class="btn btn-default" type="button" value="선택상품 삭제">
                     <input id= "select_btn" class="btn btn-warning" type="button" value="주문하기">
                  </td>
               </tr> -->
					<!-- <tr>
                  <td class="total_sum" colspan="2">총 합계금액: 30,000원</td>
               </tr> -->
				</table>

				<form>
					<table id="table_id" class="table">
						<tr>
							<th>배송지정보</th>
						</tr>
						<tr>
							<td>이름 : ${map.mv.m_name }</td>
						</tr>
						<tr>
							<td>전화번호 : ${map.mv.m_phone }</td>
						</tr>
						<tr>
							<td><c:if test="${ map.tv.t_cat eq '상품' }">
            주소 : <%-- <span id="addr">${map.mv.m_addr } ${map.mv.m_detail_addr }</span> --%>
									<input id="newaddr" name="newaddr" size="60" type="text"
										value="${map.mv.m_addr } ${map.mv.m_detail_addr }" />
									<!-- <input class="btn btn-warning" type="button" value="정보수정" onclick="new_addr();"> -->
								</c:if> <c:if test="${ map.tv.t_cat eq '재능' }">
            이메일 :<%--  <span id="email">${map.mv.m_email }</span> --%>
									<input id="newemail" name="newemail" size="30" type="text"
										value="${map.mv.m_email }">
									<!-- <input class="btn btn-warning" type="button" value="정보수정" onclick="new_email();"> -->
								</c:if></td>
						</tr>
						<tr>
							<td>요청사항 : <input size="30" placeholder="요청사항을 입력하세요">
							</td>
						</tr>
						<tr>
							<td>결제수단 : <input type="radio" name="pay">계좌결제 <input
								type="radio" name="pay">카드결제 <input type="radio"
								name="pay">일반결제
							</td>
						</tr>

					</table>

					<div id="pay_button">
						<input style="width: 150px; height: 50px;" class="btn btn-warning"
							type="button" value="결제하기" onclick="send(this.form);">
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
</body>
</html>