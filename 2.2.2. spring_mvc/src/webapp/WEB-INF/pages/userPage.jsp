<html xmlns:th="http://www.thymeleaf.org">
<%--
  Created by IntelliJ IDEA.
  User: Nikaria
  Date: 3/14/2021
  Time: 8:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form th:action="@{/logout}" method="POST">
    <input type="submit" value="Logout"/>
</form>

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
        <td>${user.roles}</td>

    </tr>

</table>

</body>
</html>
