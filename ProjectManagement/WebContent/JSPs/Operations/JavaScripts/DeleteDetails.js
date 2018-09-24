$(document).ready(function() {
	$("#DeleteConfirmed").click(function() {
		var url=""
		if($("#what").val().indexOf("Opportunity Matrix")>=0)
			url="../../../CreateObservation";
		else if($("#what").val().indexOf("Interview")>=0)
			url="../../../CreateInterview";
		$.ajax({
			url:url,
			data:{id:$("#DeleteId").val()},
			type:"GET",
			success:function(data){
				if(data.indexOf("1")>=0){
					$(".successMsg").removeClass("HideThisElement");
                    $("#successMsg").html(' <strong>Success!</strong>  Opportunity Matrix Deleted Successfully!');
					$('#Observationdatatables').DataTable().destroy();
					getObservationlist();
					$("#centralModalDangerDemo").modal('hide');
					/*
					$("#ObservationCard").removeClass("HideThisElement");
					$("#observationFormDiv").addClass("HideThisElement");*/
				}else{
					$(".errorMsg").removeClass("HideThisElement");
                    $("#errorMsg").html(' <strong>Error!</strong> Error in Deleting Opportunity Matrix ! ');
				}
			}
		});
	});
});