<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="Add Task">
<c:set var="userList" value="${sessionScope.userList}" />

<span>Add Task</span><br>

<form action ="${pageContext.request.contextPath}/AddTaskAdminServlet" id="AddTaskForm" method="POST">
 User:<select name="SelectUser" id="SelectUser">
 <c:forEach var="obj" items="${userList}">
 <option value="${obj}">${obj}</option>
 </c:forEach>     
  </select><br>
Date<input type="date" name="Date"><br>
Task<input type ="text" name="Tasks"><br>
StartTime<input type ="time" name="StartTime"><br>
EndTime<input type ="time" name="EndTime"><br>
<input type ="hidden" value="${param.User}" name="User">
<input type ="hidden" value="${param.NavInput}" name="NavInput">
<input type ="hidden" value="${param.Desig}" name="Desig">
<input type="submit" value ="AddTask">
</form>
</div>
</body>
</html>