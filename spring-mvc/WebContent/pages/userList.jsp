<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
    <title>Users</title>
</head>
<body>
<div class="add">
    <a class="href" href="add">Add user</a>
</div>
<c:if test="${users.size()!=0}">
    <div class="table">
        <table align="center" border="2" title="Users">
            <thead align="center">
            <tr>
                <td>Id</td>
                <td>Email</td>
                <td>FirstName</td>
                <td>LastName</td>
                <td>Age</td>
                <td>Role</td>
                <td colspan="2">Action</td>
            </tr>
            </thead>
            <c:forEach var="user" items="${users}">
                <tr>
                    <form:form modelAttribute="user" method="post" action="update">
                        <td><form:input path="id" value="${user.id}" disabled="true" required="true"/></td>
                        <td><form:input path="firstName" value="${user.firstName}" required="true" maxlength="100"
                                        pattern="[a-zA-Z?-??-?\s-]*"
                                        title="Enter the first name using russian or english letters. Allowed to use a hyphen and a space"/></td>
                        <td><form:input path="lastName" value="${user.lastName}" required="true" maxlength="100"
                                        pattern="[a-zA-Z?-??-?\s-]*"
                                        title="Enter the last name using russian or english letters. Allowed to use a hyphen and a space"/></td>
                        <td><form:input path="email" value="${user.email}" required="true" type="email"/></td>
                        <td><form:input path="age" value="${user.age}" required="true" type="number" min="1"
                                        max="150"/></td>
                        <td><form:select path="role" required="true">
                            <c:forEach items="${roles}" var="role">
                                <option value="${role}" label="${role.displayName}"
                                    ${role == user.role ? 'selected' : ''}></option>
                            </c:forEach>
                        </form:select></td>
                        <td>
                            <input type="submit" value="Update"/>
                        </td>
                    </form:form>
                    <td>
                        <form action="delete">
                            <input type="hidden" name="id" value="${user.id}"/>
                            <input type="submit" value="Delete"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>
</body>
</html>