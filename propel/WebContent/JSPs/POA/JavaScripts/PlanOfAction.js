$(document).ready(function() {
	
	$("#HomeText").text("Solution Matrix List");
	//$('select').selectpicker();

	$( ".datepicker" ).datepicker({
	   format: "dd MM, yyyy"
    });
	
	
	getPOAlist();
	
	$("#addplanofactionForm #SubmitButtonRegister").click(function() {
		savePlanOfAction('insert');
	});
	$("#addplanofactionForm #SubmitButtonUpdate").click(function() {
		savePlanOfAction('update');
	});
	
	$("#SubmitButtonCancel").click(function() {
		$("#HomeText").text("Solution Matrix List");
		$("#planofactionCard").removeClass("HideThisElement");
		$("#POAViewDiv").addClass("HideThisElement");
		$("#planofactionFormDiv").addClass("HideThisElement");
	});
	
	$("#editClick").click(function() {
		$("#planofactionCard").addClass("HideThisElement");
		$("#planofactionFormDiv").removeClass("HideThisElement");
		$("#infoUpdate").addClass("HideThisElement");
		$("#POAViewDiv").addClass("HideThisElement");
		$("#infoUpdate").removeClass("HideThisElement");
	});
	
	$("#SubmitButtonBackFromView").click(function() {
		$("#planofactionCard").removeClass("HideThisElement");
		$("#planofactionFormDiv").addClass("HideThisElement");
		$("#infoUpdate").addClass("HideThisElement");
		$("#POAViewDiv").addClass("HideThisElement");
		$("#HomeText").text("Solution Matrix List");
	});
	/*$("#editplanofaction").click(function() {
		$("#challengesText").addClass('HideThisElement');
		$("#challenges").removeClass("HideThisElement");
		$("#planofactionText").addClass('HideThisElement');
		$("#planofaction").removeClass("HideThisElement");
		$("#commentsText").addClass('HideThisElement');
		$("#comments").removeClass("HideThisElement");
		$("#responsible").material_select("destroy")
		$("#responsible").removeAttr("disabled")
		$("#responsible").material_select();
		$("#accountable").material_select("destroy");
		$("#accountable").removeAttr("disabled");
		$("#accountable").material_select();
		$("#consulted").material_select("destroy");
		$("#consulted").removeAttr("disabled");
		$("#consulted").material_select();
		$("#informed").material_select("destroy");
		$("#informed").removeAttr("disabled");
		$("#informed").material_select();
		$("#statusPOA").material_select("destroy");
		$("#statusPOA").removeAttr("disabled");
		$("#statusPOA").material_select();
		$("#ExpDateOfClosure").removeAttr("disabled");
		$("#addplanofactionForm #SubmitButtonUpdate").removeClass("HideThisElement");
	});*/
	
	$("#DeleteConfirmed").click(function() {
		$.ajax({
			url:"../../../CreatePlanOfAction",
			data:{id:$("#DeleteId").val()},
			type:"GET",
			success:function(data){
				if(data.indexOf("1")>=0){
					$(".successMsg").removeClass("HideThisElement");
	                $("#successMsg").html(' <strong>Success!</strong> Solution Matrix Deleted Successfully !');
					$('#POAdatatables').DataTable().destroy();
					getPOAlist();
					$("#centralModalDangerDemo").modal('hide');
				}else{
					$(".errorMsg").removeClass("HideThisElement");
                    $("#errorMsg").html(' <strong>Error!</strong> Error in Deleting Solution Matrix ! ');
				}
			}
		});
	});
	
	$("#AddComment").click(function() {
		$("#commDiv").removeClass("HideThisElement");
	});
	
	$("#SubmitButtonRegisterComments").click(function() {
		$.ajax({
			url:"../../../UpdateComments",
			data:{planofactionId:$("#planofactionId").val(),comments: $("#newcomments").val()},
			type:"POST",
			success:function(data){
				$("#newcomments").val('');
				$("#commDiv").addClass("HideThisElement");
				getCommentsHistory($("#planofactionId").val(),0,1);
			}
		});
	});
	
	$("#SubmitButtonCancelComments").click(function() {
		$("#newcomments").val('');
		$("#commDiv").addClass("HideThisElement");
	});
});

