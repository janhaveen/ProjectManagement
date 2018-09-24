<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Process</title>
    <link rel="shortcut icon" href="../../../img/TitleImage.png">
    <style type="text/css">
    .viewOn1{
    	display: none	!important;
    }
    
    </style>
</head>

<body>
    <%@ include file="../../Header.jsp" %>
     <main>
	  <div class="container">
	     <div class="container-fluid">
           	<input type="hidden" id="projectid" name="ProjectId" value="<%=request.getParameter("id")%>"> 
           	<input type="hidden" id="ProjectId"  value="<%=request.getParameter("id")%>">  
            
          <!--  	<input type="hidden" id="department" >            	 -->           	        
           	<input type="hidden" id="interviewId" name="InterviewId" value="<%=request.getParameter("iId")%>">            	
               <section>
               		<div id="ProcessCard" class="card">
						<div class="card-body">
							<!-- <h5 class="card-title">Process List</h5><hr> -->
					    	<div class="alert alert-success alert-dismissible fade show HideThisElement successMsg" role="alert">
							 <p id="successMsg"></p>
							  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
							    <span aria-hidden="true">&times;</span>
							  </button>
							</div>
							<div class="alert alert-danger alert-dismissible fade show HideThisElement errorMsg" role="alert">
							 <p id="errorMsg"></p>
							  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
							    <span aria-hidden="true">&times;</span>
							  </button>
							</div>
               				<%@include file="ProcessList.jsp" %>
					 	</div>
					</div>	
              		<%@include file="ProcessView.jsp" %>
               		<!-- <div class="row HideThisElement" id="EditProcessFormDiv">
					   <div class="col-md-12">
				        Card
				        <div id="formCard" class="card card-cascade narrower ">
				            Card image
				            <div class="view gradient-card-header mdb-color amber darken-1">
				                <h5 class="mb-0 font-weight-bold">Process Form</h5>
				            </div>
				            /Card image
				            Card content
				            <div class="card-body text-center"> -->
				           		 <%@include file="EditProcessForm.jsp" %>
				          <!--   </div>
				        </div>
				       	</div>
				      </div> -->
               </section>
              <%--  <div class="modal fade" id="processFormModal" tabindex="-1" role="dialog" aria-labelledby="processFormLabel" aria-hidden="true">
				   <div class="modal-dialog modal-fluid modal-notify modal-warning" role="document">
				       <div class="modal-content">
				           <div class="modal-header">
				               <h5 class="modal-title white-text w-100 font-weight-bold" id="exampleModalLabel">Modal title</h5>
				               <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				                   <span aria-hidden="true" class="white-text">&times;</span>
				               </button>
				           </div>
				           <div class="modal-body">
				           	<%@include file="ProcessForm.jsp" %>
				            </div>
				            <div class="modal-footer">
				                <button type="button" class="btn btn-outline-warning waves-effect" data-dismiss="modal">Close</button>
				                <!-- <button type="button" class="btn btn-warning waves-effect">Save changes</button> -->
				            </div>
				        </div>
				    </div>
				</div> --%>
         </div>
         </div>
     </main>
     <%@include file="DeleteProcess.jsp" %>
</body>
<script type="text/javascript" src="../JavaScripts/ProcessList.js"></script>
<script type="text/javascript" src="../JavaScripts/Process.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForProjectLegend.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	getProcesslist();
});
</script>
</html>