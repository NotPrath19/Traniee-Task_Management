<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:choose>
<c:when test="${param.HeaderInput eq 'Login'}">
  <jsp:include page="./Login.jsp" />
  <c:redirect url="../index.jsp">
  <c:param name="HeaderInput" value="${param.HeaderInput}"/>
  </c:redirect>
</c:when>
<c:when test="${param.HeaderInput eq 'Register'}">
  <jsp:include page="./Register.jsp" />
   <c:redirect url="../index.jsp">
  <c:param name="HeaderInput" value="${param.HeaderInput}"/>
  </c:redirect>
</c:when>
<c:otherwise>
<c:out value="This is Website is developed to provide solution to"/><br><br>
<c:out value="all your personel and task management problems "/><br><br>
<c:out value="and it is developed by ~Prath19(UID-810438027)"/><br><br><br>
<img alt="" src="components/assets/./Logo.PNG" width="10%">
</c:otherwise>
</c:choose>
</body>
</html>