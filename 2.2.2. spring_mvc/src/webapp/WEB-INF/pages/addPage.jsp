<%--
  Created by IntelliJ IDEA.
  User: Nikaria
  Date: 2/17/2021
  Time: 8:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:url value="/add" var="var"/>
<form action="${var}" method="POST">

    <label for="name">Name</label>
    <input type="text" name="name" id="name">

    <label for="age">Age</label>
    <input type="text" name="age" id="age">

    <label for="password">Password</label>
    <input type="text" name="password" id="password">

    <label for="users_roles">Users_roles</label>
    <input type="text" name="users_roles" id="users_roles">


    <sec:authentication property="principal.authorities"/>


    <input type="submit" value="Add new user">
</form>

</body>
</html>
