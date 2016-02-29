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
    <input type="file" name="file" id="file" accept="image/jpeg,image/png,image/gif,image/jpg"/>
    <input type="submit" value="Submit" name="upload" id="upload"/>
</form>
<h1 align="center">Image gallery</h1>
<br/>
<c:forEach var="img" items="${fileList}">
    <img src="hello/img?name=${img}" width="30%" height="30%" border="10%">
</c:forEach>
</body>
</html>
