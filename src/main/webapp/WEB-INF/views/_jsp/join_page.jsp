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

<!-- semantic ui -->
<link rel="stylesheet" href="../resource/Semantic-UI-CSS-master/semantic.css">
<script src="../resource/Semantic-UI-CSS-master/semantic.js"></script>

<!-- common -->
<link rel="stylesheet" href="../_css/common.css">
<script src='../js/common.js'></script>

<!-- this page -->
<link rel="stylesheet" href="../_css/join_page.css">
<script src='../js/join_page.js'></script>

</head>
<body>

   <div class="tp_layers">
      <div class="tp_button_layout">
         <%@ include file="top_button.jsp" %>
      </div>
   </div>
   
   <div class="tp_layer">
      <div class="tp_main_layout">
      
         <div id="join_box">
            <form>
               <div class="panel panel-warning">
                  <div class="panel-heading">회원가입</div>
                  <div class="panel-body">
                     <table class="table table-scripted">
                        <tr>
                           <th>이름</th>
                           <td><input name="m_name"></td>
                        </tr>
                        <tr>
                           <th>아이디</th>
                           <td><input name="m_id" id="m_id"><span id="id_msg"></span></td>
                        </tr>
                        <tr>
                           <th>비밀번호</th>
                           <td><input type="password" name="m_pwd"></td>
                        </tr>
                        <tr>
                           <th>비밀번호 확인</th>
                           <td><input type="password" name="c_pwd"></td>
                        </tr>
                        <tr>
                           <th>우편번호</th>
                           <td>
                              <input name="m_zipcode" id="m_zipcode">
                              <input class="btn btn-warning" type="button" id="btn_find" value="주소찾기">
                           </td>
                        </tr>
                        <tr>
                           <th>주소</th>
                           <td><input name="m_addr" id="m_addr" size="60"></td>
                        </tr>
                        <tr>
                           <th>상세주소</th>
                           <td><input name="m_addr" id="m_addr"></td>
                        </tr>
                        <tr>
                           <th>관심지역</th>
                           <td>
                           	<select name="loc">
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
                           <th>이메일</th>
                           <td><input name="m_email" id="m_email"></td>
                        </tr>
                        <tr>
                           <th>휴대전화</th>
                           <td>
                              <input type="radio" name="phone">SKT
                              <input type="radio" name="phone">KT
                              <input type="radio" name="phone">LGU+
                              <input placeholder="000-0000-0000">
                           </td>
                        </tr>
                        <tr>
                           <td colspan="2" align="center">
                              <input class="btn btn-warning" type="button" id="btn_register" value="회원가입" 
                                     disabled="disabled" onclick="send(this.form);">
                              <input class="btn btn-warning" type="button" value="메인화면" 
                                                   onclick="location.href='index.jsp'">
                           </td>
                        </tr>
                     </table>
                  </div>
               </div>
            </form>
         </div>
      
         
      </div>
   </div>
   
   <div class="tp_layers">
      <div class="tp_bottom_layout">
         <%@ include file="bottom.jsp" %>
      </div>
   </div>

</body>
</html>