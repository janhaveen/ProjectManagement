<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project List</title>
<link rel="shortcut icon" href="../../img/TitleImage.png">
<!-- <script type="text/javascript">
	function clickFunction(type)
	{
		window.location.href = '../Issue/IssueList.jsp?type='+type+'&projectId='+$('#selectedProjectId').val();
	}
</script> -->
</head>
<body>
	<%@ include file="../SupportHeader.jsp" %>
    <main>
        <div class="container-fluid mb-5">
            <section id="projecttableCard" class="HideThisElement">
                <div class="row">
                    <div class="col-md-12">               
                        <div class="card">
                            <div class="card-body">
								<div class="card-body">
							    	<table id="projectdatatables" class="table table-striped table-bordered nowrap">
										 <thead>
											<tr id="headerrow"  class="mdb-color darken-3 text-white">
											  <th>Action</th>
											  <th>Project ID</th>
											  <th>Company Name</th>
											  <th>Location</th>
											  <th>StakeHolder Name</th>
											  <th>Mobile Number</th>
											  <th>Email ID</th>
											  <th>CPC</th>
											  <th>EPC</th>
											</tr>
											<tr id="filterrow">
											  <td></td>
											  <th>Project ID</th>
											  <th>Company Name</th>
											  <th>Location</th>
											  <th>StakeHolder Name</th>
											  <th>Mobile Number</th>
											  <th>Email ID</th>
											  <th>CPC</th>
											  <th>EPC</th>
											</tr>
										 </thead>	                          
							        </table>
							    </div>
							</div>
                        </div>
                    </div>
                </div>
            </section>
        	<section id="issueRegisterCard" class="HideThisElement">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
						        <h4 class="card-title"><i class="fa fa-plus-circle mr-2" aria-hidden="true"></i> Issue Registration</h4>
						        <br>
	                            <form action="" id="newElementForm" name="newElementForm">
									<div class="alert alert-warning HideThisElement"
									id="alertMessage" style="background-color: #ffbb33"></div>
									<div class="alert alert-danger HideThisElement" id="errorMessage"></div>
									<%-- <input type="hidden" name="selectedProjectId" id="selectedProjectId" value=<%= request.getParameter("projectId") %>> --%>
									<input type="hidden" name="selectedProjectId" id="selectedProjectId">
									<div class="row justify-content-md-center">
										<div class="col-lg-6 col-md-12">
		                                	<div class="md-form">
												<input type="text" class="form-control capitalizeText" id="issueTitle" name="issueTitle">
			                                    <label id="issueTitleLbl" for="issueTitle">Title</label>
		                                    </div>
		                                    <div class="row">
												<div class="col-md-6">
				                                    <div class="md-form" style="padding-top: 5px;">
					                                     <select class="mdb-select" id="category" name="category">
					                                     </select>
					                                     <label style="padding-top: 5px;">Category</label>
				                                    </div>
			                                    </div>
												<div class="col-md-6">
				                                    <div class="md-form" style="padding-top: 5px;">
														<select class="mdb-select" id="mode" name="mode">
														</select>
														<label style="padding-top: 5px;">Mode</label>
				                                    </div>
			                                    </div>
			                                 </div>
										</div>
										<div class="col-lg-6 col-md-12">
		                                	<div class="md-form">
		                                		<textarea class="md-textarea" id="description" name="description" style="height: 80px"></textarea>
		                                    	<label id="descriptionLbl" for="description" class="">Description</label>
		                                    </div>
										</div>
									</div>
									<div class="row justify-content-md-center">
							        	<div class="col-md-3">
								            <div class="md-form">
									            <input type="text" id="customer" name="customer" class="form-control">
								                <label for="customer" id="customerLbl">Customer</label>
								            </div>
								        </div>
										<div class="col-md-3">
		                                    <div class="md-form" style="padding-top: 5px;">
			                                     <select class="mdb-select" id="priority" name="priority">
			                                     </select>
			                                     <label style="padding-top: 5px;">Priority</label>
		                                    </div>
	                                    </div>
										<div class="col-lg-3 col-md-12">
		                                    <div class="md-form" style="padding-top: 5px;">
												<select class="mdb-select" id="assignedTo" name="assignedTo">
												</select>
												<label style="padding-top: 5px;">Assignee</label>
		                                    </div>
	                                    </div>
									</div>
							
									<div class="row">
										<div class="text-center mt-1-half">
											<button id="SubmitButtonRegister" class="btn btn-primary waves-effect" data-dismiss="modal">Submit</button>
											<!-- <button id="SubmitButtonUpdate" class="btn btn-primary waves-effect HideThisElement" data-dismiss="modal">Update</button> -->
											<input type="button" id="close" class="btn btn-outline-primary waves-effect" value="Close">
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
        	</section>
        	<!-- <section id="issueListCard" class="HideThisElement">
        		<div class="row">
                    <div class="col-lg-4 col-md-12 mb-4">
                        <div class="card">
                            <div class="card-header white-text warning-color" style="background-color: #fb3!important;">
                                Support
                            </div>
                            <div class="card-body pt-0 px-1">
                                <div class="card-body text-center">
                                    <div class="list-group list-panel">
                                        <a onClick="clickFunction('support')" class="list-group-item d-flex justify-content-between dark-grey-text"><span style="font-weight: bold;margin-right: 10px" id="totalSupport">0</span> Number Of Support<i class="fa fa-eye ml-auto" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-lg-4 col-md-6 mb-4">
                        Panel
                        <div class="card">
                            <div class="card-header white-text warning-color" style="background-color: #fb3!important;">
                                Requests
                            </div>
                            <div class="card-body pt-0 px-1">
                                <div class="card-body text-center">
                                    <div class="list-group list-panel">
                                        <a onClick="clickFunction('pendingRequest')" class="list-group-item d-flex justify-content-between dark-grey-text"><span style="font-weight: bold;margin-right: 10px" id="pendingRequestCount">0 </span> Pending<i class="fa fa-eye ml-auto" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
                                        <a onClick="clickFunction('inProcessRequest')" class="list-group-item d-flex justify-content-between red-text"><span style="font-weight: bold;margin-right: 10px" id="inProcessRequestCount"> 0</span> In Process<i class="fa fa-eye ml-auto" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
                                        <a onClick="clickFunction('completedRequest')" class="list-group-item d-flex justify-content-between dark-grey-text"><span style="font-weight: bold;margin-right: 10px" id="completedRequestCount">0</span> Completed<i class="fa fa-eye ml-auto" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
                                        <a onClick="clickFunction('onHoldRequest')" class="list-group-item d-flex justify-content-between dark-grey-text"><span style="font-weight: bold;margin-right: 10px" id="onHoldRequestCount"> 0</span> On Hold<i class="fa fa-eye ml-auto" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
                                        <a onClick="clickFunction('disapprovedRequest')" class="list-group-item d-flex justify-content-between dark-grey-text"><span style="font-weight: bold;margin-right: 10px" id="disapprovedRequestCount"> 0</span> Disapproved<i class="fa fa-eye ml-auto" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="card">
                            <div class="card-header white-text warning-color" style="background-color: #fb3!important;">
                                Issues
                            </div>
                            <div class="card-body pt-0 px-1">
                                <div class="card-body text-center">
                                    <div class="list-group list-panel">
                                        <a onClick="clickFunction('pendingIssue')" class="list-group-item d-flex justify-content-between dark-grey-text"><span style="font-weight: bold;margin-right: 10px" id="pendingIssueCount">0 </span> Pending<i class="fa fa-eye ml-auto" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
                                        <a onClick="clickFunction('inProcessIssue')" class="list-group-item d-flex justify-content-between  dark-grey-text"><span style="font-weight: bold;margin-right: 10px" id="inProcessIssueCount"> 0</span> In Process<i class="fa fa-eye ml-auto" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
                                        <a onClick="clickFunction('completedIssue')" class="list-group-item d-flex justify-content-between red-text"><span style="font-weight: bold;margin-right: 10px" id="completedIssueCount"> 0</span> Completed<i class="fa fa-eye ml-auto" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
                                        <a onClick="clickFunction('onHoldIssue')" class="list-group-item d-flex justify-content-between dark-grey-text"><span style="font-weight: bold;margin-right: 10px" id="onHoldIssueCount"> 0</span> On Hold<i class="fa fa-eye ml-auto" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                 </div>
        	</section> -->
        </div>
    </main>
    <script type="text/javascript" src="../../JavaScripts/Project/ProjectList.js"></script>
</body>
</html>