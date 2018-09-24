function getObservationlist(){//	FnDropDown();processDropDown();
    var str="?1=1";
    if($("#projectid").val()){
    	str+="&projectid="+$("#projectid").val();
    }
   if($("#ObservationDeptId").val()){
	    if($("#ObservationDeptId").val()!=""&&$("#ObservationDeptId").val()!="null" && $("#ObservationDeptId").val()!="0"){
	    	str+="&ObservationDeptId="+$("#ObservationDeptId").val();
	    }
   }
    if($("#Observationprocessid").val()!="null"){
    	str+="&Observationprocessid="+$("#Observationprocessid").val();
    }
    $('#Observationdatatables thead #filterrow th').each( function (index) { 
	    	var title = $($('#Observationdatatables thead #headerrow th')[index+1]).text();
	        $(this).html( '<input type="text" style="font-size: 80%;padding:auto;text-align:center;width:80%;" placeholder="'+title+'" />' );
    } );
	
    $("#Observationdatatables thead input").on('keyup change', function () {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
	var table = $('#Observationdatatables').DataTable( {
		dom: 'Bfrtip',
        buttons: getDepartmentButtons(),
        "bServerSide": false,
		"bLengthChange": false,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "../../../GetObservationList"+str,
		"columns": [        	 
			{
             	className: "center",
                 defaultContent: '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> '+
                 '<i class="delete_me fa fa-trash fa-2x" aria-hidden="true"></i> '
             },
             { "data": "name", "sWidth":"50%" },
             { "data": "projectName" , "sWidth":"30%" },
             { "data": "department_text" , "sWidth":"5%" },
             { "data": "processName" , "sWidth":"5%" },
             { "data": "function_text"  , "sWidth":"3%"},
             { "data": "defectType_text"  , "sWidth":"4%"},
             { "data": "createdOn" , "sWidth":"1%" },
             { "data": "observation_ation" ,"sClass":"center" , "sWidth":"1%"},
             { "data": "impact_ation" ,"sClass":"center" , "sWidth":"1%"}
        ],
        "initComplete": function(settings, json) {   
        	$("."+$("#ObservationDeptId").val()+'btn1').removeClass("dt-button1");
        	$("."+$("#ObservationDeptId").val()+'btn1').addClass("dt-button2");
        	$(function () {
        	    $('[data-toggle="popover"]').popover()
        	});
        	 if(true){console.log("sdfsfsf");
    	    	$(".dt-button1").removeClass("HideThisElement");
    	     }
        },
        fixedColumns: true
    });
	$('#Observationdatatables tbody').off('click');

	$('#Observationdatatables tbody').on( 'click', '.select_me', function () {
		$("#ObservationCard").addClass("HideThisElement");
		$("#ObservationViewDiv").removeClass("HideThisElement");
		$("#observationFormDiv").addClass("HideThisElement");
		$("#addObservationForm #SubmitButtonRegister").addClass("HideThisElement");
		$("#addObservationForm #SubmitButtonUpdate").removeClass("HideThisElement");
		var data = table.row($(this).parents('tr')).data();
		$("#HomeText").text("Edit Opportunity Matrix (ID: "+data.rowId+" )");		
		$("#ObservationText").val(data.name);
		$(".card-title").text(data.name);
		$("#ObservationId").val(data.rowId);
		$("#ProjectId").val(data.projectId);
		$("#projectText").val(data.projectName); $("#ProjectNameText").text(data.projectName);	$("#projectLbl").addClass("active");
		$("#processText").val(data.processName);	$("#processLbl").addClass("active");   
		$("#department").val(data.department);		$("#DepartmentText").text(data.department_text);
		FnDropDown(data.process, data.department);processDropDown(data.function1, data.department);
		$("#process").val(data.process);  $("#ProcessnameText").text(data.processName);
		$("#function").val(data.function1);		$("#DefectTypeText").text(data.defectType_text);
		$("#defectType").val(data.defectType);		$("#FunctionText").text(data.function_text);
		$("#ObservationVText").html(data.observation);  $("#observationDiv .nicEdit-main").html(data.observation);
		$("#ImpactVText").html(data.impact);	$("#impactDiv .nicEdit-main").html(data.impact);
		$("textarea#impact").val(data.impact);	$("#impactLbl").addClass("active");
		$("textarea#observation").val(data.observation);	$("#observationLbl").addClass("active");	
	});
	
	$('#Observationdatatables tbody').on( 'click', '.delete_me', function (){
		$("#centralModalDangerDemo").modal('show');
		var data = table.row($(this).parents('tr')).data();
		$(".heading").text('Delete Opportunity Matrix');
		$("#wInfo").text('Opportunity Matrix details will be deleted from system.');
		$("#DeleteId").val(data.rowId);
		$("#what").val("Opportunity Matrix");
	});
}	

function loadBlankformForInterview() {
	$("#HomeText").text("New Opportunity Matrix");
	document.getElementById("addObservationForm").reset();
	var generator=new IDGenerator();
	$("#ObservationId").val("O"+generator.generate());
	$("#ObservationCard").addClass("HideThisElement");
	$("#ObservationViewDiv").addClass("HideThisElement");
	$("#observationFormDiv").removeClass("HideThisElement");
	$("#addObservationForm #SubmitButtonUpdate").addClass("HideThisElement");
	$("#addObservationForm #SubmitButtonRegister").removeClass("HideThisElement");
	$("#alertMessage").addClass("HideThisElement");
	$("#errorMessage").addClass("HideThisElement");
	$("#successMessage").addClass("HideThisElement");
	DropDownForEvaluation();
	DropDownForProjectLegend();	
}


function getDepartmentButtons() {
	var deptArray=[];
	deptArray.push(
	{
        text: "New Opportunity Matrix",
        action: function ( e, dt, node, config ) {
        	loadBlankformForInterview();
        }
    });
	$.ajax({
		url:'../../../GetProjectLegendList?projectid='+$("#projectid").val(),
		type:"GET",
		async:false,
		success:function(data){
			if(data.data.length>0){
				for (var i = 0; i < data.data.length; i++) {	
					if (data.data[i].subCategory == "Department") {
						deptArray.push(
						{
					        text: data.data[i].description,
					        action: function ( e, dt, node, config ) {
					        	setDepartmentId(config);
					        },
					        className:data.data[i].rowId+'btn1 dt-button1'
					    });
					}
				}
				deptArray.push(
				{
			        text: "All",
			        action: function ( e, dt, node, config ) {
			        	setDepartmentId(config);
			        },
			        className:'0btn1 dt-button1'
			    });
			}
		}
	});
	return deptArray;
}

function setDepartmentId(id) {console.log();
	$("#ObservationDeptId").val(((id.className).replace('btn1','')).replace(' dt-button1',''));
	$('#Observationdatatables').DataTable().destroy();
	getObservationlist();
}