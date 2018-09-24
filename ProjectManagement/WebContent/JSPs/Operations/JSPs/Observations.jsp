<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Opportunity Matrix</title>
    <link rel="shortcut icon" href="../../../img/TitleImage.png">
</head>

<body class="fixed-sn white-skin">
    <%@ include file="../../Header.jsp" %>
     <main>
         <div class="container">
	     	<div class="container-fluid">
	           	<input type="hidden" id="projectid" value="<%=request.getParameter("id")%>">
	           	<input type="hidden" id="ProjectId" value="<%=request.getParameter("id")%>">
	           	<input type="hidden" id="d" value="<%=request.getParameter("d")%>">
	           	<input type="hidden" id="ObservationDeptId" name="ObservationDeptId">
	            <input type="hidden" id="Observationprocessid" name="Observationprocessid" value="<%=request.getParameter("processid")%>">            	
	               <section>
	               		<%@include file="ObservationList.jsp" %>
	               		<%@include file="ObservationView.jsp" %>
	               		<%@include file="ObservationForm.jsp" %>
	               		<%@include file="DeleteModel.jsp" %>
	               </section>
         	</div>
         </div>
     </main>
</body>
<script type="text/javascript" src="../JavaScripts/ObservationList.js"></script>
<script type="text/javascript" src="../JavaScripts/Observations.js"></script>
<script type="text/javascript" src="../JavaScripts/DeleteDetails.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForEvaluation.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForProjectLegend.js"></script>
</html>