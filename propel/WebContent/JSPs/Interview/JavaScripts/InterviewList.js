function getInterviewlist(){
	DropDownForProjectLegend(); DropDownForEvaluation();
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
             //{ "data": "rowId" ,"sClass":"poPrdct" },
            { "data": "createdOn" },
             { "data": "projectName"  },
             { "data": "empName"  },
             //{ "data": "role1"  },
             { "data": "createdBy_txt"  }
        ],
        fixedColumns: true
    });
	$('#InterViewdatatables tbody').off('click');

	$('#InterViewdatatables tbody').on( 'click', '.select_me', function () {		
		
		/*$("#newEmployeeForm #saveEmployeeForm").addClass("HideThisElement");
		$("#newEmployeeForm #EditEmployeeForm").removeClass("HideThisElement");*/
		$("#newWhoForm #saveWhoForm").addClass("HideThisElement");
		$("#newWhoForm #editWhoForm").removeClass("HideThisElement");
		var data = table.row($(this).parents('tr')).data();		
		$("#HomeText").text("Edit Interview (Interview ID: "+data.rowId+" )");
		$("#EmployeeId").val(data.EmployeeId);	
		$("#department").val(data.department);
		$("#firstNameText").text(data.firstName); 
		$("#LastnameText").text(data.lastName);
		document.querySelector('#newEmployeeForm #department').value = data.department;
		$("#DepartmentText").text(data.department_txt);
		$("#DesignationText").text(data.designation_txt);
		$("#MobileNoText").text(data.contactNo);	
		$("#empEmailID").val(data.emailId);	
		$("#EmailText").text(data.emailId);
		$("#empLocation").val(data.location);	
		$("#LocationText").text(data.location);
		$("#empSupervisor").val(data.reportTo);	
		$("#ReportToText").text(data.reportTo);
		$("#empExperience").val(data.experience);	
		$("#ExperienceText").text(data.experience);	
		$("#InterviewId").val(data.rowId);
		$("#meeting").val(data.meeting);  $("#MeetingText").text(data.meeting_txt);	
		$("#coaching").val(data.coaching);  $("#CoachingText").text(data.coaching_txt);	
		$("#training").val(data.training);  $("#TrainingText").text(data.training_txt);	
		$("textarea#empRole").val(data.role1); 	
		$("#RoleText").html(data.role1); $("#RoleDiv .nicEdit-main").html(data.role1);
		$("textarea#obChallenges").val(data.challenges);	
		$("#ChallengesText").html(data.challenges);	$("#ChallengesDiv .nicEdit-main").html(data.challenges);
		//$("#newEmployeeForm #action").val("updat");
		$("#newWhoForm #action").val("updat");
		/*$("#upd").removeClass("HideThisElement");
		$("#add").addClass("HideThisElement");*/
		$("#departmentforTable").val(data.department); 
		$('.withTable').DataTable().destroy();
		getWithList();
		$('#howTable').DataTable().destroy();
		getHowList();
		$('.auditTable').DataTable().destroy();
		getAuditList();
		$('#Processdatatables').DataTable().destroy();
		getProcesslist();
		$("#InterViewCard").addClass("HideThisElement");
		$("#InterviewViewDiv").removeClass("HideThisElement");
		$("#InterviewFormDiv").addClass("HideThisElement");
	});
	
	$('#InterViewdatatables tbody').on( 'click', '.view_me', function () {
		var data = table.row($(this).parents('tr')).data();
		window.location.href="../../../JSPs/Interview/JSPs/Process.jsp?iId="+data.rowId;
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
	//document.getElementById("newEmployeeForm").reset();
	document.getElementById("newWhoForm").reset();
	var generator=new IDGenerator();
	$("#HomeText").text("New Interview");
	//$("#EmployeeId").val("PrE"+generator.generate());
	$("#InterviewId").val("I"+generator.generate());
	$("#newEmployeeForm #action").val("insert");
	$("#newWhoForm #action").val("insert");
	$("#InterViewCard").addClass("HideThisElement");
	$("#InterviewFormDiv").removeClass("HideThisElement");
	$("#InterViewViewDiv").addClass("HideThisElement");
	$("#newEmployeeForm #EditEmployeeForm").addClass("HideThisElement");
	$("#newEmployeeForm #saveEmployeeForm").removeClass("HideThisElement");
	$("#newWhoForm #saveWhoForm").removeClass("HideThisElement");
	$("#newWhoForm #editWhoForm").addClass("HideThisElement");
	$("#add").removeClass("HideThisElement");
	$("#upd").addClass("HideThisElement");
	DropDownForProjectLegend(); DropDownForEvaluation();
	/*$('.auditTable').DataTable().destroy();
	getAuditList();
	$('#withTable').DataTable().destroy();
	getWithList();*/
}