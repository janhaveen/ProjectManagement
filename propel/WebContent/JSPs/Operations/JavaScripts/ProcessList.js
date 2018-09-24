function getProcesslist(){
	$("#HomeText").text("Process List");
    var str="?1=1";
    if($("#projectid").val()){
    	if($("#projectid").val()!="null")
    		str+="&projectid="+$("#projectid").val();
    }
    if($("#interviewId").val()){
    	if($("#interviewId").val()!="null")
    		str+="&interviewid="+$("#interviewId").val();
    }
    
    $('#Processdatatables thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:auto;text-align:center;width:80%;" placeholder="'+title+'" />' );
    } );
	
    $("#Processdatatables thead input").on('keyup change', function () {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
    
    if($("#interviewId").val()!="null"){
    	actionStr='<i class="view_me fa fa-pencil-alt fa-2x" aria-hidden="true"></i> ';
    }else{
    	actionStr='<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> ';
    }
    
	var table = $('#Processdatatables').DataTable( {
		dom: 'Bfrtip',
        buttons: [
            /*{
                text: 'New Process',
                action: function ( e, dt, node, config ) {
                	loadBlankformForProcess();
                }
            }*/
        ],
        "bServerSide": true,
		"bLengthChange": false,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "../../../GetProcess"+str,
		"columns": [        	 
			{
             	className: "center",
                 defaultContent: actionStr
                 
             },
             { "data": "rowId" ,"sClass":"center" },
             { "data": "processName"  },
             { "data": "dept_text"  },
             { "data": "observationCount" ,"sClass":"right" },
             { "data": "function_text"  },
             { "data": "description_ation" ,"sClass":"center" }
        ],
        "initComplete": function(settings, json) {        
        	$(function () {
        	    $('[data-toggle="popover"]').popover()
        	})
        },
        fixedColumns: true
    });
	
	$('#Processdatatables tbody').on( 'click', '.select_me', function () {
		var data = table.row($(this).parents('tr')).data();
		window.location.href="../../../JSPs/Operations/JSPs/Observations.jsp?processid="+data.rowId;
	});
	
	$('#Processdatatables tbody').on( 'click', '.view_me', function () {
		EvaluationAutocomplete();
		var data = table.row($(this).parents('tr')).data();
		$("#EditProcessFormDiv").removeClass('HideThisElement');
		$("#ProcessCard").addClass('HideThisElement');
		$("#formProcess").removeClass('HideThisElement');
		$("#saveProcessDescButton").removeClass('HideThisElement');
		$("#action1").val("updat");
		$("#ProcessId").val(data.rowId);
		$("#processTitle").val(data.processName);$("#processTitleLbl").addClass('active');
		$("#departmentText").val(data.dept_text);$("#departmentLbl").addClass('active');
		$("#department").val(data.department);
		$("#functionName").val(data.function1);
		$("#functionNameText").val(data.function_text);$("#functionNameLbl").addClass('active');
		$("#processDetails").val(data.description);$("#processDetailsLbl").addClass('active');
		$("#processFormModal").modal('show');
		$('#formatTable').DataTable().destroy();
		getFormat();
		console.log($('#FtH').click());
		$('#ToolTable').DataTable().destroy();
		getTool();
	});
}	

function loadBlankformForInterview() {
	document.getElementById("addObservationForm").reset();
	var generator=new IDGenerator();
	$("#rowId").val("O"+generator.generate());
	$("#ObservationCard").addClass("HideThisElement");
	$("#observationFormDiv").removeClass("HideThisElement");
	$("#addObservationForm #SubmitButtonUpdate").addClass("HideThisElement");
	$("#addObservationForm #SubmitButtonRegister").removeClass("HideThisElement");
}