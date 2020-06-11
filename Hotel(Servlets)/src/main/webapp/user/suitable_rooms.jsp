<%@ page import="java.util.ArrayList" %>
<%@ page import="Hotel.Room" %><%--
  Created by IntelliJ IDEA.
  User: STAS
  Date: 3/21/2020
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%ArrayList roomList = (ArrayList)request.getAttribute("rooms");%>
<html>
<head>
    <title>Rooms</title>
</head>
<body>
<!--TODO
    add sorting rooms by smth
-->
<jsp:include page="../index.jsp" />
<hr>
<h2>Suitable rooms</h2>
<table>
    <tr>
        <td>Room</td>
        <td>Floor</td>
        <td>Price per night</td>
        <td>Category</td>
        <td>Occupancy</td>
    </tr>
    <hr>
    <% for(int i = 0; i < roomList.size(); i++){%>
    <tr>
        <% Room room = (Room)roomList.get(i);%>
        <td><%= room.getNum()%></td>
        <td><%= room.getFloor()%></td>
        <td><%= room.getPrice()%></td>
        <td><%= room.getCategory()%></td>
        <td><%= room.getOccupancy()%></td>
        <td>
            <form action="user/finish_reserve.jsp?room=<%= room.getNum()%>&price=<%= room.getPrice()%>" method="POST">
                <input type="submit" value="Reserve" >
            </form>
        </td>
    </tr>
    <%}%>
</table>
<jsp:include page="../footer.jsp" />
</body>
</html>
