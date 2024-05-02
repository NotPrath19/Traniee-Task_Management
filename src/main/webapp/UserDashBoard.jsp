<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
<link rel="stylesheet" href="css/UserDashBoard.css">
<script src="js/index.js"></script>
</head>
<body>
<c:set var="Status" value="${sessionScope.Status}" />
<c:choose>
<c:when test="${Status == 1}">
<div id="container">
<div id="Header">
<jsp:include page="components/DashBoardHeader.jsp" /> 
</div>
<div id=mix>
<div id="NavigationBar">
<jsp:include page="components/DashBoardNavigationBar.jsp" /> 
</div>
<div id="Main">
<jsp:include page="components/DashBoardMain.jsp" /> 
</div>
<div id="Right">
</div>
</div>
<div id="Footer">
<jsp:include page="components/Footer.jsp" /> 
</div>
</div>
</c:when>
<c:otherwise>
<c:redirect url="./index.jsp"/>
</c:otherwise>
</c:choose>
</body>
</html>