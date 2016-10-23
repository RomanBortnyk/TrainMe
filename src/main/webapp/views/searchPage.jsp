<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <title>Search</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../resources/css/bootstrap.min.css">
    <script src="../resources/js/jquery-3.1.1.min.js"></script>
    <script src="../resources/js/bootstrap.min.js"></script>
    <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
    <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
    <link href="../resources/css/userPage.css" rel="stylesheet">
    <link href="../resources/css/font-awesome.css" rel="stylesheet">
    <script type="text/javascript" src="../resources/js/searchPage.js"></script>

</head>
<body>
<%@ page isELIgnored="false" %>
<%@ include file="header.html" %>


    <div class="container">
        <div class="row">
            <h1 class="text-center" style="margin-top: 50px;">TrainMe Search</h1>
            <form action="/search" method="post">
                <div class="text-center toggle-grp">
                    <div class="toggle-sec1 text-center">
                        <input id="toggle-one" name="userTypeOption" data-on="coach" data-off="customer" checked type="checkbox">
                    </div>
                    <div class="toggle-sec2 text-center">
                        <input id="toggle-two" name="searchOption" data-on="by username" data-off="by discipline" checked type="checkbox">
                    </div>
                </div>
                <div class="col-lg-8 col-md-8 col-sm-8 col-lg-offset-2 col-md-offset-2 col-sm-offset-2">
                    <div class="input-group" style="height: 40px;">
                      <input name="searchString" type="text"  class="form-control" placeholder="Search" style="height: 40px;">
                      <span class="input-group-addon">
                          <i class="fa fa-search" aria-hidden="true"><input type="submit"></i>
                      </span>
                  </div>
              </div>
          </form>
      </div>
  </div>

  <div class="container">

      <c:forEach var="resultUser" items="${resultList}">
      <div class="row well result-section">
          <div class="col-lg-12 col-md-12 col-sm-12">
              <div class="col-lg-2 col-md-2 col-sm-3">
                  <%--<div class="avatar-result"></div>--%>
                      <img id="avatar" src="/image/avatar/${resultUser.getId()}"
                           width="140px" height="140px" class="img-circle" alt="Avatar">
              </div>
              <div class="col-lg-2 col-md-2 col-sm-3 name-result">
                  <p>${resultUser.getFirstName()}</p>
                  <p>${resultUser.getLastName()}</p>
                  <p>${resultUser.getUserType()}</p>
              </div>
              <div class="col-lg-6 col-md-6 col-sm-12 description-bkg">
                  <%--<p style="margin-bottom: 0;">${resultUser.getDescription()}</p>--%>
                  <pre style="border: none; background: none; margin-bottom: 0; padding: 0%">${resultUser.getDescription()}</pre>
              </div>
              <div class="col-lg-2 col-md-2 col-sm-12">
                  <div class="pull-right disciplines-result">
                      <div>
                          <i class="fa fa-futbol-o" aria-hidden="true"></i>
                          <p>discipline1</p>
                      </div>
                      <div>
                          <i class="fa fa-futbol-o" aria-hidden="true"></i>
                          <p>discipline2</p>
                      </div>
                      <div>
                          <i class="fa fa-futbol-o" aria-hidden="true"></i>
                          <p>discipline3</p>
                      </div>
                  </div>
              </div>
          </div>
      </div>
      </c:forEach>
  </div>

<%@include file="footer.html" %>

<script>
    $(function() {
        $('#toggle-one').bootstrapToggle();
        $('#toggle-two').bootstrapToggle();
    })
</script>
</body>
</html>

