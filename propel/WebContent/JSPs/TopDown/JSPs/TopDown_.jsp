<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location</title>
<link rel="shortcut icon" href="../../../img/TitleImage.png">
</head>
<body>
<%@include file="../../Header.jsp" %>
	<main>
		<section>
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
		</section>
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