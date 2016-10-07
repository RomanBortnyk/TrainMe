<%--
  Created by IntelliJ IDEA.
  User: romab
  Date: 10/3/16
  Time: 11:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>

    login "<%=request.getParameter("login")%>" or email "<%=request.getParameter("email")%>" already taken
    <br>
    try another values and try again
    <br>
    <a href="../views/registration.html">Back to registration page</a>


</body>
</html>
