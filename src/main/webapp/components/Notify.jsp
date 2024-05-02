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

<form action ="${pageContext.request.contextPath}/NotifyServlet" id="AddTaskForm" method="POST">
<input type ="hidden" value="${param.UserName}" name="UserName">
<input type ="hidden" name="Subject" value="${param.Tasks} submitted at ${param.SubmittedAt}" >
FeedBack:<br><br><input type ="text" name="Body" value="${param.Tasks} ,submitted at ${param.SubmittedAt} , has been Reviewed" id="Feedback" >
<input type ="hidden" value="${param.Id}" name="Id">
<input type ="hidden" value="${param.NavInput}" name="NavInput">
<input type ="hidden" value="${param.Desig}" name="Desig"><br>
<input type="submit" value="Mail">
</form>
</div>
</body>
</html>