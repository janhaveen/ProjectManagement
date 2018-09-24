$(document).ready(function(){
	getProjectList();
	$("#HomeText").text("Project List");
	$("#SubmitButtonRegister").click(function() {
		$.ajax({
			url:"../../../CreateProject?action=insert",
			data:$("#newProjectForm").serialize(),
			type:"POST",
			success:function(data){
				if(data.indexOf("1")>=0){
					createDepartmennt();
					createDesignation();
					//document.querySelector('#successMessage').innerHTML = "<strong>Success!</strong> Project added Successfully ! ";
					//$("#successMessage").removeClass("HideThisElement");
					//setTimeout(function(){
						$('#projectdatatables').DataTable().destroy();
						getProjectList();
						$("#HomeText").text("Project List");
						$("#projecttableCard").removeClass('HideThisElement');
						$("#projectDetails").addClass('HideThisElement');
						$("#projectForm").addClass('HideThisElement');
						$(".successMsg").removeClass("HideThisElement");
	                    $(".errorMsg").addClass("HideThisElement");
	                    $("#successMsg").html("<strong>Success!</strong> Project added Successfully ! ");
					//}, 3000);
					
				}else{
					document.querySelector('#errorMessage').innerHTML = "<strong>Error!</strong> Error in adding Project! ";
					$("#errorMessage").removeClass("HideThisElement");
				}
			}
		});
	});
	
	$("#SubmitButtonUpdate").click(function() {
		$.ajax({
			url:"../../../CreateProject?action=update",
			data:$("#newProjectForm").serialize(),
			type:"POST",
			success:function(data){
				if(data.indexOf("1")>=0){
					//toastr.success("Project updated Successfully ! ");
					document.querySelector('#successMessage').innerHTML = "<strong>Success!</strong> Project updated Successfully !";
					$("#successMessage").removeClass("HideThisElement");
					//setTimeout(function(){
						$('#projectdatatables').DataTable().destroy();
						getProjectList();
						$("#HomeText").text("Project List");
						$("#projecttableCard").removeClass('HideThisElement');
						$("#projectDetails").addClass('HideThisElement');
						$("#projectForm").addClass('HideThisElement');
						$(".successMsg").removeClass("HideThisElement");
	                    $(".errorMsg").addClass("HideThisElement");
	                    $("#successMsg").html("<strong>Success!</strong> Project added Successfully ! ");
					//}, 3000);
				}else{
					document.querySelector('#errorMessage').innerHTML = "<strong>Error!</strong> Error in adding Project!  ";
					$("#errorMessage").removeClass("HideThisElement");
					/*$(".successMsg").addClass("HideThisElement");
                    $(".errorMsg").removeClass("HideThisElement");
                    $("#errorMsg").html(' <strong>Error!</strong> Failed to Delete Project!');*/
				}
			}
		});
	});
	
	$("#DeleteEmployeeConfirmed").click(function() {
        var DeleteEmpId = document.querySelector('#DeletePrId').value;
        $.ajax({
            type: "GET",
            url: '../../../CreateProject?id=' + DeleteEmpId,
            success: function(data) {
                if (data == 0) {
                    $('#centralModalDangerDemo').modal('hide');
                    $(".successMsg").addClass("HideThisElement");
                    $(".errorMsg").removeClass("HideThisElement");
                    $("#errorMsg").html(' <strong>Error!</strong> Failed to Delete Project!');
                } else {
                    $('#centralModalDangerDemo').modal('hide');
                    $('#selectedEmployeeId').val('');
                    $('#projectdatatables').DataTable().ajax.reload();
                    $(".errorMsg").addClass("HideThisElement");
                    $(".successMsg").removeClass("HideThisElement");
                    $("#successMsg").html(' <strong>Success!</strong>  Project Deleted Successfully!');
                }
            }
        })
        return false; // avoid to execute the actual submit of the form.
    });
	
	$("#SubmitButtonCancel").click(function() {
		$("#HomeText").text("Project List");
		$("#projecttableCard").removeClass('HideThisElement');
		$("#projectForm").addClass('HideThisElement');
		$("#projectDetails").addClass('HideThisElement');
	});
	
	$("#SubmitButtonCancelView").click(function() {
		$("#HomeText").text("Project List");
		$("#projecttableCard").removeClass('HideThisElement');
		$("#projectForm").addClass('HideThisElement');
		$("#projectDetails").addClass('HideThisElement');
	});
	
	$("#SubmitButtonEdit").click(function() {
		//$("#HomeText").text("Project List");
		$("#projecttableCard").addClass('HideThisElement');
		$("#projectForm").removeClass('HideThisElement');
		$("#projectDetails").addClass('HideThisElement');
	});
	
});

function numericValidation(element) {
    var numbers = /^(?=.*[0-9])[- +()0-9]+$/;
    if ($(element).val().match(numbers)) {
       // alert('Your input is valid');
        return true;
    }
    else {
        //alert('Please input numeric characters only');
        return false;
    }
}

function createDepartmennt() {
	var generator=new IDGenerator();
	var formData="selectedLegendId="+generator.generate()+"&ProjectId="+$("#projectId").val()
				+"&legendGroup=Department&category=Department&subCategory=Department&description=Management&action=insert";
	$.ajax({
		url:"../../../ModifyProjectLegend", 
		data:formData,
		type:"POST",
		success:function(data){
			
		}
	})
}

function createDesignation() {
	var generator=new IDGenerator();
	var formData="";
	for (var i = 0; i < 6; i++) {
		formData="";
		formData="ProjectId="+$("#projectId").val()
		+"&legendGroup=Designation&category=Designation&subCategory=Designation&action=insert";
		formData+="&selectedLegendId="+generator.generate();
		if(i==0)formData+="&description=Owner";
		if(i==1)formData+="&description=Director";
		if(i==2)formData+="&description=Manager";
		if(i==3)formData+="&description=Supervisor";
		if(i==4)formData+="&description=Executive";
		if(i==5)formData+="&description=Associate";
		$.ajax({
			url:"../../../ModifyProjectLegend", 
			data:formData,
			type:"POST",
			success:function(data){
				
			}
		});
	}
}
