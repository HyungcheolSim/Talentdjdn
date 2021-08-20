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

	function modify_form() {
		
		location.href='modify_form.do?m_idx=' + ${vo.m_idx};
	}

</script>

</head>
<body>

   <div class="tp_layers">
      <div class="tp_button_layout">
         <%@ include file="../top_button.jsp" %>
      </div>
   </div>
   
   <div class="tp_layer">
      <div class="tp_main_layout">
      
         <div id="join_box">
            <form>
               <div class="panel panel-warning">
                  <div class="panel-heading">회원정보</div>
                  <div class="panel-body">
                     <table class="table table-scripted">
                        <tr>
                           <th>이름</th>
                           <td>${ vo.m_name }</td>
                        </tr>
                        <tr>
                           <th>아이디</th>
                           <td>${ vo.m_id }</td>
                        </tr>
                        <tr>
                           <th>우편번호</th>
                           <td>${ vo.m_zipcode }</td>
                        </tr>
                        <tr>
                           <th>주소</th>
                           <td>${ vo.m_addr }</td>
                        </tr>
                        <tr>
                           <th>상세주소</th>
                           <td>${ vo.m_detail_addr }</td>
                        </tr>
                        <tr>
                           <th>관심지역</th>
                           <td>${ vo.m_local }</td>
                        </tr>
                        <tr>
                           <th>이메일</th>
                           <td>${ vo.m_email }</td>
                        </tr>
                        <tr>
                           <th>주민번호</th>
                           <td>${ vo.m_jumin }</td>
                        </tr>
                        <tr>
                           <th>휴대전화</th>
                           <td>${ vo.m_phone }</td>
                        </tr>
                        <tr>
                           <td colspan="2" align="center">
                              <input class="btn btn-warning" type="button" id="btn_register" value="정보수정" 
                                     onclick="modify_form('${ vo.m_idx }')">
                              <input class="btn btn-warning" type="button" value="메인화면" 
                                                   onclick="location.href='../main/index.do'">
                              <input class="btn btn-warning" type="button" value="구매목록" 
                                                   onclick="location.href='../purchase/list.do'">
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
         <%@ include file="../bottom.jsp" %>
      </div>
   </div>

</body>
</html>