<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Calculator Application</title>
</head>
<body>
    <h1>-- My Simple Calculator --</h1>
    <p><font color="blue">${errorMessage}</font></p>
    <form action="/spring-mvc-assignment/calculator" method="POST">
        <strong>Enter First Number: </strong><input name="num1" type="text" placeholder="Enter input 1"/>
        <br><br>
        <strong>Enter Second Number :</strong><input name="num2" type="text" placeholder="Enter input 2"/>
        <br><br>
        <label><strong> Operation : </strong></label>  
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