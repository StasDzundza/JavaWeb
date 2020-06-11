<%--
  Created by IntelliJ IDEA.
  User: STAS
  Date: 3/21/2020
  Time: 1:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personal info</title>
</head>
<body>
<jsp:include page="../index.jsp"/>
<hr>
<p>You are going to reserve room <%=request.getParameter("room")%> which costs <%=request.getParameter("price")%> $ per night</p>
<h2>Enter your personal info : </h2>

<form action="../reserveRoom?room=<%= request.getParameter("room")%>" method="post">
    First name : <input type="text" placeholder="First name..." name="firstName">
    Last name : <input type="text" placeholder="Last name..." name="lastName">
    <input type="submit" value="Reserve">
</form>
<hr>
<jsp:include page="../footer.jsp"/>
</body>
</html>
