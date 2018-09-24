<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="card HideThisElement" id="ProcessViewDiv">
    <div class="card-body">
    	<div class="row">
    		<div class="col-md-6"><h5 class="card-title">Process Details</h5></div>
    		<div class="col-md-6 right"><u><a id="editClick" href="#">Edit</a></u></div>
    	</div>
    	<hr>
    	<dl class="row">
		  <dt class="col-sm-2">Procedure</dt>
		  <dd class="col-sm-4" id="ProcedureText">Firstname</dd>
		  <dt class="col-sm-2">Document Type</dt>
		  <dd class="col-sm-4" id="DocumentTypeText">Lastname</dt>		  
		</dl>
		<dl class="row">
		  <dt class="col-sm-1"  style="padding-right: 0px;">Supplier</dt>
		  <dd class="col-sm-5" id="SupplierText">Firstname</dd>
		  <dt class="col-sm-1">Input</dt>
		  <dd class="col-sm-5" id="InputText">Firstname</dd>
		</dl>
		<dl class="row">
		  <dt class="col-sm-1">Process</dt>
		  <dd class="col-sm-11" id="ProcessText">Firstname</dd>
		</dl>
		<dl class="row">
		  <dt class="col-sm-1">Output</dt>
		  <dd class="col-sm-5" id="OutputText">Firstname</dd>
		  <dt class="col-sm-1"  style="padding-right: 0px;">Customer</dt>
		  <dd class="col-sm-5" id="CustomerText">Firstname</dd>
		</dl>		
		<dl class="row">
		  <dt class="col-sm-1" style="padding-right: 0px;">Comments</dt>
		  <dd class="col-sm-11" id="CommentsText">Firstname</dd>
		</dl>
    <div class="col-md-12 center"><button type="button" class="btn btn-primary center" id="SubmitButtonBackFromView">Back</button></div>
</div>
</div>
</body>
</html>