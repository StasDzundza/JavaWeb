<%--
  Created by IntelliJ IDEA.
  User: STAS
  Date: 3/21/2020
  Time: 10:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ERROR</title>
</head>
<body>
<jsp:include page="index.jsp"/>
<h1>SOMETHING WAS WRONG!!!</h1>
<h1>Error message : <%=request.getParameter("error")%></h1>
</body>
</html>