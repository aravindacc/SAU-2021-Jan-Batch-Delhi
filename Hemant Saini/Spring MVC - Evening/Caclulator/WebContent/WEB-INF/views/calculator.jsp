<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator</title>
</head>
<body>
    <h2>Calculator</h2>
    <form action="/spring-mvc/calculator" method="POST">
        First Number : <input name="firstNumber" type="text" placeholder="Enter firstNumber"/>
        <br>
        Second Number : <input name="secondNumber" type="text" placeholder="Enter secondNumber" />
        <br>
        Operations : <select name="operation">
			            <option value="+">Addition</option>
			            <option value="-">Subtraction</option>
			            <option value="*">Multiply</option>
			            <option value="/">Divide</option>
			        </select>
        <br>
        <input type="submit" />
    </form>
</body>
</html>