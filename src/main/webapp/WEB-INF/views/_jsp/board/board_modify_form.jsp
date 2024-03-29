<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<!-- bootstrap을 사용하기 위한 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/boardview.css">
<script type="text/javascript">

	function send(f) {
		var b_title = f.b_title.value.trim();
		var b_content = f.b_content.value.trim();
		
		if(b_title==''){
			alert('제목을 입력하세요');
			f.b_title.value='';
			f.b_title.focus();
			return;
		}
		
		if(b_content==''){
			alert('내용을 입력하세요');
			f.b_content.value='';
			f.b_content.focus();
			return;
		}
		
		//전송대상
		f.action = "modify.do";
		f.submit();
	}	
</script>
</head>
<body>
	<div class="tp_layers">
		<div class="tp_button_layout">
			<%@ include file="../top_button.jsp"%>
		</div>
	</div>
	<div class="tp_layer">
		<div class="tp_main_layout">
	<form>
		<input type="hidden" name="b_idx" value="${ vo.b_idx }">
		<div id="box">
			<div class="panel panel-warning">
				<div class="panel-heading"><h3>수정폼</h3></div>
				<div class="panel-body">
					<table class="table">
						<tr>
							<th>제목</th>
							<td><input name="b_title" value="${ vo.b_title }"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea name="b_content" rows="8" cols="60">${ vo.b_content }</textarea></td>
						</tr>
						
						<tr>
							<td colspan="2" align="center">
								<input class="btn btn-warning" type="button" value="수정하기"
								       onclick="send(this.form);">
								<input class="btn btn-warning" type="button" value="목록보기"
								       onclick="location.href='list.do'">
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</form>	
	</div>
		<div class="tp_layers">
			<div class="tp_bottom_layout">
				<%@ include file="../bottom.jsp"%>
			</div>
		</div>
	</div>
</body>
</html>