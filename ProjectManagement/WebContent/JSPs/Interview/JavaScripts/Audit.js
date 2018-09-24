$(document).ready(function() {
	
	$("#saveAuditForm").click(function() {
		formSubmit();
	});
	
	$("#cancelAuditForm").click(function() {
		$("#tableDiv").removeClass('HideThisElement');
		$("#formDiv").addClass('HideThisElement');
	});	
});

function loadBlankformForAudit() {
	var generator = new IDGenerator();
	$("#tableDiv").addClass('HideThisElement');
	$("#formDiv").removeClass('HideThisElement');
	$("#AuditId").val("A"+generator.generate());
	$("#newAuditForm  #action").val("insert");
}

function formSubmit(){
	var generator = new IDGenerator();
	if($("#AuditId").val()=="") 	$("#AuditId").val("A"+generator.generate());
	$.ajax({
		url:"../../../ModifyAudit",
		data:$("#newAuditForm").serialize()+"&InterviewId="+$("#InterviewId").val()+"&auditItemComments="+escape($("#auditItemCommentsDiv .nicEdit-main").html()),
		type:"POST",
		success:function(data){
			if(data.indexOf("1")>=0){
				$("#newAuditForm #alertMessage").addClass("HideThisElement");
				$("#newAuditForm #errorMessage").addClass("HideThisElement");	
				document.querySelector('#newAuditForm #successMessage').innerHTML = "<strong>Success!</strong> Audit "+$("#newAuditForm  #action").val()+"ed successfully !";
				$("#newAuditForm #successMessage").removeClass("HideThisElement");									
				$('.auditTable').DataTable().destroy();
				getAuditList();
				document.getElementById("newAuditForm").reset();
				//$("#tableDiv").removeClass('HideThisElement');
				//$("#formDiv").addClass('HideThisElement');
			}else{
				document.querySelector('#newAuditForm #errorMessage').innerHTML = "<strong>Error!</strong> Failed to "+$("#newAuditForm  #action").val()+" Audit !";
				$("#newAuditForm #errorMessage").removeClass("HideThisElement");	
			}
		}
	});
}

function getAuditList() {
	$('.auditTable thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:auto;text-align:center;width:80%;" placeholder="Search '+title+'" />' );
    } );
	
    $(".auditTable thead input").on('keyup change', function () {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });

    var str="?1=1";
    
    str+="&interviewid="+$("#InterviewId").val();
    
    var actionStr="";
    if(window.location.href.indexOf("Product.jsp")>0){
    	actionStr='<center><i class="edit_me fa fa-pencil fa-2x" aria-hidden="true"></i> ' +
        '<i class="delete_me fa fa-trash fa-2x" aria-hidden="true"></i> ';
    }else{
    	actionStr='<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> ';
    }
    
	var table = $('.auditTable').DataTable( {
		dom: 'Bfrtip',
        buttons: [
           /* {
                text: 'New Audit',
                action: function ( e, dt, node, config ) {
                	loadBlankformForAudit();
                }
            }*/
        ],
        "bServerSide": false,
		"bLengthChange": false,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "../../../GetAuditList"+str,
		"columns": [
        	/* {
             	className: "center",
                 defaultContent: actionStr
             },*/
             { "data": "i" ,"sClass":"center" },
             { "data": "influencingFactor" },
             { "data": "currentMetric"  },
             { "data": "metricType_txt" },
             { "data": "comments" }
        ],
        "initComplete":function () {
        	$("#aid").click();
        }
    });
}