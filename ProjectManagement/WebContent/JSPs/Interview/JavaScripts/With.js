$(document).ready(function() {
	
	//getWithList();
	
	$("#saveWithForm").click(function() {
		formSubmitWith();
	});
	
	$("#cancelAuditForm").click(function() {
		$("#tableDiv").removeClass('HideThisElement');
		$("#formDiv").addClass('HideThisElement');
	});	
});
/*
function loadBlankformForAudit() {
	var generator = new IDGenerator();
	$("#tableDiv").addClass('HideThisElement');
	$("#formDiv").removeClass('HideThisElement');
	$("#AuditId").val("A"+generator.generate());
	$("#action").val("insert");
}
*/

function formSubmitWith() {
	var generator = new IDGenerator();
	$.ajax({
		url:"../../../ModifyTool",
		data:$("#newWithForm").serialize()+"&InterviewId="+$("#InterviewId").val()+"&ProcessId="+$("#ProcessId").val()+"&ToolId=IT"+generator.generate()+"&withItemComments="+escape($("#WithCommentsDiv .nicEdit-main").html()),
		type:"POST",
		success:function(data){
			if(data.indexOf("1")>=0){
				$("#newWithForm #alertMessage").addClass("HideThisElement");
				$("#newWithForm #errorMessage").addClass("HideThisElement");	
				document.querySelector('#newWithForm #successMessage').innerHTML = "<strong>Success!</strong> With "+$("#newWithForm #action").val()+"ed successfully !";
				$("#newWithForm #successMessage").removeClass("HideThisElement");	
				document.getElementById("newWithForm").reset();	
				$('.withTable').DataTable().destroy();
				getWithList();
			}else{
				document.querySelector('#newWithForm #errorMessage').innerHTML = "<strong>Error!</strong> Failed to "+$("#newWithForm #action").val()+" With !";
				$("#newWithForm #errorMessage").removeClass("HideThisElement");	
			}
		}
	});
}

function getWithList() {
	$('.withTable thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:auto;text-align:center;width:80%;" placeholder="Search '+title+'" />' );
    } );
	
    $(".withTable thead input").on('keyup change', function () {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
    
    var actionStr="";
    if(window.location.href.indexOf("Product.jsp")>0){
    	actionStr='<center><i class="edit_me fa fa-pencil fa-2x" aria-hidden="true"></i> ' +
        '<i class="delete_me fa fa-trash fa-2x" aria-hidden="true"></i> ';
    }else{
    	actionStr='<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> ';
    }
    
    var str="?1=1";
    
    str+="&interviewid="+$("#InterviewId").val();
    
	var table = $('.withTable').DataTable({
		dom: 'Bfrtip',
        buttons: [
            /*{
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
		"ajax": "../../../GetToolList"+str,
		"responsive": true,
		"columns": [
        	/* {
             	className: "center",
                 defaultContent: actionStr
             },*/
             { "data": "i" ,"sClass":"center" },
             { "data": "name" },
             { "data": "storage_text" },
             { "data": "condition_text"  },
             { "data": "caliberation_text"  },
             { "data": "maintainance_text"  }
        ]
    });
}