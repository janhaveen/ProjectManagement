<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="card HideThisElement" id="POAViewDiv">
    <div class="card-body">
    	<div class="row">
    		<div class="col-md-6">
    			<h5 class="card-title row">
    				<i class="fas fa-arrow-circle-left" style="margin: 0px 8px;"  id="SubmitButtonBackFromView"></i> 
    				<p id="poHead">Solution Matrix DEtails</p>
    			</h5>
    		</div>
    		<div class="col-md-6 right row" id="O1">
	    		<div class="col-md-5">
	    			<u><a id="editClick" href="#">Edit</a></u>
	    		</div>
	    		<div class="col-md-7">
	    			<div id="statusInfoDiv" class="row"><span id="statusDivView"></span></div>
	    		</div>
    		</div>
    	</div>
    	<hr>
    	<!-- <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item">
                <a class="nav-link active" id="POADetails-tab" data-toggle="tab" href="#POADetails" role="tab" aria-controls="POADetails" aria-selected="true">POA Details</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="Comments-tab" data-toggle="tab" href="#CommentsDetails" role="tab" aria-controls="CommentsDetails" aria-selected="true">Comments</a>
            </li>
        </ul> -->
      <!--   <div class="tab-content" id="myTabContent">
			  <div class="tab-pane fade show active" id="POADetails" role="tabpanel" aria-labelledby="POADetails-tab">...</div>
			  <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">...</div>
		<!-- </div> -->
        <!-- <div class="tab-content" id="myTabContent">
        	<div class="tab-pane fade show active" id="POADetails" role="tabpanel" aria-labelledby="POADetails-tab"> -->
		    	<dl class="row"> 
				  <dt class="col-sm-2">Challenges</dt>
				  <dd class="col-sm-10" id="challengesText">Firstname</dd>
				  <dt class="col-sm-2">Solution Matrix</dt>
				  <dd class="col-sm-10" id="planofactionText">Lastname</dt>
				  <dt class="col-sm-2">Responsible</dt>
				  <dd class="col-sm-4" id="ResponsibleText">Janhavee Narkar</dd>
				  <dt class="col-sm-2">Accountable</dt>
				  <dd class="col-sm-4" id="AccountableText">Aditya Pansare</dd>
				  <dt class="col-sm-2">Consulted</dt>
				  <dd class="col-sm-4" id="ConsultedText">Abhishek Todkar</dd>
				  <dt class="col-sm-2">Informed</dt>
				  <dd class="col-sm-4" id="InformedText">Aditya Pansare</dd>
				  <dt class="col-sm-2">Priority</dt>
				  <dd class="col-sm-4" id="PriorityVText">Department</dd>
				  <dt class="col-sm-2">Exp Date Of Closure</dt>	
				  <dd class="col-sm-4" id="ExpText">Department</dd>	 
				  <dt class="col-sm-2">Remarks</dt>
				  <dd class="col-sm-10"  id="CommentsVText">Firstname</dd>
				</dl>
			<!--</div>
			 <div class="tab-pane fade" id="CommentsDetails" role="tabpanel" aria-labelledby="CommentsDetails-tab">
				<div id="remarksDiv"></div>
			</div> 
		</div>
    </div>-->
    <hr>
    <button type="button" id="AddComment" class="btn btn-sm btn-primary">Add comment</button><hr>
    <div id="commDiv" class="HideThisElement">
    	<label id="commentsLbl" for="comments" class="">Comments</label>	
        <textarea type="text" rows="4" class="md-textarea form-control" id="newcomments" name="comments" style="height: 4rem;overflow-y: auto;"></textarea><br>
        <input type="button" id="SubmitButtonRegisterComments" value="Save" class="btn btn-info btn-rounded">
        <input type="button" id="SubmitButtonCancelComments" value="Cancel" class="btn btn-info-outline btn-rounded"><hr>
    </div>
    <div id="remarksDiv"></div>
    
</div>
</div>
</body>
</html>