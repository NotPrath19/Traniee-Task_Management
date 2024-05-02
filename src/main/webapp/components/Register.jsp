<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
<link rel="stylesheet" href="signup.css">
</head>
<body>
<div id="container">
  <div id="sign" class="box">
        <span id="SignupTitle">Register</span>
        <div class=formDesign>
        <form action="${pageContext.request.contextPath}/UserRegisterationServlet" method="post">
        
     Designation:<select name="Designation" id="SelectUser">
                       <option value="User">User</option>
                       <option value="Admin">Admin</option>
                       </select><br>

      UserName:<input type="text" name="UserName"><br>

      Email:<input type="text" name="Email"><br>

     MobileNo:<input type="text" name="MobileNo"><br>

     Password:<input type="password" name="Password"><br>
     
     Confirm Password:<input type="password" name="ConfirmPassword"><br>

            
             <div id= "unmatch">${param.unmatch}</div><br>
          <div class=buttons>  <input type="Submit" name="Signup" value="Signup"></div>	
        </form>
        </div>
        </div>
</div>
</body>
</html>