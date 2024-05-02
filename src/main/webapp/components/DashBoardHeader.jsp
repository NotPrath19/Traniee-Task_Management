<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<a href="<c:url value="../UserDashBoard.jsp" var="myUrl"> <c:param name="User" value="${param.User}" /> <c:param name="Desig" value="${param.Desig}" /></c:url>"><img  src="components/assets/./Logo.PNG" alt="Not Found" id=Logo ></a>
<h1 id="Title">Eventelion</h1>
<c:choose>
<c:when test="${param.Desig eq 'User'}">
<div>Welcome User, ${param.User} </div>
<form action="${pageContext.request.contextPath}/UserSignoutServlet" method="post">
<input type="hidden" value="${param.User}" name="UserName">
<input type=Submit value="Signout">
</form>
</c:when>
<c:when test="${param.Desig eq 'Admin'}">
<c:choose>
<c:when test="${param.User eq 'Prath19'}">
<div>Welcome Heavenly Principle, ${param.User} </div>
<form action="${pageContext.request.contextPath}/UserSignoutServlet" method="post">
<input type="hidden" value="${param.User}" name="UserName">
<input type=Submit value="Signout">
</form>
</c:when>
<c:otherwise>
<div>Welcome Admin, ${param.User} </div>
<form action="${pageContext.request.contextPath}/UserSignoutServlet" method="post">
<input type="hidden" value="${param.User}" name="UserName">
<input type=Submit value="Signout">
</form>
</c:otherwise>
</c:choose>
</c:when>
</c:choose>
</body>
</html>