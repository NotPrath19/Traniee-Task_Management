<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${param.User eq 'Prath19'}">
 <c:set var="UserName" scope = "session" value="${param.User}"/>
  <c:set var="DesigName" scope = "session" value="${param.Desig}"/>
  
<form action="${pageContext.request.contextPath}/DisplayAdminProfileServlet" method="post">
<input type="hidden" value="${UserName}" name="User">
<input type="hidden" value="${DesigName}" name="Desig">
<input type="hidden" value="Profile" name="NavInput">
<input type="submit" value="Profile">
</form>
<form action="${pageContext.request.contextPath}/GetUserListServlet" method="post">
<input type="hidden" value="${UserName}" name="User">
<input type="hidden" value="${DesigName}" name="Desig">
<input type="hidden" value="AddTaskAdmin" name="NavInput">
<input type="submit" value="AddTask">
</form>
<form action="${pageContext.request.contextPath}/DisplayAdminScheduleServlet" method="post">
<input type="hidden" value="${UserName}" name="User">
<input type="hidden" value="${DesigName}" name="Desig">
<input type="hidden" value="ScheduleAdmin" name="NavInput">
<input type="submit" value="Schedule">
</form>
<form action="${pageContext.request.contextPath}/DisplaySubmissionServlet" method="post">
<input type="hidden" value="${UserName}" name="User">
<input type="hidden" value="${DesigName}" name="Desig">
<input type="hidden" value="Submissions" name="NavInput">
<input type="submit" value="Submissions">
</form>
<form action="${pageContext.request.contextPath}/DisplayApprovalServlet" method="post">
<input type="hidden" value="${UserName}" name="User">
<input type="hidden" value="${DesigName}" name="Desig">
<input type="hidden" value="Approve" name="NavInput">
<input type="submit" value="Approvals">
</form>
</c:when>
<c:otherwise>
<c:choose>
<c:when test="${param.Desig eq 'User'}">
 <c:set var="UserName" scope = "session" value="${param.User}"/>
  <c:set var="DesigName" scope = "session" value="${param.Desig}"/>
<form action="${pageContext.request.contextPath}/DisplayUserProfileServlet" method="post">
<input type="hidden" value="${UserName}" name="User">
<input type="hidden" value="${DesigName}" name="Desig">
<input type="hidden" value="Profile" name="NavInput">
<input type="submit" value="Profile">
</form>
<form action="components/./DashBoardMain.jsp" method="post">
<input type="hidden" value="${UserName}" name="User">
<input type="hidden" value="${DesigName}" name="Desig">
<input type="hidden" value="AddTaskUser" name="NavInput">
<input type="submit" value="AddTask">
</form>
<form action="${pageContext.request.contextPath}/DisplayUserScheduleServlet" method="post">
<input type="hidden" value="${UserName}" name="User">
<input type="hidden" value="${DesigName}" name="Desig">
<input type="hidden" value="ScheduleUser" name="NavInput">
<input type="submit" value="Schedule">
</form>
<form action="${pageContext.request.contextPath}/DisplaySubmissionUserServlet" method="post">
<input type="hidden" value="${UserName}" name="User">
<input type="hidden" value="${DesigName}" name="Desig">
<input type="hidden" value="Submissions" name="NavInput">
<input type="submit" value="Submissions">
</form>



</c:when>
<c:when test="${param.Desig eq 'Admin'}">
 <c:set var="UserName" scope = "session" value="${param.User}"/>
  <c:set var="DesigName" scope = "session" value="${param.Desig}"/>
<form action="${pageContext.request.contextPath}/DisplayAdminProfileServlet" method="post">
<input type="hidden" value="${UserName}" name="User">
<input type="hidden" value="${DesigName}" name="Desig">
<input type="hidden" value="Profile" name="NavInput">
<input type="submit" value="Profile">
</form>
<form action="${pageContext.request.contextPath}/GetUserListServlet" method="post">
<input type="hidden" value="${UserName}" name="User">
<input type="hidden" value="${DesigName}" name="Desig">
<input type="hidden" value="AddTaskAdmin" name="NavInput">
<input type="submit" value="AddTask">
</form>
<form action="${pageContext.request.contextPath}/DisplayAdminScheduleServlet" method="post">
<input type="hidden" value="${UserName}" name="User">
<input type="hidden" value="${DesigName}" name="Desig">
<input type="hidden" value="ScheduleAdmin" name="NavInput">
<input type="submit" value="Schedule">
</form>
<form action="${pageContext.request.contextPath}/DisplaySubmissionServlet" method="post">
<input type="hidden" value="${UserName}" name="User">
<input type="hidden" value="${DesigName}" name="Desig">
<input type="hidden" value="Submissions" name="NavInput">
<input type="submit" value="Submissions">
</form>
</c:when>
<c:otherwise></c:otherwise>
</c:choose>
</c:otherwise>
</c:choose>
</body>
</html>