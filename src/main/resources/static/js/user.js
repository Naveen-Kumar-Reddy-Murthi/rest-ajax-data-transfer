$(document).ready(function() {

	$("#user-form").submit(function(event) {

		// stop submit the form, we will post it manually.
		event.preventDefault();

		fire_ajax_submit();

	});

});

function fire_ajax_submit() {

	var formVal = {}
	formVal["username"] = $("#username").val();
	formVal["email"] = $("#email").val();
	formVal["password"] =  $("#password").val();
	formVal["lattitue"] = $("#lattitue").val();
	formVal["longitude"] = $("#longitude").val();
	formVal["temperature"] = $("#temperature").val();
	formVal["city"] = $("#city").val();
	$("#bth-Save").prop("disabled", true);

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "api/v1/user/save",
		data : JSON.stringify(formVal),
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {

			var json = JSON.stringify(data, null, 4) ;
			$('#feedbackText').html(json);

			console.log("SUCCESS : ", data);
			$("#bth-Save").prop("disabled", false);

		},
		error : function(e) {

			var json = "<h4>Ajax Response</h4><pre>" + e.responseText
					+ "</pre>";
			$('#feedback').html(json);

			console.log("ERROR : ", e);
			$("#bth-Save").prop("disabled", false);

		}
	});

}


