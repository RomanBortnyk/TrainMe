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

<%@ include file="header.html"%>

<div class="container text-center">
    <div class="row">
        <div class="col-lg-4 well">
            <div class="well">

                <div class="col-lg-12 avatar">
                    <img id="avatar" src="/image/avatar/${currentSessionUser.id}"
                         width="280" height="280" class="img-circle" alt="Avatar">
                </div>

                <button type="button" id="addButton" class=" btn btn-default btn-sm" data-toggle="modal" data-target="#changePhoto">Change avatar</button>
                <!-- Modal -->
                <div class="modal fade" id="changePhoto" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="vertical-alignment-helper">
                        <div class="modal-dialog vertical-align-center">

                            <div class="modal-content">

                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                                    </button>
                                    <h4 class="modal-title" id="myModalLabel">Change photo</h4>
                                    <h6 class="modal-title" id="">
                                        image size should be less than 2 MB
                                    </h6>
                                </div>

                                <div class="modal-body">
                                    <form action="/modify/avatar" enctype="multipart/form-data" method="post">
                                        <input type="file" name="newAvatar" style="display: inline-block;">
                                        <button type="submit" class="btn btn-primary">Save changes</button>
                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>


                <p></p>
                <p>${currentSessionUser.firstName}</p>
                <p>${currentSessionUser.lastName}</p>
                <p>${currentSessionUser.birthdayDate}</p>
                <p>${currentSessionUser.userType}</p>

            </div>

            <div class="well">
                <h4>${currentSessionUser.userType.equals("customer") ? "Interests" : "Coach specialization"}</h4>
                <ul class="list-group">
                    <c:forEach var="link" items="${disciplineLinks}">
                        <li class="list-group-item"><img src="/image/icon/${link.getDiscipline().getId()}" height="35" width="35" alt="icon">
                            ${link.getDiscipline().getName()}
                        </li>
                    </c:forEach>
                </ul>

                <button type="button" style="margin-bottom: 15px;" class="btn btn-default btn-sm" data-toggle="modal" data-target="#changeInterests">Change interests</button>
                <!-- Modal -->
                <div class="modal fade" id="changeInterests" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="vertical-alignment-helper">
                        <div class="modal-dialog vertical-align-center">
                            <div class="modal-content">

                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                                    </button>
                                    <h4 class="modal-title" >Change interests</h4>
                                </div>

                                <div class="modal-body interests-section">

                                    <div class="row">
                                        <div class="col-lg-4 col-md-6 col-sm-12">
                                            <div class="checkbox-inline">
                                                <label><input type="checkbox" value="">fitness</label>
                                            </div>
                                        </div>
                                    </div>

                                    <h4 class="text-center" style="padding: 15px; border-bottom: 1px solid #e5e5e5;">Add your interests</h4>

                                    <div class="text-center">
                                        <div class="form-group">
                                            <input type="text" class="text-center interest-field">
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>

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
                            <p>${feedback.getAuthor().getLogin()}</p>
                            <img src="/image/avatar/${feedback.getAuthor().getId()}" class="img-circle" height="55" width="55" alt="Avatar">
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
