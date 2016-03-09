<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add user</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
</head>
<body>
<div id="root">
    <form:form action="add" method="post" modelAttribute="user">
        <div class="inputDiv">
            <div class="text"><label>First name:</label></div>
            <form:input class="bigInput" path="firstName" required="true" maxlength="100"
                        pattern="[a-zA-Z?-??-?\s-]*"
                        title="Enter the first name using russian or english letters. Allowed to use a hyphen and a space"/>
        </div>
        <div class="inputDiv">
            <div class="text"><label>Last name:</label></div>
            <form:input class="bigInput" path="lastName" required="true" maxlength="100" pattern="[a-zA-Z?-??-?\s-]*"
                        title="Enter the last name using russian or english letters. Allowed to use a hyphen and a space"/>
        </div>
        <div class="inputDiv">
            <div class="text"><label>Email:</label></div>
            <form:input class="bigInput" type="email" path="email" required="true"/>
        </div>
        <div class="inputDiv">
            <div class="text"><label>Age:</label></div>
            <form:input class="smallInput" type="number" path="age" required="true" min="1" max="150"/>
        </div>

        <div class="inputDiv">
            <div class="text"><label> Role:</label></div>
            <form:select class="smallInput select" path="role" required="true" >
                <form:option class="grey" value="" selected="true" disabled="true" hidden="true" label="Select role..."/>
                <c:forEach items="${roles}" var="role">
                <form:option value="${role}" label="${role.displayName}"/>
                </c:forEach>
            </form:select>
        </div>
        <div class="inputDiv" id="submit">
            <input class="button"  type="submit" value="Add">
        </div>
    </form:form>
</div>
</body>
</html>