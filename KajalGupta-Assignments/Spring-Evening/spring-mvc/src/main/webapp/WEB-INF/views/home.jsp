<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Spring MVC Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</head>

<body>
    <br><br>
    <div class="jumbotron text-center">
        <h1>Spring MVC Assignment</h1>
    <br><br>
    </div>
    <p><font color="red">${errorMessage}</font></p>

    <div class="container col-md-4 col-md-offset-4">
        <form class="container" action="/home" method="POST">
            <strong>First Number: </strong><input class="form-control" name="firstNum" type="text" />
            <br><br>
            <strong> Second Number :</strong> <input class="form-control" name="secondNum" type="text" />
            <br> <br>
            <label><strong> Operation : </strong></label>
            <select class="form-select" aria-label="Default select example" name="operator" id="operator">
                <option  value="" selected>Select Operation</option>
                <option name="ADD" value="ADD">Add</option>
                <option name="SUBSTRACT" value="SUBSTRACT">Subtract</option>
                <option name="MULTIPLY" value="MULTIPLY">Multiply</option>
                <option name="DIVIDE" value="DIVIDE">Divide</option>
            </select>
            <br><br>
            <div class="text-center">
                <input class="btn btn-primary" type="submit" value="Submit" />
            </div>
        </form>
    </div>
</body>
</html>