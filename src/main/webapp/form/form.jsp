<%@page contentType="text/html" pageEncoding="utf-8" trimDirectiveWhitespaces="true" %>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>form</title>
</head>

<body>

<form action="./save">

    <label>id: <input name="id" value="123" /></label></br>
    <label>name: <input name="name" value="jetbrick" /></label></br>
    <label>birthday: <input name="birthday" value="1990-01-02" /></label></br>
    <label>hobbies: 
        <input type="checkbox" name="hobbies" value="AA" checked /> AA
        <input type="checkbox" name="hobbies" value="BB" /> BB
        <input type="checkbox" name="hobbies" value="CC" checked /> CC
    </label></br>

    <input type="submit" name="Submit" />
</form>

</body>
</html>