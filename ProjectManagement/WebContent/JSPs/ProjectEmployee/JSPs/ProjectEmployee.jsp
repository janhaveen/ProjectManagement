<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Project Employee</title>
    <link rel="shortcut icon" href="../../../img/TitleImage.png">
</head>
<body>
<%@include file="../../Header.jsp" %>
	<div class="container">
		<div class="container-fluid">
			<input type="hidden" id="projectid" name="ProjectId" value="<%=request.getParameter("id")%>">   
			<input type="hidden" id="ProjectId" value="<%=request.getParameter("id")%>">            			
			<%@include file="ProjectEmployeeList.jsp" %>
			<%@include file="ProjectEmployeeView.jsp" %>
			<div class="card HideThisElement" id="PrEmpFormDiv">
    			<div class="card-body">
					<%@include file="ProjectEmployeeForm.jsp" %>
				</div>
			</div>
			<%@include file="DeleteProjectEmployee.jsp" %>
		</div>
	</div>
</body>
<script type="text/javascript" src="../JavaScripts/ProjectEmployee.js"></script>
<script type="text/javascript" src="../JavaScripts/ProjectEmployeeList.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForProjectLegend.js"></script>
</html>