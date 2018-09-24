<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project List</title>
<link rel="shortcut icon" href="../../../img/TitleImage.png">

</head>
<body>
<div id="projecttableCard" class="card">
	<div class="card-body">
		<!-- <h5 class="card-title">Project List</h5><hr> -->
    	<div class="alert alert-success alert-dismissible fade show HideThisElement successMsg" role="alert">
		 <p id="successMsg"></p>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<div class="alert alert-danger alert-dismissible fade show HideThisElement errorMsg" role="alert">
		 <p id="errorMsg"></p>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<input type="hidden" id="t" value="<%=request.getParameter("p")%>">
		<input type="hidden" id="v" value="<%=request.getParameter("v")%>">
    	<table id="projectdatatables" class="table table-hover mb-0 nowrap">
			 <thead>
				<tr id="headerrow"  class="">
				  <th>Action</th>
				 <!--  <th>Project ID</th> -->
				  <th>Client Name</th>
				  <th>Location</th>				
				  <th>CPC</th>
				  <th>Branch</th>
				  <th>Stage</th>
				</tr>
				<!-- <tr id="filterrow">
				  <td></td>
				  <th>Project ID</th>
				  <th>Company Name</th>
				  <th>Location</th>
				  <th>StakeHolder Name</th>
				  <th>Mobile Number</th>
				  <th>Email ID</th>
				  <th>CPC</th>
				  <th>EPC</th>
				</tr> -->
			 </thead>	                          
        </table>
    </div>
</div>
</body>
</html>