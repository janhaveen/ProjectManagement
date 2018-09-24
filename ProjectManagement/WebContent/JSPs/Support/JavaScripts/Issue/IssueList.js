$(document).ready(function(){
    $('.datepicker').pickadate();
	
	$("#issuetableCard").removeClass("HideThisElement");
	$('#status').material_select('refresh');
	
	$("#status").change(function(){
		if($("#status").val() == "1")
		{
			$(".acceptDurartion").removeClass("HideThisElement");
		}
		else
		{
			$(".acceptDurartion").addClass("HideThisElement");
		}
	});
	
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
	
    $('#issuedatatables thead #filterrow th').each( function () {
        var title = $(this).text();
        $(this).html( '<input type="text" style="font-size: 80%;padding:auto;text-align:center;width:80%;" placeholder="Search '+title+'" />' );
    });
    
    $("#issuedatatables thead input").on('keyup change', function () {
        table.column($(this).parent().index() + ':visible')
            .search(this.value)
            .draw();
    });
    
    var table = $('#issuedatatables').DataTable({
        dom: 'Bfrtip',
        buttons: [
            {
                text: 'New Issue',
                action: function ( e, dt, node, config ) {
//                	window.location.href = '../Project/ProjectList.jsp?projectId='+$("#projectId").val();
                	window.location.href = '../Project/ProjectList.jsp';
                }
            }
        ],
        "bLengthChange": false,
        "searching": true,
        "orderCellsTop": true ,
        "sScrollX": "100%",
        "sScrollXInner": "100%",
        "bScrollCollapse": true,
        "ajax": "../../../../GetIssueList?type="+$("#type").val()+"&projectId="+$("#projectId").val(),
        "columns": [
             {
                defaultContent: '<center><i class="select_me fa fa-check fa-2x" aria-hidden="true"></i>'
             },
             { "data": "projectId" },
             { "data": "title" },
             { "data": "formattedexpectedStartDate" },
             { "data": "assignedToName" },
             { "data": "customer" }
        ],
        fixedColumns: true
    });
	 
	$('#issuedatatables tbody').on( 'click', '.select_me', function () {
    	var data = table.row( $(this).parents('tr') ).data();
    	$("#selectedIssueId").val(data.rowid);
    	
    	$("#issueTitle").val(data.title);
    	$("#issueTitleLbl").addClass("active");
    	$("#description").val(data.description);
    	$("#descriptionLbl").addClass("active");
    	$("#customer").val(data.customer);
    	$("#customerLbl").addClass("active");
    	$("#remarks").val(data.remarks);
    	$("#remarksLbl").addClass("active");
    	$('#category').val(data.category).material_select("refresh");
    	$('#mode').val(data.mode).material_select("refresh");
    	$('#priority').val(data.priority).material_select("refresh");
    	$('#assignedTo').val(data.assignedTo).material_select("refresh");
    	$('#status').val(data.isAccepted).material_select("refresh");
    	if (data.formattedexpectedStartDate  !== "") {
			$('#expectedStartDate').val(data.formattedexpectedStartDate);
			$('#expectedStartDate').pickadate('set').set('select', data.formattedexpectedStartDate);
    	}
    	$("#duration").val(data.duration);
    	$("#durationLbl").addClass("active");
    	if($("#type").val() == "support")
    	{
        	$("#statusDiv").addClass("HideThisElement");
        	$("#remarksDiv").addClass("HideThisElement");
    	}
    	
    	if(data.isAccepted == "1" && data.startDate == "" && data.endDate == "")
    	{
			$(".acceptDurartion").removeClass("HideThisElement");
        	$("#SubmitButtonStart").removeClass("HideThisElement");
        	$("#SubmitButtonEnd").addClass("HideThisElement");
    	}
    	else if(data.isAccepted == "1" && data.startDate !== "" && data.endDate == "")
    	{
			$(".acceptDurartion").removeClass("HideThisElement");
        	$("#SubmitButtonEnd").removeClass("HideThisElement");
        	$("#SubmitButtonStart").addClass("HideThisElement");
    	}
    	else if(data.isAccepted == "1" && data.startDate !== "" && data.endDate !== "")
    	{
        	$("#SubmitButtonEnd").addClass("HideThisElement");
        	$("#SubmitButtonStart").addClass("HideThisElement");
    	}
    	
    	$("#issueUpdateCard").removeClass("HideThisElement");
    	$("#issuetableCard").addClass("HideThisElement");
    });
	
	function updateClick()
	{

		var url = "../../../../IssueUpdateServlet";
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
	               data: $("#newElementForm").serialize(), // serializes the form's elements.
	               success: function(data)
	               {
	                   if (data == 1) {
	                	   document.getElementById("newElementForm").reset();
							$(".selectpicker").val('default');
							$(".selectpicker").selectpicker("refresh");
							$("#alertMessage").addClass("HideThisElement");
							$("#errorMessage").addClass("HideThisElement");
							$('#issuedatatables').DataTable().ajax.reload();
							toastr.success('Issue Updated Successfully!');
					    	$("#issueUpdateCard").addClass("HideThisElement");
					    	$("#issuetableCard").removeClass("HideThisElement");
						} else{
							toastr.error('Failed to Update Issue!');
						}
	               }
	    	});
//	    }
	}
	
	$("#SubmitButtonUpdate").click(function() {
		updateClick();
	    return false;
	});
	
	$("#SubmitButtonStart").click(function() {
		$("#updateDate").val("updateStart");
		updateClick();
	    return false;
	});
	
	$("#SubmitButtonEnd").click(function() {
		$("#updateDate").val("updateEnd");
		updateClick();
	    return false;
	});

	$("#close").click(function() {
    	$("#issueUpdateCard").addClass("HideThisElement");
    	$("#issuetableCard").removeClass("HideThisElement");
	});
});