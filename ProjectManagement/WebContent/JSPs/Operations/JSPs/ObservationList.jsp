<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
button.dt-button1, button.dt-button1:hover {
    position: relative;
    display: inline-block;
    box-sizing: border-box;
    margin-right: 0.333em;
    padding: 0.5em 1em;
    border: 1px solid #999;
    border-radius: 2px;
    cursor: pointer;
    font-size: 0.88em;
    color: black;
    white-space: nowrap;
    overflow: hidden;
    background-color: #e9e9e9;
  /*   background-image: -webkit-linear-gradient(top, #fff 0%, #e9e9e9 100%);
    background-image: -moz-linear-gradient(top, #fff 0%, #e9e9e9 100%);
    background-image: -ms-linear-gradient(top, #fff 0%, #e9e9e9 100%);
    background-image: -o-linear-gradient(top, #fff 0%, #e9e9e9 100%); */
    background-image: linear-gradient(to bottom, #ace4f9 0%, #ace4f9 9%);
  /*   filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,StartColorStr='white', EndColorStr='#e9e9e9');
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none; */
    user-select: none;
    text-decoration: none;
    outline: none;
    border-radius: 3px;
}
button.dt-button2,button.dt-button2:hover{
    position: relative;
    display: inline-block;
    box-sizing: border-box;
    margin-right: 0.333em;
    padding: 0.5em 1em;
    border: 1px solid #999;
    border-radius: 2px;
    cursor: pointer;
    font-size: 0.88em;
    color: black;
    white-space: nowrap;
    overflow: hidden;
    background-color: #e9e9e9;
  /*   background-image: -webkit-linear-gradient(top, #fff 0%, #e9e9e9 100%);
    background-image: -moz-linear-gradient(top, #fff 0%, #e9e9e9 100%);
    background-image: -ms-linear-gradient(top, #fff 0%, #e9e9e9 100%);
    background-image: -o-linear-gradient(top, #fff 0%, #e9e9e9 100%); */
    background-image: linear-gradient(to bottom, #8ef1b6 0%, #8ef1b6 9%);
  /*   filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,StartColorStr='white', EndColorStr='#e9e9e9');
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none; */
    user-select: none;
    text-decoration: none;
    outline: none;
    border-radius: 3px;
}
</style>
</head>
<body>
<div id="ObservationCard" class="card">
	<div class="card-body">
		<!-- <h5 class="card-title">Opportunity Matrix List</h5><hr> -->
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
    	<table id="Observationdatatables" class="table table-hover mb-0 nowrap dataTable no-footer">
			 <thead>
				<tr id="headerrow">
				  <th>Action</th>
				  <th>Observation</th>
				  <th>Project Name</th>
				  <th>Department</th>
				  <th>Process Name</th>
				  <th>Function</th>
				  <th>Defect Type</th>
				  <th>Created On</th>
				  <th>Description</th>
				  <th>Impact</th>
				</tr>
			 </thead>	                          
        </table>
    </div>
</div>
</body>
</html>