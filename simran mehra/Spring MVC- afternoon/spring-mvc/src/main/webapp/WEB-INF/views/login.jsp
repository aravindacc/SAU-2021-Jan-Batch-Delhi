<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Spring MVC</title>
</head>
<body>
    <form action="/login" method="POST">
    <ul>
        <li><h2>Enter the first number : <input name="firstNum" type="text" /></h2></li>
         <br><br>
       <li><h2>Enter the second number : <input name="secondNum" type="text" /></h2></li>
        <br> <br>
        <li><h2><label>Choose the arithmetic operation : </label>  
 <select name="operator" id="operator">
            <option  value="" selected>Select</option>
            <option name="ADD" value="ADD">Add</option>
            <option name="SUBSTRACT" value="SUBSTRACT">Subtract</option>
            <option name="MULTIPLY" value="MULTIPLY">Multiply</option>
            <option name="DIVIDE" value="DIVIDE">Divide</option>
    </select></h2></li>
                
         <br><br>                       
        <input type="submit" />
    </ul>
    </form>
</body>
</html>