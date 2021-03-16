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

<form:form action="/logout" method="POST">
    <input type="submit" value="Logout"/>
</form:form>

<c:url value="/add" var="var"/>
<form action="${var}" method="POST">

    <label for="name">Name</label>
    <input type="text" name="name" id="name">

    <label for="age">Age</label>
    <input type="text" name="age" id="age">

    <label for="password">Password</label>
    <input type="text" name="password" id="password">

    <select multiple name="roleId" size="2" id="roleId">
        <option value="ROLE_ADMIN">ADMIN</option>
        <option value="ROLE_USER">USER</option>
    </select>

    <input type="submit" value="Add new user">
</form>

</body>
</html>
