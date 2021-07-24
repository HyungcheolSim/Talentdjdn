<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Talent List</title>
<!-- common -->

<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/common.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/talent/talent_sidebar.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/talent/talent_list.css">
<script type="text/javascript">
    $(document).ready(function(){        
        getTalentListCon();
    });
 
    function getTalentListCon(){
        
        $.ajax({            
            type:"GET",
            url:"gettalentlist.do",
            dataType:"JSON",
            success : function(obj) {
                getTalentListCallback(obj);                
            },           
            error : function(xhr, status, error) {}
         });
    }
    
    function getTalentListCallback(obj){
        
        var list = obj;
        var listLen = obj.length;
        
        console.log(list);
        console.log(listLen);
        
        var str = "";
        
        if(listLen >  0){
            
            for(var a=0; a<listLen; a++){
                
                var talentId = list[a].t_id; 
                var talentTitle = list[a].t_title; 
                var talentContent  = list[a].t_content;
                var talentBigField=list[a].t_big_field;
                var talentSmallField=list[a].t_small_field;
                var talentPrice = list[a].t_price;
                var talentLocal = list[a].t_local;
                var talentCategory = list[a].t_cat;
                var talentBigImage= list[a].t_big_image;
                var talentSmallImage = list[a].t_small_image;
                var talentSellerId = list[a].s_id;
                
                str += "<tr>";
                str += "<td>"+ talentSmallImage + "</td>";
                str += "<td>"+ talentId +"</td>";
                str += "<td>"+ talentTitle +"</td>";
                str += "<td>"+ talentPrice +"</td>";
                str += "<td>"+ talentSellerId +"</td>";
                str += "<td>"+ talentCategory + "<td>";
                str += "</tr>";
                
            } 
            
        } else {
            
            str += "<tr colspan='6'>";
            str += "<td>등록된 글이 존재하지 않습니다.</td>";
            str += "<tr>";
        }
        
        $("#tbody").html(str);
    }
    
</script>
</head>
<body>
   
<div class="talent_list_body_container">
	<div class="tp_layers">
      <div class="tp_button_layout">
         <%@ include file="../top_button.jsp" %>
      </div>
   </div>
	<div class="talent_list_content_container">
		<div class="talent_list_content_sidebar_container">
			<%@ include file="talent_sidebar.jsp" %>
		</div>
		<div class="table_container">
			<table>
				<thead>
					<tr>
						<td class="td_else">썸네일</td>
						<td class="td_else">글번호</td>
						<td id="td_title">제목</td>
						<td class="td_else">가격</td>
						<td class="td_else">작성자</td>
						<td class="td_else">카테고리</td>
					</tr>
				</thead>
				<tbody id="tbody">
		
				</tbody>
			</table>
		</div>
	</div>
	<div class="tp_layers">
   		<div class="tp_bottom_layout">
       		 <%@ include file="../bottom.jsp" %>
   		</div>
	</div>
	
</div>
</body>
</html>