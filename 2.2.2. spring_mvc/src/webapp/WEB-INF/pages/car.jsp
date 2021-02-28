<%--
  Created by IntelliJ IDEA.
  User: Nikaria
  Date: 2/23/2021
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div>
    <th:block th:each="car : ${cars}">
        <h2> Color </h2> <h1 th:text="${car.getColor()}"></h1>
        <h2> Model </h2> <h1 th:text="${car.getModel()}"></h1>
        <h2> Series</h2> <h1 th:text="${car.getSeries()}"></h1>
    </th:block>
</div>
</body>
</html>
