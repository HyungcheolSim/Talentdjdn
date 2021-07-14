<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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

<!-- this page -->
<link rel="stylesheet" href="../_css/login.css">
<script src='../js/login.js'></script>


</head>
<body>

	<div class="tp_layers">
      <div class="tp_button_layout">
         <%@ include file="top_button.jsp" %>
      </div>
   </div>

	<div id="login_box">
		<form>
			<div class="panel panel-warning">
				<div class="panel-heading">로그인</div>
				<div class="panel-body">
					<table class="table">
						<tr>
							<th>아이디</th>
							<td><input></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password"></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input class="btn btn-warning" type="button" value="로그인" >
								<input class="btn btn-warning" type="button" value="메인화면" onclick="location.href='index.jsp'">
							</td>
						</tr>
					</table>
				</div>
			</div>
		</form>
	</div>
	
	<div class="tp_layers">
      <div class="tp_bottom_layout">
         <%@ include file="bottom.jsp" %>
      </div>
   </div>

</body>
</html>