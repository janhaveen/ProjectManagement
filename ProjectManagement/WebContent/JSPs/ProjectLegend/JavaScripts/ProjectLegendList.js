function getProjectLegendList(){
	$('#pldatatables thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:1%;text-align:center" placeholder="'+title+'" />' );
    });
	
    $("#pldatatables thead input").on('keyup change', function () {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
    
    
    
	var table = $('#pldatatables').DataTable( {
		dom: 'Bfrtip',
        buttons: [
            {
                text: 'New Department',
                action: function ( e, dt, node, config ) {
                	loadBlankform();
                }
            }
        ],
		"bLengthChange": false,
		"searching": true,
		"orderCellsTop": true ,
		"sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
		"ajax": "../../../GetProjectLegendList?projectid="+$("#ProjectId").val()+"&type=Department",
		"columns": [
        	 {
             	className: "center",
                 defaultContent: 
                 '<i class="edit_me fa fa-pencil-alt fa-2x" aria-hidden="true"></i> '+
                 '<i class="delete_me fa fa-trash fa-2x" aria-hidden="true"></i>'
             },
            { "data": "description" }
            
        ],
        fixedColumns: true
        
    } );
	
    $('#pldatatables tbody').on( 'click', '.edit_me', function () {
    	var data = table.row( $(this).parents('tr') ).data();
		document.getElementById("newProjectLegendForm").reset();
		document.querySelector('#selectedLegendId').value = data.rowId;
		$("#legendGroup").val( data.legendGroup);
		$("#category").val( data.category);
		$("#subCategory").val( data.subCategory);
		$("#description").val( data.description); $("#descriptionLbl").addClass("active");
		$('#RegisterNewProjectLegend').modal('show');
		$("#newProjectLegendForm #SubmitButtonUpdate").removeClass("HideThisElement");
		$("#newProjectLegendForm #SubmitButtonRegister").addClass("HideThisElement");
    } );
    
   
    $('#pldatatables tbody').on( 'click', '.delete_me', function () {
    	var data = table.row( $(this).parents('tr') ).data();
    	document.querySelector('#DeleteId').value = data.rowId;
    	$('#centralModalDangerDemo').modal('show');
    	$(".heading").text("Delete Department");
    	$(".wText1").text("Department details will be deleted from system.");
    	$(".wText2").text("Click 'Confirm' to proceed, and 'Close' to cancel.");
    });
}

function loadBlankform() {
	var generator = new IDGenerator();
	document.getElementById("newProjectLegendForm").reset();
	$("#selectedLegendId").val(generator.generate());
	$("#legendGroup").val("Department");
	$("#category").val("Department");
	$("#subCategory").val("Department");
	$("#newProjectLegendForm #SubmitButtonUpdate").addClass("HideThisElement");
	$('#RegisterNewProjectLegend').modal('show');
}
