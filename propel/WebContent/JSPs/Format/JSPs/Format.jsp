<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Format</title>
<link rel="shortcut icon" href="../../../img/TitleImage.png">
</head>
<body>
<%@include file="../../Header.jsp" %>
<main>
 <div class="container">
    <div class="container-fluid">
      	<input type="hidden" id="projectid" name="ProjectId" value="<%=request.getParameter("id")%>">            	
      	<input type="hidden" id="t" value="<%=request.getParameter("p")%>">  
	   	 <%@include file="FormatList.jsp" %>
	   	<%--  <%@include file="InterviewView.jsp" %> --%>
     	 <%@include file="FormatForm.jsp" %>
    </div>
  </div>
  <div class="modal fade" id="UploadFile" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document" style="margin-top: 35px;">
			<div class="modal-content">
            	<div class="modal-header">
					<h4 class="" id="NewElement-modal-title">Upload File</h4>
					<button type="button" class="close waves-effect waves-light" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form enctype = "multipart/form-data" id="UploadFileForm">							
						<div class="form-row col-md-12">
			                 <!-- <div class="md-form">
			                     <div class="file-field">
			                         <div class="btn btn-primary btn-sm float-left">
			                             <span>Choose file</span>
			                            
			                             <input type="file"  name="file">
			                         </div>
			                         <div class="file-path-wrapper">
			                             <input class="file-path validate" type="text" placeholder="Upload your file" name="filename" id="filenameTextField">
			                         </div>
			                     </div>
			                 </div> -->
			                 <div class="form-group col-md-3">
			                  	<input type="hidden" id="fid" name="fid">
              					<label for="exampleFormControlFile1">Choose file</label>
             					<input type="file" name="file" class="form-control-file" id="exampleFormControlFile1">
                 			</div>	
			             </div>
						 <div class="col-md-12" style="float: left;">
							<center><button class="btn btn-rounded light-blue darken-3" type="submit" id="imgsnd">Upload</button>
							<button type="button" class="btn btn-outline-info waves-effect" data-dismiss="modal">Close</button></center>
						 </div>
					</form>
				</div>    
			</div>
		</div>
	</div>
</main>
<script type="text/javascript" src="../JavaScripts/Format.js"></script></body>
</html>