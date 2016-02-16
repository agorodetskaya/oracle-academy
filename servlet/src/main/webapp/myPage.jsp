<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Page</title>
</head>
<body>
<form method="post" action="hello" enctype="multipart/form-data" id="form">
    <p>Выберите картинку: </p>
    <input type="file" value="file" id="file" accept="image/*,image/jpeg,image/png,image/gif,image/jpg"/>
    <input type="submit" value="Submit" name="upload" id="upload"/>
</form>
<h1 align="center">Image gallery</h1>
<c:forEach items = ${fileList} var="img">
    <img src=${var}>
</c:forEach>
</body>
</html>
