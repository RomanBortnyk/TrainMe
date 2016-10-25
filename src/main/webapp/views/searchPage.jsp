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
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <script type="text/javascript" src="../resources/js/searchPage.js"></script>

</head>
<body>
<%@ page isELIgnored="false" %>
<%@ include file="header.html" %>

    <div class="container">
    <div class="row">
      <h1 class="text-center" style="margin-top: 50px;">TrainMe Search</h1>
      <form action="" method="">
        <div class="col-lg-8 col-md-8 col-sm-8 col-lg-offset-2 col-md-offset-2 col-sm-offset-2">

          <div class="input-group" style="height: 40px;">
            <input id="myInput1" type="text" class="form-control" placeholder="Search" style="height: 40px;">
            

            <div class="input-group-btn">
              <button id="btnSearch" type="button" class="btn btn-default" style="height: 40px;"><i class="fa fa-search" aria-hidden="true"></i></button>

              <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="height: 40px;"><span class="caret"></span></button>

              

              <div class="dropdown-menu dropdown-menu-right">
                <div class="form-group">
                  <p>Search option</p>

                  <select class="form-control">
                    <option value="0" selected>by full name</option>
                    <option value="1">by login</option>
                    <option value="2">by discipline</option>
                  </select>
                </div>
                <div class="form-group">
                  <p style="float: left; margin-top: 10px;">User type</p>

                  <select class="form-control">
                    <option selected>all</option>
                    <option>coach</option>
                    <option>customer</option>
                  </select>
                </div>
                
              </div>

            </div><!-- /btn-group -->

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
    $(document).on('click', '.dropdown-menu', function (e) {
      e.stopPropagation();
    });
    $('select').on('change input', changePlaceHolder);
    function changePlaceHolder() {
      if ($(this).val() == "0") {
        $(myInput1).attr("placeholder","Search by full name");
      }
      if ($(this).val() == "1") {
        $(myInput1).attr("placeholder","Search by login");
      }
      if ($(this).val() == "2") {
        $(myInput1).attr("placeholder","Search by discipline");
      }
    }

    $('#btnSearch').prop("disabled", true);
    $(function() {
      $("input[id='myInput1']").keyup(function countRemainingChars(){
        var number = $("input[id='myInput1']").val().length;
        if(number > 0){
          $('#btnSearch').prop("disabled", false);
        }
        if(number == 0){
          $('#btnSearch').prop("disabled", true);
        }
      });
    });

  </script>
</body>
</html>

