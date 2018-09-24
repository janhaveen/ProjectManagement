function getProjectList(){
	DropDownForLegend();DropDownForEmployee("");

	$('#projectdatatables thead #filterrow th').each( function (index) { 
		//if(index!=0){
	    	var title = $($('#projectdatatables thead #headerrow th')[index+1]).text();
	        $(this).html( '<input type="text" style="font-size: 80%;padding:auto;text-align:center;width:80%;" placeholder="'+title+'" />' );
		//}
    } );
	
    $("#projectdatatables thead input").on('keyup change', function () {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
    
    var actionStr="";
    var url="";
    if(window.location.href.indexOf("UserHome.jsp")>=0){ console.log("sdf");
    	url="../GetProjectList?1=1";
        actionStr='<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> ';
    }else{
    	url="../../../GetProjectList?1=1";
        //if($("#t").val()=="1"){
        	actionStr+='<i class="edit_me mg fa fa-check fa-2x" aria-hidden="true"></i> ' +
    			'<i class="delete_me mg fa fa-trash fa-2x" aria-hidden="true"></i> ';
        /*}else {*/
        	actionStr+='<i class="view_me fa fa-eye fa-2x" aria-hidden="true"></i> ';
    	//}
    }
    
    if($("#v").val()!="null"){
    	url+="&viewOnly="+$("#v").val();
    }else {
    	//url+="&viewOnly=m"
	}
    
	var table = $('#projectdatatables').DataTable( {
		dom: 'Bfrtip',
        buttons: [
            {
                text: 'New Project',
                action: function ( e, dt, node, config ) {
                	loadBlankform();
                },
                className:"mg"
            }
        ],
        "bServerSide": false,
		"bLengthChange": false,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": url,
		"columns": [
        	 {
             	className: "center",
                 defaultContent: actionStr
             },
            // { "data": "rowid" ,"sClass":"center" },
             { "data": "companyName" },
             { "data": "location"  },
            /* { "data": "stakeholderName" },
             { "data": "phoneNo" },
             { "data": "emailId" },*/
             { "data": "cpc_txt" },
             { "data": "branchName" },
             { "data": "stage" }
        ],
        fixedColumns: true
    });
	$('#projectdatatables tbody').off('click');

	$('#projectdatatables tbody').on( 'click', '.edit_me', function () {
    	var data = table.row($(this).parents('tr')).data();    	
    	$("#projecttableCard").addClass('HideThisElement');
		$("#projectForm").addClass('HideThisElement');
		$("#projectDetails").removeClass('HideThisElement');
    	$("#HomeText").text("Edit Project (Project ID:"+data.rowid+")");
    	$("#SubmitButtonUpdate").removeClass('HideThisElement');
    	$("#SubmitButtonRegister").addClass('HideThisElement');
    	/*$("#projecttableCard").addClass('HideThisElement');
    	$("#formCard").removeClass('HideThisElement');*/
    	$("#projectId").val(data.rowid); $("#projectIdLbl").addClass('active'); $("#PrIDView").text(data.rowid);
    	$("#branchName").val(data.branchName);	$("#branchNameLbl").addClass('active');
    	$("#referenceBy").val(data.referenceBy);	$("#referenceByLbl").addClass('active');
    	$("#companyName").val(data.companyName);	$("#companyNameLbl").addClass('active'); $("#ClientView").text(data.companyName);
    	$("#location").val(data.location);	$("#locationLbl").addClass('active');	$("#LocationView").text(data.location);	
    	$("#industry").val(data.industry);	$("#industryLbl").addClass('active');	$("#IndustryView").val(data.industry);
    	$("#phoneNo").val(data.phoneNo);	$("#phoneNoLbl").addClass('active');
    	$("#website").val(data.website);	$("#websiteLbl").addClass('active');
    	$("#emailId").val(data.emailId);	$("#emailIdLbl").addClass('active');
    	$("#preferredDayText").val(data.preferredDay); 
    	$("#firstName").val(data.stakeholderFname);	$("#firstNameLbl").addClass('active');
    	$("#lastName").val(data.stakeholderLname);	$("#lastNameLbl").addClass('active');
    	$("#designation").val(data.stakeholderDesignation);	$("#designationText").val(data.stakeholderDesignation_txt); $("#designationLbl").addClass('active');
    	$("#mobileNo").val(data.stakeholderContactno);	$("#mobileNoLbl").addClass('active');
    	$("#altContactNo").val(data.stakeholderAltcontactno);	$("#altContactNoLbl").addClass('active');
    	$("#SHEmailId").val(data.stakeholderEmailid);	$("#SHEmailIdLbl").addClass('active');
    	$("#billAmt").val(data.billAmount);	$("#billAmtLbl").addClass('active');  $("#BillView").text(data.billAmount);
    	$("#modeOfPayText").val(data.paymentMode);	$("#modeOfPayText").val(data.paymentMode_txt); $("#modeOfPayLbl").addClass('active');
    	$("#frequency").val(data.paymentFrequency); $("#frequencyText").val(data.paymentFrequency_txt);	$("#frequencyLbl").addClass('active');
    	$("#gst").val(data.gstNo);	$("#gstLbl").addClass('active');   $("#GSTView").text(data.gstno);
    	$("#startDate").val(data.startdate);	$("#startDateLbl").addClass('active'); $("#StartView").text(data.startdate);
    	$("#visitFrequency").val(data.visitfrequency);  $("#visitFrequencyText").val(data.visitfrequency_txt);	
    	$("#VFView").text(data.visitfrequency_txt); $("#visitFrequencyLbl").addClass('active');
    	$("#cpc").val(data.cpc);  $("#cpcText").val(data.cpc_txt);	
    	$("#CPCView").text(data.cpc_txt);	$("#cpcLbl").addClass('active');
    	$("#epc").val(data.epc);  $("#epcText").val(data.epc_txt);	
    	$("#EPCView").text(data.epc_txt);	 $("#epcLbl").addClass('active');$("#SourceView").text(data.source);
    	$("#address1").val(data.address1);	$("#address1Lbl").addClass('active');
    	$("#address2").val(data.address2);	$("#address2Lbl").addClass('active');
    	$("#area").val(data.areaCity); 	$("#areaLbl").addClass('active');
    	$("#state").val(data.state); $("#stateText").val(data.state_txt);	$("#stateLbl").addClass('active');
    	$("#pincode").val(data.pincode);	$("#pincodeLbl").addClass('active');    
    	document.querySelector('#modeOfPayText').value = data.paymentMode;
    });
	
	$('#projectdatatables tbody').on( 'click', '.delete_me', function () {
		var data = table.row($(this).parents('tr')).data();
		$("#DeletePrId").val(data.rowid);
		$("#centralModalDangerDemo").modal('show');		
	});
	
	$('#projectdatatables tbody').on( 'click', '.view_me', function () {
		var data = table.row($(this).parents('tr')).data();
		if($("#t").val().indexOf("2")>=0){
			window.location.href="../../../JSPs/Interview/JSPs/interview.jsp?id="+data.rowid;
		}else if($("#t").val().indexOf("3")>=0){
			window.location.href="../../../JSPs/Operations/JSPs/Observations.jsp?id="+data.rowid;
		}else if($("#t").val().indexOf("4")>=0){
			window.location.href="../../../JSPs/Menu.jsp?id="+data.rowid;
		}else {
			window.location.href="../../../JSPs/TopDown/JSPs/TopDown.jsp?id="+data.rowid;
		}		
	});
	
	$("#SubmitButtonEdit").click(function() {
		$("#projecttableCard").addClass('HideThisElement');
    	$("#projectForm").removeClass('HideThisElement');
    	$("#projectDetails").addClass('HideThisElement');
	});
}

function loadBlankform() {
	$("#HomeText").text("New Project");
	document.getElementById("newProjectForm").reset();
	$("#projecttableCard").addClass('HideThisElement');
	$("#projectForm").removeClass('HideThisElement');
	$("#projectDetails").addClass('HideThisElement');
	$("#SubmitButtonRegister").removeClass('HideThisElement');
	$("#SubmitButtonUpdate").addClass('HideThisElement');
	var generator = new IDGenerator();
	$("#projectId").val("PR"+generator.generate());
	$("#projectIdLbl").addClass('active');
	DropDownForLegend();DropDownForEmployee("");

}