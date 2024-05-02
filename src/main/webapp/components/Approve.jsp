<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.yash.Eventelion.model.Approval"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Approval Display</title>
</head>
<body>
	<c:set var="userList" value="${sessionScope.userList}" />
	<table id="ProfileTaskdisplay">
		<thead>
			<tr>
				<th>UserName</th>
				<th>Email</th>
				<th>MobileNo</th>
				<th>Designation</th>
				<th>Approve</th>
				<th>Deny</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="obj" items="${userList}">
				<tr>
					<td>${obj.userName}</td>
					<td>${obj.email}</td>
					<td>${obj.mobileNo}</td>
					<td>${obj.designation}</td>
					<td><form
							action="${pageContext.request.contextPath}/GrantApprovalServlet"
							method="post">
							<input type="hidden" value="${obj.id}" name="Id"> <input
								type="hidden" value="${param.User}" name="User"> <input
								type="hidden" value="${param.Desig}" name="Desig"> <input
								type="submit" value="Approve">
						</form></td>
					<td><form
							action="${pageContext.request.contextPath}//RevokeApprovalServlet"
							method="post">
							<input type="hidden" value="${obj.id}" name="Id"> <input
								type="hidden" value="${param.User}" name="User"> <input
								type="hidden" value="${param.Desig}" name="Desig"> <input
								type="submit" value="Deny">
						</form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:redirect url="./UserDashBoard.jsp">
		<c:param name="NavInput" value="${param.NavInput}" />
		<c:param name="User" value="${param.User}" />
		<c:param name="Desig" value="${param.Desig}" />
	</c:redirect>
</body>
</html>