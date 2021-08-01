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
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/common.css">
<script src='../js/common.js'></script>

<!-- this page -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/join_page.css">
<script src='../js/join_page.js'></script>

<script type="text/javascript">


function send(f) {
    
    //입력값 체크...
    var s_account      = f.s_account.value.trim();
    var s_field        = f.s_field.value.trim();
    var s_education    = f.s_education.value.trim();
    var s_skill        = f.s_skill.value.trim();
    var s_local        = f.s_local.value;
    var s_msg          = f.s_msg.value.trim();
    
    if(s_account==''){
       alert('계좌번호를 입력하세요!!')
       f.s_account.value = '';
       f.s_account.focus();
       return;
    }
    
    if(s_field==''){
       alert('분야를 입력하세요!!')
       f.s_field.value = '';
       f.s_field.focus();
       return;
    }
    
    if(s_education==''){
       alert('학력을 입력하세요!!')
       f.s_education.value = '';
       f.s_education.focus();
       return;
    }

    if(s_skill==''){
        alert('기술을 입력하세요!!')
        f.s_skill.value = '';
        f.s_skill.focus();
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
    f.action = "insert.do"; 
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
               
               <input type="hidden" name="m_idx" value="${ user.m_idx }">
               
               <div class="panel panel-warning">
                  <div class="panel-heading">고수등록</div>
                  <div class="panel-body">
                     <table class="table table-scripted">
                        <tr>
                           <th>계좌번호</th>
                           <td><input name="s_account" id="s_account"></td>
                        </tr>
                        <tr>
                           <th>분야</th>
                           <td><input name="s_field" id="s_field"></td>
                        </tr>
                        <tr>
                           <th>학력</th>
                           <td><input name="s_education" id="s_education"></td>
                        </tr>
                        <tr>
                           <th>경력</th>
                           <td><input name="s_career" id="s_career"></td>
                        </tr>
                        <tr>
                        <tr>
                           <th>자격증</th>
                           <td><input name="s_license" id="s_license"></td>
                        </tr>
                        <tr>
                           <th>포트폴리오</th>
                           <td><input type="file" name="potfolio" id="potfolio"></td>
                        </tr>
                        <tr>
                           <th>기술</th>
                           <td><input name="s_skill" id="s_skill"></td>
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
                           	<textarea name="s_msg" id="s_msg" rows="8" cols="60"></textarea>
                           </td>
                        </tr>
                        <tr>
                           <td colspan="2" align="center">
                              <input class="btn btn-warning" type="button" id="btn_register" value="고수등록" 
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