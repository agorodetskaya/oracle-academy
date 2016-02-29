<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users</title>
</head>
<body>
<form action="add">
    <button name="newUser">New user</button>
</form>
<table align="center" border="2" title="Users">
    <thead align="center">
    <tr>
        <td>Id</td>
        <td>Email</td>
        <td>FirstName</td>
        <td>LastName</td>
        <td>Role</td>
        <td>Action</td>
    </tr>
    </thead>
    <colgroup align="center">
        <c:forEach var="user" items="users">
            <tr>
                <td>${user.getId}</td>
                <td>${user.getEmail}</td>
                <td>${user.getFirstName}</td>
                <td>${user.getLastName}</td>
                <td>${user.getRole}</td>
                <td>
                    <form action="update"/>
                </td>
            </tr>
        </c:forEach>
    </colgroup>
</table>
</body>
</html>