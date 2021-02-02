<html>
<head>
<title>Calculator</title>
<style>
body {
    display: flex;
    flex-direction: column;
    height: 100vh;
    justify-content: center;
    align-items: center;
}

input , select {
    display: block;
    margin: 10px;
}

.button{
margin:20px auto;
}
</style>
</head>
<body>
    <form action="/" method="POST">
        Enter a : <input required name="a" type="text" />
        Enter b : <input required name="b" type="text" />
        Operation :
          <select name="opr">
            <option value="add">Add</option>
            <option value="sub">Sub</option>
            <option value="mul">Mul</option>
            <option value="div">Div</option>
          </select>
        <input class="button" type="submit" />
    </form>
</body>
</html>