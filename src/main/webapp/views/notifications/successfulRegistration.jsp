<%--
  Created by IntelliJ IDEA.
  User: romab
  Date: 10/4/16
  Time: 12:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>

    User <%=request.getParameter("firstName")%> <%=request.getParameter("lastName")%> was successfully created
    <a href="index.html">Now you can sign in</a>

</body>
</html>
