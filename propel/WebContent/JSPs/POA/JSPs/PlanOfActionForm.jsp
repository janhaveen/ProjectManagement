<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Solution Matrix</title>
<style type="text/css">
#planofactionFormDiv p{
	height: 16rem;
	overflow-y: auto;
	text-align: left;
}
</style>
</head>
<body>
<div class="row HideThisElement" id="planofactionFormDiv">
	   <div class="col-md-12">
        <!--Card-->
        <div id="formCard" class="card card-cascade narrower ">
            <div class="card-body">
    			<!-- <h5 class="card-title">New Solution Matrix</h5><hr> -->
                <!-- Edit Form -->
                <form action="" id="addplanofactionForm" name="addplanofactionForm">
                    <div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
                    <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
       			    <div class="alert alert-success HideThisElement" id="successMessage"></div>
                    <!--First row-->
                    <div class="row">
                    	<div class="col-md-12 HideThisElement" id="infoUpdate">
                    		<div class="row">
	                    		<div class="col-md-3">
	                    			<div class="md-form">
	                    				<!-- <i class="fa fa-pencil-alt prefix" id="editplanofaction" style="margin-left: -50%;"></i> -->
	                    				<label id="revieweeLbl" for="reviewee" class="">Reviewee</label>
										<input type="text" readonly="readonly"  class=" form-control" id="reviewee">			                            
			                        </div>
		                        </div>
		                        <div class="col-md-3">
		                       	 	<div class="md-form">
		                       	 		<label id="DORLbl" for="DOR" class="">Date of Review</label>
										<input type="text" readonly="readonly"  class=" form-control" id="DOR">			                            
			                        </div>
		                        </div>
		                        <div class="col-md-3">
			                        <div class="md-form">
			                            <label id="lastUpdatedOnLbl" for="lastUpdatedOn" class="">Last Updated On</label>
										<input type="text" readonly="readonly"  class=" form-control" id="lastUpdatedOn">
			                         </div>
		                        </div>
		                        <div class="col-md-3">
		                        	<div class="md-form">
			                            <label id="lastUpdatedByLbl" for="lastUpdatedBy" class="">last Updated By</label>
										<input type="text" readonly="readonly"  class=" form-control" id="lastUpdatedBy">
		                           	</div>
		                        </div>
	                        </div>
                    	</div>
		                <div class="col-md-12"><br>
	                    	<div class="row">
	                    		<div class="col-md-12">
	                                <label id="poaNameLbl" for="poaName" class="">Activity</label>
	                                <input type="text" class="form-control" id="poaName" name="poaName">		                            			                          
		                        </div>
	                    		<div class="col-md-4" id="challengesDiv">
	                                <input type="hidden" id="planofactionId" name="planofactionId">
	                                <input type="hidden" id="challengesOld" name="challengesOld">
	                                <label id="challengesLbl" for="challenges" class="">Challenges</label>
	                                <textarea rows="11" type="text" class="md-textarea richTextArea form-control" id="challenges"  style="height:14rem;overflow-y: auto;"></textarea>		                            			                          
		                        </div>
		                     	<div class="col-md-4" id="planofactionDiv">
	                             	<input type="hidden" id="planofactionOld" name="planofactionOld">
		                            <label id="planofactionLbl" for="planofaction" class="">Solution Matrix</label>			                           
	                                <textarea rows="11" type="text" class="md-textarea richTextArea form-control" id="planofaction" style="height: 14rem;overflow-y: auto;"></textarea>
		                        </div>
		                        <div class="col-md-4">
		                              <label for="responsible">Responsible</label>
									  <select class="form-control" id="responsible" name="responsible" multiple data-live-search="true">
	                                    	<option value=""  selected>Responsible</option> 
		                               </select>
		                               <label for="accountable">Accountable</label>
									   <select class="form-control" id="accountable" name="accountable" multiple data-live-search="true">
	                                    	<option value=""  selected>Accountable</option> 
		                                </select>
										<label for="consulted">Consulted</label>
									  	<select class="form-control" id="consulted" name="consulted"  multiple data-live-search="true">
	                                    	<option value=""  selected>Consulted</option> 
		                               	</select>
										<label for="informed">Informed</label>
									  	<select class="form-control" id="informed" name="informed" multiple data-live-search="true">
	                                    	<option value=""  selected>Informed</option> 
		                               	</select>
			                     </div>
		                        </div>
		                      </div>
	                      </div>
                   		  <div class="row">
	                   			<div class="col-md-4">
	                   				<!-- <input type="hidden" id="statusPOAOld" name="statusPOAOld">
	                         	 	<label for="statusPOA">Status</label>
								 	<select class="form-control" id="statusPOA" name="statusPOA">
	                                   	<option value="" disabled selected>Status</option> 
	                               </select> -->
	                               <input type="hidden" id="priorityOld" name="priorityOld">
	                         	 	<label for="priorityPOA">Change Category</label>
								 	<select class="form-control" id="priorityPOA" name="priority">
	                                   	<!-- <option value=""  selected>Priority</option>  -->
	                               </select> 
	                               	<label id="ExpDateOfClosureLbl" for="ExpDateOfClosure" class="">Expected Date Of Closure</label>
		                         	<input type="hidden" id="ExpDateOfClosureOld" name="ExpDateOfClosureOld">				                         	  
									<input type="text" name="ExpDateOfClosure" id="ExpDateOfClosure" class="form-control datepicker">
	                            </div>
		                         <div class="col-md-8">
<!-- 		                           	<p id="commentsText"  style="height: 4rem;overflow-y: auto;"></p>
 -->		                         <label id="commentsLbl" for="comments" class="">Remarks</label>	
 									<input type="hidden" id="commentsOld" name="commentsOld">				              										
 		                            <textarea type="text" rows="4" class="md-textarea  form-control" id="comments" name="comments" style="height: 4rem;overflow-y: auto;"></textarea>
		                         </div>
                   			</div>
                    <!-- Fourth row -->
                    <div class="row">
                        <div class="col-md-12 text-center my-4">
                            <input type="button" id="SubmitButtonRegister" value="Save" class="btn btn-info btn-rounded">
                            <input type="button" id="SubmitButtonUpdate" value="Update" class="btn btn-info btn-rounded">
                            <input type="button" id="SubmitButtonCancel" value="Back" class="btn btn-info btn-rounded">
                        </div>
                    </div>
                    <!-- /.Fourth row -->
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