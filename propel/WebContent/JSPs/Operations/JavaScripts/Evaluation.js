$(document).ready(function(){
	$("#HomeText").text("Interview List");
	getInterviewlist();
	
	EvaluationAutocomplete();
});

function EditProcess(id,processName,desc,dept_text,function_text,department, functionId) {
	$("#formProcess").removeClass('HideThisElement');
	$("#action1").val("updat");
	$("#ProcessId").val(id);
	$("#processTitle").val(processName);$("#processTitleLbl").addClass('active');
	$("#departmentText").val(dept_text);$("#departmentLbl").addClass('active');
	$("#department").val(department);
	$("#functionName").val(functionId);
	$("#functionNameText").val(function_text);$("#functionNameLbl").addClass('active');
	$("#processDetails").val(desc);$("#processDetailsLbl").addClass('active');
	$("#processFormModal").modal('show');
	$('#formatTable').DataTable().destroy();
	getFormat();
	console.log($('#FtH').click());
	$('#ToolTable').DataTable().destroy();
	getTool();
}

function newProcess() {
	document.getElementById("newProcessForm").reset();
	$("#action1").val("insert");
	var generator=new IDGenerator();
	$("#ProcessId").val("P"+generator.generate());
	$("#processFormModal").modal('show');
	$('#formatTable').DataTable().destroy();
	getFormat();
	$('#ToolTable').DataTable().destroy();
	getTool();
	$('#tooltH').click();

}