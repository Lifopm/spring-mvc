<%@ page import="web.model.User" %>
<%@ page import="java.util.List" %><%--
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

<h3>Users</h3>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>year</th>
        <th>password</th>
        <th>roles</th>
    </tr>

    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.password}</td>
            <c:forEach var="role" items="${user.roles}">
                <td>${role.role}</td>
            </c:forEach>
            <td>
                <a href="/edit/${user.id}">edit</a>
                <a href="/delete/${user.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h3>Add</h3>
<c:url value="/add" var="add"/>
<a href="${add}">Add new user</a>
</body>
</html>
