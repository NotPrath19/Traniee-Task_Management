
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.yash.Eventelion.model.Task"%><%@ page
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/SearchTaskDisplayServlet" method="post" id="searchb">
		<input type="hidden" value="${param.User}" name="User"> <input
			type="hidden" value="${param.Desig}" name="Desig">
			<input type="search" name="Search">
			<input type="submit" value="Search" id="sb">
	</form>
	<span>Schedule</span><br>
	<c:set var="taskList" value="${sessionScope.taskList}" />
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
				<th>Update</th>
				<th>Remove</th>
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
								<form
									action="${pageContext.request.contextPath}/GetUserListForAdminUpdateServlet"
									method="post">
									<input type="hidden" value="${obj.userName}" name="UserName">
									<input type="hidden" value="${obj.id}" name="Id"> <input
										type="hidden" value="${obj.date}" name="Date"> <input
										type="hidden" value="${obj.tasks}" name="Tasks"> <input
										type="hidden" value="${obj.startTime}" name="StartTime">
									<input type="hidden" value="${obj.endTime}" name="EndTime">
									<input type="hidden" value="${param.User}" name="User">
									<input type="hidden" value="${param.Desig}" name="Desig">
									<input type="hidden" value="UpdateAdmin" name="NavInput">
									<input type="submit" value="Update">
								</form>
							</td>
							<td><form
									action="${pageContext.request.contextPath}/DeleteAdminTaskServlet"
									method="post">
									<input type="hidden" value="${obj.id}" name="Id"> <input
										type="hidden" value="${param.User}" name="User"> <input
										type="hidden" value="${param.Desig}" name="Desig"> <input
										type="submit" value="Remove">
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
<br><c:out value="They Got No Work,Give'em some!"/>
</c:otherwise>
</c:choose>
</body>
</body>
</html>