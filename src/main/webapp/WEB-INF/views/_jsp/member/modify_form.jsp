<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 정보 수정</title>
<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- common -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/common.css">
<!-- this page -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/join_page.css">
<!-- daum 주소찾기 라이브러리 -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
var regular_id = /^[a-zA-Z0-9]{4,10}$/;

$(document).ready(function(){
   
   //m_id입력 내용이 변경되면
   $("#m_id").keyup(function(event){
      
      var m_id = $(this).val();
      //회원가입버튼 비활성화
      $("#btn_register").attr('disabled',true);           
      if(regular_id.test(m_id)==false){
         $("#id_msg").html('영문자숫자조합 4~10자리로 작성하세요');
         $("#id_msg").css('color','red');
         return;
      }      
      //Ajax를 이용해서 아이디 중복체크
      $.ajax({
         url      : 'check_id.do', //MemberCheckIdAction
         data     : {'m_id' : m_id},
         dataType : 'json',
         success  : function(result_data){
            //result_data = {"result" : true} or {"result" : false}   
            // true  
            if(result_data.result){//사용가능
               
               $("#id_msg").html('사용가능한 아이디 입니다');
               $("#id_msg").css('color','blue'); 
               
               //회원가입버튼 활성화
               $("#btn_register").attr('disabled',false);
               
            }else{//사용불가(이미사용중)
               
               $("#id_msg").html('이미 사용중인 아이디 입니다');
               $("#id_msg").css('color','red'); 
            }
            
         },
         error    : function(err){
            //alert(err.responseText);
            console.log(err.responseText);
         }
      });
   }); // end keyup
   //주소찾기 버튼 클릭시 
   $("#btn_find").click(function(){
      
      var width = 500; //팝업의 너비
      var height = 600; //팝업의 높이
      
      new daum.Postcode({
          width: width, //생성자에 크기 값을 명시적으로 지정해야 합니다.
          height: height,
          theme: {
              searchBgColor: "#0B65C8", //검색창 배경색
              queryTextColor: "#FFFFFF" //검색창 글자색
          },
           oncomplete: function(data) {
               // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
               // 예제를 참고하여 다양한 활용법을 확인해 보세요.
               //data = { 'zonecode':'12345','address':'서울시 관악구 시흥대로 552','roadAddress':'서울시 관악구 시흥대로 552' }
               $("#m_zipcode").val(data.zonecode);
               $("#m_addr").val(data.roadAddress);
           }
       }).open(
          {   
             left: (window.screen.width / 2) - (width / 2),
             top: (window.screen.height / 2) - (height / 2)   
          }
       );
      
   });// end 찾기버튼 클릭   
});// end jQuery 초기화

