<html xmlns:th="http://www.thymeleaf.org">
<%--
  Created by IntelliJ IDEA.
  User: Nikaria
  Date: 3/14/2021
  Time: 8:40 PM
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

<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>year</th>
        <th>password</th>
        <th>roles</th>
    </tr>

    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.age}</td>
        <td>${user.password}</td>
        <c:forEach var="role" items="${user.roles}">
            <td>${role.role}</td>
        </c:forEach>
    </tr>

</table>

</body>
</html>
