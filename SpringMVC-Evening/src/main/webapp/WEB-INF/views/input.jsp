<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>MVC input!!</title>
	<style>
		
		.form-inline {
			margin-left:20%;
			margin-top: 2%;
			font-Size: 25px;
			}
		
		.button {
		    background-color: #4CAF50; /* Green */
		    border: none;
		    color: white;
		    padding: 15px 32px;
		    text-align: center;
		    text-decoration: none;
		    display: inline-block;
		    font-size: 16px;
		    cursor: pointer;
		}
	
		.op{
			
			font-Size: 25px;
			width: 250px;
		}
	</style>

</head>
<body>
    <p><font color="red">${errorMessage}</font></p>
    <form action="/spring-mvc/input" method="POST" class="form-inline">
        <strong >Enter First Number: </strong><br><input class = "op" name="firstNum" type="text" />
         <br><br><br>
       <strong> Enter Second Number:</strong><br><input class = "op" name="secondNum" type="text" />
        <br> <br><br>
        <label><strong> Operation : </strong><br></label>
          
 		<select class = "op" name="operator" id="operator">
            <option  value="" selected>Apply Operator</option>
            <option name="ADD" value="ADD">+</option>
            <option name="SUBSTRACT" value="SUBSTRACT">-</option>
            <option name="MULTIPLY" value="MULTIPLY">*</option>
            <option name="DIVIDE" value="DIVIDE">/</option>
    	</select>                
         <br><br>                       
        <input type="submit" value = "Evaluate" class = "button" />
    </form>
</body>
</html>