<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https:////code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://propelway.com:8080/propel/css/Bootstrap/Style.css">
   	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.js"></script>
   	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.min.js"></script>
   	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker.min.css">
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
    <script src="//cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" href="//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.5.2/css/buttons.dataTables.min.css">
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js"></script>
    <script type="text/javascript" src="http://propelway.com:8080/propel/js/General/IDGenerator.js"></script> 
    <style type="text/css">
       body, .form-control {
		    font-size: 90% !important;
		    height: auto !important; 
		}
		.alert p, .navbar p{
			margin-bottom: 0rem	!important; 
		}
		.collapse{
			margin-left: 13%;	
		}
		input[type=number]::-webkit-inner-spin-button, 
		input[type=number]::-webkit-outer-spin-button { 
		    -webkit-appearance: none;
		    -moz-appearance: none;
		    appearance: none;
		    margin: 0; 
		}
		.whiteText{
			color:white		!important; 
		}
		<%-- <%if(session.getAttribute("designationTxt")=="cpc"){%>
			.epc
		<%}%> --%>
    </style>
    <script type="text/javascript">
	function onloadBody() {
		$.ajax({
			url:"http://propelway.com:8080/propel/CheckIsLogged",
			type:"GET",
			success:function(data){ 
				if(data.indexOf("0")>=0){
					 window.location.replace('http://propelway.com:8080/propel/LogOut?page=timeout');		
				}
			},
			error:function(data){
				if(data.indexOf("0")>=0){
					 window.location.replace('http://propelway.com:8080/propel/LogOut?page=timeout');		
				}
			}		
		}); 
	}
	setInterval(function(){ 
		$.ajax({
			url:"http://propelway.com:8080/propel/CheckIsLogged",
			type:"GET",
			success:function(data){ 
				if(data.indexOf("0")>=0){
					 window.location.replace('http://propelway.com:8080/propel/LogOut?page=timeout');		
				}
			},
			error:function(data){
				if(data.indexOf("0")>=0){
					 window.location.replace('http://propelway.com:8080/propel/LogOut?page=timeout');		
				}
			}		
		}); 
	}, 3600001);
</script>
<% if(session.getAttribute("departmentTxt")!=null){ %>
	<% if(!session.getAttribute("departmentTxt").equals("Management") && !session.getAttribute("departmentTxt").equals("IT")){ %>
		<style type="text/css">
			.mg{
				display:none	!important;
			}
		</style>
	<% }if(!session.getAttribute("departmentTxt").equals("IT")){ %>
		<style type="text/css">
			.it{
				display:none	!important;
			}
		</style>
	<%} %>
<% } %>
</head>

<body  onload="onloadBody();">

