function getProcesslist(){	
	DropDownForProjectLegend();

	if(window.location.href.indexOf("JSPs/Process.jsp?")>=0) $("#HomeText").text("Process List");
    var str="?1=1";
    if($("#projectid").val()){
    	if($("#projectid").val()!="null")
    		str+="&projectid="+$("#projectid").val();
    }
    if($("#interviewId").val()){
    	if($("#interviewId").val()!="null")
    		str+="&interviewid="+$("#interviewId").val();
    }
    
    if($("#departmentforTable").val()){
    	if($("#departmentforTable").val()!="null" && $("#departmentforTable").val()!="0")
    		str+="&department="+$("#departmentforTable").val();
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
    var actionStr="";
   
    	actionStr+='<i class="view_me fa fa-pencil-alt fa-2x" aria-hidden="true"></i> ';
    	actionStr+='<i class="delete_me fa fa-trash fa-2x" aria-hidden="true"></i> ';
    
    if(window.location.href.indexOf("JSPs/Interview.jsp?")>=0){
    	$(".viewOn1").addClass("HideThisElement");
    	$(".viewOn").removeClass("HideThisElement");
    }else {
    	$(".viewOn1").removeClass("HideThisElement");
    	$(".viewOn").addClass("HideThisElement");
	}
    
	var table = $('#Processdatatables').DataTable( {
		dom: 'Bfrtip',
		buttons: getDepartmentButtons(),
        //"bServerSide": true,
		"bLengthChange": false,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "../../../GetProcess"+str,
		"columns": [        	 
			{
             	className: "center viewOn",
                 defaultContent: actionStr
                 
             },
             { "data": "i" ,"sClass":"center viewOn1 " },
             //{ "data": "rowId" ,"sClass":"center" },
             { "data": "processName"  },
             { "data": "dept_text"  },
             { "data": "type"  },
             { "data": "supplier_action" ,"sClass":"center" },
             { "data": "input_action"  ,"sClass":"center"},
             { "data": "process_action" ,"sClass":"center" },
             { "data": "output_action","sClass":"center"  },
             { "data": "customer_action"  ,"sClass":"center"},
             //{ "data": "observationCount" ,"sClass":"right" },
            
             //{ "data": "description_ation" ,"sClass":"center" }
        ],
        "initComplete": function(settings, json) {       
        	if(window.location.href.indexOf("JSPs/Interview.jsp?")<0){
            	$(".viewOn1").addClass("HideThisElement");
            	$(".viewOn").removeClass("HideThisElement");
            }else {
            	$(".viewOn1").removeClass("HideThisElement");
            	$(".viewOn").addClass("HideThisElement");
        	}
        	$(function () {
        	    $('[data-toggle="popover"]').popover()
        	})
        	$("."+$("#departmentforTable").val()+'btn1').removeClass("dt-button1");
        	$("."+$("#departmentforTable").val()+'btn1').addClass("dt-button2");
        	$(function () {
        	    $('[data-toggle="popover"]').popover()
        	});
        },
        fixedColumns: true
    });
	
	$('#Processdatatables tbody').off('click');
	
	$('#Processdatatables tbody').on( 'click', '.select_me', function () {
		var data = table.row($(this).parents('tr')).data();
		window.location.href="../../../JSPs/Operations/JSPs/Observations.jsp?processid="+data.rowId;
	});
	
	$('#Processdatatables tbody').on( 'click', '.view_me', function () {
		var data = table.row($(this).parents('tr')).data();
		$("#HomeText").text("Edit Process (ID: "+data.rowId+")");
		$("#EditProcessFormDiv").removeClass('HideThisElement');
		$("#ProcessCard").addClass('HideThisElement');
		$("#ProcessViewDiv").removeClass('HideThisElement');
		$("#formProcess").addClass('HideThisElement');
		$("#ProcessId").val(data.rowId);
		$("#EditProcessForm #action").val("updat");
		$("#procedureTitle").val(data.processName);$("#ProcedureText").text(data.processName);
		$("input[name='processDocType'][value='"+data.type+"']").prop('checked', true); 
		$("#DocumentTypeText").text(data.type); $("#EditProcessForm #department").val(data.department);
		$("#procedureComments").val(data.description);$("#empRoleLbl").addClass('active'); $
		("#CommentsText").text(data.description)
		$("#supplier").val(data.supplier);$("#supplierLbl").addClass('active'); $("#SupplierText").text(data.supplier)
		$("#inputText").val(data.input);$("#inputTextLbl").addClass('active');$("#InputText").text(data.input)
		$("#processText").val(data.process);$("#processTextLbl").addClass('active');
		$("#ProcessText").html(data.process); $("#EditProcessForm .nicEdit-main").html(data.process)
		$("#outputText").val(data.output);$("#outputTextLbl").addClass('active');$("#OutputText").text(data.output)
		$("#customer").val(data.customer);$("#customerLbl").addClass('active');		$("#CustomerText").text(data.customer)
		$("#EditProcessForm #SubmitButtonUpdate").removeClass("HideThisElement");
		$("#EditProcessForm #SubmitButtonRegister").addClass("HideThisElement");
	});
	
	$('#Processdatatables tbody').on( 'click', '.delete_me', function () {
    	var data = table.row( $(this).parents('tr') ).data();
    	document.querySelector('#DeleteProcessId').value = data.rowId;
    	$('#centralModalDangerDemo').modal('show');
    });
}	

/*function loadBlankformForProcess() {
	document.getElementById("addObservationForm").reset();
	var generator=new IDGenerator();
	$("#rowId").val("O"+generator.generate());
	$("#ObservationCard").addClass("HideThisElement");
	$("#observationFormDiv").removeClass("HideThisElement");
	$("#addObservationForm #SubmitButtonUpdate").addClass("HideThisElement");
	$("#addObservationForm #SubmitButtonRegister").removeClass("HideThisElement");
}*/

function getDepartmentButtons() {
	var deptArray=[];
	deptArray.push(
	{
        text: "New Process",
        action: function ( e, dt, node, config ) {
        	loadBlankformForProcess();
        }, 
        className:'newProcessbtn'
    });
	$.ajax({
		url:'../../../GetProjectLegendList?type=Department&projectid='+$("#projectid").val(),
		type:"GET",
		async:false,
		success:function(data){
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
			}deptArray.push(
					{
				        text: "All",
				        action: function ( e, dt, node, config ) {
				        	setDepartmentId(config);
				        },
				        className:'0btn1 dt-button1'
				    });
		}
	});
	return deptArray;
}

function setDepartmentId(id) {console.log(id);
	console.log($("#departmentforTable").val(((id.className).replace('btn1','')).replace(' dt-button1','')));
	$('#Processdatatables').DataTable().destroy();
	getProcesslist();
}

function loadBlankformForProcess() {
	document.getElementById("EditProcessForm").reset();
	var generator=new IDGenerator();
	$("#HomeText").text("New Process");
	$("#ProcessId").val("IPr"+generator.generate());
	$("#EditProcessForm #action").val("insert");
	$("#ProcessCard").addClass('HideThisElement');
	$("#ProcessViewDiv").addClass('HideThisElement');
	$("#formProcess").removeClass('HideThisElement');
	$("#EditProcessForm #SubmitButtonUpdate").addClass("HideThisElement");
	$("#EditProcessForm #SubmitButtonRegister").removeClass("HideThisElement");
	DropDownForProjectLegend();
}