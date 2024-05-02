<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
    <%@ page import="com.yash.Eventelion.model.Approval" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${Valid eq 'Notified'}">
  <c:redirect url="./index.jsp">
  </c:redirect>
</c:when>
<c:when test="${Valid eq 'NotAUser'}">
  <c:redirect url="./index.jsp">
  <c:param name="HeaderInput" value="Login"/>
   <c:param name="unmatch" value="Not A User"/>
  </c:redirect>
</c:when>
<c:when test="${Valid eq 'WrongPassword'}">
  <c:redirect url="./index.jsp">
  <c:param name="HeaderInput" value="Login"/>
   <c:param name="unmatch" value="Wrong Password"/>
  </c:redirect>
</c:when>
<c:when test="${Valid eq 'Success'}">
<c:choose>
<c:when test="${Status == 1}">
<c:set var="User" scope = "session" value="${User}" />
<c:set var="Desig" scope = "session" value="${Desig}" />
 <c:redirect url="./UserDashBoard.jsp">
  <c:param name="User" value="${User}"/>
  <c:param name="Desig" value="${Desig}"/>
  <c:set var="Status" scope = "session" value="${Status}" />
  </c:redirect>
  </c:when>
  <c:otherwise>
   <c:redirect url="./index.jsp"/>  
  </c:otherwise>
  </c:choose>
</c:when>
<c:when test="${Valid eq 'All Fields Are Required'}">
<c:redirect url="./index.jsp">
  <c:param name="HeaderInput" value="Register"/>
   <c:param name="unmatch" value="All Fields Are Required"/>
  </c:redirect>
</c:when>
<c:when test="${Valid eq 'Registered Succefully'}">
<c:redirect url="./index.jsp">
  <c:param name="HeaderInput" value="Register"/>
   <c:param name="unmatch" value="Registered Succefully"/>
  </c:redirect>
</c:when>
<c:when test="${Valid eq 'Approval Pending'}">
<c:redirect url="./index.jsp">
  <c:param name="HeaderInput" value="Register"/>
   <c:param name="unmatch" value="Approval Pending"/>
  </c:redirect>
</c:when>
<c:when test="${Valid eq 'Password Does Not Match'}">
<c:redirect url="./index.jsp">
  <c:param name="HeaderInput" value="Register"/>
   <c:param name="unmatch" value="Confirm Password Does Not Match"/>
  </c:redirect>
</c:when>
<c:when test="${Valid eq 'ApproveDisplay'}">

<c:redirect url="./UserDashBoard.jsp">
  <c:param name="NavInput" value="Approve"/>
<c:set var="userList" value="${userList}" scope="session"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
</c:when>
 <c:when test="${Valid eq 'Approved'}">

<c:redirect url="./UserDashBoard.jsp">
  <c:param name="NavInput" value="Approve"/>
<c:set var="userList" value="${userList}" scope="session"/>
  <c:param name="User" value="${User}"/>
  <c:param name="Desig" value="${Desig}"/>
  </c:redirect>
  </c:when>
  <c:when test="${Valid eq 'Denied'}">

<c:redirect url="./UserDashBoard.jsp">
  <c:param name="NavInput" value="Approve"/>
<c:set var="userList" value="${userList}" scope="session"/>
  <c:param name="User" value="${User}"/>
  <c:param name="Desig" value="${Desig}"/>
  </c:redirect>
  </c:when>
    <c:when test="${Valid eq 'AddedTaskUser'}">

<c:redirect url="./UserDashBoard.jsp">
  <c:param name="NavInput" value="AddTaskUser"/>
  <c:param name="User" value="${User}"/>
  <c:param name="Desig" value="${Desig}"/>
  </c:redirect>
  </c:when>
  
  <c:when test="${Valid eq 'AddedTaskAdmin'}">
<c:redirect url="./UserDashBoard.jsp">
  <c:param name="NavInput" value="AddTaskAdmin"/>
  <c:param name="User" value="${User}"/>
  <c:param name="Desig" value="${Desig}"/>
  </c:redirect>
  </c:when>
  
  <c:when test="${Valid eq 'GetUserList'}">
<c:redirect url="./UserDashBoard.jsp">
  <c:param name="NavInput" value="AddTaskAdmin"/>
