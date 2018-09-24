$(document).ready(function() {
	$("#HomeText").text("Format");
	
	$('input[type=file]').change(function () {
	    console.log($('input[type=file]')[0].value);
	});
	
	getFormatList();	
	
	//$(document).on('submit', '#newFormatForm', function(e) {
		
	$("#submitFormatForm").click(function() {
		var generator = new IDGenerator();
		if($("#FormatId").val()=="") 	$("#FormatId").val("F"+generator.generate());
		//e.preventDefault();    
		//var formData = new FormData(this);console.log(new FormData(this));
		$.ajax({
			url:"../../../CreateFormat",
			data:$("#newFormatForm").serialize(),
			type:"POST",
			success:function(data){
				if(data.indexOf("1")>=0){
					//uploadFile(formData);
					//toastr.success("Success! Format "+$("#action").val()+"d successfully!");
					$('#FormatTable').DataTable().ajax.reload();
					document.getElementById("newFormatForm").reset();
					$("#FormatTableDiv").removeClass('HideThisElement');
					$("#formDiv").addClass('HideThisElement');
				}else{
					//toastr.error("Error! Failed to "+$("#action").val()+" Format!");
				}
			}
		});
		return false;
	});
	
	$("#cancelFormatForm").click(function() {
		$("#FormatTableDiv").removeClass('HideThisElement');
		$("#formDiv").addClass('HideThisElement');
	});	
	
	$(document).on('submit', '#UploadFileForm', function(e) {
		e.preventDefault();    
		var formData = new FormData(this);
		uploadFile(formData);
	});
});

function loadBlankformForFormat() {
	var generator = new IDGenerator();
	$("#FormatTableDiv").addClass('HideThisElement');
	$("#formDiv").removeClass('HideThisElement');
	$("#FormatId").val("F"+generator.generate());
	$("#action").val("insert");
}

function formSubmit(e){
	/*var generator = new IDGenerator();
	if($("#FormatId").val()=="") 	$("#FormatId").val("F"+generator.generate());
	e.preventDefault();    
	var formData = new FormData($("#newFormatForm"));
	$.ajax({
		url:"../../../CreateFormat",
		data:formData,
		type:"POST",
		success:function(data){
			if(data.indexOf("1")>=0){
				toastr.success("Success! Format "+$("#action").val()+"d successfully!");
				$('#FormatTable').DataTable().ajax.reload();
				document.getElementById("newFormatForm").reset();
				$("#FormatTableDiv").removeClass('HideThisElement');
				$("#formDiv").addClass('HideThisElement');
			}else{
				toastr.error("Error! Failed to "+$("#action").val()+" Format!");
			}
		}
	});*/
}

function uploadFile(formData) {
	$.ajax({
		url:"../../../UploadFile",
		data:formData,
		type:"POST",
		success:function(data){
			if(data==1){
				toastr.success("Success! Format File saved successfully!");
				$('#FormatTable').DataTable().ajax.reload();
				$("#UploadFile").modal('hide');
			}else{
				toastr.error("Error! Failed to save Format!");
			}
		},
        cache: false,
        contentType: false,
        processData: false
	});
	return false;
}

function getFormatList() {
	$('#FormatTable thead #filterrow th').each( function () {
    	var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:auto;text-align:center;width:80%;" placeholder="Search '+title+'" />' );
    } );
	
    $("#FormatTable thead input").on('keyup change', function () {
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
    
	var table = $('#FormatTable').DataTable( {
		dom: 'Bfrtip',
        buttons: [
            {
                text: 'New Format',
                action: function ( e, dt, node, config ) {
                	loadBlankformForFormat();
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
		"ajax": "../../../GetFormatList"+str,
		"columns": [
        	 {
             	className: "center",
                 defaultContent: '<i class="edit_me fa fa-pencil-alt fa-2x" aria-hidden="true"></i>'
             },
			//{ "data": "i" ,"sClass":"center" },
            { "data": "name" ,"sClass":"poPrdct" },
            { "data": "type" },
            { "data": "filename"  },
            { "data": "action" ,"sClass":"center"  }
        ],
        "initComplete":function () {
        	$("#aid").click();
        }
    });
	$('#FormatTable tbody').off('click');

	 $('#FormatTable tbody').on( 'click', '.upload', function () {
	    	var data = table.row( $(this).parents('tr') ).data();
			$('#UploadFile').modal('show');
			$("#fid").val(data.rowId);
     });
	 
	 $('#FormatTable tbody').on( 'click', '.download', function () {
		 var data = table.row( $(this).parents('tr') ).data();	    	
		 $.ajax({
			url:"https://api.dropboxapi.com/2/files/get_temporary_link",
			type:"POST",				
			data:JSON.stringify({"path": data.filepath}),
			beforeSend: function (xhr) {
		        /* Authorization header */
		        xhr.setRequestHeader("Authorization", "Bearer " + "6rdOKk-CwgAAAAAAAAAAWvfY0oWkuR7NeGcjTDI3aTUEvSLPKBTuTVIoWWW8Ybbq");
		        xhr.setRequestHeader("Content-Type", "application/json");
		    },
			success:function(data){
				console.log(data.link);
				window.location.href = data.link;
			}
		 });
     });
	 
	 $('#FormatTable tbody').on( 'click', '.edit_me', function () {
		 var data = table.row( $(this).parents('tr') ).data();
		 $("#FormatTableDiv").addClass('HideThisElement');
		 $("#formDiv").removeClass('HideThisElement');
		 $("#FormatId").val(data.rowId);
		 $("#formatName").val(data.name);  $("#formatNameLbl").addClass('active'); 
		 $("#action").val("updat"); 
		 $("#formatType").val(data.type);   $("#formatTypeLbl").addClass('active'); 
		 $("#filenameTextField").val(data.filename); 	$("#formatTypeLbl").addClass('active'); 
	 });
}