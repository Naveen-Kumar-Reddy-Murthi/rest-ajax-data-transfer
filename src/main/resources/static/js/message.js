$(document).ready(function () {

    $("#message-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

    var messageVal = {}
    messageVal["message"] = $("#message").val();

    $("#bth-Done").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "api/v1/msg/save",
        data: JSON.stringify(messageVal),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#bth-Done").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#bth-Done").prop("disabled", false);

        }
    });

}