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



<!-- common -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/common.css">


<!-- this page -->
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/index_screen.css">

<!-- image slider_bxslider -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>


<script>
$ ( document ). ready ( function (){
  $ ( '.bxslider' ). bxSlider ({
	  auto: true, 
	  speed: 500, 
	  pause: 3500,
	  maxSlides: 4,
	  moveSlides:4
  });
});
</script>


</head>
<style>
.bx-wrapper {border:0;background:#fbfbfb;box-shadow:none;}
</style>
<body>
<div id ="text_box"><b>재능마켓 인기서비스</b></div>

<div id = "tt" class = "bxslider">
	<ul id="bxslider">
		<li id="pic1"><img src="${ pageContext.request.contextPath }/resources/img/${ vo.s_potfolio }"></li>
		<li id="pic1"><img src="${ pageContext.request.contextPath }/resources/img/${ vo.s_potfolio }"></li>
		<li id="pic1"><img src="${ pageContext.request.contextPath }/resources/img/${ vo.s_potfolio }"></li>
		<li id="pic1"><img src="${ pageContext.request.contextPath }/resources/img/${ vo.s_potfolio }"></li>
	</ul>		
	<ul id="pic_box">
		<li id="pic1"><img src="${ pageContext.request.contextPath }/resources/img/${ vo.s_potfolio }"></li>
		<li id="pic1"><img src="${ pageContext.request.contextPath }/resources/img/${ vo.s_potfolio }"></li>
		<li id="pic1"><img src="${ pageContext.request.contextPath }/resources/img/${ vo.s_potfolio }"></li>
		<li id="pic1"><img src="${ pageContext.request.contextPath }/resources/img/${ vo.s_potfolio }"></li>
	</ul>	
</div>



<div id ="text_box"><b>우리지역 인기서비스</b></div>

<div class = "bxslider">
	<ul id="pic_box">
		<li id="pic1"><img src="${ pageContext.request.contextPath }/resources/img/${ vo.s_potfolio }"></li>
		<li id="pic1"><img src="${ pageContext.request.contextPath }/resources/img/${ vo.s_potfolio }"></li>
		<li id="pic1"><img src="${ pageContext.request.contextPath }/resources/img/${ vo.s_potfolio }"></li>
		<li id="pic1"><img src="${ pageContext.request.contextPath }/resources/img/${ vo.s_potfolio }"></li>
	</ul>		
	<ul id="pic_box">
		<li id="pic1"><img src="${ pageContext.request.contextPath }/resources/img/${ vo.s_potfolio }"></li>
		<li id="pic1"><img src="${ pageContext.request.contextPath }/resources/img/${ vo.s_potfolio }"></li>
		<li id="pic1"><img src="${ pageContext.request.contextPath }/resources/img/${ vo.s_potfolio }"></li>
		<li id="pic1"><img src="${ pageContext.request.contextPath }/resources/img/${ vo.s_potfolio }"></li>
	</ul>	
</div>


</body>
</html>