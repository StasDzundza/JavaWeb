<%--
  Created by IntelliJ IDEA.
  User: STAS
  Date: 3/1/2020
  Time: 11:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <jsp:include page="../index.jsp" />
    <hr>
    <h2>Only for administration</h2>
    <form action="../login" method="post">
        Admin's password : <input type="password" name="password">
        <input type="submit" value="Login">
    </form>
    <hr>
    <jsp:include page="../footer.jsp" />
</body>
</html>
