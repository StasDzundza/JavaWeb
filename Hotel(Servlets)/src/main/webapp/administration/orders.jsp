<%@ page import="java.util.ArrayList" %>
<%@ page import="Hotel.Order" %><%--
  Created by IntelliJ IDEA.
  User: STAS
  Date: 3/21/2020
  Time: 11:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%ArrayList orders = (ArrayList)request.getAttribute("orders");%>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<jsp:include page="../index.jsp" />
<hr>
<h2>Information about reserved rooms</h2>
<table>
    <tr>
        <td>ID</td>
        <td>From</td>
        <td>To</td>
        <td>Room</td>
        <td>Client first name</td>
        <td>Client last name</td>
        <td>Active</td>
    </tr>
    <hr>
    <% for(int i = 0; i < orders.size(); i++){%>
    <tr>
        <% Order order = (Order)orders.get(i);%>
        <td><%= order.getId()%></td>
        <td><%= order.getDateFrom()%></td>
        <td><%= order.getDateTo()%></td>
        <td><%= order.getRoom()%></td>
        <td><%= order.getFirstName()%></td>
        <td><%= order.getLastName()%></td>
        <td><%= order.getStatus()%></td>
    </tr>
    <%}%>
</table>
<jsp:include page="../footer.jsp" />
</body>
</html>
