
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
	<c:choose>
		<c:when test="${Desig eq 'User' }">
			<span>Submission</span>
			<br>
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
								<th>SubmittedAt</th>
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
											<td>${obj.submittedAt}</td>
											<td>
												<!-- change servlet -->
												<form action="components/./DashBoardMain.jsp" method="post">
													<input type="hidden" value="${obj.id}" name="Id"> 
													<input type="hidden" value="${obj.userName}" name="UserName">
													<input type="hidden" value="${obj.tasks}" name="Tasks">
													<input type="hidden" value="${param.User}" name="User">
													<input type="hidden" value="${param.Desig}" name="Desig">
													<input type="hidden" value="UpdateSubmission" name="NavInput">
													<input type="submit" value="Update">
												</form>
											</td>
											<td><form
													action="${pageContext.request.contextPath}/DeleteSubmissionServlet"
													method="post">
													<input type="hidden" value="${obj.id}" name="Id"> <input
														type="hidden" value="${param.User}" name="User"> <input
														type="hidden" value="${param.Desig}" name="Desig">
													<input type="submit" value="Remove">
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
					<br>
					<c:out value="No submission yet" />
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:when test="${Desig eq 'Admin'}">
			<form
				action="${pageContext.request.contextPath}/SearchTaskDisplayServlet"
				method="post" id="searchb">
				<input type="hidden" value="${param.User}" name="User"> <input
					type="hidden" value="${param.Desig}" name="Desig"> <input
					type="search" name="Search"> <input type="submit"
					value="Search" id="sb">
			</form>
			<span>Submission</span>
			<br>
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
								<th>SubmittedAt</th>
								<th>Review</th>
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
											<td>${obj.submittedAt}</td>
											<td>
												<!-- change servlet -->
												<form action="components/./DashBoardMain.jsp" method="post">
													<input type="hidden" value="${obj.id}" name="Id"> <input
														type="hidden" value="${obj.userName}" name="UserName">
													<input type="hidden" value="${obj.tasks}" name="Tasks">
													<input type="hidden" value="${obj.submittedAt}"
														name="SubmittedAt"> <input type="hidden"
														value="${param.User}" name="User"> <input
														type="hidden" value="${param.Desig}" name="Desig">
													<input type="hidden" value="Notify" name="NavInput">
													<input type="submit" value="Review">
												</form>
											</td>
											<td><form
													action="${pageContext.request.contextPath}/DeleteSubmissionServlet"
													method="post">
													<input type="hidden" value="${obj.id}" name="Id"> <input
														type="hidden" value="${param.User}" name="User"> <input
														type="hidden" value="${param.Desig}" name="Desig">
													<input type="submit" value="Remove">
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
					<br>
					<c:out value="No submission yet" />
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
</body>
</body>
</html>