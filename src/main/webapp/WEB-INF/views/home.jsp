<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
<link rel="stylesheet" href="resources/css/home.css">
<script type="text/javascript">

	location.href="member/list.do";
	
</script>

</head>
<body>
<h1>
	Hello world!!	
</h1>

<P>  The time on the server is ${serverTime}. </P>

<br><br>
pageContext.request.requestURL : ${pageContext.request.requestURL}<br>
pageContext.request.scheme: ${pageContext.request.scheme} <br>
pageContext.request.serverName: ${pageContext.request.serverName} <br>
pageContext.request.serverPort: ${pageContext.request.serverPort} <br>
pageContext.request.requestURI: ${pageContext.request.requestURI}  <br>
pageContext.request.servletPath: ${pageContext.request.servletPath}  <br>
</body>
</html>
