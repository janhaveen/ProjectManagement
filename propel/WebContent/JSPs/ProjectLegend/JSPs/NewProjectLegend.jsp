<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="modal fade" id="RegisterNewProjectLegend" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-info" role="document" style="margin-top: 50px;">
		<div class="modal-content">
			<div class="modal-header light-blue darken-3 white-text">
				<h4 class="" id="NewElement-modal-title">New Legend Details</h4>
				<button type="button" class="close waves-effect waves-light" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<!--Body-->
			<div class="modal-body mb-0">
				<form action="" id="newProjectLegendForm" name="newProjectLegendForm">
					<div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33">
					</div>
					<div class="alert alert-danger HideThisElement" id="errorMessage"></div>
					<input type="hidden" name="selectedLegendId" id="selectedLegendId">
					<input type="hidden" name="legendGroup" id="legendGroup">
					<input type="hidden" name="category" id="category">
					<input type="hidden" name="subCategory" id="subCategory">
					<input type="hidden" name="ProjectId" id="ProjectId" value="<%=request.getParameter("id")%>">				
					<div class="col-md-12">
						<div class="md-form">
							<input type="text" class="form-control" id="description" name="description">
							<label id="descriptionLbl" for="description">Description</label>
						</div>
					</div>
					<div class="row">
						<div class="text-center mt-1-half">
							<button id="SubmitButtonRegister" class="btn btn-info waves-effect" data-dismiss="modal">
								Submit 
							</button>
							<button id="SubmitButtonUpdate"	class="btn btn-info waves-effect HideThisElement" data-dismiss="modal">Update
							</button>
							<button class="btn btn-outline-info waves-effect"
								data-dismiss="modal">Close
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!--/.Content-->
	</div>
</div>
</body>
</html>