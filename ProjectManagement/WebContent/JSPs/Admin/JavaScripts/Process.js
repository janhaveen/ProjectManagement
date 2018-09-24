function getProcess() {
	$.ajax({
		url:"../../../GetProcess",
		data:"InterviewId="+$("#InterviewId").val(),
		type:"POST",
		success:function(data){

		}
	});
}
