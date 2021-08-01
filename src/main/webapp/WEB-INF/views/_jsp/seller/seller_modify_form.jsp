<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- common -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/common.css">


<!-- this page -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/join_page.css">


<script type="text/javascript">


function send(f) {
    
    //입력값 체크...
    var s_account      = f.s_account.value.trim();
    var s_education    = f.s_education.value.trim();
    var s_local        = f.s_local.value;
    var s_msg          = f.s_msg.value.trim();
    
    if(s_account==''){
       alert('계좌번호를 입력하세요!!')
       f.s_account.value = '';
       f.s_account.focus();
       return;
    }
    
    if(s_education==''){
       alert('학력을 입력하세요!!')
       f.s_education.value = '';
       f.s_education.focus();
       return;
    }

    if(s_local==''){
        alert('지역을 입력하세요!!')
        f.s_local.value = '';
        f.s_local.focus();
        return;
     }
    
    if(s_msg==''){
        alert('자기소개를 입력하세요!!')
        f.s_msg.value = '';
        f.s_msg.focus();
        return;
     }

    //
    f.action = "modify.do"; 
    f.submit();//전송

 }

</script>

</head>
<body>

   <div class="tp_layers">
      <div class="tp_button_layout">
         <%@ include file="../top_button.jsp" %>
      </div>
   </div>
      
         <div id="join_box">
            <form method="post" enctype="multipart/form-data">
		        <input type="hidden" name="s_idx" value="${ vo.s_idx }">
				<input type="hidden" name="page" value="${ param.page }">
				<input type="hidden" name="search" value="${ param.search }">
				<input type="hidden" name="search_text" value="${ param.search_text }">
		        <div class="panel panel-warning">
                  <div class="panel-heading">고수수정</div>
                  <div class="panel-body">
                     <table class="table table-scripted">
                        <tr>
                           <th>계좌번호</th>
                           <td><input name="s_account" id="s_account" value="${ vo.s_account }"></td>
                        </tr>
                        <tr>
                           <th>학력</th>
                           <td><input name="s_education" id="s_education" value="${ vo.s_education }"></td>
                        </tr>
                        <tr>
                           <th>경력</th>
                           <td><input name="s_career" id="s_career" value="${ vo.s_career }"></td>
                        </tr>
                        <tr>
                        <tr>
                           <th>자격증</th>
                           <td><input name="s_license" id="s_license" value="${ vo.s_license }"></td>
                        </tr>
                        <tr>
                           <th>포트폴리오</th>
                           <td>
                           	<input type="file" name="potfolio" id="potfolio" >
                           	<p>${ vo.s_potfolio }</p>
                           </td>
                        </tr>
                        <tr>
                           <th>지역</th>
                           <td>
                           	<select name="s_local" id="s_local">
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
                           	</select>
                           </td>
                        </tr>
                        <tr>
                           <th>자기소개</th>
                           <td>
                           	<textarea name="s_msg" id="s_msg" rows="8" cols="60">${ vo.s_msg }</textarea>
                           </td>
                        </tr>
                        <tr>
                           <td colspan="2" align="center">
                              <input class="btn btn-warning" type="button" id="btn_register" value="고수수정" 
                                     onclick="send(this.form);">
                              <input class="btn btn-warning" type="button" value="메인화면" 
                                                   onclick="location.href='list.do'">
                           </td>
                        </tr>
                     </table>
                  </div>
               </div>
            </form>
         </div>
      
   
   <div class="tp_layers">
      <div class="tp_bottom_layout">
         <%@ include file="../bottom.jsp" %>
      </div>
   </div>

</body>
</html>