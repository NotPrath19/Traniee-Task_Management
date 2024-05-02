<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.yash.Eventelion.model.Task"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="taskList" value="${sessionScope.taskList}" />
	<span>Schedule</span><br>
<c:choose>
	<c:when test="${not empty taskList}">
	<table id="ProfileTaskdisplay">
		<thead>
			<tr>
				<th>UserName</th>
				<th>Date</th>
				<th>Tasks</th>
				<th>StartTime</th>
				<th>EndTime</th>
				<th>Submit</th>
				<th>Update</th>
				<th>Remove</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="obj" items="${taskList}">
				<tr>
					<td>${obj.userName}</td> 
					<td>${obj.date}</td>
					<td>${obj.tasks}</td>
					<td>${obj.startTime}</td>
					<td>${obj.endTime}</td>
							<td><form
							action="${pageContext.request.contextPath}/SubmitTaskServlet"
							method="post">
							<input type="hidden" value="${obj.id}" name="Id"> <input
								type="hidden" value="${param.User}" name="User"> <input
								type="hidden" value="${param.Desig}" name="Desig"> <input
							type="submit" value="Submit">
						</form></td>
					<td>
					
						<form action="components/./DashBoardMain.jsp" method="post">
							<input type="hidden" value="${obj.id}" name="Id"> 
							<input type="hidden" value="${obj.date}" name="Date"> 
							<input type="hidden" value="${obj.tasks}" name="Tasks"> 
							<input type="hidden" value="${obj.startTime}" name="StartTime"> 
							<input type="hidden" value="${obj.endTime}" name="EndTime"> <input
								type="hidden" value="${param.User}" name="User"> <input
								type="hidden" value="${param.Desig}" name="Desig"> <input
								type="hidden" value="UpdateUser" name="NavInput">  <input
								type="submit" value="Update">
						</form>
					</td>
					<td><form
							action="${pageContext.request.contextPath}/DeleteTaskServlet"
							method="post">
							<input type="hidden" value="${obj.id}" name="Id"> <input
								type="hidden" value="${param.User}" name="User"> <input
								type="hidden" value="${param.Desig}" name="Desig"> <input
							type="submit" value="Remove">
						</form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:when>
<c:otherwise>
<br><c:out value="Enjoy your freedom it's fleeting"/>
</c:otherwise>
</c:choose>
</body>
</html>