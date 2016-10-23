/**
 * Created by romab on 10/1/16.
 */

// autocompletion for search page
$(document).ready(function() {

    // //autocomletion function
    // $(function() {
    //
    //     $("#disciplineAutocomplete").autocomplete({
    //         source : function(request, response) {
    //             $.ajax({
    //                 url : "/autocomplete",
    //                 type : "GET",
    //                 data : {
    //                     disciplines: request.term
    //                 },
    //                 dataType : "json",
    //                 success : function(data) {
    //                     response(data);
    //                 },
    //             });
    //         },
    //     });
    //     $(".ui-autocomplete").css("z-index", "2147483647");
    // });

    
    $(function () {
        $.ajax({
            url: "/autocomplete/userPage",
            dataType: "json",
            success: function (data) {
                fillAddList(data)
            }
        });
    });
});


function fillAddList(data) {
    
    var options = $("#discToAdd");
    $.each(data, function(key, val) {
        options.append('<option>'+ val +'</option>');
    });
    
}



    


