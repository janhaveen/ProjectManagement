$(document).ready(function() {
	$("#SubmitButtonUpdate").click(function() {
		formSubmitProcess();
	});
	$("#SubmitButtonRegister").click(function() {
		formSubmitProcess();
	});	
	
	$("#editClick").click(function() {
		$("#ProcessCard").addClass('HideThisElement');
		$("#ProcessViewDiv").addClass('HideThisElement');
		$("#formProcess").removeClass('HideThisElement');
	});
	
	$("#SubmitButtonCancel").click(function() {
		if(window.location.href.indexOf("JSPs/Process.jsp?")>=0) $("#HomeText").text("Process List");
		$("#ProcessCard").removeClass('HideThisElement');
		$("#formProcess").addClass('HideThisElement');
		$("#ProcessViewDiv").addClass('HideThisElement');
	});
	$("#SubmitButtonBackFromView").click(function() {
		if(window.location.href.indexOf("JSPs/Process.jsp?")>=0) $("#HomeText").text("Process List");
		$("#ProcessCard").removeClass('HideThisElement');
		$("#formProcess").addClass('HideThisElement');
		$("#ProcessViewDiv").addClass('HideThisElement');
	});
	
	$("#DeleteProcessConfirmed").click(function() {
        var DeleteEmpId = document.querySelector('#DeleteProcessId').value;
        $.ajax({
            type: "GET",
            url: '../../../ModifyProcess?id=' + DeleteEmpId,
            success: function(data) {
                if (data == 0) {
                    $('#centralModalDangerDemo').modal('hide');
                    $(".errorMsg").removeClass("HideThisElement");
                    $("#errorMsg").html(' <strong>Error!</strong> Failed to Delete Process!');
                } else {
                    $('#centralModalDangerDemo').modal('hide');
                    $('#DeleteProcessId').val('');
                    $('#Processdatatables').DataTable().ajax.reload();
                    $(".successMsg").removeClass("HideThisElement");
                    $("#successMsg").html(' <strong>Success!</strong>  Process Deleted Successfully!');
                }
            }
        })
        return false; // avoid to execute the actual submit of the form.
    });
	
});

function formSubmitProcess(){
	$.ajax({
		url:"../../../ModifyProcess?ProjectId="+$("#projectid").val(),
		data:$("#EditProcessForm").serialize()+"&processText="+escape($("#EditProcessForm .nicEdit-main").html()),
		type:"POST",
		success:function(data){
			if(data.indexOf("1")>=0){
				$("#EditProcessForm #alertMessage").addClass("HideThisElement");
				$("#EditProcessForm #errorMessage").addClass("HideThisElement");	
				document.querySelector('#EditProcessForm #successMessage').innerHTML = "<strong>Success!</strong> Process "+$("#action").val()+"ed successfully !";
				$("#EditProcessForm #successMessage").removeClass("HideThisElement");					
			 	document.getElementById("EditProcessForm").reset();
			 	//setTimeout(function(){
			 		$("#ProcessCard").removeClass('HideThisElement');
					$("#formProcess").addClass('HideThisElement');
					$("#ProcessViewDiv").addClass('HideThisElement');						
					$('#Processdatatables').DataTable().ajax.reload();	
				 //}, 3000);
			 	if(window.location.href.indexOf("JSPs/Process.jsp?")>=0) $("#HomeText").text("Process List");
			 	$('#successMsg').html("<strong>Success!</strong> Process "+$("#action").val()+"ed Successfully ! ");
				$(".successMsg").removeClass("HideThisElement");
			}else{
				document.querySelector('#EditProcessForm #errorMessage').innerHTML = "<strong>Success!</strong> Failed to "+$("#action").val()+" Process!";
				$("#EditProcessForm #errorMessage").removeClass("HideThisElement");	
			}
		}
	});
}