<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div id=top-container>
<a href="./index.jsp"><img  src="components/assets/./Logo.PNG" alt="Not Found" id=Logo ></a>
<h1 id="Title">Eventelion</h1>
<div id="Main-container">
<form action="components/./Main.jsp" method="post">
<input type="hidden" value="Login" name="HeaderInput">
<input type="submit" name="Login" value="Login" id =Loginheaderbutton>
</form>
<form action="components/./Main.jsp" method="post">
<input type="hidden" value="Register" name="HeaderInput">
<input type="submit" name="Register" value="Signup">
</form>
</div>
</div>
</body>
</html>