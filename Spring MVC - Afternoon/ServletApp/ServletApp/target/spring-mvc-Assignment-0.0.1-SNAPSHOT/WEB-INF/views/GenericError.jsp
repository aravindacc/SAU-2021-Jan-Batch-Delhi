<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
        <!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Error Page</title>
</head>
<body>
    <h1>Input should not be blank and must be numeric!</h1>

    Hi There,an error occurred: error code is <%=response.getStatus() %><br>
    Please go to <a href="/spring-mvc-assignment/calculator.jsp">Calculator page</a>

</body>
</html>