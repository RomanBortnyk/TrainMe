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
  	<link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
  	<link rel="stylesheet" href="../../resources/css/errors.css">
  </head>
  <body>
  	<div class="wrapper">
  		<form class="form-signin">       
  			<h3>User <%=request.getParameter("firstName")%> <%=request.getParameter("lastName")%> was successfully created</h3>
  			<button class="btn btn-lg btn-primary btn-block" type="submit"><a href="index.html">Now you can sign in</a></button>   
  		</form>
  	</div>
  </body>
  </html>
  </html>
