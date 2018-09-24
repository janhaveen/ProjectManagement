$(document).ready(function() {
	$("#addDept").click(function() {
		loadBlankFormForDepartment();
	});
	$("#HomeText").text("Topdown");
	$("#NewFunctionForm #SubmitButtonRegister").click(function() {
		formSubmitFunction();
	});
	$("#NewFunctionForm #SubmitButtonUpdate").click(function() {
		formSubmitFunction();
	});
	
	$("#DeleteConfirmed").click(function() {
    	var DeleteId = document.querySelector('#DeleteElementId').value;
    	var url="";
    	if($("#typeOfL").val().indexOf("Function")>=0){
    		url='../../../ModifyFunction';
    	}else{
    		url='../../../ModifyProjectLegend';
    	}
    	$.ajax({
            type: "GET",
            url: url,
            data:{id:DeleteId},
            success: function(data)
            {
                if (data == 0) {                	
	            	$('#centralModalDangerDemo').modal('hide');
	            	$(".errorMsg").removeClass("HideThisElement");
	                $("#errorMsg").html(' <strong>Success!</strong> Failed to Delete '+$("#typeOfL").val()+' !');
				} else {
					$("#NewFunction").modal('hide');
					$('#centralModalDangerDemo').modal('hide');
					getDepartmentCards("");	
					$(".successMsg").removeClass("HideThisElement");
	                $("#successMsg").html(' <strong>Success!</strong> '+$("#typeOfL").val()+' Deleted Successfully !');
				}
            }
		})
		return false; // avoid to execute the actual submit of the form.
    });
	
	$(".edit").click(function() {
		$("#NewFunction #viewDiv").addClass("HideThisElement");
		$("#NewFunction #updateDiv").removeClass("HideThisElement");
		$("#NewFunction #changeDept").addClass("HideThisElement");
	});
	
	$(".delete").click(function() {
		DeleteFunction();
	});
	
	$(".close1").click(function() {
		$("#NewFunction").modal('hide');
		getDepartmentCards("");	
	});
	
	$(".change").click(function() {
		changeDepartment();
	});
	
	$("#SubmitButtonUpdate1").click(function() {
		$.ajax({
            type: "POST",
            url: '../../../ChangeDepartment',
            data:{deptid:$("#department").val(), fid:$("#NewFunctionForm #FunctionId").val()},
            success: function(data)
            {
                if (data == 0) {                	
	            	$(".errorMsg").removeClass("HideThisElement");
	                $("#errorMsg").html(' <strong>Success!</strong> Failed to Change Department!');
				} else {
					$("#NewFunction").modal('hide');
					getDepartmentCards("");	
					$(".successMsg").removeClass("HideThisElement");
	                $("#successMsg").html(' <strong>Success!</strong> Department Changed Successfully !');
				}
            }
		})
		return false; // avoid to execute the actual submit of the form.
	});
});


function loadBlankformForFunction(deptid) {
	$("#NewFunction").modal('show');
	document.getElementById("NewFunctionForm").reset();
	DropDownForProjectLegend();
	var generator=new IDGenerator();
	$("#NewFunction #viewDiv").addClass("HideThisElement");
	$("#NewFunction #updateDiv").removeClass("HideThisElement");
	$("#NewFunction #NewElement-modal-title").html("<i class='fa fa-plus mr-1'></i> New Function");
	$("#NewFunctionForm #FunctionId").val("F"+generator.generate());
	$("#NewFunctionForm #DepartmentId").val(deptid);
	$("#NewFunctionForm #action").val("insert");
	$("#NewFunctionForm #SubmitButtonUpdate").addClass("HideThisElement");
	$("#NewFunctionForm #SubmitButtonRegister").removeClass("HideThisElement");
}


