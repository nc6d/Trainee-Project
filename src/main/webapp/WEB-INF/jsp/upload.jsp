<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title> Upload file </title>
</head>
<body>
<h2> Upload file </h2>
<hr/>
<form method="POST" enctype="multipart/form-data" action="/upload">

    <p> File: <input type = "file" name = "file" /> </p>
    <p> <input type = "submit" value = "Upload" /> </p>

</form>

</body>
</html>