function send(f) {
    
    //입력값 체크...
    var m_name = f.m_name.value.trim();
    var m_pwd  = f.m_pwd.value.trim();
    var c_pwd  = f.c_pwd.value.trim();
    //우편번호/주소...
    var m_zipcode      = f.m_zipcode.value.trim();
    var m_addr         = f.m_addr.value.trim();
    var m_detail_addr  = f.m_detail_addr.value.trim();
    var m_local        = f.m_local.value.trim();
    var m_email        = f.m_email.value.trim();
    var m_phone        = f.m_phone.value.trim();
    var m_jumin        = f.m_jumin.value.trim();
    
    if(m_name==''){
       alert('이름을 입력하세요!!')
       f.m_name.value = '';
       f.m_name.focus();
       
       return;
    }
    
    if(m_pwd==''){
       alert('비밀번호를 입력하세요!!')
       f.m_pwd.value = '';
       f.m_pwd.focus();
       
       return;
    }
    
	  if(m_pwd!=c_pwd){
		  alert('비밀번호를 똑같이 입력하세요!!');
		  f.m_pwd.value='';
		  f.c_pwd.value='';
		  f.m_pwd.focus();
		  f.c_pwd.focus();
		  
		  return;
	  }
    
    if(m_zipcode==''){
       alert('우편번호를 입력하세요!!')
       f.m_zipcode.value = '';
       f.m_zipcode.focus();
       
       return;
    }
    
    if(m_addr==''){
       alert('주소를 입력하세요!!')
       f.m_addr.value = '';
       f.m_addr.focus();
       
       return;
    }

    if(m_detail_addr==''){
        alert('상세주소를 입력하세요!!')
        f.m_detail_addr.value = '';
        f.m_detail_addr.focus();
        
        return;
     }
    
    if(m_local==''){
        alert('지역을 입력하세요!!')
        f.m_local.value = '';
        f.m_local.focus();
        
        return;
     }
    
    if(m_email==''){
        alert('이메일을 입력하세요!!')
        f.m_email.value = '';
        f.m_email.focus();
        
        return;
     }
    
    if(m_jumin==''){
        alert('주민번호를 입력하세요!!')
        f.m_jumin.value = '';
        f.m_jumin.focus();
        
        return;
     }
    
    
    if(m_phone==''){
        alert('번호를 입력하세요!!')
        f.m_phone.value = '';
        f.m_phone.focus();
        
        return;
     }
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
   <div class="newtp_layer">
      <div class="tp_main_layout">      
         <div id="join_box">
            <form>
            <input type="hidden" name="m_idx" value="${vo.m_idx }">
               <div class="panel panel-warning">
                  <div class="panel-heading">정보수정</div>
                  <div class="panel-body">
                     <table class="table table-scripted">
                        <tr>
                           <th>이름</th>
                           <td><input name="m_name" value="${ vo.m_name }"></td>
                        </tr>
                        <tr>
                           <th>아이디</th>
                           <td><input name="m_id" id="m_id" value="${ vo.m_id }"><span id="id_msg"></span></td>
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
                              <input name="m_zipcode" id="m_zipcode" value="${ vo.m_zipcode }">
                              <input class="btn btn-warning" type="button" id="btn_find" value="주소찾기">
                           </td>
                        </tr>
                        <tr>
                           <th>주소</th>
                           <td><input name="m_addr" id="m_addr" size="60" value="${ vo.m_addr }"></td>
                        </tr>
                        <tr>
                           <th>상세주소</th>
                           <td><input name="m_detail_addr" id="m_detail_addr" value="${ vo.m_detail_addr }"></td>
                        </tr>
                        <tr>
                           <th>관심지역</th>
                           <td>
                           	<select name="m_local">
                           		<option value="">선택</option>
                           		<option value="서울"<c:if test="${ vo.m_local eq '서울' }">selected</c:if>>서울</option>
                           		<option value="경기"<c:if test="${ vo.m_local eq '경기' }">selected</c:if>>경기</option>
                           		<option value="인천"<c:if test="${ vo.m_local eq '인천' }">selected</c:if>>인천</option>
                           		<option value="강원"<c:if test="${ vo.m_local eq '강원' }">selected</c:if>>강원</option>
                           		<option value="충남"<c:if test="${ vo.m_local eq '충남' }">selected</c:if>>충남</option>
                           		<option value="충북"<c:if test="${ vo.m_local eq '충북' }">selected</c:if>>충북</option>
                           		<option value="경남"<c:if test="${ vo.m_local eq '경남' }">selected</c:if>>경남</option>
                           		<option value="경북"<c:if test="${ vo.m_local eq '경북' }">selected</c:if>>경북</option>
                           		<option value="전남"<c:if test="${ vo.m_local eq '전남' }">selected</c:if>>전남</option>
                           		<option value="전북"<c:if test="${ vo.m_local eq '전북' }">selected</c:if>>전북</option>
                           		<option value="대구"<c:if test="${ vo.m_local eq '대구' }">selected</c:if>>대구</option>
                           		<option value="대전"<c:if test="${ vo.m_local eq '대전' }">selected</c:if>>대전</option>
                           		<option value="광주"<c:if test="${ vo.m_local eq '광주' }">selected</c:if>>광주</option>
                           		<option value="울산"<c:if test="${ vo.m_local eq '울산' }">selected</c:if>>울산</option>
                           		<option value="부산"<c:if test="${ vo.m_local eq '부산' }">selected</c:if>>부산</option>
                           		<option value="세종"<c:if test="${ vo.m_local eq '세종' }">selected</c:if>>세종</option>
                           		<option value="제주도"<c:if test="${ vo.m_local eq '제주도' }">selected</c:if>>제주도</option>
                           	</select>
                           </td>
                        </tr>
                        <tr>
                           <th>이메일</th>
                           <td><input name="m_email" id="m_email" value="${ vo.m_email }"></td>
                        </tr>
                        <tr>
                           <th>주민번호</th>
                           <td><input name="m_jumin" id="m_jumin" value="${ vo.m_jumin }" placeholder="000000-0000000"></td>
                        </tr>
                        <tr>
                           <th>휴대전화</th>
                           <td>
                              <input name ="m_phone" placeholder="000-0000-0000" value="${ vo.m_phone }">
                           </td>
                        </tr>
                        <tr>
                           <td colspan="2" align="center">
                              <input class="btn btn-warning" type="button" id="btn_register" value="정보수정" 
                                     onclick="send(this.form);">
                              <input class="btn btn-warning" type="button" value="메인화면" 
                                                   onclick="location.href='../main/index.do'">
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