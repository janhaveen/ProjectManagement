<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Interview</title>
    <link rel="shortcut icon" href="../../../img/TitleImage.png">
    <style type="text/css">
    #PrEmpTableDiv .dt-button, .newProcessbtn{
    	display: none	!important;
    }
    </style>
</head>
<body>
    <%@include file="../../Header.jsp" %>
	 <main>
	  <div class="container">
	     <div class="container-fluid">
	       	<input type="hidden" id="projectid" name="ProjectId" value="<%=request.getParameter("id")%>"> 
	       	<input type="hidden" id="ProjectId"  value="<%=request.getParameter("id")%>">            	
	       	<input type="hidden" id="t" value="<%=request.getParameter("p")%>">  
	    	 <%@include file="InterviewList.jsp" %>
	    	 <%@include file="InterviewView.jsp" %>
	      	 <%@include file="InterviewForm.jsp" %>
	     </div>
	   </div>
	 </main>
	 <%@include file="../../Operations/JSPs/DeleteModel.jsp" %>
</body>
<script type="text/javascript" src="../JavaScripts/InterviewList.js"></script>
<script type="text/javascript" src="../../ProjectEmployee/JavaScripts/ProjectEmployeeList.js"></script>
<script type="text/javascript" src="../../ProjectEmployee/JavaScripts/ProjectEmployee.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForProjectLegend.js"></script>
<script type="text/javascript" src="../../../js/General/DropDownForEvaluation.js"></script>
<script type="text/javascript" src="../JavaScripts/Interview.js"></script>
<script type="text/javascript" src="../../Process/JavaScripts/ProcessList.js"></script>
<script type="text/javascript" src="../JavaScripts/Audit.js"></script>
<script type="text/javascript" src="../JavaScripts/With.js"></script>
<script type="text/javascript" src="../JavaScripts/How.js"></script>
</html>