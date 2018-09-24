<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Task</title>
	    <link rel="shortcut icon" href="img/TitleImage.png">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker.css">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker.min.css">
	    <link rel="stylesheet" href="../../../css/bootstrap-datetimepicker.css">
	    <link rel="stylesheet" href="../../../css/bootstrap-datetimepicker.min.css"> 
	    <!-- <link rel="stylesheet" type="text/css" href="../js/vendor/datatables/css/dataTables.bootstrap4.min.css"/> -->
		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" />
		<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.5.2/css/buttons.dataTables.min.css" />
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
		
		<!-- extra js for the time picker -->
		<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
	</head>
	<body class="fixed-sn white-skin">
		<%@ include file="TaskHeader.jsp" %>
			<div class="container-fluid mb-4">
			<input type="hidden" id="what" value=<%= request.getParameter("what") %>>
			<input type="hidden" id="date" value=<%= request.getParameter("date") %>>
			<section id="taskListSection" class="HideThisElement">
				<div class="row" style="padding-top: 2% !important;">
					<div class="col-md-1">
					</div>
					<div class="col-md-10">
						<div class="card card-cascade narrower">
						    <div class="py-2 d-flex justify-content-between">
						        <div>
						        </div>
						        <h5>Task List</h5>
						        <div>
						        </div>
						    </div>
						    <div class="px-4">
						        <div class="table-wrapper">
									<table id="taskListTable" class="table table-hover mb-0">
										<thead>
											<tr>
										 		<th class="noExport">Action</th>
										 		<th>Title</th>
										 		<th>Project Name</th>
										 		<th>Module Name</th>
										 		<th>Date</th>
										 		<th>Assigned By</th>
										 		<th>Status</th>
										 		<th>Created By</th>
										 		<th>Duration</th>
										  	</tr>
									  	</thead>
								  	</table>
									<br/>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-1">
					</div>
				</div>
			</section>
			
	          <section id="taskSection" class="HideThisElement">
				<form action="" class="form form-horizontal" name="taskForm" id="taskForm">
				<input type="hidden" id="taskId" name="taskId">
				<div class="row firstRow" style="padding-top: 2% !important;">
					<div class="col-md-2">
					</div>
					<div class="col-md-8">
								<div class="card card-cascade narrower">
									<div class="justify-content-between alert HideThisElement" id="alertMessages" style="text-align:center;">
									</div>
									<div class="row py-2 d-flex justify-content-between" style="text-align:center;">
										<div class="col-md-4">
										</div>
										<div class="col-md-4">
							        		<div class="pull-right"><h5>Task</h5></div>
										</div>
										<div class="col-md-4">
										</div>
									</div>
								    <div class="px-4">
								        <div class="table-wrapper">
											<div class="row">
												<div class="col-md-3">
													<div class="form-group">
														<label>Title</label>	
														<input type="text" id="title" name="title" class="form-control">
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
														<label>Project Name</label>	
														<input type="text" id="projectName" name="projectName" class="form-control">
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
														<label>Module</label>
														<input type="text" id="module" name="module" class="form-control">
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
														<label>Assigned By</label>
														<input type="text" id="assignedBy" name="assignedBy" class="form-control">
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-3">
													<div class="form-group">
														<label>Task Date</label>
										          		<div class="input-append date" id="datepicker" data-date-format="dd-mm-yyyy">
														<input type="text" readonly="readonly" name="date" class="form-control">
														<span class="add-on"><i class="icon-th"></i></span>
														</div>
													</div>
												</div>
												<div class="col-md-3">
													<label>Start Time</label>
													<input type="text" class="form-control timePicker" id="startTime" name="startTime">
												</div>
												<div class="col-md-3">
													<div class="form-group">
														<label>End Time</label>
														<input type="text" class="form-control timePicker" id="endTime" name="endTime">
											        </div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
														<label>Status</label>
														<input type="text" id="status" name="status" class="form-control">
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-12">
													<div class="form-group">
													  <label for="description">Description</label>
													  <textarea class="form-control" rows="5" id="description" name="description"></textarea>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-3">
													<div class="form-group">
													  <button type="button" class="btn btn-default" id="UpdateTask">Update</button>
													  <button type="button" class="btn btn-default" id="RegisterTask">Submit</button>
													</div>
												</div>
											</div>
									<br/>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-2">
					</div>
				</div>
				</form>
			  </section>
			</div>
    	<script src="../../../js/moment.js"></script>
    	<script type="text/javascript" src="../JavaScripts/TaskList.js"></script>
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
		
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.js"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.min.js"></script>
    	<script src="../../../js/bootstrap-datetimepicker.js"></script>
    	<script src="../../../js/bootstrap-datetimepicker.min.js"></script>
	    <!-- <script type="text/javascript" src="../js/vendor/datatables/js/jquery.dataTables.min.js"></script> -->
	    <!-- <script type="text/javascript" src="../js/vendor/datatables/js/dataTables.bootstrap4.min.js"></script> -->
		<script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
		<!-- <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js"></script> -->
    	
    	<script type="text/javascript">
    	$('.timePicker').timepicker({
    	    timeFormat: 'h:mm p',
    	    interval: 60,
    	    minTime: '09',
    	    maxTime: '6:00pm',
    	    startTime: '09:00',
    	    dynamic: false,
    	    dropdown: true,
    	    scrollbar: true
    	});
	    	
    	$("#datepicker").datepicker({
    	    format: "yyyy-mm-dd"
        });
			
    	</script>
    	
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.flash.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.html5.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.print.min.js"></script>
	</body>
</html>