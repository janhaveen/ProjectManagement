<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="../img/TitleImage.png">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project</title>
<style type="text/css">
li{
	text-align: left;
}
</style>
</head>
<body class="fixed-sn white-skin">
<%@ include file="Header.jsp" %>
<main>
	<%-- <div class="container-fluid">
	    <section class="mt-lg-5">
	    	 <div class="card card-cascade narrower">
                 <div class="view gradient-card-header mdb-color amber darken-1">
                     <h5 class="mb-0 font-weight-bold">Project Details</h5>
                 </div>
                 <div class="card-body text-center">
                 	<div class="col-md-3">
                 	 <ul>
                 	 <li>Employee List</li>
                     <ul>
                     	<li><h5><a href="Employee/JSPs/Employee.jsp?t=s&id=<%=request.getParameter("id") %>">Stakeholder</a></h5></li>
                     	<li><h5><a href="Employee/JSPs/Employee.jsp?t=e&id=<%=request.getParameter("id") %>">Employee</a></h5></li>
                     </ul>
                      <li>Legend List</li>
                     <ul>
                     	<li><h5><a href="ProjectLegend/JSPs/ProjectLegend.jsp?t=dept&id=<%=request.getParameter("id") %>">Department</a></h5></li>
                     </ul>
                     </ul>
                     </div>
                 </div>
             </div>
	    </section>
	 </div> --%>
     <div class="container">
 		<div class="container-fluid">
	 		<div id="planofactionCard" class="card">
				<div class="card-body">
				<h5 class="card-title">Menu</h5><hr>
				<ul>
					<input type="hidden" id="pid" value="<%=request.getParameter("id")%>">
					<li><h6><a href="TopDown/JSPs/TopDown.jsp?id=<%=request.getParameter("id") %>">Top Down</a></h6></li>
					<li><h6><a href="ProjectEmployee/JSPs/ProjectEmployee.jsp?id=<%=request.getParameter("id") %>">Employee</a></h6></li>					
					<li><h6><a href="Interview/JSPs/Interview.jsp?id=<%=request.getParameter("id") %>">Interview</a></h6></li>
					<li><h6><a href="Process/JSPs/Process.jsp?id=<%=request.getParameter("id") %>">Process (SIPOC)</a></h6></li>
					<li><h6><a href="Operations/JSPs/Observations.jsp?id=<%=request.getParameter("id") %>">Opportunity Matrix</a></h6></li>
					<li><h6><a href="POA/JSPs/PlanOfAction.jsp?id=<%=request.getParameter("id") %>">Solution Matrix</a></h6></li>
					<li><h6><a href="ProjectTaskPOA/JSPs/Task.jsp?id=<%=request.getParameter("id") %>">Plan of Action</a></h6></li>
				</ul>
				</div>
			</div>
 		</div>
 	</div>
</main>
</body>
<script type="text/javascript">
$(document).ready(function() {
	$.ajax({
		url:"../../GetProjectList?projectid="+$("#pid").val(),
		type:"GET",
		success:function(data){
			$(".card-title").html(data.data[0].companyName);
		}
	});
});
</script>
</html>