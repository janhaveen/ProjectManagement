<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="HideThisElement card" id="projectForm">
    <!-- <p class="h5">New Project</p> 
    <hr>-->
	<div class="card-body">
    <form id="newProjectForm" name="newProjectForm">
    	<div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
        <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
        <div class="alert alert-success HideThisElement" id="successMessage"></div>
    	<input type="hidden" id="projectId" name="Project ID">
        <div class="form-row">
            <div class="form-group col-md-4">
                <label id="branchNameLbl" for="branchName">Branch Name</label>
                <input type="text" id="branchName" class="form-control text-capitalize" name="Branch Name">
            </div>
            <div class="form-group col-md-4">
                <label id="companyNameLbl" for="companyName" class="">Client Name</label>
                <input type="text" class="form-control text-capitalize" id="companyName" name="companyName">
            </div>
            <div class="form-group col-md-4">
                <label id="locationLbl" for="location" class="">Location</label>
                <input type="text" class="form-control text-capitalize" id="location" name="location">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <label id="referenceByLbl" for="referenceBy" class="">Source/ Reference By</label>
                <input type="text" class="form-control text-capitalize" id="referenceBy" name="referenceBy">
            </div>
            <div class="form-group col-md-4">
                <label id="industryLbl" for="industry" class="">Industry</label>
                <input type="text" class="form-control text-capitalize" id="industry" name="industry">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                  <label id="startDateLbl" for="startDate" class="">Start Date</label>
                  <input type="text" class="form-control datepicker validate" id="startDate" name="startDate">
            </div>
            <div class="form-group col-md-4">
                <label id="visitFrequencyLbl" for="visitFrequency" class="">Visit Frequency</label>
                <select id="visitFrequency" name="visitFrequency" class="form-control">
                    <option selected>Choose...</option>
                    <option>...</option>
                </select>
            </div>
            <div class="form-group col-md-4">
                <label id="preferredDayLbl" for="preferredDayText" class="">Preferred Day</label>
                <select id="preferredDayText" name="preferredDayText" class="form-control">
                    <option selected>Choose...</option>
                    <option>...</option>
                </select>
            </div>
        </div>
        <div class="form-row">
        	<div class="form-group col-md-4">                
                <label id="cpcLbl" for="cpc" class="">CPC</label>
                <select id="cpc" name="cpc" class="form-control">
                    <option selected>Choose...</option>
                    <option>...</option>
                </select>                   
            </div>
            <div class="form-group col-md-4">
                 <label id="epcLbl" for="epc" class="">EPC</label>
                 <select id="epc" name="epc" class="form-control">
                     <option selected>Choose...</option>
                     <option>...</option>
                 </select>
             </div>
             <div class="form-group col-md-4">
                  <label id="modeOfPayLbl" for="modeOfPayText" class="">Mode of Payment</label>
                  <select id="modeOfPayText" name="modeOfPay" class="form-control">
                      <option selected>Choose...</option>
                      <option>...</option>
                  </select>
              </div>
        </div>
        <div class="form-row">
	        <div class="form-group col-md-4">
               	<label id="billAmtLbl" for="billAmt" class="">Bill Amount</label>
               	<input type="text" class="form-control validate" id="billAmt" name="billAmt">
	         </div>
	         <div class="form-group col-md-4">
                  <label id="gstLbl" for="gst" class="">GST No</label>
                  <input type="text" class="form-control text-uppercase validate" id="gst" name="gst">
             </div>
        </div>
        <button type="button" id="SubmitButtonRegister" class="btn btn-primary">Save</button>
        <button type="button" id="SubmitButtonUpdate" class="btn btn-primary">update</button>
        <button type="button" id="SubmitButtonCancel" class="btn btn-primary">Back</button>
    </form>
    </div>
</div>
</body>
</html>