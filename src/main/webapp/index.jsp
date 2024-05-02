<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eventelion</title>
<link rel="stylesheet" href="css/index.css">
 <script src="js/index.js"></script>
</head>
<body>
<div id="container">
<div id="Header">
<jsp:include page="components/Header.jsp" />  
</div>
<div id="NavigationBar">
<jsp:include page="components/NavigationBar.jsp" />
</div>
<div id="Main">
<jsp:include page="components/Main.jsp" />
</div>
<div id="footer">
<jsp:include page="components/Footer.jsp" /> 
</div>
</div>
</body>
</html>