function getPOAlist(){
    var str="?1=1";DropDownForProjectEmployee();dropDownForPOALegend();
    if($("#projectid").val()!="null"){
    	str+="&projectid="+$("#projectid").val();
    }
    if($("#statusId").val()){
    	if($("#statusId").val()!="0" && ($("#statusId").val()!="null"))
    		str+="&statusId="+$("#statusId").val();
    }
    
    $('#POAdatatables thead #filterrow th').each( function (index) { 
		//if(index!=0){
	    	var title = $($('#POAdatatables thead #headerrow th')[index+1]).text();
	        $(this).html( '<input type="text" style="font-size: 80%;padding:auto;text-align:center;width:80%;" placeholder="'+title+'" />' );
		//}
    } );
	
    $("#POAdatatables thead input").on('keyup change', function () {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
    
    if($("#v").val()!="null"){
    	str+="&viewOnly="+$("#v").val();
    }else {
    	//url+="&viewOnly=m"
	}
	var table = $('#POAdatatables').DataTable( {
		dom: 'Bfrtip',
        buttons: getStatusButtons(),
        "bServerSide": false,
		"bLengthChange": false,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "../../../GetPlanOfActionList"+str,
		"columns": [        	 
			{
             	className: "center",
                 defaultContent: '<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> '+
                 '<i class="delete_me fa fa-trash fa-2x" aria-hidden="true"></i> '
             },
            // { "data": "rowId" ,"sClass":"center" },
             { "data": "poaName"  }, 
             { "data": "companyName"  }, 
             { "data": "cpc_txt"  }, 
             { "data": "status_txt"  },
             { "data": "priority_txt"  },
             { "data": "reviewDate"  },
             { "data": "expectedClosureDate"  },
             { "data": "closureDate" ,"sClass":"center" },           
             { "data": "challenges" ,"sClass":"center" },
             { "data": "planofaction","sClass":"center"  }          
            // { "data": "comment" ,"sClass":"center" },             
             
        ],
        "initComplete": function(settings, json) {        
        	$("#planofactionCard ."+$("#statusId").val()+'btn').removeClass("dt-button1");
        	$("#planofactionCard ."+$("#statusId").val()+'btn').addClass("dt-button2");

        	$(function () {
        	    $('[data-toggle="popover"]').popover()
        	})
        },
        fixedColumns: true
    });
	$('#POAdatatables tbody').off('click');
	$('#POAdatatables tbody').on( 'click', '.select_me', function () {
		
		/*$("#challengesText").removeClass('HideThisElement');
		$("#challenges").addClass("HideThisElement");
		$("#planofactionText").removeClass('HideThisElement');
		$("#planofaction").addClass("HideThisElement");
		$("#commentsText").removeClass('HideThisElement');
		$("#comments").addClass("HideThisElement");*/
		
		var data = table.row($(this).parents('tr')).data();
		
		$("#HomeText").text("Solution Matrix (ID: "+data.rowId+")");
		$('#remarksDiv').html('');
		$("#planofactionId").val(data.rowId); 
		$("#poaName").val(data.poaName);
		$("#statusPOAOld").val(data.status);	
		$("#priorityPOA").val(data.priority);	$("#priorityOld").val(data.priority);
		document.querySelector('#priorityPOA').value = data.priority;
		$('#ExpDateOfClosure').val(data.expectedClosureDate1);
		$('#ExpDateOfClosureOld').val(data.expectedClosureDate1);
		$('#ExpText').text(data.expectedClosureDate1);
		$("#challengesText").html(data.challenges1);	$("#challengesOld").val(data.challenges1);
		$("textarea#challenges").val(data.challenges1);	$("#challengesLbl").addClass("active");
		$('#StatusVText').text(data.status_txt);
		$('#PriorityVText').text(data.priority_txt);
		$("#planofactionText").html(data.planofaction1); 	$("#planofactionOld").val(data.planofaction1);
		$("textarea#planofaction").val(data.planofaction1);	$("#planofactionLbl").addClass("active");
		$("#challengesDiv .nicEdit-main").html(data.challenges1);
		$("#planofactionDiv .nicEdit-main").html(data.planofaction1);
		$("commentsOld").val(data.comment1);
		$("#commentsText").text(data.comment1); $("#CommentsVText").text(data.comment1);
		$("textarea#comments").val(data.comment1);	$("#commentsLbl").addClass("active");	
		
		$("#reviewee").val(data.reviewee_txt);	$("#revieweeLbl").addClass("active");		
		$("#DOR").val(data.reviewDate1);	$("#DORLbl").addClass("active");		
		$("#lastUpdatedOn").val(data.updatedOn);	$("#lastUpdatedOnLbl").addClass("active");		
		$("#lastUpdatedBy").val(data.updatedBy_txt);	$("#lastUpdatedByLbl").addClass("active");	
		$("#POAViewDiv #poHead").html(data.poaName);
		var arrResponsible=[]; var arrAccountable=[]; var arrConsulted=[]; var arrInformed=[];
		//$('#responsible').attr("disabled",true);
		var Responsible="";
		if (data.responsible !== "") {
		    $.each((data.responsible).split(","), function(i,e){ 
		    	arrResponsible.push(e);
		    	Responsible+=getActivityEmp(e)+" ";
		    });
		    $('#responsible').val(arrResponsible);
		}
		$("#ResponsibleText").text(Responsible)+" ";
		//$('#accountable').attr("disabled",true);
		var Accountable="";
		if (data.accountable !== "") {
		    $.each((data.accountable).split(","), function(i,e){ 
		    	arrAccountable.push(e);
		    	Accountable+=getActivityEmp(e)+" ";
		    });
		    //$('#accountable').val(arrAccountable).material_select("refresh");
		}
		$("#AccountableText").text(Accountable);
		///$('#consulted').attr("disabled",true);
		var Consulted="";
		if (data.consulted !== "") {
		    $.each((data.consulted).split(","), function(i,e){ 
		    	arrConsulted.push(e);
		    	Consulted+=getActivityEmp(e)+" ";
		    });
		}
		$("#ConsultedText").text(Consulted);
		//$('#informed').attr("disabled",true);
		var Informed="";
		if (data.informed !== "") {
		    $.each((data.informed).split(","), function(i,e){ 
		    	arrInformed.push(e);
		    	Informed+=getActivityEmp(e)+" ";
		    });
		}
		$("#InformedText").text(Informed);
		
		getCommentsHistory(data.rowId, 0, 1);
		$("#planofactionCard").addClass("HideThisElement");
		$("#planofactionFormDiv").addClass("HideThisElement");
		$("#infoUpdate").addClass("HideThisElement");
		$("#POAViewDiv").removeClass("HideThisElement");
		$("#addplanofactionForm #SubmitButtonUpdate").removeClass("HideThisElement");
		$("#addplanofactionForm #SubmitButtonRegister").addClass("HideThisElement");
		
		$("#statusDivView").html(data.StatusBtn);
		//$("#O1").css('padding-left','20%');			
	});
	
	$('#POAdatatables tbody').on( 'click', '.delete_me', function (){
		$("#centralModalDangerDemo").modal('show');
		var data = table.row($(this).parents('tr')).data();
		$(".heading").text('Delete Observation');
		$("#wInfo").text('Observation details will be deleted from system.');
		$("#DeleteId").val(data.rowId);
		$("#what").val("Observation");
	});
}	

function loadBlankformForPOA() {
	$("#HomeText").text("New Solution Matrix");
	document.getElementById("addplanofactionForm").reset();
	var generator=new IDGenerator();
	$("#planofactionId").val("POA"+generator.generate());
	$("#planofactionCard").addClass("HideThisElement");
	
	$("#infoUpdate").addClass("HideThisElement");
	//$("#challengesText").addClass('HideThisElement');
	$("#challenges").removeClass("HideThisElement");
	//$("#planofactionText").addClass('HideThisElement');
	$("#planofaction").removeClass("HideThisElement");
	//$("#commentsText").addClass('HideThisElement');
	$("#comments").removeClass("HideThisElement");
	
	/*$("#statusPOA").material_select("destroy");
	$("#statusPOA").removeAttr("disabled");
	$("#statusPOA").val("100001").material_select();
    //$("#statusPOA").material_select();
	
	$("#responsible").material_select("destroy")
	$("#responsible").removeAttr("disabled")
    $("#responsible").material_select();
	$("#accountable").material_select("destroy")
	$("#accountable").removeAttr("disabled")
    $("#accountable").material_select();
	$("#consulted").material_select("destroy")
	$("#consulted").removeAttr("disabled")
    $("#consulted").material_select();
	$("#informed").material_select("destroy")
	$("#informed").removeAttr("disabled")
    $("#informed").material_select();*/
	
	
	$('#ExpDateOfClosure').attr("disabled",false);
	
	$("#planofactionFormDiv").removeClass("HideThisElement");
	$("#addplanofactionForm #SubmitButtonUpdate").addClass("HideThisElement");
	$("#addplanofactionForm #SubmitButtonRegister").removeClass("HideThisElement");
	DropDownForProjectEmployee();dropDownForPOALegend();
}


function getStatusButtons() {
	var prStr="?1=1";
	if($("#projectid").val()!="null"){
		prStr+="&projectid="+$("#projectid").val();
    }
	if($("#v").val()!="null"){
		prStr+="&viewOnly="+$("#v").val();
    }else {
    	//url+="&viewOnly=m"
	}
	var statusButtonsArray=[];
	statusButtonsArray.push(
	{
        text: "New Solution Matrix",
        action: function ( e, dt, node, config ) {
        	loadBlankformForPOA();
        },
		className:'IfNotProjectId'
    });
	$.ajax({
		url:'../../../GetPoaCountforStatus'+prStr,
		type:"GET",
		async:false,
		success:function(data){
			if(data.data.length>0){
				for (var i = 0; i < data.data.length; i++) {	
					//if (data.data[i].subCategory == "Status") {
						statusButtonsArray.push(
						{
					        text: data.data[i].status_txt+"("+data.data[i].total+")",
					        action: function ( e, dt, node, config ) {
					        	setStatusId(config);
					        },
					        className:data.data[i].rowId+'btn dt-button1'
					    });
					//}
				}
				statusButtonsArray.push(
				{
			        text: "All",
			        action: function ( e, dt, node, config ) {
			        	setStatusId(config);
			        },
			        className:'0btn dt-button1'
			    });
			}
		}
	});
	
	return statusButtonsArray;
}


function setStatusId(id) {console.log();
	$("#statusId").val(((id.className).replace('btn','')).replace(' dt-button1',''));
	$('#POAdatatables').DataTable().destroy();
	getPOAlist();
}

function getCommentsHistory(rowId, start, isRefresh, e) {	
	$.ajax({
		url:"../../../GetCommentsHistory?poaId="+rowId+"&action=200006&start="+start+"&limit=5",
		type:"GET",
		success:function(data){ 
			if(e)	e.preventDefault();
			if(data!=0){
				var str="";$('#lm').html('');
				if(isRefresh==1)$('#remarksDiv').html('');
				document.querySelector('#remarksDiv').insertAdjacentHTML('beforeend', data);
				//$('#remarksDiv').append(data);
				str="<div id='lm'><a href='#' onclick='getCommentsHistory(\""+rowId+"\", "+(parseInt(start)+5)+",0, "+$(this).event+");'>Load More . . .</a></div>";
				document.querySelector('#remarksDiv').insertAdjacentHTML('afterend', str);
				$(document).scrollTop($(document).height());
				if($('#remarksDiv .card:first').length>0){
			        var firstMsg = $('#remarksDiv .card:first');
			        // Store current scroll/offset
			        var curOffset = firstMsg.offset().top - $(document).scrollTop();
			        
			        // Add your new messages
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			       
			        $(document).scrollTop(firstMsg.offset().top-curOffset);
				}    
			}else if(data==0){ 
				$('#lm').html('');
				$(document).scrollTop($(document).height());
				if($('#remarksDiv .card:first').length>0){
			        var firstMsg = $('#remarksDiv .card:first');
			        // Store current scroll/offset
			        var curOffset = firstMsg.offset().top - $(document).scrollTop();
			        
			        // Add your new messages
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			        firstMsg.before($('#remarksDiv .card').eq(5).clone());
			       
			        $(document).scrollTop(firstMsg.offset().top-curOffset);
				}
			}
		}
	});
}

function getActivityEmp(data) {
	var str="";
	$.ajax({
		url:"../../../GetEmployeeForPOA?employeeId="+$.trim(data),
		type:"GET",
		async:false,
		success:function(data){ 
			str= data.data[0].empname;
		}
	});
	return str;
}