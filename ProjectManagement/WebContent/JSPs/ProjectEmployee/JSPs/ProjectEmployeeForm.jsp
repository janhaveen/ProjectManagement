<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
</head>
<body>
<%-- <%@include file="../header.jsp" %> --%>	
<form id="newEmployeeForm" name="newEmployeeForm">
	<div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
     <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
     <div class="alert alert-success HideThisElement" id="successMessage"></div>
    <div class="form-row">
        <div class="form-group col-md-3">        	
           	<input type="hidden" id="EmployeeId" name="EmployeeId">
           	<input type="hidden" id="action" name="action">        
           	<label for="empFirstName" id="empFirstNameLbl">First Name</label>    	
            <input type="text" id="empFirstName" name="empFirstName" class="form-control text-capitalize">                
        </div>
        <div class="form-group col-md-3">
           	<label for="empLastName" id="empLastNameLbl">Last Name</label>
            <input type="text" id="empLastName" name="empLastName" class="form-control text-capitalize">                
        </div>
        <div class="form-group col-md-3">
        	<label for="department" id="departmentTextLbl">Department</label>
        	<select  class="form-control" id="department" name="department">
        		<option></option>
        	</select>
        </div>
        <div class="form-group col-md-3">
        	<label for="designation" id="designationTextLbl">Designation</label>
        	<select  class="form-control" id="designation" name="designation">
        		<option></option>
        	</select>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-2">
           <label for="empMobileNo" id="empMobileNoLbl">Mobile No</label>
           <input type="number" id="empMobileNo" name="empMobileNo" class="form-control">
        </div>
        <div class="form-group col-md-4">
            <label for="empEmailID" id="empEmailIDLbl">Email ID</label>
            <input type="email" id="empEmailID" name="empEmailID" class="form-control">
        </div>
        <div class="form-group col-md-3">
             <label for="empLocation" id="empLocationLbl">Location</label>
             <input type="text" id="empLocation" name="empLocation" class="form-control text-capitalize">
        </div>
        <div class="form-group col-md-3">
        	<label for="empSupervisor" id="empSupervisorLbl">Report To</label>
            <input type="text" id="empSupervisor" name="empSupervisor" class="form-control text-capitalize">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-3">
            <label for="empExperience" id="empExperienceLbl">Experience</label>
            <input type="text" id="empExperience" name="empExperience" class="form-control text-capitalize">
        </div>
        <div class="form-group col-md-3">
            <label for="empCompensation" id="empCompensationLbl">Compensation</label>
            <input type="text" id="empCompensation" name="empCompensation" class="form-control text-capitalize">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-12">
            <input type="button" id="saveEmployeeForm" value="Submit" class="btn btn-primary btn-rounded">
            <input type="button" id="EditEmployeeForm" value="Update" class="btn btn-primary btn-rounded">
            <input type="button" id="cancelEmployeeForm" value="Cancel" class="btn btn-primary btn-rounded back">
        </div>
    </div>
</form>
</body>
</html>
