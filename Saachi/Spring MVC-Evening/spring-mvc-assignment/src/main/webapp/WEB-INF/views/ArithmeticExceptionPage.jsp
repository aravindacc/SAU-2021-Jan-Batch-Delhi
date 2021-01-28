<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
<h1> Divide by Zero Exception Occurred</h1>

Hi There, an error occurred: error code is <%=response.getStatus() %><br>
Please go to <a href="/spring-mvc-assignment/calculator.jsp">Calculator page</a>
<br><br>
<h1>${msg}</h1>
</body>
</html>