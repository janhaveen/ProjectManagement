$(document).ready(function() {	
	//getHowList();
	
	$("#saveHowForm").click(function() {
		formSubmitHow();
	});
	
	$("#cancelAuditForm").click(function() {
		$("#tableDiv").removeClass('HideThisElement');
		$("#formDiv").addClass('HideThisElement');
	});	
});

function formSubmitHow(){
	var generator=new IDGenerator();
	$("#ProcessId").val("IPr"+generator.generate());
	if($("#department").val()==""){
		document.querySelector('#newHowForm #alertMessage').innerHTML = "<strong>Warning!</strong> Select Employee First!";
		$("#newHowForm #alertMessage").removeClass("HideThisElement");
	}else{
		$.ajax({
			url:"../../../ModifyProcess?ProjectId="+$("#projectid").val(),
			data:$("#newHowForm").serialize()+"&InterviewId="+$("#InterviewId").val()+"&department="+$("#department").val()+"&procedureComments="+escape($("#newHowForm .nicEdit-main").html()),
			type:"POST",
			success:function(data){
				if(data.indexOf("1")>=0){
					//toastr.success("Success! How "+$("#action").val()+"d successfully!");
					$("#newHowForm #alertMessage").addClass("HideThisElement");
					$("#newHowForm #errorMessage").addClass("HideThisElement");	console.log("sef",$("#newHowForm #action").val());
					document.querySelector('#newHowForm #successMessage').innerHTML = "<strong>Success!</strong> How "+$("#newHowForm #action").val()+"ed successfully !";
					$("#newHowForm #successMessage").removeClass("HideThisElement");	
					setTimeout(function() {
						$("#newHowForm #successMessage").addClass("HideThisElement");
					},2000);
				 	document.getElementById("newHowForm").reset();
				 	$('#howTable').DataTable().destroy();
				 	getHowList();
					/*$('#howTable').DataTable().ajax.reload();*/
				}else{
					document.querySelector('#newHowForm #errorMessage').innerHTML = "<strong>Error!</strong> Failed to "+$("#newHowForm #action").val()+" How !";
					$("#newHowForm #errorMessage").removeClass("HideThisElement");
				}
			}
		});
		
	}
	return false;
}

function getHowList() {
	$('#howTable thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:auto;text-align:center;width:80%;" placeholder="Search '+title+'" />' );
    } );
	
    $("#howTable thead input").on('keyup change', function () {
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
    console.log($("#InterviewId").val(),"in");
    str+="&interviewid="+$("#InterviewId").val();
    
	var table = $('#howTable').DataTable( {
		dom: 'Brtip',
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
        "ajax": "../../../GetProcess"+str,
		"columns": [        	 
			/*{
             	className: "center",
                 defaultContent: actionStr
                 
             },*/
			 { "data": "i" ,"sClass":"center" },
             //{ "data": "rowId" ,"sClass":"center" },
             { "data": "processName"  },
             { "data": "type" ,"sClass":"center" },
             { "data": "dept_text"  },
             { "data": "description_ation" ,"sClass":"center" }
        ]/*,
        "initComplete":function () {
        	$(function () {
        	    $('[data-toggle="popover"]').popover()
        	})
        }*/
    });
}