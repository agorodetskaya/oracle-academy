<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div align="center">
    <form method="post" action="" enctype="multipart/form-data" id="form">
        <label>Выберите картинку: </label>
        <input type="file" name="file" id="file" accept="image/jpeg,image/png,image/gif,image/jpg"/>
        <input type="submit" value="Подтвердить"/>
    </form>
</div>
<c:if test="${not empty fileList}">
    <h1 align="center">Галлерея:</h1>
    <c:forEach var="image" items="${fileList}">
        <p align="center"><img src="<c:url value="img?name=${image}"/>"/></p>
    </c:forEach>
</c:if>
</body>
</html>
