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
        <table class="table table-hover mb-0 nowrap table-sm" id="howTable">
			 <thead  class="blue-grey lighten-4">
				<tr>
				  <th>#</th>
				  <th>Process Name</th>
				  <th>Document Type</th>
				  <th>Department</th>
				  <th>Description</th>
				</tr>
			</thead>
			<tbody></tbody>                   
        </table>
    </div>
</div>
<form id="newHowForm" name="newHowForm">
	<div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
    <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
    <div class="alert alert-success HideThisElement" id="successMessage"></div>
    <div class="form-row">
        <div class="form-group col-md-12">
           	<input type="hidden" id="action" name="action" value="insert">
           	<input type="hidden" id="ProcessId" name="ProcessId">
           	<label for="procedureTitle" id="procedureTitleLbl">Procedure</label>
            <input type="text" id="procedureTitle" name="procedureTitle" class="form-control text-capitalize">                
        </div>
        <div class="form-group col-md-3" style="text-align: left">
        	<label for="procedureTitle" id="procedureTitleLbl">Document Type</label>
            <div class="form-check mb-4">
                <input class="form-check-input with-gap" type="radio" name="processDocType" id="processDocTypeWritten" value="Written" checked>
                <label class="form-check-label" for="processDocTypeWritten">Written</label>
            </div>
            <div class="form-check mb-4">
                <input class="form-check-input with-gap" type="radio" name="processDocType" id="processDocTypeExpertJudge" value="Expert Judgement">
                <label class="form-check-label" for="processDocTypeExpertJudge">Expert Judgement</label>
            </div>
            <div class="form-check mb-4">
                <input class="form-check-input with-gap" type="radio" name="processDocType" id="processDocTypeAbsent" value="Absent">
                <label class="form-check-label" for="processDocTypeAbsent">Absent</label>
            </div>
        </div>
        <div class="form-group col-md-9">
           	<label for="procedureComments" id="empRoleLbl">Comments</label>
            <textarea class="md-textarea richTextArea form-control md-textarea-auto"  cols="40" style="width: 100% !important;" id="procedureComments"  rows="5"></textarea>                
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-12">
            <input type="button" id="saveHowForm" value="Save" class="btn btn-primary btn-rounded">
            <input type="button" id="cancelHowForm" value="Cancel" class="btn btn-primary btn-rounded back">
        </div>
    </div>
</form>
</body>
</html>
