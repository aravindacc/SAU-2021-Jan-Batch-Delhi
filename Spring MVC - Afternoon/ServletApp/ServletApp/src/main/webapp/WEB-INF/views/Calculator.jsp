<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Calculator</title>
</head>
<body>
    <h1>-- My Simple Calculator --</h1>
    <p><font color="red">${errorMessage}</font></p>
    <form action="/spring-mvc-assignment/calculator" method="POST">
        Enter First Number:<input name="num1" type="text" placeholder="Enter number 1"/>
        <br><br>
        Enter Second Number :<input name="num2" type="text" placeholder="Enter number 2"/>
        <br><br>
        Operation :<br><br>
        <select name="operator" id="operator">
            <option value="" selected>Select Operation</option>
            <option value="+">Addition</option>
            <option value="-">Subtraction</option>
            <option value="*">Multiply</option>
            <option value="/">Divide</option>
        </select>
        <br><br>
        <input type="submit" />
    </form>
</body>
</html>