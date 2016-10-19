/**
 * Created by romab on 10/14/16.
 */


$(document).ready(function() {
    
    $(function() {

        $("#search").autocomplete({
            source : function(request, response) {
                $.ajax({
                    url : "/SearchController",
                    type : "GET",
                    data : {
                        users: request.term
                    },
                    dataType : "json",
                    success : function(data) {
                        response(data);
                    }
                });
            },

        });
        
    });
    
    

    
});