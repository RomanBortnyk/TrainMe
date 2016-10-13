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
                        term : request.term
                    },
                    dataType : "json",
                    success : function(data) {
                        response(data);
                    }
                });
            },

            select: function( event, ui ) {
                var name =  ui.item.value
                // Your code
                $("#search").val(name);
                return false;
                
            }
        });
        
    });

    
});