<c:set var="userList" value="${userList}" scope="session"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
</c:when>
<c:when test="${Valid eq 'GetUserListForAdminUpdate'}">
<c:redirect url="./UserDashBoard.jsp">
  <c:param name="NavInput" value="UpdateAdmin"/>
<c:set var="userList" value="${userList}" scope="session"/>
  <c:param name="User" value="${User}"/>
  <c:param name="Desig" value="${Desig}"/>
<c:param name="UserName" value="${UserName}"/>
  <c:param name="Id" value="${Id}"/>
  <c:param name="Date" value="${Date}"/>
  <c:param name="Tasks" value="${Tasks}"/>
  <c:param name="StartTime" value="${StartTime}"/>
  <c:param name="EndTime" value="${EndTime}"/>
  </c:redirect>
</c:when>
<c:when test="${Valid eq 'DisplayTaskUser'}">
<c:redirect url="./UserDashBoard.jsp">
  <c:param name="NavInput" value="ScheduleUser"/>
<c:set var="taskList" value="${taskList}" scope="session"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
  </c:when>
  <c:when test="${Valid eq 'DeletedTask'}">
<c:redirect url="./UserDashBoard.jsp">
<c:set var="taskList" value="${taskList}" scope="session"/>
  <c:param name="NavInput" value="ScheduleUser"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
  </c:when>
  <c:when test="${Valid eq 'SubmittedTask'}">
<c:redirect url="./UserDashBoard.jsp">
<c:set var="taskList" value="${taskList}" scope="session"/>
  <c:param name="NavInput" value="ScheduleUser"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
  </c:when>
  <c:when test="${Valid eq 'DeletedTaskAdmin'}">
<c:redirect url="./UserDashBoard.jsp">
<c:set var="taskList" value="${taskList}" scope="session"/>
  <c:param name="NavInput" value="ScheduleAdmin"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
  </c:when>
  <c:when test="${Valid eq 'DisplaySearchTask'}">
<c:redirect url="./UserDashBoard.jsp">
<c:set var="taskList" value="${taskList}" scope="session"/>
  <c:param name="NavInput" value="ScheduleAdmin"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
  </c:when>
  <c:when test="${Valid eq 'UpdatedTask'}">
<c:redirect url="./UserDashBoard.jsp">
<c:set var="taskList" value="${taskList}" scope="session"/>
  <c:param name="NavInput" value="ScheduleUser"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
  </c:when>
  <c:when test="${Valid eq 'UpdatedTasksAdmin'}">
<c:redirect url="./UserDashBoard.jsp">
<c:set var="taskList" value="${taskList}" scope="session"/>
  <c:param name="NavInput" value="ScheduleAdmin"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
  </c:when>
  <c:when test="${Valid eq 'DisplayTaskAdmin'}">
<c:redirect url="./UserDashBoard.jsp">
  <c:param name="NavInput" value="ScheduleAdmin"/>
<c:set var="taskList" value="${taskList}" scope="session"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
  </c:when>
  <c:when test="${Valid eq 'DisplaySubmissions'}">
<c:redirect url="./UserDashBoard.jsp">
  <c:param name="NavInput" value="Submissions"/>
<c:set var="taskList" value="${taskList}" scope="session"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
  </c:when>
   <c:when test="${Valid eq 'ProfileDisplay'}">
<c:redirect url="./UserDashBoard.jsp">
  <c:param name="NavInput" value="Profile"/>
  <c:set var="UserProfile" value="${UserProfile}" scope="session"/>
  <c:set var="taskList" value="${taskList}" scope="session"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
  </c:when>
     <c:when test="${Valid eq 'AdminProfileDisplay'}">
<c:redirect url="./UserDashBoard.jsp">
  <c:param name="NavInput" value="Profile"/>
  <c:set var="UserProfile" value="${UserProfile}" scope="session"/>
  <c:set var="taskList" value="${taskList}" scope="session"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
  </c:when>
  <c:when test="${Valid eq 'Signout'}">

   <c:set var="Status" scope = "session" value="${Status}" />
   <c:redirect url="./index.jsp"/> 

</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
</body>
</html>