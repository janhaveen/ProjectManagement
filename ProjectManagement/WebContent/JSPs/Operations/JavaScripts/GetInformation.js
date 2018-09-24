function getProcess() {
	$.ajax({
		url:"../../../GetProcess?interviewid="+$("#InterviewId").val(),
		type:"POST",
		success:function(data){
			$('#processDisplayDiv').html('');
			document.querySelector('#processDisplayDiv').insertAdjacentHTML('beforeend', data);
		}
	});
}

function getFormat() {
	/*$('#formatTable thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:auto;text-align:center;width:80%;" placeholder="Search '+title+'" />' );
    } );
	
    $("#formatTable thead input").on('keyup change', function () {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });*/
    
    var actionStr="";
    if(window.location.href.indexOf("Product.jsp")>0){
    	actionStr='<center><i class="edit_me fa fa-pencil fa-2x" aria-hidden="true"></i> ' +
        '<i class="delete_me fa fa-trash fa-2x" aria-hidden="true"></i> ';
    }else{
    	actionStr='<i class="select_me fa fa-check fa-2x" aria-hidden="true"></i> ';
    }
    
	var table = $('#formatTable').DataTable( {
		dom: 'Bfrtip',
        buttons: [
            /*{
                text: 'New Product',
                action: function ( e, dt, node, config ) {
                	loadBlankformForProductType();
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
		"ajax": "../../../GetFormatList?1=1"+"&ProcessId="+$("#ProcessId").val(),
		"columns": [        	 
             { "data": "i" ,"sClass":"center" },
             { "data": "name" ,"sClass":"poPrdct" },
             { "data": "type" },
             { "data": "filename"  },
             { "data": "action"  }
        ],
        fixedColumns: true,
        "initComplete": function(settings, json) {        
        	$('#FtH').click();
         }
    });
}


function getTool() {
	$('#ToolTable thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:auto;text-align:center;width:80%;" placeholder="Search '+title+'" />' );
    } );
	
    $("#ToolTable thead input").on('keyup change', function () {
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
    
	var table = $('#ToolTable').DataTable( {
		dom: 'Bfrtip',
        buttons: [
            /*{
                text: 'New Product',
                action: function ( e, dt, node, config ) {
                	loadBlankformForProductType();
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
		"ajax": "../../../GetToolList?1=1"+"&ProcessId="+$("#ProcessId").val(),
		"columns": [        	 
             { "data": "i" ,"sClass":"center" },
             { "data": "name" ,"sClass":"poPrdct" },
             { "data": "storage_text" },
             { "data": "condition_text"  },
             { "data": "caliberation_text"  },
             { "data": "maintainance_text"  },
             { "data": "action"  }
        ],
        fixedColumns: true,
        "initComplete": function(settings, json) {        
        	$('#ToolTable #tooltH').click();
         }
    });
}