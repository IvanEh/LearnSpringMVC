<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form method="post" action="/user/new">
        <label>name</label><input type="text" name="name"><br/>
        <label>age</label><input type="range" name="age" min=16 max=99 value=18 step=1><br/>
        <input type="submit">
    </form>
    <hr/>
    ${date}
</body>
</html>