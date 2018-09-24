$(document).ready(function() {
	$("#SubmitButtonLegend").click(function() {
		if($("#description").val()==""){
			$('#NewLegendForm #alertMessage').html("<strong>Warning!</strong> Description can not be blank !");
			$("#NewLegendForm  #alertMessage").removeClass("HideThisElement");
		}else{
			$.ajax({
				url:"../../../ModifyProjectLegend",
				data:$("#NewLegendForm").serialize()+"&ProjectId="+$("#ProjectId").val(),
				type:"POST",
				success:function(data){
					if(data.indexOf("1")>=0){ 
						$(".successMsg").removeClass("HideThisElement");
		                $("#successMsg").html('<strong>Success!</strong> Department '+$("#NewLegendForm #action").val()+'ed successfully!');
						document.getElementById("NewLegendForm").reset();	
						$("#NewLegend").modal('hide');
						getDepartmentCards("");	
						$("#NewLegendForm  #alertMessage").addClass("HideThisElement"); 
					}else{
						$(".errorMsg").removeClass("HideThisElement");
		                $("#errorMsg").html(' <strong>Error!</strong> Failed to '+$("#NewLegendForm #action").val()+' Department!');
					}
				}
			});
		}return false;
	});
});

function DeleteDept(id) {
	document.querySelector('#DeleteElementId').value = id;
	document.querySelector('#typeOfL').value ="Department";
	$("#wText").text("Department will be deleted from system.");
	$("#dHeader").text("Delete Department");
	$('#centralModalDangerDemo').modal('show');
}

function EditDept(id, desc) {
	$("#NewLegend").modal('show');
	$("#NewLegendForm #action").val("updat");
	$("#selectedLegendId").val(id);
	$("#legendGroup").val("Department");
	$("#category").val('Department');
	$("#subCategory").val('Department');
	$("#description").val(desc);
	$("#SubmitButtonLegend").text("Update");
}

function loadBlankFormForDepartment() {
	var generator=new IDGenerator();
	$("#NewLegend").modal('show');
	$("#NewLegendForm #action").val("insert");
	$("#selectedLegendId").val(generator.generate());
	$("#legendGroup").val("Department");
	$("#category").val('Department');
	$("#subCategory").val('Department');
	$("#SubmitButtonLegend").text("Submit");
}