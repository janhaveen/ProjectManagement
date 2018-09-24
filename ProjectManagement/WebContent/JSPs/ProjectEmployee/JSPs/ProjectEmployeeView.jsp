<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="card HideThisElement" id="PrEmpViewDiv">
    <div class="card-body">
    	<div class="row">
    		<div class="col-md-6"><h5 class="card-title">Employee Details</h5></div>
    		<div class="col-md-6 right"><u><a id="editClick" href="#">Edit</a></u></div>
    	</div>
    	<hr>
    	<dl class="row">
		  <dt class="col-sm-2">Firstname</dt>
		  <dd class="col-sm-2" id="firstNameText">Firstname</dd>
		  <dt class="col-sm-2">Lastname</dt>
		  <dd class="col-sm-2" id="LastnameText">Lastname</dt>
		  <dt class="col-sm-2">Department</dt>
		  <dd class="col-sm-2" id="DepartmentText">Department</dd>
		  <dt class="col-sm-2">Designation</dt>
		  <dd class="col-sm-2" id="DesignationText">Designation</dd>
		  <dt class="col-sm-2">Contact No</dt>
		  <dd class="col-sm-2" id="ContactText">Contact No.</dd>
		  <dt class="col-sm-2">Email ID</dt>
		  <dd class="col-sm-2" id="EmailText">Email</dd>
		  <dt class="col-sm-2">Location</dt>
		  <dd class="col-sm-2" id="LocationText">User</dd>
		  <dt class="col-sm-2">Report To</dt>
		  <dd class="col-sm-2" id="SupervisorText">Supervisor</dd>
		  <dt class="col-sm-2">Experience</dt>
		  <dd class="col-sm-2" id="ExperienceText">Experience</dd>		  
		  <dt class="col-sm-2">Compensation</dt>
		  <dd class="col-sm-2" id="CompensationText">Compensation</dd>		  
		</dl><hr>
    <button type="button" class="btn btn-primary " id="SubmitButtonBackFromView">Back</button></div>
</div>
</body>
</html>