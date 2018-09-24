$(document).ready(function() {
	getInterviewlist();
	$("#HomeText").text("Interview");
	
	$('#datatables tbody').on( 'click', '.select_me', function () {
    	var data = $('#datatables').DataTable().row( $(this).parents('tr') ).data();
    	getEmpDetails(data.employeeId);
    } );
	
	var generator = new IDGenerator();
	
	$("#SubmitButtonBackFromView").click(function() {
		$("#InterViewCard").removeClass("HideThisElement");
		$("#InterviewFormDiv").addClass("HideThisElement");
		$("#InterviewViewDiv").addClass("HideThisElement");
	});
	
	$("#editClick").click(function() {//DropDownForProjectLegend(); 
		getEmpDetails($("#EmployeeId").val());
		$("#InterViewCard").addClass("HideThisElement");
		$("#InterviewFormDiv").removeClass("HideThisElement");
		$("#InterviewViewDiv").addClass("HideThisElement");
	});
	
	$("#saveWhoForm").click(function() {
		formSubmitWho();
	});
	$("#editWhoForm").click(function() {
		formSubmitWho();
	});
	
	$(".back").click(function() {
		$('#InterViewdatatables').DataTable().destroy();
		getInterviewlist();
		$("#HomeText").text("Interview List");
		$("#InterViewCard").removeClass("HideThisElement");
		$("#InterviewViewDiv").addClass("HideThisElement");
		$("#InterviewFormDiv").addClass("HideThisElement");		
	});	
	/*
	$("#cancelEmployeeForm").click(function() {
		$("#InterViewCard").removeClass("HideThisElement");
		$("#InterviewFormDiv").addClass("HideThisElement");
	});	
	$("#cancelWhoForm").click(function() {
		$("#InterViewCard").removeClass("HideThisElement");
		$("#interviewFormDiv").addClass("HideThisElement");
	});	
	$("#cancelHowForm").click(function() {
		$("#InterViewCard").removeClass("HideThisElement");
		$("#interviewFormDiv").addClass("HideThisElement");
	});
	$("#cancelWithForm").click(function() {
		$("#InterViewCard").removeClass("HideThisElement");
		$("#interviewFormDiv").addClass("HideThisElement");
	});	
	$("#cancelAuditForm").click(function() {
		$("#InterViewCard").removeClass("HideThisElement");
		$("#interviewFormDiv").addClass("HideThisElement");
	});	*/
	
	$("#DeleteConfirmed").click(function() {
		$.ajax({
			url:"../../../ModifyInterview",
			data:{id:$("#DeleteId").val()},
			type:"GET",
			success:function(data){
				if(data.indexOf("1")>=0){
					$(".successMsg").removeClass("HideThisElement");
					$("#successMsg").html(' <strong>Success!</strong> Interview Deleted Successfully !');
					$('#InterViewdatatables').DataTable().destroy();
					getInterviewlist();
					$("#centralModalDangerDemo").modal('hide');
				}else{
					$(".errorMsg").removeClass("HideThisElement");
	                $("#errorMsg").html(' <strong>Error!</strong> Error in Deleting Interview ! ');
				}
			}
		});
	});
});

function formSubmitWho(){
	var typeOfAct="";
	if($("#newWhoForm #action").val().indexOf("insert")>=0){
		typeOfAct="insert";
	}else{
		typeOfAct="updat";
	}
	if($("#EmployeeId").val()=="null" || $("#EmployeeId").val()==""){
		document.querySelector('#newWhoForm #alertMessage').innerHTML = "<strong>Warning!</strong> Select Employee First!";
		$("#newWhoForm #alertMessage").removeClass("HideThisElement");
	}else{
		$.ajax({
			url:"../../../ModifyInterview?ProjectId="+$("#projectid").val(),
			data:$("#newWhoForm").serialize()+"&EmployeeId="+$("#EmployeeId").val()+"&empRole="+escape($("#RoleDiv .nicEdit-main").html())+"&obChallenges="+escape($("#ChallengesDiv .nicEdit-main").html()),
			type:"POST",
			success:function(data){
				if(data.indexOf("1")>=0){
					$("#newWhoForm #alertMessage").addClass("HideThisElement");
					$("#newWhoForm #errorMessage").addClass("HideThisElement");	
					document.querySelector('#newWhoForm #successMessage').innerHTML = "<strong>Success!</strong> Who "+typeOfAct+"ed successfully !";
					$("#newWhoForm #successMessage").removeClass("HideThisElement");	
					setTimeout(function() {
						$("#newWhoForm #successMessage").addClass("HideThisElement");
					},2000);			
					$("#newWhoForm #action").val("updat");//document.getElementById("newWhoForm").reset();
					
				} else{
					document.querySelector('#newWhoForm #errorMessage').innerHTML = "<strong>Error!</strong> Failed to "+typeOfAct+" Who!";
					$("#newWhoForm #errorMessage").removeClass("HideThisElement");
				}
			}
		});
	}
	return false;
}

function getEmpDetails(id) {
	$.ajax({
		url:"../../../GetProjectEmployeeList?empId="+id,
		type:"GET",
		success:function(data1){
			var data=data1.data[0];
			document.querySelector('#EmployeeId').value = data.employeeId;
	        document.querySelector('#department').value = data.department;     $('#newEmployeeForm #department').attr("disabled",true);
	        document.querySelector('#designation').value = data.designation;     $('#newEmployeeForm #designation').attr("disabled",true);		    
	        $('#empFirstName').val(data.firstName);	 	$('#empFirstName').attr("readOnly",true);
	        $('#empLastName').val(data.lastName);		 $('#empLastName').attr("readOnly",true);
		    $('#empMobileNo').val(data.contactNo);		 $('#empMobileNo').attr("readOnly",true);
		    $('#empEmailID').val(data.emailId);		 	$('#empEmailID').attr("readOnly",true);
		    $('#empLocation').val(data.location);		 $('#empLocation').attr("readOnly",true);
		    $('#empSupervisor').val(data.reportTo); 	$('#empSupervisor').attr("readOnly",true);
		    $('#empExperience').val(data.experience);	 
		    $('#empCompensation').val(data.compensation);	 
		    $("#newEmployeeForm #action").val("upIntCmp");
		    $("#saveEmployeeForm").addClass("HideThisElement");
		    $("#EditEmployeeForm").removeClass("HideThisElement");
		    $("#add").addClass("HideThisElement");
			$("#upd").removeClass("HideThisElement");
		    $("#PrEmpTableDiv").addClass("HideThisElement");
			$("#PrEmpViewDiv").addClass("HideThisElement");
			$("#PrEmpFormDiv").removeClass("HideThisElement");
			$("#EmpViewDiv").removeClass("HideThisElement"); 
		}
	});
	
}

