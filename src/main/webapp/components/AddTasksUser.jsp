<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="Add Task">
<span>Add Task</span><br>
<form action ="${pageContext.request.contextPath}/AddTaskUserServlet" id="AddTaskForm" method="POST">
<input type ="hidden" value="${param.User}" name="User">
Date<input type="date" name="Date"><br><br>
Task<input type ="text" name="Tasks"><br><br>
StartTime<input type ="time" name="StartTime"><br><br>
EndTime<input type ="time" name="EndTime"><br><br>
<input type ="hidden" value="${param.NavInput}" name="NavInput">
<input type ="hidden" value="${param.Desig}" name="Desig">
<input type="submit" value="AddTask">
</form>
</div>
</body>
</html>