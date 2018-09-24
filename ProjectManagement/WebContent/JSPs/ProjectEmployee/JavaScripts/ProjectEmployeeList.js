$(document).ready(function(){
	DropDownForProjectLegend();
	var str="?1=1";
    if($("#projectid").val()!="null"){
    	str+="&projectid="+$("#projectid").val();
    }
	$('#datatables thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
    });
    $("#datatables thead input").on('keyup change', function () {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
    var actionStr="";
    if(window.location.href.indexOf("ProjectEmployee.jsp")>=0){
    	actionStr='<i class="edit_me fa fa-pencil-alt fa-2x" aria-hidden="true"></i> '+
        '<i class="delete_me fa fa-trash fa-2x " aria-hidden="true"></i>';
    }else{
    	actionStr='<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> ';
    }
	var table = $('#datatables').DataTable( {
        buttons: [
            {
                text: 'New Employee',
                action: function ( e, dt, node, config ) {
                	loadBlankform();
                }
            }
        ],dom: 'Bfrtip',
		"bLengthChange": false,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "../../../GetProjectEmployeeList"+str,
		"columns": [
        	 {
             	className: "center",
                 defaultContent: actionStr
             },
            { "data": "empname" },
            { "data": "deptText" },
            { "data": "desigText" },
            { "data": "contactNo" },
            { "data": "emailId" },
            { "data": "reportTo" },
            { "data": "experience" },
            { "data": "compensation" }
        ],
        columnDefs: [
            { width: '25pc', targets: 1 },
            { width: '30pc', targets: 2 }
        ],
        fixedColumns: true
    });
	
	$('#datatables tbody').on('click', '.edit_me', function() {
	    var data = table.row($(this).parents('tr')).data();
	    document.getElementById("newEmployeeForm").reset();
	    document.querySelector('#EmployeeId').value = data.employeeId;

	    if(window.location.href.indexOf("JSPs/ProjectEmployee.jsp?")>=0)  $("#HomeText").text("View Employee (ID:"+data.employeeId+")");
		$("#firstNameText").text(data.firstName); $("#LastnameText").text(data.lastName); 
		$("#DepartmentText").text(data.deptText); $("#DesignationText").text(data.desigText); 
		$("#ContactText").text(data.contactNo);  $("#EmailText").text(data.emailId);
		$("#LocationText").text(data.location);  $("#SupervisorText").text(data.reportTo);
		$("#ExperienceText").text(data.location);  $("#CompensationText").text(data.reportTo);

	    $('#empFirstName').val(data.firstName);	$('#empLastName').val(data.lastName);
	    //console.log($('select[name^="department"] option[value="'+data.department+'"]').attr("selected","selected"));
	    //$("#department option[value='"+data.department+"']").prop('selected', true);
	    
	   // console.log($('#department').val(1),$('#department option').eq(1), $('#department option').eq(1).prop('selected',true));
	    $('#department').val(data.department);
	   	document.querySelector('#designation').value=data.designation;
	    $('#empMobileNo').val(data.contactNo);		$('#empEmailID').val(data.emailId);		
	    $('#empLocation').val(data.location);		$('#empSupervisor').val(data.reportTo);
	    $('#empExperience').val(data.experience);	$('#empCompensation').val(data.compensation);
	    $("#action").val("updat");
	    $("#saveEmployeeForm").addClass("HideThisElement");
	    $("#EditEmployeeForm").removeClass("HideThisElement");
	    
	    
	    $("#PrEmpTableDiv").addClass("HideThisElement");
		$("#PrEmpViewDiv").removeClass("HideThisElement");
		$("#PrEmpFormDiv").addClass("HideThisElement");
		$("#EmpViewDiv").removeClass("HideThisElement");
	});
	
	$('#editClick').click(function() {
		if(window.location.href.indexOf("JSPs/ProjectEmployee.jsp?")>=0) $("#HomeText").text("Edit Employee (ID:"+$('#EmployeeId').val()+")");
		$("#saveEmployeeForm").addClass("HideThisElement");
	    $("#EditEmplPrEmpeForm").removeClass("HideThisElement");
	    $("#cancelEmployeeForm").removeClass("HideThisElement");	    
		$("#alertMessage").addClass("HideThisElement");
		$("#errorMessage").addClass("HideThisElement");
		$("#successMessage").addClass("HideThisElement");
		$("#PrEmpTableDiv").addClass("HideThisElement");
		$("#PrEmpViewDiv").addClass("HideThisElement");
		$("#PrEmpFormDiv").removeClass("HideThisElement");
	});
	
	/*$('#datatables tbody').on( 'click', '.select_me', function () {
    	var data = table.row( $(this).parents('tr') ).data();
        document.querySelector('#ResetPassEmpId').value = data.employeeId;
    	$('#centralModalWarningDemo').modal('show');
    } );*/
    
    $('#datatables tbody').on( 'click', '.delete_me', function () {
    	var data = table.row( $(this).parents('tr') ).data();
    	document.querySelector('#DeleteEmpId').value = data.employeeId;
    	$('#centralModalDangerDemo').modal('show');
    });
    
    $("#DeleteEmployeeConfirmed").click(function() {
        var DeleteEmpId = document.querySelector('#DeleteEmpId').value;
        $.ajax({
            type: "GET",
            url: '../../../ModifyProjectEmployee?id=' + DeleteEmpId,
            success: function(data) {
                if (data == 0) {
                    $('#centralModalDangerDemo').modal('hide');
                    $(".errorMsg").removeClass("HideThisElement");
                    $("#errorMsg").html(' <strong>Error!</strong> Failed to Delete Employee!');
                } else {
                    $('#centralModalDangerDemo').modal('hide');
                    $('#selectedEmployeeId').val('');
                    $('#datatables').DataTable().ajax.reload();
                    $(".successMsg").removeClass("HideThisElement");
                    $("#successMsg").html(' <strong>Success!</strong>  Employee Deleted Successfully!');
                }
            }
        })
        return false; // avoid to execute the actual submit of the form.
    });
});

function loadBlankform() {
	$("#HomeText").text("New Employee");
	document.getElementById("newEmployeeForm").reset();
	$("#saveEmployeeForm").removeClass("HideThisElement");
	$("#EditEmployeeForm").addClass("HideThisElement");
	$("#cancelEmployeeForm").removeClass("HideThisElement");	    
	$("#alertMessage").addClass("HideThisElement");
	$("#errorMessage").addClass("HideThisElement");
	$("#successMessage").addClass("HideThisElement");
	$("#PrEmpTableDiv").addClass("HideThisElement");
	$("#PrEmpViewDiv").addClass("HideThisElement");
	$("#PrEmpFormDiv").removeClass("HideThisElement");
	$("#action").val("insert");
	var generator = new IDGenerator();
	DropDownForProjectLegend();
	$("#EmployeeId").val("PrE"+ generator.generate());
}