<header>
    <div id="mySidenav" class="sidenav">
    	<input type="hidden" id="designationHeader" value="<%=session.getAttribute("designationTxt")%>"> 
    	<input type="hidden" id="departmentHeader" value="<%=session.getAttribute("departmentTxt")%>"> 
    	<input type="hidden" id="idForM" value="<%=request.getParameter("id")==null?"":request.getParameter("id")%>">       
			<!-- <a href="http://propelway.com:8080/propel/JSPs/UserHome.jsp" style="padding:  0px;margin-left: 6%;"><img style="width: 90%;margin-top: -5%;" src="http://propelway.com:8080/propel/img/CompanyLogo.png" class="CompanyLogo"></a> -->
			<div class="collapsible">
				<div id="generalMenu">
				<a href="http://propelway.com:8080/propel/JSPs/Admin/JSPs/Projects.jsp?p=4&v=m" class="cpc waves-effect">
					<i class="fas fa-angle-right"></i>
					My Projects
				</a>
				<a href="http://propelway.com:8080/propel/JSPs/Admin/JSPs/Projects.jsp?p=4&v=t" class="epc waves-effect">
					<i class="fas fa-angle-right"></i>
					Team Projects
				</a>
				<!-- <a href="http://propelway.com:8080/propel/JSPs/POA/JSPs/PlanOfAction.jsp?p=1&v=m" class="cpc waves-effect">
					<i class="fas fa-angle-right"></i>
					My POA
				</a>
				<a href="http://propelway.com:8080/propel/JSPs/POA/JSPs/PlanOfAction.jsp?p=1&v=t" class="epc waves-effect">
					<i class="fas fa-angle-right"></i>
					Team POA
				</a> -->
				<a href="http://propelway.com:8080/propel/JSPs/ProjectTaskPOA/JSPs/Task.jsp?p=1&v=m" class="cpc waves-effect">
					<i class="fas fa-angle-right"></i>
					My POA
				</a>
				<a href="http://propelway.com:8080/propel/JSPs/ProjectTaskPOA/JSPs/Task.jsp?p=1&v=t" class="epc waves-effect">
					<i class="fas fa-angle-right"></i>
					Team POA
				</a>
				<a href="http://propelway.com:8080/propel/JSPs/Admin/JSPs/Projects.jsp?p=4" class="mg waves-effect">
					<i class="fas fa-angle-right"></i>
					All Projects
				</a>
				<!-- <a href="http://propelway.com:8080/propel/JSPs/POA/JSPs/PlanOfAction.jsp" class="mg waves-effect">
					<i class="fas fa-angle-right"></i>
					All POA
				</a> -->
				<a href="http://propelway.com:8080/propel/JSPs/ProjectTaskPOA/JSPs/Task.jsp" class="mg waves-effect">
					<i class="fas fa-angle-right"></i>
					All POA
				</a>
				<a href="http://propelway.com:8080/propel/JSPs/Employee/JSPs/Employee.jsp" class="mg waves-effect">
					<i class="fas fa-angle-right"></i>
					Employee
				</a>
				<a href="http://propelway.com:8080/propel/JSPs/Support/JSPs/HomePage.jsp" class="it waves-effect">
					<i class="fas fa-angle-right"></i>
					Support
				</a>
				<a href="http://propelway.com:8080/propel/JSPs/Task/JSPs/TaskHomePage.jsp" class="it waves-effect">
					<i class="fas fa-angle-right"></i>
					Daily Activities
				</a>
				<!-- <a href="http://propelway.com:8080/propel/LMS/JSPs/UserHome.jsp" class="mg waves-effect">
					<i class="fas fa-angle-right"></i>
					LMS
				</a> -->
				</div>
				<div id="ProjectMenu" class="HideThisElement">
					<a href="http://propelway.com:8080/propel/JSPs/TopDown/JSPs/TopDown.jsp?id=<%=request.getParameter("id") %>" class="waves-effect">
						<i class="fas fa-arrows-alt-v"></i>&nbsp;&nbsp;&nbsp;
						Top Down
					</a>
					<a href="http://propelway.com:8080/propel/JSPs/ProjectEmployee/JSPs/ProjectEmployee.jsp?id=<%=request.getParameter("id") %>" class=" waves-effect">
						<i class="fas fa-user"></i>&nbsp;&nbsp;
						Employee
					</a>
					<a href="http://propelway.com:8080/propel/JSPs/Interview/JSPs/Interview.jsp?id=<%=request.getParameter("id") %>" class=" waves-effect">
						<i class="fas fa-calendar-alt"></i>&nbsp;&nbsp;
						Interview
					</a>
					<a href="http://propelway.com:8080/propel/JSPs/Process/JSPs/Process.jsp?id=<%=request.getParameter("id") %>" class=" waves-effect">
						<i class="fas fa-spinner"></i>&nbsp;&nbsp;
						Process
					</a>
					<a href="http://propelway.com:8080/propel/JSPs/Operations/JSPs/Observations.jsp?id=<%=request.getParameter("id") %>" class=" waves-effect">
						<i class="fas fa-eye"></i>&nbsp;
						Opportunity Matrix
					</a>
					<a href="http://propelway.com:8080/propel/JSPs/POA/JSPs/PlanOfAction.jsp?id=<%=request.getParameter("id") %>" class=" waves-effect">
						<i class="fas fa-tasks"></i>&nbsp;&nbsp;
						Solution Matrix
					</a>
					<a href="http://propelway.com:8080/propel/JSPs/ProjectTaskPOA/JSPs/Task.jsp?id=<%=request.getParameter("id") %>" class=" waves-effect">
						<i class="fas fa-list-alt"></i>&nbsp;&nbsp;
						Plan of Action
					</a>
				</div>
			</div>
    </div>
    <nav class="navbar navbar-expand-sm navbar-dark sticky-top">
        <div class="float-left">
            <p style="cursor:pointer" onclick="openNav()"><i class="fa fa-bars" style="margin-right: 10px;font-size: 120%;"></i><a href="http://propelway.com:8080/propel/JSPs/UserHome.jsp" title="Home" data-toggle="tooltip"><i class="fa fa-home" style="margin-right: 10px;font-size: 120%;"></i></a> </p>
        </div>
        <!-- Breadcrumb-->
        <div class="breadcrumb-dn mr-auto">
            <p id="HomeText" style="font-size: 120%;font-weight: 500;"> Home</p>
        </div>

        <ul class="navbar-nav">
            <li class="nav-item">
                <a style="font-size: 120% !important; color:  white;" class="nav-link dropdown-toggle waves-effect" href="#" id="userDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fa fa-user"></i> <span class="clearfix d-none d-sm-inline-block" style="font-size:15px;"><%=session.getAttribute("userName") %></span>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown" style="margin-right: 1%;">
                    <a class="dropdown-item" href="http://propelway.com:8080/propel/LogOut">Log Out</a>
                    <a class="dropdown-item" href="http://propelway.com:8080/propel/JSPs/Employee/JSPs/ChangePassword.jsp">Change Password</a>
                </div>
            </li>
            <li class="nav-item">

            </li>
        </ul>
    </nav>
    <br>
    </header>
