<%--
  Created by IntelliJ IDEA.
  User: romab
  Date: 10/28/16
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>messenger</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../resources/css/bootstrap.min.css">
    <script src="../resources/js/jquery-3.1.1.min.js"></script>
    <script src="../resources/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../resources/css/font-awesome.min.css">
    <script src="../resources/js/jquery.nicescroll.min.js"></script>

    <link rel="stylesheet" href="../resources/css/conversations.css" >

</head>
<body>
<%@ page isELIgnored="false" %>
<%@include file="header.html"%>

<div class="content container-fluid bootstrap snippets">
    <div class="row row-broken">
        <div class="col-sm-3 col-xs-12">
            <div class="col-inside-lg decor-default chat" style="overflow: hidden; outline: none;" tabindex="5000">
                <div class="chat-users">
                    <h6>Online</h6>
                    <div class="user">
                        <div class="avatar">
                            <img src="http://bootdey.com/img/Content/avatar/avatar1.png" alt="User name">
                            <div class="status off"></div>
                        </div>
                        <div class="name">User name</div>
                        <div class="mood">User mood</div>
                    </div>
                    <div class="user">
                        <div class="avatar">
                            <img src="http://bootdey.com/img/Content/avatar/avatar2.png" alt="User name">
                            <div class="status online"></div>
                        </div>
                        <div class="name">User name</div>
                        <div class="mood">User mood</div>
                    </div>
                    <div class="user">
                        <div class="avatar">
                            <img src="http://bootdey.com/img/Content/avatar/avatar3.png" alt="User name">
                            <div class="status busy"></div>
                        </div>
                        <div class="name">User name</div>
                        <div class="mood">User mood</div>
                    </div>
                    <div class="user">
                        <div class="avatar">
                            <img src="http://bootdey.com/img/Content/avatar/avatar4.png" alt="User name">
                            <div class="status offline"></div>
                        </div>
                        <div class="name">User name</div>
                        <div class="mood">User mood</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-9 col-xs-12 chat" style="overflow: hidden; outline: none;" tabindex="5001">
            <div class="col-inside-lg decor-default">
                <div class="chat-body">
                    <h6>Mini Chat</h6>

                    <div class="answer left">

                        <div class="avatar">
                            <img src="http://bootdey.com/img/Content/avatar/avatar1.png" alt="User name">
                            <div class="status offline"></div>
                        </div>

                        <div class="name">Alexander Herthic</div>
                        <div class="text">
                            Lorem ipsum dolor amet, consectetur adipisicing elit Lorem ipsum dolor amet, consectetur adipisicing elit Lorem ipsum dolor amet, consectetur adiping elit
                        </div>

                        <div class="time">5 min ago</div>
                    </div>

                    <div class="answer left bkg">
                        <div class="avatar">
                            <img src="http://bootdey.com/img/Content/avatar/avatar2.png" alt="User name">
                            <div class="status offline"></div>
                        </div>
                        <div class="name">Alexander Herthic</div>
                        <div class="text">
                            Lorem ipsum dolor amet, consectetur adipisicing elit Lorem ipsum dolor amet, consectetur adipisicing elit Lorem ipsum dolor amet, consectetur adiping elit
                        </div>
                        <div class="time">5 min ago</div>

                    </div>

                    <div class="answer-add">
                        <input placeholder="Write a message">
                        <span class="answer-btn answer-btn-1"></span>
                        <span class="answer-btn answer-btn-2"></span>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function(){
        $(".chat").niceScroll();
    })

    $(".chat-users").on("click", ".user", function(){
        $(".chat-users .user").removeClass("activeUser");
        $(this).addClass("activeUser");
    });

</script>

<%@include file="footer.html"%>

</body>
</html>
