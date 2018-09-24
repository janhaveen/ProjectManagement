<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Top Down</title>
<link rel="shortcut icon" href="../../../img/TitleImage.png">
<style type="text/css">
.badge{
    font-size: 110%	!important;
    font-weight: 400	!important;
     margin: 2px	!important;

}
</style>
</head>
<body>
<%@include file="../../Header.jsp" %>
	<main>
	  <div class="container">
	     <div class="container-fluid">
	      	<div class="card" id="InterviewFormDiv">
    			<div class="card-body">
			     	<nav>
						  <div class="nav nav-tabs" id="nav-tab" role="tablist">
						    <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Topdown</a>
<!-- 						    <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">Topdown</a>
						    <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">Hierarchy</a>
 -->				  		  </div>
					</nav>
					<div class="tab-content" id="nav-tabContent">
					  	<div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
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
						<button class='btn-sm btn btn-primary' onclick='loadBlankformForFunction("");'><i class='fa fa-plus mr-1'></i> New Function</button>
						<button class='btn-sm btn btn-primary' id="addDept"><i class='fa fa-plus mr-1'></i> New Department</button><br>
   						<input type="hidden" id="ProjectId" value="<%=request.getParameter("id")%>">
   						<br>
   						<div id="mainDiv" class="row"></div>
					 	</div>
					 </div>
				</div>
			</div>
	     </div>
	  </div>
		
		<%-- <section>
			<div class="card">
				<div class="card-body">
				    <h4 class="card-title"><i class="fa fa-info mr-2" aria-hidden="true"></i> Top Down</h4><hr>
				    <div class="col-md-12">
						<div class="row">
							<input type="hidden" id="ProjectId" value="<%=request.getParameter("id")%>">
							<input type="hidden" id="warehouseId">
							<input type="hidden" id="FloorId">
						    <div  class="col-md-12 row">
						    <button class='btn btn-primary' id="addDept"><i class='fa fa-plus mr-1'></i> New Department</button>
						    </div>
						    <div id="mainDiv" class="col-md-12 row"></div>
						    <!-- <div class="col-md-1 card" style="margin: 1%;"><br>
						    	<div class="view view-cascade card-header mdb-color amber darken-1">
						    		<h5 class="center mb-0 font-weight-bold">sfvhsv</h5>
						    	</div>
						        <div class="tab-content vertical" id="FloorTab">
						        </div>
						    </div> -->
						    <!-- <div class="col-md-3 card" style="margin: 1%;">
						        <div class="tab-content vertical" id="AisleTab">
						        </div>
						    </div>
						    <div class="col-md-3 card" style="margin: 1%;">
						        <div class="tab-content vertical" id="RackTab">
						        </div>
						    </div> -->
						   <!--  <div class="col-md-2 card" style="margin: 1%;">
						        <div class="tab-content vertical" id="ShelfTab">
						        </div>
						    </div> -->
						</div>
					</div>
				</div>
			</div>
		</section> --%>
	</main>
	<%@include file="NewDepartment.jsp" %>
	<%@include file="NewFunction.jsp" %>
	<%@include file="DeleteFunction.jsp" %>
</body>
<script type="text/javascript" src="../JavaScripts/TopDown.js"></script>
<script type="text/javascript" src="../JavaScripts/Function.js"></script>
<script type="text/javascript" src="../JavaScripts/Department.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForProjectLegend.js"></script>
</html>