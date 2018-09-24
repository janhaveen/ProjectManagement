<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="card HideThisElement" id="formDiv">
    <div class="card-body">
    	<h5 class="card-title">New Interview</h5><hr>
	    <div class="form-group col-md-12">
	    <form id="newFormatForm" enctype = "multipart/form-data">
        <div class="row">
            <div class="form-group col-md-3">
              	 <input type="hidden" id="FormatId" name="FormatId">
        		 <input type="hidden" id="action" name="action">		
                 <label id="formatNameLbl" for="formatName">Name</label>
                 <input type="text" id="formatName" class="form-control text-capitalize" name="formatName">
             </div>
             <!--Second form-group column-->
             <div class="form-group col-md-3">
                 <label id="formatTypeLbl" for="formatType">Type</label>
                 <input type="text" id="formatType" class="form-control text-capitalize" name="formatType">
             </div>
             <div class="form-group col-md-3">
              	<label for="exampleFormControlFile1">Choose file</label>
             	<input type="file" name="file" class="form-control-file" id="exampleFormControlFile1">
                     <!-- <div class="file-field">
                         <div class="btn btn-primary btn-sm float-left">
                             <span>Choose file</span>
                             <input type="file" name="file">
                         </div>
                         <div class="file-path-wrapper">
                             
                         </div>
                     </div> -->
             </div>
              <div class="form-group col-md-3">
              		<label for="exampleFormControlFile1">File Name</label>
             		<input class="file-path validate" type="text" placeholder="Upload your file" name="filename" id="filenameTextField">
             </div>
             <div class="form-group col-md-12">
				<button class="btn btn-primary" id="submitFormatForm" type="button">Save Changes</button>
				<button type="button" class="btn btn-outline-primary waves-effect" id="cancelFormatForm" >Back</button>
			</div>
        </div>
    </form>
  </div>
</div>
</div>
</body>
</html>