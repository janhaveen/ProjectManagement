<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <style type="text/css">
div.dt-buttons {
    position: relative;
    float: left;
    display: none;
}
</style> -->
</head>
<body>
<div class="card HideThisElement" id="InterviewViewDiv">
    <div class="card-body">
    	<div class="row">
    		<div class="col-md-6"><h5 class="card-title">Employee Details</h5></div>
    		<div class="col-md-6 right"><u><a id="editClick" href="#">Edit</a></u></div>
    	</div>
    	<hr>
    	<dl class="row">
		  <dt class="col-sm-2">First Name</dt>
		  <dd class="col-sm-2" id="firstNameText">Firstname</dd>
		  <dt class="col-sm-2">Last Name</dt>
		  <dd class="col-sm-2" id="LastnameText">Lastname</dt>
		  <dt class="col-sm-2">Department</dt>
		  <dd class="col-sm-2" id="DepartmentText">Gender</dd>
		  <dt class="col-sm-2">Designation</dt>
		  <dd class="col-sm-2" id="DesignationText">Contact</dd>
		  <dt class="col-sm-2">Mobile No</dt>
		  <dd class="col-sm-2" id="MobileNoText">Alt Contact</dd>
		  <dt class="col-sm-2">Email ID</dt>
		  <dd class="col-sm-2" id="EmailText">Email</dd>
		  <dt class="col-sm-2">Location</dt>
		  <dd class="col-sm-2" id="LocationText">Department</dd>
		  <dt class="col-sm-2">Report To</dt>
		  <dd class="col-sm-2" id="ReportToText">Designation</dd>
		  <dt class="col-sm-2">Experience</dt>
		  <dd class="col-sm-2" id="ExperienceText">Supervisor</dd>
		  <dt class="col-sm-2">Compensation</dt>
		  <dd class="col-sm-2" id="CompensationText">User</dd>
		</dl><hr>
		<h5 class="card-title">Interview Details</h5>
		<dl class="row">
		  <dt class="col-sm-2">Meeting</dt>
		  <dd class="col-sm-2" id="MeetingText">Firstname</dd>
		  <dt class="col-sm-2">Coaching</dt>
		  <dd class="col-sm-2" id="CoachingText">Firstname</dd>
		  <dt class="col-sm-2">Training</dt>
		  <dd class="col-sm-2" id="TrainingText">Firstname</dd>
		</dl>
		<dl class="row">
			<dt class="col-sm-2">Role</dt>
		  	<dd class="col-sm-10" id="RoleText">Role</dd>
		</dl>
		<dl class="row">
			<dt class="col-sm-2">Challenges</dt>
		  	<dd class="col-sm-10" id="ChallengesText">Role</dd>
		</dl>
		<hr>
		<h5 class="card-title">Process Details</h5>
			 <%@include file="../../Process/JSPs/ProcessList.jsp" %>
		<hr>
		<h5 class="card-title">Tool Details</h5>
			 <%@include file="ToolList.jsp" %>
		<hr>
		<h5 class="card-title">Audit Details</h5>
			<%@include file="AuditList.jsp"%>
	
		<div class="col-md-12" style="text-align: center;">
   			<button type="button" class="btn btn-primary back" id="SubmitButtonBackFromView">Back</button>
   		</div>
    </div>   
   </div>
</body>
</html>