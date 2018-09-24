<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.form-check{
	 padding-left: 0rem	!important;
}
/* .nicEdit-main{
	height: 100px		!important;
} */
</style>
</head>
<body>
    <div id="formProcess" class="card HideThisElement">
        <!--Card image-->
       <!--  <div class="view gradient-card-header mdb-form-group color amber darken-1">
            <h5 class="mb-0 font-weight-bold">Process</h5>
        </div> -->
        <!--/Card image-->
        <!-- Card content -->
        <div class="card-body">
            <!-- Edit Form -->
            <form action="" id="EditProcessForm" name="EditProcessForm">
                <div class="alert alert-warning HideThisElement" id="alertMessage" style="background-form-group color: #ffbb33"></div>
                <div class="alert alert-danger HideThisElement" id="errorMessage"></div>  
                <div class="alert alert-success HideThisElement" id="successMessage"></div>  
                <div class="form-row">
                <div class="form-group col-md-12">
                 <div class="form-group col-md-12">
                	<label for="procedureTitle" id="procedureTitleLbl">Procedure</label>
		            <input type="text" id="procedureTitle" name="procedureTitle" class="form-control text-capitalize">
		        </div></div>
                <div class="form-group col-md-3" style=" margin-right: 2%;">
                	<div class="form-group col-md-12">
			            <label for="department" id="departmentTextLbl">Department</label>
			        	<select  class="form-control" id="department" name="department">
			        		<option></option>
			        	</select>				            
			         </div><br>
                	<div class="form-group col-md-12">
	                	<label for="procedureTitle" id="procedureTitleLbl">Document Type</label>
				         <div class="form-group col-md-12">
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
			         </div><br>
			         <div class="form-group col-md-12" style="margin-top: -5%;">
			                <label for="procedureComments" id="empRoleLbl">Comments</label>
			                <textarea class="md-textarea form-control" rows="5" id="procedureComments" name="procedureComments" style="overflow-y: auto;"></textarea>				            
			         </div>
                </div>
                <div style="border-left:2px solid #ced4da;"></div>
                <div class="form-group col-md-8" style="margin-left: 4%;">
                <div class="form-row">
                   <div class="form-group col-md-6">
                       	<input type="hidden" id="ProcessId" name="ProcessId">
                       	<input type="hidden" id="action"  name="action">
                       	<label id="supplierLbl" for="supplier" class="">Supplier</label>
                        <textarea type="text" class="md-textarea  form-control" id="supplier" rows="3" name="supplier" style="overflow-y: auto;"></textarea>                        
                    </div>
                    <div class="form-group col-md-6">
                       	<label id="inputTextLbl" for="inputText" class="">Input</label>                        
                      	<textarea type="text" class="md-textarea  form-control" id="inputText" rows="3" name="inputText" style="overflow-y: auto;"></textarea>
                    </div>
                    <div class="form-group col-md-12">
                        <label id="processTextLbl" for="processText" class="">Process</label>                    
                    	<textarea type="text" class="md-textarea richTextArea form-control" id="processText" rows="6" style="height: 6rem;overflow-y: auto;"></textarea>
                    </div>
                     <div class="form-group col-md-6">
                        <label id="outputTextLbl" for="outputText" class="">Output</label>
	 					<textarea type="text" class="md-textarea  form-control" id="outputText" rows="3" name="outputText" style="overflow-y: auto;"></textarea>
                     </div>
                     <div class="form-group col-md-6">
                    	 <label id="customerLbl" for="customer" class="">Customer</label>
			 			 <textarea type="text" class="md-textarea  form-control" id="customer" rows="3" name="customer" style="overflow-y: auto;"></textarea>
                     </div>
                 </div>
                 </div>
                 </div>
                <!-- Fourth form-row -->
                <div class="form-row">
                    <div class="form-group col-md-12 text-center my-4">
                        <input type="button" id="SubmitButtonRegister" value="Submit" class="btn btn-info btn-rounded">
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
</body>
</html>