<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="Add Task">

<form action ="${pageContext.request.contextPath}/UpdateUserTaskServlet" id="AddTaskForm" method="POST">
<input type ="hidden" value="${param.User}" name="User">
Date<input type="date" name="Date" value="${param.Date}">
AddTask<input type ="text" name="Tasks" value="${param.Tasks}">
StartTime<input type ="time" name="StartTime" value="${param.StartTime}">
EndTime<input type ="time" name="EndTime" value="${param.EndTime}">
<input type ="hidden" value="${param.Id}" name="Id">
<input type ="hidden" value="${param.NavInput}" name="NavInput">
<input type ="hidden" value="${param.Desig}" name="Desig">
<input type="submit">
</form>
</div>
</body>
</html>