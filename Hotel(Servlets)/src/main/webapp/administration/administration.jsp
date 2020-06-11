<%--
  Created by IntelliJ IDEA.
  User: STAS
  Date: 3/1/2020
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>For Administration</title>
</head>
<body>
    <jsp:include page="../index.jsp" />
    <hr>
    <ul>
        <form action="${pageContext.request.contextPath}/../allPersonnel" method="post">
            <input type="submit" value="Show all personnel">
        </form>
        <form action="${pageContext.request.contextPath}/../allRooms" method="post">
            <input type="submit" value="Show all rooms in hotel">
        </form>
        <form action="${pageContext.request.contextPath}/../allOrders" method="post">
            <input type="submit" value="Show all orders">
        </form>
        <li>Add new Worker</li>
        <form action="${pageContext.request.contextPath}/../addingWorker" method="post">
            First name : <input type="text" name="firstName">
            Last name : <input type="text" name="lastName">
            Age : <input type="number" name="age" min="18" max="70">
            <select name="role">
                <option value="cleaner">Cleaner</option>
                <option value="administrator">Administrator</option>
                <option value="cook">Cook</option>
            </select>
            Salary : <input type="number" name="salary" min="1" max="100000">
            Phone : <input type="text" name="phone">
            <input type="submit" value="Add Worker">
        </form>
        <li>Dismiss Worker</li>
        <form action="${pageContext.request.contextPath}/../dismissingWorker" method="post">
            Worker ID : <input type="number" name="id" min="1">
            <input type="submit" value="Dismiss">
        </form>
        <li>Update Salary</li>
        <form action="${pageContext.request.contextPath}/../changingSalary" method="post">
            Worker ID : <input type="number" name="id" min="1">
            New Salary : <input type="number" name="salary" min="1">
            <input type="submit" value="Update">
        </form>
        <li>Add new Room</li>
        <form action="${pageContext.request.contextPath}/../addRoom" method="post">
            Number : <input type="number" name="num">
            Floor : <input type="number" name="floor">
            Price for night : <input type="number" name="price" min="1" value="0">
            Category :
            <select name="category">
                <option value="economic">economic</option>
                <option value="standard">standard</option>
                <option value="luxury">luxury</option>
            </select>
            Occupancy : <input type="number" name="occupancy" value="1" min="1" max="4">
            <input type="submit" value="Add Room">
        </form>
    </ul>
    <jsp:include page="../footer.jsp" />
</body>
</html>
