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
    <script src="../resources/js/conversations.js"></script>

    <link rel="stylesheet" href="../resources/css/conversations.css" >

</head>
<body>
<%@ page isELIgnored="false" %>
<%@include file="header.html"%>
<jsp:useBean id="currentSessionUser" class="model.User" scope="session"></jsp:useBean>


<div class="content container-fluid bootstrap snippets">
    <div class="row row-broken">
        <div class="col-sm-3 col-xs-12">
            <div class="col-inside-lg decor-default friends-list" style="outline: none;" tabindex="5000">
                <h6>My conversations</h6>
                <div class="chat">
                    <div class="chat-users" style="padding-top: 10px;">

                        <c:forEach var="chat" items="${usersChatsList}">
                            <div id="${chat.getId()}" class="user">
                                <div class="avatar">
                                    <img src="/image/avatar/${chat.getUser2().getId()}"  alt="User name">
                                </div>
                                <div id="firstName" class="name">${chat.getUser2().getFirstName()}</div>
                                <div id="lastName" class="name">${chat.getUser2().getLastName()}</div>
                            </div>
                        </c:forEach>

                    </div>
                </div>


            </div>
        </div>
        <div class="col-sm-9 col-xs-12 " style="outline: none;" tabindex="5001">
            <div class="col-inside-lg decor-default">
                <h6 id="chatTitle"></h6>
                <div id="chat" class="chat">
                    <div  class="chat-body">
                        <div class="answer left">
                            <div class="avatar">
                                <img src="http://bootdey.com/img/Content/avatar/avatar1.png" alt="User name">
                                <div class="status offline"></div>
                            </div>
                            <div class="name">Alexander Herthic</div>
                            <div class="text">
                                Lorem ipsum dolor amet, consectetur adipisicing elit Lorem ipsum dolor amet, consectetur
                                adipisicing elit Lorem ipsum dolor amet, consectetur adiping elit
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
                                Lorem ipsum dolor amet, consectetur adipisicing elit Lorem ipsum dolor amet, consectetur
                                adipisicing elit Lorem ipsum dolor amet, consectetur adiping elit
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
                                Lorem ipsum dolor amet, consectetur adipisicing elit Lorem ipsum dolor amet, consectetur
                                adipisicing elit Lorem ipsum dolor amet, consectetur adiping elit
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
                                Lorem ipsum dolor amet, consectetur adipisicing elit Lorem ipsum dolor amet, consectetur
                                adipisicing elit Lorem ipsum dolor amet, consectetur adiping elit
                            </div>
                            <div class="time">5 min ago</div>
                        </div>
                    </div>
                </div>
                <div class="answer-add">
                    <input id="inputMessageField" placeholder="Write a message">
                    <span class="answer-btn answer-btn-1"></span>
                    <span class="answer-btn answer-btn-2"></span>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.html"%>

<script type="text/javascript">

    long_polling();

    var userName;

    function long_polling() {
        $.ajax({
            url: "/sendEventListenerRequest",
            dataType: "json",
            success: function (message) {
                processMessage(message);
                long_polling();
            }
        });
    }

    function processMessage(message) {

        console.log(message.text);


        var id=message.authorId;
        var name = message.authorName;
        var text = message.text;

        var activeChatId = $(".activeUser").attr("id");

        if (message.chatId.toString() === activeChatId ){

            var messageBlock = '<div class="answer left"> ' +
                    '<div class="avatar"> ' +
                    '<img src="/image/avatar/'+id+'" alt="User name"> ' +
                    '<div class="status offline"></div> ' +
                    '</div> ' +
                    '<div class="name">'+name+'</div> ' +
                    '<div class="text">'+text+'</div> ' ;

            $('.chat-body').append(messageBlock)

        }

        var objDiv = document.getElementById("chat");
        objDiv.scrollTop = objDiv.scrollHeight;
    }





</script>

</body>
</html>
