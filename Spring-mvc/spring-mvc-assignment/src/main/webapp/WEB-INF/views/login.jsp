<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Yahoo!!</title>
</head>
<body>
    <p><font color="red">${errorMessage}</font></p>
    <form action="/spring-mvc/login" method="POST">
        <strong>FirstNumber: </strong><input name="firstNum" type="text" />
         <br><br>
       <strong> SecondNumber :</strong> <input name="secondNum" type="text" />
        <br> <br>
        <label><strong> Operation : </strong></label>  
 <select name="operator" id="operator">
            <option  value="" selected>Select Operation</option>
            <option name="ADD" value="ADD">+</option>
            <option name="SUBSTRACT" value="SUBSTRACT">-</option>
            <option name="MULTIPLY" value="MULTIPLY">*</option>
            <option name="DIVIDE" value="DIVIDE">/</option>
    </select>
                
         <br><br>                       
        <input type="submit" />
    </form>
</body>
</html>