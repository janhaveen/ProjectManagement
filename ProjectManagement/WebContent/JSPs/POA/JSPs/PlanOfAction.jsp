<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title> Plan Of Action</title>
    <link rel="shortcut icon" href="../../../img/TitleImage.png">
    
    <style type="text/css">
    .popover-body{
	    overflow-y: auto;
	    max-height: 100px;
    }
    </style>
    
</head>

<body class="fixed-sn white-skin">
    <%@ include file="../../Header.jsp" %>
    <% if(request.getParameter("id")==null){%>
    	<%// if(request.getParameter("id")==""){%>
	    	<style type="text/css">
	    		.IfNotProjectId{
	    			display: none	!important;
	    		}
	    	</style>
   	 	<%// }%>
   	  <%}else{%>   
   	  <%}%>
     <main>
          <div class="container">
	     		<div class="container-fluid">
		           	<input type="hidden" id="projectid" value="<%=request.getParameter("id")%>">   
		           	<input type="hidden" id="ProjectId" value="<%=request.getParameter("id")%>">         	
		           	<input type="hidden" id="statusId" >            	
		               <section>
		               		<%@include file="PlanOfActionList.jsp" %>
		               		<%@include file="PlanOfActionView.jsp" %>
		               		<%@include file="PlanOfActionForm.jsp" %>
		               		<%@include file="DeleteModel.jsp" %>
		               </section>
		         </div>
		   </div>
     </main>
</body>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>

<script type="text/javascript" src="../JavaScripts/PlanOfAction.js"></script>
<script type="text/javascript" src="../JavaScripts/PlanOfActionList.js"></script>
<!-- <script type="text/javascript" src="../../../js/General/DropDownForEvaluation.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForLegend.js"></script> -->
<script type="text/javascript" src="../../../js/General/DropDownForProjectEmployee.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForPOALegend.js"></script>
</html>