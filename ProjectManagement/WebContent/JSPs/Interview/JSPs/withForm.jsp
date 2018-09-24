<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
</head>
<body>
<div class="form-row">
    <div class="form-group col-md-12">
        <%@include file="ToolList.jsp" %>
    </div>
</div>

<form id="newWithForm" name="newWithForm">
	<div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
    <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
    <div class="alert alert-success HideThisElement" id="successMessage"></div>
    <div class="form-row">
        <div class="form-group col-md-12">
            <label for="withItemTitle" id="withItemTitleLbl">Item Required</label>
            	<input type="hidden" id="action" name="action" value="insert">
            <input type="text" id="withItemTitle" name="withItemTitle" class="form-control text-capitalize">
        </div>
        <div class="form-group col-md-3">
            <label id="storageLbl" for="storage">Storage</label>
            <select id="storage" name="storage" class="form-control">
       		</select>
        </div>
        <!--Third form-group column-->
        <div class="form-group col-md-3">
            <label id="conditionLbl" for="condition">Condition</label>
            <select id="condition" name="condition" class="form-control">
       		</select>
        </div>
        <!--Fourth form-group column-->
        <div class="form-group col-md-3">
            <label id="calibrationLbl" for="calibration">Calibration</label>
            <select id="calibration" name="calibration" class="form-control">
   			</select>
        </div>
        <!--Fifth form-group column-->
        <div class="form-group col-md-3">
            <label id="maintainanceLbl" for="maintainanceText">Maintainance</label>
            <select id="maintainance" name="maintainance" class="form-control">
   			</select>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-12" id="WithCommentsDiv">
       		<label for="withItemComments" id="withItemCommentsLbl">Comments</label>
           	<textarea class="md-textarea richTextArea form-control md-textarea-auto" id="withItemComments" rows="2"></textarea>                
        </div>
    </div>
    <div class="form-row">
	    <div class="form-group col-md-4">
	         <div class="md-form">
	             <input type="button" id="saveWithForm" value="Save" class="btn btn-primary btn-rounded">
	             <input type="button" id="cancelWithForm" value="Cancel" class="btn btn-primary btn-rounded back">
	         </div>
	     </div>
     </div>
</form>
</body>
</html>