function formSubmitFunction() {
	if($("#NewFunctionForm #name").val() == "") { 
		$('#NewFunctionForm #alertMessage').html("<strong>Warning!</strong> Function Name is mandatory !");
		$("#NewFunctionForm  #alertMessage").removeClass("HideThisElement");
	}else{
		$.ajax({
			url:"../../../ModifyFunction",
			data:$("#NewFunctionForm").serialize()+"&RoleText="+escape($("#NewFunctionForm .nicEdit-main").html()),
			type:"POST",
			success:function(data){
				if(data.indexOf("1")>=0){ 
					$(".successMsg").removeClass("HideThisElement");
	                $("#successMsg").html(' <strong>Success!</strong> Function '+$("#NewFunctionForm #action").val()+'ed successfully!');
					/*viewFn($("#FunctionId").val());
					document.getElementById("NewFunctionForm").reset();	*/
					$("#NewFunction").modal('hide');
					getDepartmentCards("");	
					$("#NewFunctionForm  #alertMessage").addClass("HideThisElement"); 
				}else{
					$(".errorMsg").removeClass("HideThisElement");
	                $("#errorMsg").html(' <strong>Success!</strong> Failed to '+$("#NewFunctionForm  #action").val()+' Function!');
				}
			}
		});
	}
	return false; // avoid to execute the actual submit of the form.
}

function DeleteFunction() {
	document.querySelector('#DeleteElementId').value = $("#FunctionId").val();
	document.querySelector('#typeOfL').value ="Function";
	$("#wText").text("Function will be deleted from system.");
	$("#dHeader").text("Delete Function");
	$('#centralModalDangerDemo').modal('show');
}

function viewFn(id) {
	$("#NewFunction").modal('show');
	document.getElementById("NewFunctionForm").reset();
	$("#NewFunctionForm #FunctionId").val(id);
	$.ajax({
		type: "GET",
        url: '../../../GetFunctionList',
        data:{id:id},
        success: function(data)
        {		
        	$("#NewFunction #NewElement-modal-title").html("View Function");
			$("#NewFunction #viewDiv").removeClass("HideThisElement");
			$("#NewFunction #updateDiv").addClass("HideThisElement");
			$("#NewFunction #changeDept").addClass("HideThisElement");
        	$("#NewFunctionForm #action").val("updat");
        	$("#NewFunctionForm #DepartmentId").val(data.data[0].departmentId);
        	$("#NewFunctionForm #name").val(data.data[0].name);
        	$("#ProjectId").val(data.data[0].projectId);
        	$("#NewFunctionForm #NameLbl").addClass("active");
        	$("#NewFunctionForm #RoleText").val(data.data[0].roleDesc); $("#NewFunctionForm .nicEdit-main").html(data.data[0].roleDesc);
        	$("#NewFunctionForm #RoleTextLbl").addClass("active");
        	$("#NewFunctionForm #InfluencingFactors").val(data.data[0].InfluencingFactor);
        	$("#NewFunctionForm #InfluencingFactorsLbl").addClass("active");
        	$("#NewFunctionForm #SubmitButtonUpdate").removeClass("HideThisElement");
        	$("#NewFunctionForm #SubmitButtonRegister").addClass("HideThisElement");
        	$("#fnName").text(data.data[0].name);
        	$("#roleView").html(data.data[0].roleDesc);
        	var ifArr=data.data[0].InfluencingFactor.split(',');
        	var str="";
        	for (var i = 0; i < ifArr.length; i++) {
            	str+=''+
        		'<span class="badge badge-dark">'+ifArr[i]+'</span>'+
        		' ';
			}
        	$("#ifDiv").html('');
        	document.querySelector('#ifDiv').insertAdjacentHTML('beforeend', str);	
        }
	});
}

function changeDepartment(){
	DropDownForProjectLegend();
	//$("#NewFunction #department").val(data.data[0].departmentId).material_select('refresh');
	$("#NewFunction #viewDiv").addClass("HideThisElement");
	$("#NewFunction #updateDiv").addClass("HideThisElement");
	$("#NewFunction #changeDept").removeClass("HideThisElement");
}
