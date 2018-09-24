function getInterviewlist(){
	var actionStr="";
    if(($("#t").val()).indexOf("1")>=0){
    	actionStr='<i class="view_me fa fa-eye fa-2x" aria-hidden="true"></i> ';
    }else{
    	actionStr='<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> '+
    	'<i class="delete_me fa fa-trash fa-2x" aria-hidden="true"></i> ';
    }
	$('#InterViewdatatables thead #filterrow th').each( function (index) { 
		//if(index!=0){
	    	var title = $($('#InterViewdatatables thead #headerrow th')[index+1]).text();
	        $(this).html( '<input type="text" style="font-size: 80%;padding:auto;text-align:center;width:80%;" placeholder="'+title+'" />' );
		//}
    } );
	
    $("#InterViewdatatables thead input").on('keyup change', function () {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
    
    var str="?1=1";
    if($("#projectid").val()){
    	if($("#projectid").val()!="null")
    	str+="&projectid="+$("#projectid").val();
    }
    
	var table = $('#InterViewdatatables').DataTable( {
		dom: 'Bfrtip',
        buttons: [
            {
                text: 'New Interview',
                action: function ( e, dt, node, config ) {
                	loadBlankformForInterview();
                }
            }
        ],
        "bServerSide": true,
		"bLengthChange": false,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "../../../GetInterviewList"+str,
		"columns": [        	 
			{
             	className: "center",
                 defaultContent: actionStr
             },
             { "data": "rowId" ,"sClass":"poPrdct" },
             { "data": "createdOn" },
             { "data": "projectName"  },
             { "data": "empName"  },
             { "data": "role1"  },
             { "data": "createdBy_txt"  }
        ],
        fixedColumns: true
    });
	
	$('#InterViewdatatables tbody').on( 'click', '.select_me', function () {
		$("#InterViewCard").addClass("HideThisElement");
		$("#evaluationFormDiv").removeClass("HideThisElement");
		$("#addInterViewForm #SubmitButtonRegister").addClass("HideThisElement");
		$("#addInterViewForm #SubmitButtonUpdate").removeClass("HideThisElement");
		var data = table.row($(this).parents('tr')).data();
		$("#HomeText").text("Edit Interview (Interview ID: "+data.rowId+" )");
		$("#InterviewId").val(data.rowId);
		$("#empName").val(data.empName);	$("#empNameLbl").addClass("active");
		$("#designation").val(data.designation);
		$("#designationText").val(data.designation_txt);	$("#designationLbl").addClass("active");
		$("#experience").val(data.experience);	$("#experienceLbl").addClass("active");
		$("#compensation").val(data.compensation);	$("#compensationLbl").addClass("active");
		$("#meeting").val(data.meeting);
		$("#meetingText").val(data.meeting_txt);	$("#meetingsLbl").addClass("active");
		$("#coaching").val(data.coaching);
		$("#coachingText").val(data.coaching_txt);	$("#coachingLbl").addClass("active");
		$("#training").val(data.training);
		$("#trainingText").val(data.training_txt);	$("#trainingLbl").addClass("active");
		$("textarea#empRole").val(data.role1);	$("#empRoleLbl").addClass("active");
		$("#action").val("updat");
		getProcess();
	});
	$('#InterViewdatatables tbody').on( 'click', '.view_me', function () {
		var data = table.row($(this).parents('tr')).data();
		window.location.href="../../../JSPs/Operations/JSPs/Process.jsp?iId="+data.rowId;
	});
	$('#InterViewdatatables tbody').on( 'click', '.delete_me', function () {
		var data = table.row($(this).parents('tr')).data();
		$(".heading").text("Delete Interview");
		$("#DeleteId").val(data.rowId);
		$("#wInfo").text('Interview details will be deleted from system.');
		$("#what").val("Interview");
		$("#centralModalDangerDemo").modal('show');
	});
}	

function loadBlankformForInterview() {
	document.getElementById("addInterViewForm").reset();
	var generator=new IDGenerator();
	$("#HomeText").text("New Interview");
	$("#InterviewId").val("I"+generator.generate());
	$("#action").val("insert");
	$("#InterViewCard").addClass("HideThisElement");
	$("#evaluationFormDiv").removeClass("HideThisElement");
	$("#addInterViewForm #SubmitButtonUpdate").addClass("HideThisElement");
	$("#addInterViewForm #SubmitButtonRegister").removeClass("HideThisElement");
}