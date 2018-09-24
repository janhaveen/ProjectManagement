$(document).ready(function() {
	//DropDownForLegend();
	if(window.location.href.indexOf("JSPs/ProjectEmployee.jsp?")>=0)  $("#HomeText").text("Employee List");
	$("#saveEmployeeForm").click(function() {
		formSubmitEmployee();
	});	
	$("#EditEmployeeForm").click(function() {
		formSubmitEmployee();
	});
	

	$("#cancelEmployeeForm").click(function() {
		$("#HomeText").text("Employee List");
		$("#PrEmpTableDiv").removeClass("HideThisElement");
		$("#PrEmpViewDiv").addClass("HideThisElement");
		$("#PrEmpFormDiv").addClass("HideThisElement");
	});	
	$("#SubmitButtonBackFromView").click(function() {
		$("#HomeText").text("Employee List");
		$("#PrEmpTableDiv").removeClass("HideThisElement");
		$("#PrEmpViewDiv").addClass("HideThisElement");
		$("#PrEmpFormDiv").addClass("HideThisElement");
	});	
	
	
});

function formSubmitEmployee(){
	if($("#department").val()==""){
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Department is mandatory!";
		$("#alertMessage").removeClass("HideThisElement");
	}else{
		$.ajax({
			url:"../../../ModifyProjectEmployee",
			data:$("#newEmployeeForm").serialize()+"&ProjectId="+$("#projectid").val(),
			type:"POST",
			success:function(data){
				if(data.indexOf("1")>=0){
					document.querySelector('#successMessage').innerHTML = "<strong>Success!</strong> Employee "+$("#action").val()+"ed successfully!";
					$("#successMessage").removeClass("HideThisElement");
					$("#alertMessage").addClass("HideThisElement");
					$("#errorMessage").addClass("HideThisElement");		
					//setTimeout(function(){
						$("#PrEmpTableDiv").removeClass("HideThisElement");
						$("#PrEmpFormDiv").addClass("HideThisElement");							
						$('#datatables').DataTable().ajax.reload();	
					// }, 3000);
					 	if(window.location.href.indexOf("JSPs/ProjectEmployee.jsp?")>=0) $("#HomeText").text("ProjectEmployee List");
					 	$('#successMsg').html("<strong>Success!</strong> Employee "+$("#action").val()+"ed Successfully ! ");
						$(".successMsg").removeClass("HideThisElement");
				}else{
					$("#alertMessage").addClass("HideThisElement");
					$("#successMessage").addClass("HideThisElement");
					document.querySelector('#errorMessage').innerHTML = "<strong>Error!</strong> Failed to "+$("#action").val()+" Employee! ";
					$("#errorMessage").removeClass("HideThisElement");
				}
			}
		});
	}
}