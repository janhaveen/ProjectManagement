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
<div class="modal fade" id="NewLegend" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-notify modal-info" role="document" >
        <!--Content-->
        <div class="modal-content">
            <!--Header-->
            <div class="modal-header light-blue darken-3 white-text">
                <i class="" style="color: #ffffff;"></i>
                <h5 class="" id="NewElement-modal-title">New Department</h5>
                <button type="button" class="close waves-effect waves-light" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <!--Body-->
            <div class="modal-body mb-0">   
             	<form action="" id="NewLegendForm" name="NewLegendForm">
                    <div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
                    <div class="alert alert-danger HideThisElement" id="errorMessage"></div>         	
					<div class="row">
	                     <div class="col-md-12">
	                         <div class="md-form">
	                         	<input type="hidden" id="selectedLegendId" name="selectedLegendId"> 
	                         	<input type="hidden" id="legendGroup" name="legendGroup">   
	                         	<input type="hidden" id="category" name="category">   
	                         	<input type="hidden" id="subCategory" name="subCategory">  
	                         	<input type="hidden" id="action" name="action">                         	
	                             <label id="descriptionLbl" for="description" class="">Descripton</label>
	                         	 <input type="text" id="description" name="description" class="form-control">
	                         </div>
	                     </div>
	                  </div><br>
	                  <div class="text-center mt-1-half">
	                       <button type="button" id="SubmitButtonLegend" class="btn btn-info waves-effect ">Submit</button>
	                       <button  type="button" class="btn btn-outline-info waves-effect close1" data-dismiss="modal">Close</button>
	                   </div>
	              </form>
            </div>
            <!--/.Content-->
        </div>
    </div>
</div>
</body>
</html>