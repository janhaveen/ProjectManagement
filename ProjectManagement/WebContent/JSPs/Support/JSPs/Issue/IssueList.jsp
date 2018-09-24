<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Issue List</title>
<link rel="shortcut icon" href="../../img/TitleImage.png">
</head>
<body>
	<%@ include file="../SupportHeader.jsp" %>
    <main>
        <div class="container-fluid mb-5">
            <section id="issuetableCard" class="HideThisElement">
                <div class="row">
                    <div class="col-md-12">               
                        <div class="card">
                            <div class="card-body">
								<div class="card-body">
							    	<table id="issuedatatables" class="table table-striped table-bordered nowrap">
										 <thead>
											<tr id="headerrow"  class="mdb-color darken-3 text-white">
											  <th>Action</th>
											  <th>Project ID</th>
											  <th>Title</th>
											  <th>Expected Start Date</th>
											  <th>Assigned To</th>
											  <th>Customer</th>
											</tr>
											<tr id="filterrow">
											  <td></td>
											  <th>Project ID</th>
											  <th>Title</th>
											  <th>Expected Start Date</th>
											  <th>Assigned To</th>
											  <th>Customer</th>
											</tr>
										 </thead>	                          
							        </table>
							    </div>
							</div>
                        </div>
                    </div>
                </div>
            </section>
        	<section id="issueUpdateCard" class="HideThisElement">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
						        <h4 class="card-title"><i class="fa fa-plus-circle mr-2" aria-hidden="true"></i> Update Issue</h4>
						        <br>
	                            <form action="" id="newElementForm" name="newElementForm">
									<div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
									<div class="alert alert-danger HideThisElement" id="errorMessage"></div>
									<input type="hidden" id="projectId" name ="projectId" value="<%=request.getParameter("projectId")%>">
									<input type="hidden" id="type" name ="type" value="<%=request.getParameter("type")%>">
									<input type="hidden" name="selectedIssueId" id="selectedIssueId">
									<input type="hidden" name="updateDate" id="updateDate">
									<div class="row justify-content-md-center">
										<div class="col-lg-8 col-md-12">
		                                	<div class="md-form">
												<input type="text" class="form-control capitalizeText" id="issueTitle" name="issueTitle">
			                                    <label id="issueTitleLbl" for="issueTitle">Title</label>
		                                    </div>
		                                    <div class="row">
												<div class="col-md-4">
				                                    <div class="md-form" style="padding-top: 5px;">
					                                     <select class="mdb-select" id="category" name="category">
					                                     </select>
					                                     <label style="padding-top: 5px;">Category</label>
				                                    </div>
			                                    </div>
												<div class="col-md-4">
				                                    <div class="md-form" style="padding-top: 5px;">
														<select class="mdb-select" id="mode" name="mode">
														</select>
														<label style="padding-top: 5px;">Mode</label>
				                                    </div>
			                                    </div>
												<div class="col-md-4">
				                                    <div class="md-form" style="padding-top: 5px;">
					                                     <select class="mdb-select" id="priority" name="priority">
					                                     </select>
					                                     <label style="padding-top: 5px;">Priority</label>
				                                    </div>
			                                    </div>
			                                 </div>
										</div>
										<div class="col-lg-4 col-md-12">
		                                	<div class="md-form">
		                                		<textarea class="md-textarea" id="description" name="description" style="height: 80px"></textarea>
		                                    	<label id="descriptionLbl" for="description" class="">Description</label>
		                                    </div>
										</div>
									</div>
									<div class="row justify-content-md-center">
										<div class="col-lg-8 col-md-12">
		                                    <div class="row">
									        	<div class="col-md-6">
										            <div class="md-form">
											            <input type="text" id="customer" name="customer" class="form-control">
										                <label for="customer" id="customerLbl">Customer</label>
										            </div>
										        </div>
												<div class="col-lg-6 col-md-12">
				                                    <div class="md-form" style="padding-top: 5px;">
														<select class="mdb-select" id="assignedTo" name="assignedTo">
														</select>
														<label style="padding-top: 5px;">Assignee</label>
				                                    </div>
			                                    </div>
			                                 </div>
		                                    <div class="row">
												<div class="col-lg-4 col-md-12" id="statusDiv">
				                                    <div class="md-form" style="padding-top: 5px;">
														<select class="mdb-select" id="status" name="status">
															<option value="" selected>Select Status</option>
															<option value='1'>Accept</option>
															<option value='2'>Reject</option>
														</select>
														<label style="padding-top: 5px;">Status</label>
				                                    </div>
			                                    </div>
			                                    <div class="col-lg-4 col-md-12 acceptDurartion HideThisElement">
			                                        <div class="md-form">
			                                            <input placeholder="Selected date" type="text" id="expectedStartDate" name="expectedStartDate" class="form-control datepicker">
			                                            <label id="expectedStartDateLbl" for="expectedStartDate">Select Expected Start Date</label>
			                                        </div>
												</div>
			                                    <div class="col-lg-4 col-md-12 acceptDurartion HideThisElement">
										            <div class="md-form">
											            <input type="text" id="duration" name="duration" class="form-control">
										                <label for="duration" id="durationLbl">Duration</label>
										            </div>
												</div>
			                                </div>
										</div>
										<div class="col-lg-4 col-md-12" id="remarksDiv">
		                                	<div class="md-form">
		                                		<textarea class="md-textarea" id="remarks" name="remarks" style="height: 80px"></textarea>
		                                    	<label id="remarksLbl" for="remarks" class="">Remarks</label>
		                                    </div>
										</div>
									</div>
							
									<div class="row">
										<div class="text-center mt-1-half">
											<button id="SubmitButtonUpdate" class="btn btn-primary waves-effect" data-dismiss="modal">Update</button>
											<button id="SubmitButtonStart" class="btn btn-primary waves-effect HideThisElement" data-dismiss="modal">Start</button>
											<button id="SubmitButtonEnd" class="btn btn-primary waves-effect HideThisElement" data-dismiss="modal">End</button>
											<input type="button" id="close" class="btn btn-outline-primary waves-effect" value="Close">
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
        	</section>
        </div>
    </main>
    <script type="text/javascript" src="../../JavaScripts/Issue/IssueList.js"></script>
</body>
</html>