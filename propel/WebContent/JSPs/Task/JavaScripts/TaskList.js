$(document).ready(function() {
	
	if($("#what").val() == "newTask")
	{
		$("#taskListSection").addClass("HideThisElement");
		$("#taskSection").removeClass("HideThisElement");
    	$("#RegisterTask").removeClass("HideThisElement");
    	$("#UpdateTask").addClass("HideThisElement");
	}
	else
	{
		$("#taskListSection").removeClass("HideThisElement");
		$("#taskSection").addClass("HideThisElement");
	}
	var generator = new IDGenerator();
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();
//	$('#startTime').timepicker().val("9:00 AM");
//	$("#startTime").val('9:00 AM');
	if(dd<10) {
	    dd = '0'+dd
	} 

	if(mm<10) {
	    mm = '0'+mm
	} 

	today = yyyy + '-' + mm + '-'+dd ;
//	console.log(today);
	$('#datepicker').data({date: today});
	$('#datepicker').datepicker('update');
	$('#datepicker').datepicker().children('input').val(today);
	
	var table = $('#taskListTable').DataTable({
		dom: 'Bfrtip',
        buttons: [
        	{
                extend: 'csv',
                exportOptions: {
                    columns: "thead th:not(.noExport)"
                }
            },
            {
                text: 'New Task',
                action: function ( e, dt, node, config ) {
                	$("#taskListSection").addClass("HideThisElement");
                	$("#taskSection").removeClass("HideThisElement");
                	$("#UpdateTask").addClass("HideThisElement");
                }
            }
        ],
		"bLengthChange": false,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "../../../GetTaskList?date="+$("#date").val(),
		"columns": [
        	{ "data": "action" },
            { "data": "title" },
            { "data": "projectName" },
            { "data": "moduleName" },
            { "data": "date" },
            { "data": "assignedBy" },
            { "data": "status" },
            { "data": "createdByEmp" },
            { "data": "duration" }
        ],
    });

    $('#taskListTable tbody').on( 'click', '.select_me', function () {
    	var data = table.row( $(this).parents('tr') ).data();
    	$("#taskListSection").addClass("HideThisElement");
    	$("#taskSection").removeClass("HideThisElement");
    	$("#RegisterTask").addClass("HideThisElement");
    	$("#UpdateTask").removeClass("HideThisElement");
    	
    	$("#taskId").val(data.rowId);
    	$("#projectName").val(data.projectName);
    	$("#module").val(data.moduleName);
    	$("#assignedBy").val(data.assignedBy);
    	
    	$('#datepicker').data({date: data.date});
    	$('#datepicker').datepicker('update');
    	$('#datepicker').datepicker().children('input').val(data.date);
    	
    	$("#startTime").val(data.startTimeToShow);
    	$("#endTime").val(data.endTimeToShow);
    	
    	$("#status").val(data.status);
    	$("#description").val(data.description);
    });

    $("#RegisterTask").click(function() {
    	console.log($("#testIdDate").val());
    	$.ajax({
            type: "POST",
            url: '../../../RegisterTask',
            data : $("#taskForm").serialize()+"&rowId="+generator.generate(),
            success: function(data)
            {
                if (data == 0)
                {
                	$("#alertMessages").removeClass("HideThisElement");
                	$("#alertMessages").addClass("alert-danger");
                	$("#alertMessages").removeClass("alert-success");
				}
                else
                {
                	$("#alertMessages").removeClass("HideThisElement");
                	$("#alertMessages").removeClass("alert-danger");
                	$("#alertMessages").addClass("alert-success");
                	$("#alertMessages").html("<strong>Success!</strong> Task Register Successfully!");
					document.getElementById("taskForm").reset();
				}
            }
		})
		return false;
    });

    $("#UpdateTask").click(function() {
    	$.ajax({
            type: "POST",
            url: '../../../UpdateTask',
            data : $("#taskForm").serialize(),
            success: function(data)
            {
                if (data == 0)
                {
                	$("#alertMessages").removeClass("HideThisElement");
                	$("#alertMessages").addClass("alert-danger");
                	$("#alertMessages").removeClass("alert-success");
				}
                else
                {
                	$("#alertMessages").removeClass("HideThisElement");
                	$("#alertMessages").removeClass("alert-danger");
                	$("#alertMessages").addClass("alert-success");
                	$("#alertMessages").html("<strong>Success!</strong> Task Register Successfully!");
					document.getElementById("taskForm").reset();
				}
            }
		})
		return false;
    });

    /*$("#next").click(function() {
    	var date = new Date($("#date").val());
    	var month = 0;
    	var dd = 0;
    	var dateToDisplay ="";
    	
    	date.setDate(date.getDate()+7);

    	month = parseInt(date.getMonth())+1;
    	dd = parseInt(date.getDate());
    	
    	if(month<10)
    	{
    		month = "0"+month;
    	}
    	
    	if(dd<10)
    	{
    		dd = "0"+dd;
    	}
    	
    	date = date.getFullYear() + '-' + month + '-' + dd;
    	$("#date").val(date);
    	fillDates();
    	dateToDisplay =dd+'-'+month+' to ';
    	
    	date = new Date($("#date").val());
    	date.setDate(date.getDate()+6);
    	
    	month = parseInt(date.getMonth())+1;
    	dd = parseInt(date.getDate());
    	
    	if(month<10)
    	{
    		month = "0"+month;
    	}
    	
    	if(dd<10)
    	{
    		dd = "0"+dd;
    	}

    	dateToDisplay += dd+'-'+month;
    	
    	$("#daysDisplayed").html(dateToDisplay);
    });*/

    /*$("#dateButton").click(function() {
    	var date = $('#datepicker').datepicker().children('input').val();
    	var arr = date.split('-');
    	
    	var month = arr[0];
    	var year = arr[1];
    	
    	date = year + '-' + month + '-01';
    	$("#date").val(date);
    	fillDates();
    });*/

    /*$("#submitDates").click(function() {
        var table1 = document.getElementById('taskListTableBody');
        var rowCount = table1.rows.length;
        var successStatus = false;
        var otherData = "employeeId="+$('#employeeId').val();
        for(i=0; i < rowCount;i++)
        {
        	var row = table1.rows[i];
        	var formData = "";
			for(var j=0; j<$(row.cells).length; j++){
				if(j==2)
				{
					formData+="date="+$(row.cells[j]).html()+"&";
				}
				else if(j==3)
				{
					var name = $($(row.cells[j]).html()).attr('name');
					formData+=name+"="+$(row.cells[j].childNodes[0]).val()+"&";
				}
				else if(j==4)
				{
					var name = $($(row.cells[j]).html()).attr('name');
					formData+=name+"="+$(row.cells[j].childNodes[0]).val()+"&";
				}
			}
			formData+=otherData;
			console.log(formData);
	        $.ajax({
	            type: "GET",
	            url: "../../../UpdateAttendance",
	            data: formData ,
	            success: function(data) {
	                if (data == 1) {
	                    successStatus = true;
	                } else {
	                    successStatus = false;
	                }
	            }
	        });
        }
        if (successStatus) {
            toastr.success('Attendance Updated Successfully!');
        } else {
            toastr.error('Failed to Update Attendance!');
        }
        return false;
    });*/
});