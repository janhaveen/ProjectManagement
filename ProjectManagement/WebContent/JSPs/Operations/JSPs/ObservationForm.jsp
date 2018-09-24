<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="HideThisElement" id="observationFormDiv">
        <!--Card-->
        <div id="formCard" class="card ">
            <div class="card-body">
           <!--  <h5 class="card-title">New Observation</h5><hr> -->
                <!-- Edit Form -->
                <form action="" id="addObservationForm" name="addObservationForm">
                    <div class="alert alert-warning HideThisElement" id="alertMessage" style="background-form-group color: #ffbb33"></div>
                    <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
       				<div class="alert alert-success HideThisElement" id="successMessage"></div>
                    <!--First form-row-->
                    <div class="form-row">
                       <div class="form-group col-md-6">
                           <input type="hidden" id="ObservationId" name="ObservationId">
                           <input type="hidden" id="ProjectId" name="ProjectId" value="<%=request.getParameter("id")%>">
                           <label id="ObservationLbl" for="ObservationText" class="">Title</label>
                            <input type="text" id="ObservationText" class="form-control" name="ObservationText">
                        </div>
                         <div class="form-group col-md-6">
                         	  <label for="department">Department</label>
                         	  <input type="hidden" id="departmentH" name="departmentH">
							  <select class="form-control" id="department" name="department">
                                   	<option value=""  selected>Department</option> 
                               </select>	                           
                         </div>
                         <div class="form-group col-md-4" id="processDiv">
                             <label id="processLbl" for="processText" class="">Process</label>
                             <select class="form-control"  id="process" name="process" >
                                   	<option value=""  selected>Process</option> 
                               </select>
                        </div>
                         <div class="form-group col-md-4">
                              <label for="defectType">Defect Type</label>
							  <select class="form-control" id="defectType" name="defectType">
                                   	<option value="" disabled selected>Defect Type</option> 
                               </select>
                         </div>
                        <div class="form-group col-md-4">
                             <label for="function">Function</label>
                             <input type="hidden" id="functionH" name="functionH">
						  	 <select class="form-control" id="function" name="function">
                                  	<option value="" disabled selected>Function</option> 
                              </select>
                         </div>
                        <div class="form-group col-md-6" id="observationDiv">
                              <label id="observationLbl" for="observation" class="">Description</label>
                              <textarea type="text" rows="7" class="md-textarea richTextArea form-control" id="observation"  style="height: 6rem;overflow-y: auto;"></textarea>
                        </div>
                        <div class="form-group col-md-6" id="impactDiv">
							  <label id="impactLbl" for="impact" class="">Impact</label>
							  <textarea type="text" rows="7" class="md-textarea richTextArea form-control" id="impact"  style="height: 6rem;overflow-y: auto;"></textarea>
						</div>
                    </div>
                    <!-- Fourth form-row -->
                    <div class="form-row">
                        <div class="form-group col-md-12 text-center my-4">
                            <input type="button" id="SubmitButtonRegister" value="Save" class="btn btn-info btn-rounded">
                            <input type="button" id="SubmitButtonUpdate" value="Update" class="btn btn-info btn-rounded">
                            <input type="button" id="SubmitButtonCancel" value="Back" class="btn btn-info btn-rounded">
                        </div>
                    </div>
                    <!-- /.Fourth form-row -->
                </form>
                <!-- Edit Form -->
            </div>
            <!-- /.Card content -->
        </div>
        <!--/.Card-->
    </div>
</div>
</body>
</html>