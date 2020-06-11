<%--
  Created by IntelliJ IDEA.
  User: STAS
  Date: 3/3/2020
  Time: 1:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reserve</title>
</head>
<body>
<jsp:include page="../index.jsp"/>
<hr>
<form action="../findRoom" method="post">
    <h2>Price for night : </h2>
    From : <input type="number" name="minPrice" min="0" value="0">
    To : <input type="number" name="maxPrice" max="1000000" value="1000000">
    <br>
    <h2>Category : </h2>
    <input type="checkbox" name="categories" value="economic" checked> Economic
    <br>
    <input type="checkbox" name="categories" value="standard" checked> Standard
    <br>
    <input type="checkbox" name="categories" value="luxury" checked> Luxury
    <br>
    <h2>Occupancy : </h2>
    <input type="number" name="occupancy" value="1" min="1" max="4">
    <br>
    <h2>Dates : </h2>
    From : <input type="date" name="dateFrom">
    To : <input type="date" name="dateTo">
    <br>
    <input type="submit" value="Find Rooms">
</form>
<hr>
<jsp:include page="../footer.jsp"/>
</body>
</html>
