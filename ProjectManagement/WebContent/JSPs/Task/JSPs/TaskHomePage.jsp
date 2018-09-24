<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
		<title>Home Page</title>
	    <!-- <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta http-equiv="x-ua-compatible" content="ie=edge"> -->
	    <link rel="shortcut icon" href="../../../img/TitleImage.png">
		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" />
		<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.5.2/css/buttons.dataTables.min.css" />
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
	</head>
	<body class="fixed-sn white-skin">
		<%@ include file="TaskHeader.jsp" %>
		<div class="container-fluid mb-4">
			<section>
				<div class="row" style="padding-top: 2% !important;">
					<div class="col-md-1">
					</div>
					<div class="col-md-10">
						<div class="card card-cascade narrower">
						    <!-- <div class="py-2 d-flex justify-content-between">
						        <div>
						        </div>
						        <h5>Task List</h5>
						        <div>
						        </div>
						    </div> -->
						    <div class="px-4">
						        <div class="table-wrapper">
									<table id="daywiseListTable" class="table table-hover mb-0">
										<thead>
											<tr>
										 		<th class="noExport">Action</th>
										 		<th>Date</th>
										 		<th>Abhishek</th>
										 		<th>Janhavee</th>
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
		</div>
    	<script src="../../../js/moment.js"></script>
    	<script type="text/javascript" src="../JavaScripts/HomePage.js"></script>
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
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