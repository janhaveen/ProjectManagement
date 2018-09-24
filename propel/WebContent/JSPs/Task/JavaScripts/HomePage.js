$(document).ready(function() {
	var generator = new IDGenerator();
	
	var table = $('#daywiseListTable').DataTable({
		dom: 'Bfrtip',
        buttons: [
        	{
                extend: 'csv',
                exportOptions: {
                    columns: "thead th:not(.noExport)"
                }
            }
        ],
		"bLengthChange": false,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "../../../GetDateWiseTaskList",
		"columns": [
        	{ "data": "action" },
            { "data": "date" },
            { "data": "Abhishek Todkar" },
            { "data": "Janhavee Narkar" }
        ],
    });

    $('#daywiseListTable tbody').on( 'click', '.select_me', function () {
    	var data = table.row( $(this).parents('tr') ).data();
    	window.location.href = '../JSPs/Task.jsp?date='+data.date;
    	/*$("#taskListSection").addClass("HideThisElement");
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
    	$("#description").val(data.description);*/
    });
});