<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.modal-dialog.modal-notify.modal-info .fa{
    padding: 5px	!important;
}
</style>
</head>
<body>
<div class="modal fade" id="NewFunction" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document" >
        <!--Content-->
        <div class="modal-content">
            <!--Header-->
            <div class="modal-header">
                <h5 class="" id="NewElement-modal-title"></h5>
                <button type="button" class="close waves-effect waves-light" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <!--Body-->
            <div class="modal-body">
            	<div id="viewDiv">
						<!-- <div class="col-md-12"><label  class="font-weight-normal">Function Name</label></div>
						<div class="col-md-12"><b>Role: </b><p class="font-weight-normal" id="roleView" class=""></p></div>
						<div class="col-md-12" id="ifDiv"></div> -->
						<table class="table table-hover mb-0 nowrap">
							<tr>
								<td>Name: </td>
								<td id="fnName" class="font-weight-normal">Name </td>
							</tr>
							<tr>
								<td>Role: </td>
								<td><p class="font-weight-normal" id="roleView" class=""></p></td>
							</tr>
							<tr>
								<td style="width: 25%;">Influencing factor: </td>
								<td id="ifDiv"></td>
							</tr>
							<!-- <tr>
								<td></td>
								<td class="left">
									 <i class='fa fa-2x fa-pencil-alt blckcolor edit'></i>
									 <i class='fa fa-2x fa-trash-alt blckcolor delete'></i>
									 <i class='fa fa-2x fa-exchange-alt blckcolor change'></i>
								</td>
							</tr> -->
						</table><hr>									
						<button  type="button" class="edit btn btn-info waves-effect ">Edit</button>
						<button  type="button" class="delete btn btn-info waves-effect ">Delete</button>
						<button  type="button" class="btn btn-outline-info waves-effect close1" data-dismiss="modal">Close</button>
            	</div>
            	<div id="updateDiv" class="HideThisElement">
                <form action="" id="NewFunctionForm" name="NewFunctionForm">
                    <div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
                    <div class="alert alert-danger HideThisElement" id="errorMessage"></div>                    
					<div class="form-row">
					    <div class="form-group col-md-8">
					    	<input type="hidden" id="FunctionId" name="FunctionId">
                           	<input type="hidden" id="ProjectId" name="ProjectId">
                           	<input type="hidden" id="action" name="action">   
						    <label for="name">Function Name</label>
						    <input type="text" class="form-control" id="name" name="name" placeholder="Name">
					    </div>
					    <div class="form-group col-md-4">
						      <label for="DepartmentId">Department</label>
						      <select class="form-control" id="DepartmentId" name="DepartmentId" placeholder="Department"></select>
					    </div>
					    <div class="form-group col-md-9">
						      <label for="RoleText">Role</label>
						      <textarea class="form-control richTextArea" id="RoleText"  rows="5"></textarea>
					    </div>
					    <div class="form-group col-md-3">
						      <label for="InfluencingFactors">Influencing Factors</label>
						      <textarea class="form-control" name="InfluencingFactors" id="InfluencingFactors" rows="5"></textarea>
						      <!-- <input type="textarea"> -->
					    </div>
					 </div>
					<br>
                    <div class="row">
                        <div class="col-md-12">
                            <button type="button" id="SubmitButtonRegister" class="btn btn-info waves-effect">Submit <i class="fa fa-chcek ml-1"></i></button>
                            <button type="button" id="SubmitButtonUpdate" class="btn btn-info waves-effect HideThisElement">Update</button>
                            <button  type="button" class="btn btn-outline-info waves-effect close1" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </form>
				</div>
				<div id="changeDept" class="HideThisElement">
					<div class="row">
                        <div class="col-md-12">
                            <div class="md-form">
                            	<label id="departmentLbl" for="department" class="">Department</label>
                            	<select id="department" class=" form-control"></select>                                
                            </div>
                        </div>
                     </div>
                     <div class="text-center mt-1-half">
                          <button type="button" id="SubmitButtonUpdate1" class="btn btn-info waves-effect ">Update</button>
                          <button  type="button" class="btn btn-outline-info waves-effect close1" data-dismiss="modal">Close</button>
                      </div>
				</div>
            </div>
            <!--/.Content-->
        </div>
    </div>
</div>
</body>
</html>