<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    
    <link rel="shortcut icon" href="http://propelway.com:8080/propel/img/TitleImage.png">
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
    <link rel="stylesheet" href="http://propelway.com:8080/propel/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://propelway.com:8080/propel/css/mdb.css">

    <link href="http://propelway.com:8080/propel/css/style.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="http://propelway.com:8080/propel/js/vendor/datatables/css/dataTables.bootstrap4.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/css/bootstrap-select.min.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.4.0/css/buttons.dataTables.min.css" />
    
    <style type="text/css">
    	.picker__box select {
			display: initial  !important;
		}
		.mandatory-element{
			color:red;
		}
    </style>
	<script type="text/javascript">
	    /* function setSession(data) {
	    	var url = "http://propelway.com:8080/propel/SalesSession";
	        $.ajax({
	               type: "POST",
	               url: url,
	               headers: {  'Access-Control-Allow-Origin': '*' },
	               data: "data="+data,
	               success: function(data)
	               {
	            	   $('#vertical').val('1');
	               }
	             });
	        return false;
	    } */
	    
	   /*  function hideFunctn() {
        	$('#centralModalSetSession').modal('hide');
	    } */
	    
	    function onloadBody() {
	    	  $.ajax({
	    		   url:"http://propelway.com:8080/propel/CheckIsLogged",
	    		   type:"GET",
	               headers: {  'Access-Control-Allow-Origin': '*' },
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
	               headers: {  'Access-Control-Allow-Origin': '*' },
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
</head>

<body class="fixed-sn white-skin" onload="onloadBody();">
<%-- <div id="loaderDiv"><%@include file="EnquiryLoader.jsp" %></div> --%>
<header id="mainHeader">
   		<%-- <input type="hidden" value="<%= session.getAttribute("Department") %>" id="deptId" class="HideThisElement">
   		<input type="hidden" value="<%= session.getAttribute("salesVertical") %>" id="vertical" class="HideThisElement">
		<input type="hidden" id="getDateForLMSExport" name="getDateForLMSExport" class="form-control datepicker HideThisElement" data-value="" disabled> --%>
        <ul id="slide-out" class="side-nav fixed sn-bg-1 custom-scrollbar">
            <li class="logo-sn waves-effect" style="padding-top: 0px;">
                <div class=" text-center">
                    <a href="http://propelway.com:8080/propel/JSPs/Support/JSPs/HomePage.jsp" class="pl-0"><img src="http://propelway.com:8080/propel/img/CompanyLogo.png" class="CompanyLogo" alt="Company Logo"></a>
                </div>
            </li>
            <li>
                <!-- <form class="search-form" role="search">
                    <div class="form-group waves-effect">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                </form> -->
            </li>
            <li>
                <!-- <ul class="collapsible collapsible-accordion">
                    <li id="" class=""><a class="collapsible-header waves-effect arrow-r"><i class="fas fa-cogs"></i>&nbsp&nbsp&nbsp Project<i class="fa fa-angle-down rotate-icon"></i></a>
                        <div class="collapsible-body">
                            <ul>
                                <li id="" class=""><a href="http://propelway.com:8080/propel/JSPs/Project/ProjectList.jsp" class="waves-effect">Projects</a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li id="" class=""><a class="collapsible-header waves-effect arrow-r"><i class="fas fa-cogs"></i>&nbsp&nbsp&nbsp Issues<i class="fa fa-angle-down rotate-icon"></i></a>
                        <div class="collapsible-body">
                            <ul>
                                <li id="" class=""><a href="http://propelway.com:8080/propel/JSPs/Issue/IssueList.jsp?type=allIssueList" class="waves-effect">All Issue</a>
                                </li>
                                <li id="" class=""><a href="http://propelway.com:8080/propel/JSPs/Issue/IssueList.jsp?type=allSupportList" class="waves-effect">All Support</a>
                                </li>
                                <li id="" class=""><a href="http://propelway.com:8080/propel/JSPs/Issue/IssueList.jsp?type=allRequestList" class="waves-effect">All Request</a>
                                </li>
                            </ul>
                        </div>
                    </li>
                </ul> -->
                <ul>
                    <li id="" class=""><a href="http://propelway.com:8080/propel/JSPs/Support/JSPs/Project/ProjectList.jsp" class="waves-effect">Projects</a>
                    </li>
                    <li id="" class=""><a href="http://propelway.com:8080/propel/JSPs/Support/JSPs/Issue/IssueList.jsp?type=allIssueList" class="waves-effect">All Issue</a>
                    </li>
                    <li id="" class=""><a href="http://propelway.com:8080/propel/JSPs/Support/JSPs/Issue/IssueList.jsp?type=allSupportList" class="waves-effect">All Support</a>
                    </li>
                    <li id="" class=""><a href="http://propelway.com:8080/propel/JSPs/Support/JSPs/Issue/IssueList.jsp?type=allRequestList" class="waves-effect">All Request</a>
                    </li>
                    <li id="" class=""><a href="http://propelway.com:8080/propel/JSPs/UserHome.jsp" class="waves-effect">Project Management</a>
                    </li>
                    <li id="" class=""><a href="http://propelway.com:8080/propel/JSPs/Task/JSPs/TaskHomePage.jsp" class="it waves-effect">Daily Activities</a>
					</li>
                </ul>
            </li>
            <div class="sidenav-bg mask-strong"></div>
        </ul>
        <nav class="navbar fixed-top navbar-toggleable-md navbar-expand-lg scrolling-navbar double-nav">
            <div class="float-left">
                <a href="#" data-activates="slide-out" class="button-collapse black-text"><i class="fa fa-bars"></i></a>
            </div>
            <div class="breadcrumb-dn mr-auto">
                <p id="pageTitle" class="increaseWeight"></p>
            </div>
            <ul class="nav navbar-nav nav-flex-icons ml-auto">
                <!-- <li class="nav-item dropdown">
               		<button type="button" class="btn btn-outline-primary btn-sm" id="swtchDept" class="HideThisElement">Switch Dept</button>
                </li> -->
                <!-- <li class="nav-item dropdown notifications-nav">
                    <a class="nav-link dropdown-toggle waves-effect" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
                        aria-expanded="false">
                        <span class="badge red">3</span> <i class="fa fa-bell"></i>
                        <span class="d-none d-md-inline-block">Notifications</span>
                    </a>
                    <div class="dropdown-menu dropdown-info" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="#">
                            <i class="fa fa-money mr-2" aria-hidden="true"></i>
                            <span>New order received</span>
                            <span class="float-right"><i class="fa fa-clock-o" aria-hidden="true"></i> 13 min</span>
                        </a>
                        <a class="dropdown-item" href="#">
                            <i class="fa fa-money mr-2" aria-hidden="true"></i>
                            <span>New order received</span>
                            <span class="float-right"><i class="fa fa-clock-o" aria-hidden="true"></i> 33 min</span>
                        </a>
                        <a class="dropdown-item" href="#">
                            <i class="fa fa-line-chart mr-2" aria-hidden="true"></i>
                            <span>Your campaign is about to end</span>
                            <span class="float-right"><i class="fa fa-clock-o" aria-hidden="true"></i> 53 min</span>
                        </a>
                    </div>
                </li> -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle waves-effect" href="#" id="userDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fa fa-user"></i> <span class="clearfix d-none d-sm-inline-block capitalizeText">${userName}</span></a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <input type="hidden" name="employeeId" id="employeeId" value="<%= session.getAttribute("userId") %>">
                        <a class="dropdown-item" href="http://propelway.com:8080/propel/LogOut">Log Out</a>
                    <a class="dropdown-item" href="http://propelway.com:8080/propel/JSPs/Employee/JSPs/ChangePassword.jsp">Change Password</a>
                    </div>
                </li>
            </ul>
        </nav>
    </header>
	
  
    <script src="http://propelway.com:8080/propel/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="http://propelway.com:8080/propel/js/popper.min.js"></script>
    <script type="text/javascript" src="http://propelway.com:8080/propel/js/bootstrap.js"></script>
    <script type="text/javascript" src="http://propelway.com:8080/propel/js/mdb.min.js"></script>
    
    <script type="text/javascript" src="http://propelway.com:8080/propel/js/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="http://propelway.com:8080/propel/js/vendor/datatables/js/dataTables.bootstrap4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.0/js/dataTables.buttons.min.js"></script>
    <!-- <script type="text/javascript" src="http://propelway.com:8080/propel/JavaScripts/Header.js"></script>
    <script type="text/javascript" src="http://propelway.com:8080/propel/JavaScripts/DataExport.js"></script>
    <script type="text/javascript" src="http://propelway.com:8080/propel/JavaScripts/CallingExport.js"></script> -->
    
    <script>
        $(".button-collapse").sideNav();

        var container = document.getElementById('slide-out');
        Ps.initialize(container, {
            wheelSpeed: 2,
            wheelPropagation: true,
            minScrollbarLength: 20
        });
	    
        function IDGenerator() {
     		 this.length = 8;
     		 this.timestamp = +new Date;
     		 
     		 var _getRandomInt = function( min, max ) {
     			return Math.floor( Math.random() * ( max - min + 1 ) ) + min;
     		 }
     		 
     		 this.generate = function() {
     			 var ts = this.timestamp.toString();
     			 var parts = ts.split( "" ).reverse();
     			 var id = "";
     			 
     			 for( var i = 0; i < this.length; ++i ) {
     				var index = _getRandomInt( 0, parts.length - 1 );
     				id += parts[index];	 
     			 }
     			 return id;
     		 }
		}
    </script>
</body>
</html>