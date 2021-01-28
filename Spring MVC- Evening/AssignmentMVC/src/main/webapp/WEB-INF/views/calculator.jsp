<html>
<head>
<title>Welcome</title>
</head>
<body>
    <p><font color="red">${errorMessage}</font></p>
    <form action="/spring-mvc/calculator" method="POST">
        input1 : <input name="firstNumber" type="text" />
        input2 : <input name="secondNumber" type="text" />
        Operation : <select name="operation">
            <option value="add">Add</option>
            <option value="substract">Substract</option>
            <option value="multiply">Multiply</option>
            <option value="divide">Divide</option>
        </select>
        <input type="submit" />
    </form>
</body>
</html>