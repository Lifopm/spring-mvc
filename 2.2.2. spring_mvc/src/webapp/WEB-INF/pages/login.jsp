<%--
  Created by IntelliJ IDEA.
  User: Nikaria
  Date: 3/14/2021
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form:form action="/logout" method="POST">
    <input type="submit" value="Logout"/>
</form:form>
</body>
</html>