</body>
<script type="text/javascript">
function openNav() {
	if(!$("#mySidenav").hasClass("viewDiv")){
	    document.getElementById("mySidenav").style.width = "230px";
	    $("#mySidenav").addClass("viewDiv");
	}else{
		document.getElementById("mySidenav").style.width = "0px";
		$("#mySidenav").removeClass("viewDiv");
	}
}

/* function closeNav() {
    document.getElementById("mySidenav").style.width = "0px";
} */
$( function() {
	if($("#idForM").val()!=""){
		$("#generalMenu").addClass('HideThisElement');
		$("#ProjectMenu").removeClass('HideThisElement');
	}else {
		$("#ProjectMenu").addClass('HideThisElement');
		$("#generalMenu").removeClass('HideThisElement');
	}
	
	if($("#designationHeader").val().indexOf("CPC")>=0){
		$(".epc").addClass('HideThisElement');
		$(".mg").addClass('HideThisElement');
	}else if($("#designationHeader").val().indexOf("EPC")>=0){
		//$(".epc").addClass('HideThisElement');
		$(".mg").addClass('HideThisElement');
	}else {
		$(".epc").addClass('HideThisElement');
		$(".cpc").addClass('HideThisElement');
	}
	
   $( ".datepicker" ).datepicker({
	   format: "dd MM, yyyy"
   });
   
   $('body').on('click', function (e) { console.log($(e.target).attr('class'));
	    //did not click a popover toggle or popover
	    if ($(e.target).data('toggle') !== 'popover'
	        && $(e.target).parents('.popover.in').length === 0) { 
	        $('[data-toggle="popover"]').popover('hide');
	    }
	    /* if(!$(e.target).attr('class')=="fa fa-bars"){
	    	openNav();
	    } */
	    
	});
   $('.container').on('click', function (e) { 
	   if($("#mySidenav").hasClass("viewDiv")){
		   document.getElementById("mySidenav").style.width = "0px";
			$("#mySidenav").removeClass("viewDiv");
		}
	});
 });
</script>
<script type="text/javascript" src="http://propelway.com:8080/propel/js/TextArea/nicEdit-latest.js"></script> 
<script type="text/javascript">
//<![CDATA[
	console.log();
      bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
//]]>
</script>
</html>