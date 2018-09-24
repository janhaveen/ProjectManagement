$(document).ready(function() {
	$("#HomeText").text("Opportunity Matrix List");

	DropDownForEvaluation();
	DropDownForProjectLegend(); 
	getObservationlist();
	
	/*var options1; var options2;
	$('#ProjectId').empty();
	options1 = '<option value="" selected>Select Project</option>';
	$.ajax({
		url:"../../../GetProjectList",
		type:"GET",
		success:function(data){
			for (var i = 0; i < data.data.length; i++) {				
				options1 += "<option value='" + data.data[i].rowid + "'>" + data.data[i].companyName + "</option>";
			}
			$('#ProjectId').html(options1);
		}
	});*/

	$("#department").change(function() {
		processDropDown('',$("#department").val());FnDropDown('',$("#department").val());
	});
	
	
	$("#SubmitButtonRegister").click(function() {
		saveObservation('insert');
	});
	$("#SubmitButtonUpdate").click(function() {
		saveObservation('updat');
	});
	$("#SubmitButtonCancel").click(function() {
		$("#HomeText").text("Opportunity Matrix List");
		$("#ObservationCard").removeClass("HideThisElement");
		$("#observationFormDiv").addClass("HideThisElement");
	});
	
	$("#editClick").click(function() {	
		$("#HomeText").text("Opportunity Matrix List");
		$("#ObservationCard").addClass("HideThisElement");
		$("#ObservationViewDiv").addClass("HideThisElement");
		$("#observationFormDiv").removeClass("HideThisElement");
	});
	
	$("#SubmitButtonBackFromView").click(function() {	
		$("#HomeText").text("Opportunity Matrix List");
		$("#ObservationCard").removeClass("HideThisElement");
		$("#ObservationViewDiv").addClass("HideThisElement");
		$("#observationFormDiv").addClass("HideThisElement");
	});
});

function saveObservation(type) {
	$.ajax({
		url:"../../../CreateObservation?action="+type,
		data:$("#addObservationForm").serialize()+"&impact="+escape($("#impactDiv .nicEdit-main").html())+"&observation="+escape($("#observationDiv .nicEdit-main").html()),
		type:"POST",
		success:function(data){
			if(data.indexOf("1")>=0){
				$("#HomeText").text("Opportunity Matrix List");
				document.querySelector('#successMessage').innerHTML = "<strong>Success!</strong> Opportunity Matrix "+type+"ed Successfully ! ";
				$("#successMessage").removeClass("HideThisElement");
				//setTimeout(function(){
					$('#Observationdatatables').DataTable().destroy();
					getObservationlist();
					$("#ObservationCard").removeClass("HideThisElement");
					$("#observationFormDiv").addClass("HideThisElement");
				//}, 3000);
					$('#successMsg').html("<strong>Success!</strong> Opportunity Matrix "+type+"ed Successfully ! ");
					$(".successMsg").removeClass("HideThisElement");
			}else{
				document.querySelector('#errorMessage').innerHTML = "<strong>Error!</strong> Error in "+type+"ing Opportunity Matrix !";
				$("#errorMessage").removeClass("HideThisElement");
			}
		}
	});
}

/*function setDeptAndFn(element) {
	$.ajax({
		url:"../../../GetProcess?processid="+$(element).val(),
		type:"GET",
		success:function(data){
			$("#departmentH").val(data.data[0].department); $("#department").val(data.data[0].department);	$("#department").attr("disabled",true);
			$("#functionH").val(data.data[0].function1); $("#function").val(data.data[0].function1);	$("#function").attr("disabled",true);
		}
	});
}*/

function processDropDown(pid, dept) {
	$('#process').empty();
	options2 = '<option value="" selected>Select process</option>';
	$.ajax({
		url:"../../../GetProcess?department="+$("#department").val(),
		type:"GET",
		success:function(data){
			var selecteed="";
			for (var i = 0; i < data.data.length; i++) {
				if(data.data[i].rowId.indexOf(pid)>=0){
					selecteed="selected";
				}else{
					selecteed="";
				}
				options2 += "<option "+selecteed+" value='" + data.data[i].rowId + "'>" + data.data[i].processName + "</option>";
			}
			$('#process').html(options2);
		}
	});
}

function FnDropDown(fnId, dept) {
	$('#function').empty();
	options3 = '<option value="" selected>Select Function</option>';
	$.ajax({
		url:"../../../GetFunctionList?departmentId="+$("#department").val(),
		type:"GET",
		success:function(data){
			var selecteed="";
			for (var i = 0; i < data.data.length; i++) {
				if(data.data[i].rowId.indexOf(fnId)>=0){
					selecteed="selected";
				}else{
					selecteed="";
				}
				options3 += "<option "+selecteed+" value='" + data.data[i].rowId + "'>" + data.data[i].name + "</option>";
			}
			$('#function').html(options3);
		}
	});
}