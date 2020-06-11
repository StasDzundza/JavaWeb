<%@ page import="Hotel.Worker" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: STAS
  Date: 3/1/2020
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%ArrayList workerList = (ArrayList)request.getAttribute("workers");%>
<html>
<head>
    <title>Personnel</title>
</head>
<body>
    <jsp:include page="../index.jsp" />
    <hr>
    <h2>Information about all personnel</h2>
    <table>
        <tr>
            <td>ID</td>
            <td>FirstName</td>
            <td>LastName</td>
            <td>Age</td>
            <td>Role</td>
            <td>Salary</td>
        </tr>
        <hr>
        <% for(int i = 0; i < workerList.size(); i++){%>
        <tr>
            <% Worker w = (Worker)workerList.get(i);%>
            <td><%= w.getId()%></td>
            <td><%= w.getFirstName()%></td>
            <td><%= w.getLastName()%></td>
            <td><%= w.getAge()%></td>
            <td><%= w.getRole()%></td>
            <td><%= w.getSalary()%></td>
        </tr>
        <%}%>
    </table>
    <jsp:include page="../footer.jsp" />
</body>
</html>
