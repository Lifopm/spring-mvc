<%--
  Created by IntelliJ IDEA.
  User: Nikaria
  Date: 2/17/2021
  Time: 8:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>jsp page WEB-INF</h1>
<form:form action="/logout" method="POST">
    <input type="submit" value="Logout"/>
</form:form>

<c:url value="/edit" var="var"/>
<form action="${var}" method="POST">
    <input type="hidden" name="id" value="${user.id}">

    <label for="name">Name</label>
    <input type="text" name="name" id="name">

    <label for="age">Age</label>
    <input type="text" name="age" id="age">

    <label for="password">Password</label>
    <input type="text" name="password" id="password">

    <label for="users_roles">Users_roles</label>
    <input type="text" name="users_roles" id="users_roles">

    <input type="submit" value="Edit user">
</form>

</body>
</html>
