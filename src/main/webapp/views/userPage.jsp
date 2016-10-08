<%--
  Created by IntelliJ IDEA.
  User: romab
  Date: 9/29/16
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../resources/css/bootstrap.min.css">
    <script src="../resources/js/jquery-3.1.1.min.js"></script>
    <script src="../resources/js/bootstrap.min.js"></script>
    <link href="../resources/css/userPage.css" rel="stylesheet">
    <link href="../resources/css/font-awesome.css" rel="stylesheet">
    <script type="text/javascript" src="../resources/js/userPage.js"></script>


</head>
<body>
<%@ page isELIgnored="false" %>
<jsp:useBean id="currentSessionUser" class="model.User" scope="session"></jsp:useBean>

<%@ include file="header.html" %>

<div class="container text-center">
    <div class="row">
        <div class="col-lg-4 well">
            <div class="well">

                <div class="col-lg-12 avatar">
                    <img id="avatar" src="/downloadAvatar"
                         width="280" height="280" class="img-circle"  alt="Avatar">
                </div>

                <button id="addButton" type="button" class=" btn btn-default btn-sm">Change photo</button>

                <p></p>
                <p>${currentSessionUser.firstName}</p>
                <p>${currentSessionUser.lastName}</p>
                <p>${currentSessionUser.birthdayDate}</p>
                <p>${currentSessionUser.userType}</p>

            </div>
            <div class="well">
                <p>${currentSessionUser.userType.equals("customer") ? "Interests" : "Coach specialization"}</p>
                <ul class="list-group">
                    <c:forEach var="link" items="${disciplineLinks}">
                        <li class="list-group-item"><img src=""alt="icon">
                            ${link.getDiscipline().getName()}
                        </li>
                    </c:forEach>
                </ul>
            </div>

        </div>

        <div class="col-lg-8">
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default text-left">
                        <div class="panel-body">
                            <p>${currentSessionUser.description}</p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-lg-12"> <h3>Feedbacks</h3> </div>

            <c:forEach var="feedback" items="${usersFeedbacks}" >
                <div class="row">
                    <div class="col-lg-3">
                        <div class="well">
                            <p>${userDao.read(feedback.authorId()).getLogin()}</p>
                            <img src="" class="img-circle" height="55" width="55" alt="Avatar">
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="well">
                            <p id="feedbackText">${feedback.getText()}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>

    </div>
</div>

<%@include file="footer.html"%>

</body>
</html>
