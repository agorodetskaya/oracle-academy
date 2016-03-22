<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
    <title>Users</title>
</head>
<body>
<div class="add">
    <a class="href" href="add">Add user</a>
</div>
<c:choose>
    <c:when test="${users.size()!=0}">
        <div>
            <table class="table-users" align="center" title="Users">
                <thead align="center">
                <tr>
                    <td class="thead-users">Id</td>
                    <td class="thead-users">FirstName</td>
                    <td class="thead-users">LastName</td>
                    <td class="thead-users">Email</td>
                    <td class="thead-users">Age</td>
                    <td class="thead-users">Role</td>
                    <td class="thead-users" colspan="2">Action</td>
                </tr>
                </thead>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <form:form modelAttribute="user" method="post" action="update">
                            <td class="tr-users"><form:input class="input input-id" path="id" value="${user.id}"
                                                             readonly="true" required="true"/></td>
                            <td class="tr-users"><form:input class="input" path="firstName" value="${user.firstName}"
                                                             required="true" maxlength="100"/></td>
                            <td class="tr-users"><form:input class="input" path="lastName" value="${user.lastName}"
                                                             required="true" maxlength="100"/></td>
                            <td class="tr-users"><form:input class="input" path="email" value="${user.email}"
                                                             required="true" type="email"/></td>
                            <td class="tr-users"><form:input class="input" path="age" value="${user.age}"
                                                             required="true" type="number" min="1"
                                                             max="150"/></td>
                            <td class="tr-users"><form:select class="input" path="role" required="true">
                                <c:forEach items="${roles}" var="role">
                                    <option value="${role}" label="${role.displayName}"
                                        ${role == user.role ? 'selected' : ''}></option>
                                </c:forEach>
                            </form:select></td>
                            <td class="tr-users">
                                <input class="input submit" type="submit" value="Update"/>
                            </td>
                        </form:form>
                        <td class="tr-users">
                            <form action="delete">
                                <input type="hidden" name="id" value="${user.id}"/>
                                <input class="input submit" type="submit" value="Delete"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:when>
    <c:otherwise>
        <p class="empty-list" align="center">List is empty. Please add a new user.</p>
    </c:otherwise>
</c:choose>
</body>
</html>