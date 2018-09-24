$(document).ready(function(){
    $('.datepicker').pickadate();
	getProjectList();
	
	if($("#selectedProjectId").val() != "")
	{
    	$("#issueRegisterCard").removeClass("HideThisElement");
	}
	else
	{
		$("#projecttableCard").removeClass("HideThisElement");
	}
  
	var ourRequest1 = new XMLHttpRequest();
	var data1 = [];
	ourRequest1.open('GET', '../../../../GetSupportLegendList');
	ourRequest1.onload = function() {
		if (ourRequest1.status >= 200 && ourRequest1.status < 400) {
			data1 = JSON.parse(ourRequest1.responseText);
			createHTML2(data1);
			createHTML4(data1);
			createHTML5(data1);
		} else {
			console.log("We connected to the server, but it returned an error.");
		}
	};

	ourRequest1.onerror = function() {
		console.log("Connection error");
	};
	
    ourRequest1.send();
	
	function createHTML2(Data) {
		var options2;
		$('#category').empty();
		options2 = '<option value="" selected>Select Category</option>';
		for (i = 0; i < Data.data.length; i++)
		{
			if (Data.data[i].subCategory == "category")
			{
				options2 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
			}
		}
		$('#category').html(options2);
		$('#category').material_select('refresh');
	}
	
	function createHTML4(Data) {
		var options2;
		$('#mode').empty();
		options2 = '<option value="" selected>Select Mode</option>';
		for (i = 0; i < Data.data.length; i++)
		{
			if (Data.data[i].subCategory == "mode")
			{
			options2 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
			}
		}
		$('#mode').html(options2);
		$('#mode').material_select('refresh');
	}
	
	function createHTML5(Data) {
		var options2;
		$('#priority').empty();
		options2 = '<option value="" selected>Select Priority</option>';
		for (i = 0; i < Data.data.length; i++)
		{
			if (Data.data[i].subCategory == "priority")
			{
			options2 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
			}
		}
		$('#priority').html(options2);
		$('#priority').material_select('refresh');
	}
  
	var ourRequest2 = new XMLHttpRequest();
	var data1 = [];
	ourRequest2.open('GET', '../../../../GetEmployeeList');
	ourRequest2.onload = function() {
		if (ourRequest2.status >= 200 && ourRequest2.status < 400) {
			data1 = JSON.parse(ourRequest2.responseText);
			createHTML3(data1);
		} else {
			console.log("We connected to the server, but it returned an error.");
		}
	};

	ourRequest2.onerror = function() {
		console.log("Connection error");
	};
	
    ourRequest2.send();
	
	function createHTML3(Data) {
		var options2;
		$('#assignedTo').empty();
		options2 = '<option value="" selected>Select Employee</option>';
		for (i = 0; i < Data.data.length; i++)
		{
			/*if (Data.data[i].subcategory == "Product Category")
			{*/
			options2 += "<option value='" + Data.data[i].employeeId + "'>" + Data.data[i].employeeName + "</option>";
//			}
		}
		$('#assignedTo').html(options2);
		$('#assignedTo').material_select('refresh');
	}
	});

