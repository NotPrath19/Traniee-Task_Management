<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<div id="container">
 <div id ="log" class="box">
        <span id="LoginTitle">Login</span>
       <form action="${pageContext.request.contextPath}/UserLoginServlet" method="post">
      UserName:<input type="text" name="UserName"><br>
      Password:<input type="password" name="Password"><br>
            <div id= "unmatch">${param.unmatch}</div><br>
            <div class=buttons><input type="submit" name="Login" value="Login"></div>
        </form>
        </div>
</div>
 </body>
</html>
