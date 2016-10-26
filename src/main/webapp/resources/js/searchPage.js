/**
 * Created by romab on 10/23/16.
 */

// autocompletion for search page
$(document).ready(function() {

    var property = "users";
    
    if (property === "disciplines"){
        //autocomletion function
        $(function() {

            $("#searchField").autocomplete({
                source : function(request, response) {
                    $.ajax({
                        url : "/autocomplete/searchPage",
                        type : "GET",
                        data : {
                            disciplines: request.term
                        },
                        dataType : "json",
                        success : function(data) {
                            response(data);
                        }
                    });
                }
            });
            // $(".ui-autocomplete").css("z-index", "2147483647");
        });
    }else {
        //autocomletion function
        $(function() {

            $("#searchField").autocomplete({
                source : function(request, response) {
                    $.ajax({
                        url : "/autocomplete/searchPage",
                        type : "GET",
                        data : {
                            users: request.term
                        },
                        dataType : "json",
                        success : function(data) {
                            response(data);
                        }
                    });
                }
            });
            // $(".ui-autocomplete").css("z-index", "2147483647");
        });
    }
    
});


$(function() {
    $('#toggle-one').change(function() {
        if ($(this).prop('checked')===true) $(this).attr('value', 'coach'); 
        else $(this).attr('value', 'customer');

        console.log($(this).attr('value'));
        // $('#console-event').html('Toggle: ' + $(this).prop('checked'))
    })
});

$(function() {
    $('#toggle-two').change(function() {
        if ($(this).prop('checked')===true) $(this).attr('value', 'byUserName');
        else $(this).attr('value', 'byDiscipline');

        console.log($(this).attr('value'));
        // $('#console-event').html('Toggle: ' + $(this).prop('checked'))
    })
});

