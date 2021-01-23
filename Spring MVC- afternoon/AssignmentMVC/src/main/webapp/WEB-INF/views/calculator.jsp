<html>
<head>
<title>Yahoo!!</title>
</head>
<body>
    <p><font color="red">${errorMessage}</font></p>
    <form action="/spring-mvc/calculator" method="POST">
        Name : <input name="firstNum" type="text" />
        Password : <input name="secondNum" type="text" /> 
        Operation : <select name="operation">
            <option value="addition">Addition</option>
            <option value="substraction">Substraction</option>
            <option value="multiply">Multiply</option>
            <option value="divide">Divide</option>
        </select>
        <input type="submit" />
    </form>
</body>
</html>