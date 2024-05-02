<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
 <c:choose>
 <c:when test="${param.NavInput eq 'Profile'}">
  <jsp:include page="./Profile.jsp"/>
  <c:redirect url="../UserDashBoard.jsp">
  <c:param name="NavInput" value="${param.NavInput}"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
</c:when>             
 <c:when test="${param.NavInput eq 'ScheduleUser'}">
  <jsp:include page="./ScheduleUser.jsp"/>
  <c:redirect url="../UserDashBoard.jsp">
  <c:param name="NavInput" value="${param.NavInput}"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
</c:when>
 <c:when test="${param.NavInput eq 'ScheduleAdmin'}">
  <jsp:include page="./ScheduleAdmin.jsp"/>
  <c:redirect url="../UserDashBoard.jsp">
  <c:param name="NavInput" value="${param.NavInput}"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
</c:when>

<c:when test="${param.NavInput eq 'AddTaskUser'}">
  <jsp:include page="./AddTasksUser.jsp"/>
  <c:redirect url="../UserDashBoard.jsp">
  <c:param name="NavInput" value="${param.NavInput}"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
</c:when>
<c:when test="${param.NavInput eq 'AddTaskAdmin'}">
  <jsp:include page="./AddTaskAdmin.jsp"/>
  <c:redirect url="../UserDashBoard.jsp">
  <c:param name="NavInput" value="${param.NavInput}"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
</c:when>
<c:when test="${param.NavInput eq 'Approve'}">
  <jsp:include page="./Approve.jsp"/>
  <c:redirect url="../UserDashBoard.jsp">
  <c:param name="NavInput" value="${param.NavInput}"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
</c:when>
<c:when test="${param.NavInput eq 'Submissions'}">
  <jsp:include page="./Submission.jsp"/>
  <c:redirect url="../UserDashBoard.jsp">
  <c:param name="NavInput" value="${param.NavInput}"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
</c:when>
<c:when test="${param.NavInput eq 'UpdateSubmission'}">
  <jsp:include page="./UpdateSubmission.jsp"/>
  <c:redirect url="../UserDashBoard.jsp">
    <c:param name="Id" value="${param.Id}"/>
  <c:param name="UserName" value="${param.UserName}"/>
  <c:param name="Tasks" value="${param.Tasks}"/>
  <c:param name="NavInput" value="${param.NavInput}"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
</c:when>
<c:when test="${param.NavInput eq 'Notify'}">
  <jsp:include page="./Notify.jsp"/>
  <c:redirect url="../UserDashBoard.jsp">
  <c:param name="Id" value="${param.Id}"/>
  <c:param name="UserName" value="${param.UserName}"/>
  <c:param name="Tasks" value="${param.Tasks}"/>
  <c:param name="SubmittedAt" value="${param.SubmittedAt}"/>
  <c:param name="NavInput" value="${param.NavInput}"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
</c:when>
<c:when test="${param.NavInput eq 'UpdateUser'}">
  <jsp:include page="./UpdateUser.jsp"/>
  <c:redirect url="../UserDashBoard.jsp">
  <c:param name="Id" value="${param.Id}"/>
  <c:param name="Date" value="${param.Date}"/>
  <c:param name="Tasks" value="${param.Tasks}"/>
  <c:param name="StartTime" value="${param.StartTime}"/>
  <c:param name="EndTime" value="${param.EndTime}"/>
  <c:param name="NavInput" value="${param.NavInput}"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
</c:when>
<c:when test="${param.NavInput eq 'UpdateAdmin'}">
  <jsp:include page="./UpdateAdmin.jsp"/>
  <c:redirect url="../UserDashBoard.jsp">
  <c:param name="UserName" value="${param.UserName}"/>
  <c:param name="Id" value="${param.Id}"/>
  <c:param name="Date" value="${param.Date}"/>
  <c:param name="Tasks" value="${param.Tasks}"/>
  <c:param name="StartTime" value="${param.StartTime}"/>
  <c:param name="EndTime" value="${param.EndTime}"/>
  <c:param name="NavInput" value="${param.NavInput}"/>
  <c:param name="User" value="${param.User}"/>
  <c:param name="Desig" value="${param.Desig}"/>
  </c:redirect>
</c:when>
<c:otherwise>
<div id= "Home">
<c:out value="This is Website is developed to provide solution to"/><br><br>
<c:out value="all your personel and task management problems "/><br><br>
<c:out value="and it is developed by ~Prath19(UID-810438027)"/><br><br><br>
<img alt="" src="components/assets/./Logo.PNG" width="10%">
</div>
</c:otherwise>
 </c:choose>

</body>
</html>