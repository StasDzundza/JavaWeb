<%@ page import="java.util.ArrayList" %>
<%@ page import="Hotel.Room" %><%--
  Created by IntelliJ IDEA.
  User: STAS
  Date: 3/21/2020
  Time: 11:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%ArrayList rooms = (ArrayList)request.getAttribute("rooms");%>
<html>
<head>
    <title>Rooms</title>
</head>
<body>
<jsp:include page="../index.jsp" />
<hr>
<h2>Information about all personnel</h2>
<table>
    <tr>
        <td>Number</td>
        <td>Floor</td>
        <td>Price per night</td>
        <td>Category</td>
        <td>Occupancy</td>
    </tr>
    <hr>
    <% for(int i = 0; i < rooms.size(); i++){%>
    <tr>
        <% Room order = (Room)rooms.get(i);%>
        <td><%= order.getNum()%></td>
        <td><%= order.getFloor()%></td>
        <td><%= order.getPrice()%></td>
        <td><%= order.getCategory()%></td>
        <td><%= order.getOccupancy()%></td>
    </tr>
    <%}%>
</table>
<jsp:include page="../footer.jsp" />
</body>
</html>