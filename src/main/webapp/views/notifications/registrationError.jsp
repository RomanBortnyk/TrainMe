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
    <meta charset="UTF-8">
    <title>Error</title>
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/errors.css">
  </head>

  <body>
    <div class="wrapper">
      <form class="form-signin">       
        <h3>login "<%=request.getParameter("login")%>" or email "<%=request.getParameter("email")%>" already taken
          <br>
          try another values and try again
        </h3>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><a href="../views/registration.html">Back to registration page</a></button>   
      </form>
    </div>
  </body>
  </html>
