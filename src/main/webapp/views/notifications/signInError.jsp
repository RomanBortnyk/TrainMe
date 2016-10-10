<%--
  Created by IntelliJ IDEA.
  User: romab
  Date: 10/1/16
  Time: 7:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Invalid Login</title>
</head>
<body>

 <div>
     <%
         String message ="";
        if ( request.getAttribute("incorrectPass")!=null) message = "Password incorect";
         if (request.getAttribute("unexistLogin") != null) message = "Login does not exist";

     %>


     Error:  <%= message%>
        <br>
     <a href="index.html">Back to the main page</a>


 </div>

</body>
</html>
