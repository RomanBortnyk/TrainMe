/**
 * Created by romab on 11/1/16.
 */

$( document ).ready(function() {

    $(window).resize(function(){
        $h = $(window).outerHeight()
        $('.chat').css({
            height: $h - $('.navbar').outerHeight() - $('footer').outerHeight() - $('.decor-default h6').outerHeight() - $('.answer-add').outerHeight() - 60
        });
        $('.friends-list').css({
            height: $('.chat').outerHeight() + $('.decor-default h6').outerHeight() + 80
        });
    });
    $(window).resize();

    $scrollBottom = $(window).scrollTop() + $(".chat").height();
    $(".chat").scrollTop($scrollBottom);



    $(".chat-users").on("click", ".user", function(){

        if ( !$(this).hasClass("activeUser") ){
            $(".chat-users .user").removeClass("activeUser");
            $(this).addClass("activeUser");
            cleanMessageList();
            refreshMessagesList();

            $("#chatTitle").text( $(this).find("#firstName").text() +" "
                +$(this).find("#lastName").text());

        }
    });
    

});



function cleanMessageList() {
    $(".chat-body").empty()
}

function refreshMessagesList() {

    var currentChatId = $(".activeUser").attr('id');
    var url = "/messenger/chatMessages/";

    $.ajax({
        url : "/messenger/chatMessages/"+currentChatId,
        type : "GET",
        dataType : "json",
        success : function(data) {
            response(data);
        }
    });
}

function response(data) {

    $.each(data, function(index, element) {

        var id=element.authorId;
        var name = element.authorName;
        var text = element.text;

        var large = '<div class="answer left"> ' +
            '<div class="avatar"> ' +
            '<img src="/image/avatar/'+id+'" alt="User name"> ' +
            '<div class="status offline"></div> ' +
            '</div> ' +
            '<div class="name">'+name+'</div> ' +
            '<div class="text">'+text+'</div> ' +
            '<div class="time">5 min ago</div> </div>';

        $('.chat-body').append(large)

    });
}