function savePlanOfAction(type) {
	var selectedValuesR=[];var selectedValuesA=[];var selectedValuesC=[];var selectedValuesI=[];
	$("#responsible :selected").each(function(){
        selectedValuesR.push($(this).val()); 
    });
	$("#accountable :selected").each(function(){
		selectedValuesA.push($(this).val()); 
	});
	$("#consulted :selected").each(function(){
		selectedValuesC.push($(this).val()); 
	});
	$("#informed :selected").each(function(){
		selectedValuesI.push($(this).val()); 
	});
    var formData="";
    for(var i=0; i<selectedValuesR.length; i++){
    	formData+="&responsible["+i+"]="+selectedValuesR[i];
    }
    for(var i=0; i<selectedValuesA.length; i++){
    	formData+="&accountable["+i+"]="+selectedValuesA[i];
    }
    for(var i=0; i<selectedValuesC.length; i++){
    	formData+="&consulted["+i+"]="+selectedValuesC[i];
    }
    for(var i=0; i<selectedValuesI.length; i++){
    	formData+="&informed["+i+"]="+selectedValuesI[i];
    }
    formData+="&countR="+selectedValuesR.length+"&countA="+selectedValuesA.length
    		+"&countC="+selectedValuesC.length+"&countI="+selectedValuesI.length
    		+"&projectid="+$("#projectid").val()
    		+"&challenges="+escape($("#challengesDiv .nicEdit-main").html())
    		+"&planofaction="+escape($("#planofactionDiv .nicEdit-main").html()) ;
	$.ajax({
		url:"../../../CreatePlanOfAction?action="+type,
		data:$("#addplanofactionForm").serialize()+formData,
		type:"POST",
		success:function(data){
			if(data.indexOf("1")>=0){
				$("#HomeText").text("Solution Matrix List");
				document.querySelector('#successMessage').innerHTML = "<strong>Success!</strong> Solution Matrix "+type+"ed Successfully ! ";
				$("#successMessage").removeClass("HideThisElement");
				//setTimeout(function(){
					$('#POAdatatables').DataTable().ajax.reload();
					//getPOAlist();
					$("#planofactionCard").removeClass("HideThisElement");
					$("#planofactionFormDiv").addClass("HideThisElement");
					$("#addplanofactionForm #SubmitButtonUpdate").addClass("HideThisElement");
					$("#addplanofactionForm #SubmitButtonRegister").addClass("HideThisElement");
				 //}, 3000);		
					$('#successMsg').html("<strong>Success!</strong> Solution Matrix "+type+"ed Successfully ! ");
					$(".successMsg").removeClass("HideThisElement");
			}else{
				document.querySelector('#errorMessage').innerHTML = "<strong>Error!</strong> Error in "+type+"ing Solution Matrix ! ";
				$("#errorMessage").removeClass("HideThisElement");
			}
		}
	});
}

function updateStatus(id, statusOld, status) {
	var statusPOA="";
	if(status=="100001"){
		statusPOA="100002";
	}else if(status=="100002"){
		statusPOA="100005";
	}
	$.ajax({
		url:"../../../UpdateStatusForPOA",
		data:{planofactionId:id, statusPOAOld: statusOld, statusPOA:status},
		type:"POST",
		success:function(data){
			$.ajax({
				url:"../../../GetPlanOfActionList?POAID="+id,
				type:"GET",
				success:function(data){
					$("#statusDivView").html(data.data[0].StatusBtn);
					$('#POAdatatables').DataTable().ajax.reload();
				}
			});
		}
	});
}