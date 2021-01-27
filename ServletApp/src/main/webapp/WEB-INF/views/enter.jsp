<html>
<head>
<title>Calculator</title>
</head>
<body>
    
    <form action="/calculator/enter" method="POST">
        Enter 1st number : <input type="text" name="input1"  />
        Enter 2nd number : <input type="text" name="input2"  />
        Select Operation : <select name="operation">
                      <option value="add">Add</option>
                      <option value="sub">Subtract</option>
                      <option value="multiply">Multiply</option>
                      <option value="div">Divide</option>
                    </select>
        <input type="submit" />
    </form>
</body>
</html>