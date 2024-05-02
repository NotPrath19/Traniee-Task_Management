<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.yash.Eventelion.model.User"%>
    <%@ page import="com.yash.Eventelion.model.Task"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="UserProfile" value="${sessionScope.UserProfile}" />
	<c:set var="taskList" value="${sessionScope.taskList}" />
<c:choose>	
<c:when test="${Desig eq 'User' }">
<p>User Profile</p>
<table id="ProfileTaskdisplay">
		
			
			<tr><th>UserName</th>	<td>${UserProfile.userName}</td></tr>
			<tr><th>Email</th>      <td>${UserProfile.email}</td></tr>
 			<tr><th>MobileNo</th>   <td>${UserProfile.mobileNo}</td></tr>			
			<tr><th>Designation</th> <td>${UserProfile.designation}</td></tr>
				
			
		

				
		
	</table><br>
	<p>Today's Tasks</p>
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
			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="obj" items="${taskList}">
				<c:choose>	
					<c:when test="${not empty obj.userName}">
						<tr>
							<td>${obj.userName}</td>
							<td>${obj.date}</td>
							<td>${obj.tasks}</td>
							<td>${obj.startTime}</td>
							<td>${obj.endTime}</td>
							
						</tr>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</tbody>
	</table>
	</c:when>
	<c:otherwise>
	<br><c:out value="No Tasks Free Today"/>
	</c:otherwise>
	</c:choose>
	</c:when>
	<c:when test="${Desig eq 'Admin' }">
<p>User Profile</p>
<table id="ProfileTaskdisplay">
		
			
			<tr><th>UserName</th>	<td>${UserProfile.userName}</td></tr>
			<tr><th>Email</th>      <td>${UserProfile.email}</td></tr>
 			<tr><th>MobileNo</th>   <td>${UserProfile.mobileNo}</td></tr>			
			<tr><th>Designation</th> <td>${UserProfile.designation}</td></tr>
				
			
		

				
		
	</table><br>
	<p>Today's Tasks</p>
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
			    <th>Reminder</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="obj" items="${taskList}">
				<c:choose>
					<c:when test="${not empty obj.userName}">
						<tr>
							<td>${obj.userName}</td>
							<td>${obj.date}</td>
							<td>${obj.tasks}</td>
							<td>${obj.startTime}</td>
							<td>${obj.endTime}</td>
							<td>	
							<form action="${pageContext.request.contextPath}/SendReminderServlet"method="post">
									<input type="hidden" value="${obj.userName}" name="UserName">
									<input type="hidden" value="${obj.tasks}" name="Task">
									<input type="hidden" value="${obj.endTime}" name="EndTime">
									<input type="hidden" value="${param.Desig}" name="Desig">
									<input type="hidden" value="${param.NavInput }" name="NavInput">
									<input type="submit" value="SendReminder">
								</form></td>
						</tr>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</tbody>
	</table>
	</c:when>
	<c:otherwise>
	<br><c:out value="No Tasks Free Today"/>
	</c:otherwise>
	</c:choose>
	</c:when>
	<c:otherwise>
	</c:otherwise>
	</c:choose>
</body>
</html>