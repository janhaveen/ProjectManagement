$(document).ready(function(){	
	var generator=new IDGenerator();
	$("#addInterViewForm #SubmitButtonRegister").click(function() {
		saveInterview();
	});
	$("#addInterViewForm #SubmitButtonUpdate").click(function() {
		saveInterview();
	});

	$("#saveChangesProcess").click(function() {
		saveProcessForm();
	});
	$("#saveProcessDescButton").click(function() {
		saveProcessForm();
	});
	
	
	
	$("#SubmitButtonCancel").click(function() {
		$("#InterViewCard").removeClass("HideThisElement");
		$("#evaluationFormDiv").addClass("HideThisElement");
	});
	
	
	$("#saveFormatButton").click(function(){
		$("#FormatId").val("F"+generator.generate());
		$.ajax({
			url:"../../../CreateFormat",
			data:$("#newFormatForm").serialize()+"&ProcessId="+$("#ProcessId").val()+"&InterviewId="+$("input[name=InterviewId]").val(),
			type:"POST",
			success:function(data){
				toastr.success("Format saved Successfully ! ");
				document.getElementById("newFormatForm").reset();
				$('#formatTable').DataTable().destroy();
				getFormat();
			}
		});
	});
	
	$("#saveToolButton").click(function(){
		$("#ToolId").val("T"+generator.generate());
		var table1 = document.getElementById('toolBody');
		var rowCount = table1.rows.length;
		$.ajax({
			url:"../../../CreateTool",
			data:$("#newToolForm").serialize()+"&ProcessId="+$("#ProcessId").val()+"&InterviewId="+$("input[name=InterviewId]").val(),
			type:"POST",
			success:function(data){
				toastr.success("Tool saved Successfully ! ");
				document.getElementById("newToolForm").reset();
				$('#ToolTable').DataTable().destroy();
				getTool();			
			}
		});
	});
});


function saveInterview(){
	var type=$("#action").val();
	$.ajax({
		url:"../../../CreateInterview?action="+type,
		data:$("#addInterViewForm").serialize()+"&ProjectId="+$("#projectid").val(),
		type:"POST",
		success:function(data){
			if(data.indexOf("1")>=0){
				toastr.success("Interview "+type+"ed Successfully ! ");
				$('#InterViewdatatables').DataTable().destroy();
				getInterviewlist();
				$("#InterViewCard").removeClass("HideThisElement");
				$("#evaluationFormDiv").addClass("HideThisElement");
			}else{
				toastr.error("Error in "+type+"ing Interview ! ");
			}
		}
	});
}

function saveProcessForm() {
	var type=$("#action1").val();
	$.ajax({
		url:"../../../CreateProcess?action="+type,
		data:$("#newProcessForm").serialize()+"&InterviewId="+$("input[name=InterviewId]").val()+"&description="+$("#processDetails").val(),
		type:"POST",
		success:function(data){
			toastr.success("Process added Successfully ! ");
			$("#processFormModal").modal('hide');
			//$("#formProcess").removeClass('HideThisElement');
			getProcess();
		}
	});
}
