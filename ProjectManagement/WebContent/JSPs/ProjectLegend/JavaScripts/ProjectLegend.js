$(document).ready(function(){
	$('.datepicker').pickadate();
	getProjectLegendList();
	$("#SubmitButtonRegister").click(function() {
    	formSubmit("new"); 
    	return false;
    });
    
    $("#SubmitButtonUpdate").click(function() {
    	formSubmit("edit");
    	return false;
    });

    $("#DeleteConfirmed").click(function() {
    	var DeleteId = document.querySelector('#DeleteId').value;
    	$.ajax({
            type: "GET",
            url: '../../../ModifyProjectLegend?id='+DeleteId,
            success: function(data)
            {
                if (data == 0) {
	            	$('#centralModalDangerDemo').modal('hide');
	            	toastr.error('Failed to Delete Department!');
				} else {
					$('#centralModalDangerDemo').modal('hide');
					$('#pldatatables').DataTable().ajax.reload();
					toastr.success('Department Deleted Successfully!');
				}
            }
		
		})
		return false; // avoid to execute the actual submit of the form.
    });
});


function formSubmit(type){ console.log(type);
	var url = "";
	if(type=="new"){
		url="../../../ModifyProjectLegend?action=insert";
	}else{
		url="../../../ModifyProjectLegend?action=update";
	}	
	$.ajax({
           type: "POST",
           url: url,
           data: $("#newProjectLegendForm").serialize()+"&ProjectId="+$("#ProjectId").val(), // serializes the form's elements.
           success: function(data)
           {
               if (data == 1) {
            	   document.getElementById("newProjectLegendForm").reset();
					$("#alertMessage").addClass("HideThisElement");
					$("#errorMessage").addClass("HideThisElement");
					$('#pldatatables').DataTable().ajax.reload();
					$('#RegisterNewProjectLegend').modal('hide');
					if(type=="new")
						toastr.success('New Department Registered Successfully!');
					else
						toastr.success('Department Updated Successfully!');
				} else{
					if(type=="new")
						toastr.error('Failed to Register New Department!');
					else
						toastr.error('Failed to Update Department!');
				}
           }
	});
    return false; // avoid to execute the actual submit of the form.
}