function getProjectList(){
    $('#projectdatatables thead #filterrow th').each( function () {
        var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:auto;text-align:center;width:80%;" placeholder="Search '+title+'" />' );
    });
    
    $("#projectdatatables thead input").on('keyup change', function () {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
    
    var table = $('#projectdatatables').DataTable( {
        dom: 'Bfrtip',
        buttons: [
            {
                text: 'New Project',
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
        "ajax": "../../../../GetProjectList",
        "columns": [
             {
                defaultContent: '<center><i class="select_me fa fa-check fa-2x" aria-hidden="true"></i>'/*+
                '<i class="view_me fa fa-eye fa-2x" aria-hidden="true"></i></center>'*/
             },
             { "data": "rowid" ,"sClass":"center" },
             { "data": "companyName" },
             { "data": "location"  },
             { "data": "stakeholderName" },
             { "data": "phoneNo" },
             { "data": "emailId" },
             { "data": "cpc_txt" },
             { "data": "epc_txt" }
        ],
        fixedColumns: true
    });
	 
	$('#projectdatatables tbody').on( 'click', '.select_me', function () {
    	var data = table.row( $(this).parents('tr') ).data();
    	$("#selectedProjectId").val(data.rowid);
    	$("#issueRegisterCard").removeClass("HideThisElement");
    	$("#projecttableCard").addClass("HideThisElement");
    });
	 
	/*$('#projectdatatables tbody').on( 'click', '.view_me', function () {
    	var data = table.row( $(this).parents('tr') ).data();
    	$("#selectedProjectId").val(data.rowid);
    	
    	var getListOfCounts = new XMLHttpRequest();
    	var data1 = [];
    	getListOfCounts.open('GET', '../../../../GetNumberOfIssues?projectId='+data.rowid);
    	getListOfCounts.onload = function() {
    		if (getListOfCounts.status >= 200 && getListOfCounts.status < 400) {
    			data1 = JSON.parse(getListOfCounts.responseText);
    			
    			$("#totalSupport").html(data1.data[0].totalsupport);
    			
    			$("#pendingRequestCount").html(data1.data[0].totalpendingrequest);
    			$("#inProcessRequestCount").html(data1.data[0].totalinprocessrequest);
    			$("#completedRequestCount").html(data1.data[0].totalcompletedrequest);
    			$("#onHoldRequestCount").html(data1.data[0].totalonholdrequest);
    			$("#disapprovedRequestCount").html(data1.data[0].totaldisapproved);
    			
    			$("#pendingIssueCount").html(data1.data[0].totalpendingissue);
    			$("#inProcessIssueCount").html(data1.data[0].totalinprocessissue);
    			$("#completedIssueCount").html(data1.data[0].totalcompletedissue);
    			$("#onHoldIssueCount").html(data1.data[0].totalonholdissue);
    			
    		} else {
    			console.log("We connected to the server, but it returned an error.");
    		}
    	};

    	getListOfCounts.onerror = function() {
    		console.log("Connection error");
    	};
    	
        getListOfCounts.send();
    	
    	$("#issueListCard").removeClass("HideThisElement");
    	$("#projecttableCard").addClass("HideThisElement");
    });*/
}
var generator = new IDGenerator();

function loadBlankform() {
	$("#HomeText").text("New Project");
	$("#projecttableCard").addClass('HideThisElement');
	$("#formCard").removeClass('HideThisElement');
	$("#SubmitButtonRegister").removeClass('HideThisElement');
	$("#SubmitButtonUpdate").addClass('HideThisElement');
	var generator = new IDGenerator();
	$("#projectId").val("PR"+generator.generate());
	$("#projectIdLbl").addClass('active');
}

$("#SubmitButtonRegister").click(function() {
	var url = "../../../../IssueRegisterServlet";
	/*if (document.getElementById("firstName").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> First Name is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("lastName").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Last Name is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("department").value ==  "Department *") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Department is not selected !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("designation").value ==  "Designation *") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Designation is not selected !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("mobileno").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Contact Number is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("location").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Location is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("UserId").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Unique User ID is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("birthDate").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Birthday Date is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	} else if (document.getElementById("joinDate").value == "") {
		document.querySelector('#alertMessage').innerHTML = "<strong>Warning!</strong> Joining Date is mandatory !";
		$("#alertMessage").removeClass("HideThisElement");
	} else {*/
    	$.ajax({
               type: "POST",
               url: url,
               data: $("#newElementForm").serialize()+"&issueId="+generator.generate(), // serializes the form's elements.
               success: function(data)
               {
                   if (data == 1) {
                	   document.getElementById("newElementForm").reset();
						$(".selectpicker").val('default');
						$(".selectpicker").selectpicker("refresh");
						$("#alertMessage").addClass("HideThisElement");
						$("#errorMessage").addClass("HideThisElement");
						$('#datatables').DataTable().ajax.reload();
						toastr.success('New Issue Registered Successfully!');
				    	$("#issueRegisterCard").addClass("HideThisElement");
				    	$("#projecttableCard").removeClass("HideThisElement");
					} else{
						toastr.error('Failed to Registered New Employee!');
					}
               }
    	});
//    }
    return false; // avoid to execute the actual submit of the form.
	});

$("#close").click(function() {
	$("#issueRegisterCard").addClass("HideThisElement");
	$("#projecttableCard").removeClass("HideThisElement");
});