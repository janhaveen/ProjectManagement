<%--
  Created by IntelliJ IDEA.
  User: consultantaadi
  Date: 20/06/18
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta http-equiv="x-ua-compatible" content="ie=edge">
	</head>
	<body>
    <%@include file="../../Header.jsp" %>	
	<main>
        <div class="container-fluid">
        <section class="mb-5">
        	<div class="card" id="tableDiv">
	        	<div class="card-body">
			        <%@include file="AuditList.jsp" %>
		        </div>
	        </div>
	        <div class="card card-cascade narrower HideThisElement" id="formDiv">
	        	<div class="view view-cascade gradient-card-header mdb-color amber darken-1">
                    <h5 class="mb-0 font-weight-bold">Audit Form</h5>
                </div>
	        	<div class="card-body">
			       <%@include file="AuditForm.jsp" %>
		   		</div>
		   </div>
	     </section>
	   </div>
	</main>
	</body>
	<script type="text/javascript" src="../JavaScripts/Audit.js"></script>
</html>