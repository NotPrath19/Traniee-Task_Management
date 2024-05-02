<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="userList" value="${sessionScope.userList}" />
<div id="Add Task">
<form action ="${pageContext.request.contextPath}/UpdateAdminTaskServlet" id="AddTaskForm" method="POST">
 User:<select name="SelectUser" id="SelectUser" >
 <option value="${param.UserName}">${param.UserName}</option>
 <c:forEach var="obj" items="${userList}">
 <option value="${obj}">${obj}</option>
 </c:forEach>     
  </select>
Date<input type="date" name="Date" value="${param.Date}" >
AddTask<input type ="text" name="Tasks" value="${param.Tasks}">
StartTime<input type ="time" name="StartTime" value="${param.StartTime}">
EndTime<input type ="time" name="EndTime" value="${param.EndTime}">
<input type ="hidden" value="${param.Id}" name="Id">
<input type ="hidden" value="${param.User}" name="User">
<input type ="hidden" value="${param.NavInput}" name="NavInput">
<input type ="hidden" value="${param.Desig}" name="Desig">
<input type="submit">
</form>
</div>
</body>
</html>