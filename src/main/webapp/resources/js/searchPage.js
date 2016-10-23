/**
 * Created by romab on 10/23/16.
 */

$(document).ready(function() {

    $(function() {
        $('#toggle-one').bootstrapToggle();
        $('#toggle-two').bootstrapToggle();
    })
    
    
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