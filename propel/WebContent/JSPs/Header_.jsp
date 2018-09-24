<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
	
	
	<!-- Font Awesome -->
    <link href="http://localhost:8081/propel/css/fontawesome-all.css" rel="stylesheet">
    <!-- Bootstrap core CSS -->
    <link href="http://localhost:8081/propel/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="http://localhost:8081/propel/css/mdb.min.css" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link href="http://localhost:8081/propel/css/style.css" rel="stylesheet">
	
	<link rel="stylesheet" href="http://localhost:8081/propel/js/vendor/datatables/css/buttons.dataTables.min.css">
	<link rel="stylesheet" href="http://localhost:8081/propel/js/vendor/datatables/css/dataTables.bootstrap4.min.css">
	
    <!-- Your custom styles (optional) -->
    <link rel="shortcut icon" href="http://localhost:8081/propel/img/TitleImage.png">
    <style>
        th,.center{
        	text-align: center	!important 	;
        }
        .HideThisElement{
        	display: none	!important;
        }
        #HomeText{
        	font-weight: 600;
        }
        .warningImage {
		    width: 80pt;
		}
		.modal-dialog.modal-notify.modal-danger .btn-outline-secondary-modal {
		    border: 2px solid #cc4141;
		    color: #cc4141 !important;
		    background-color: transparent;
		}
		.right{
			text-align: right	!important 	;
		}
		.left{
			text-align: left	!important 	;
		}
		.pull-right{ 
			float: right;
		}
		.blckcolor{
			color: #000000 !important 	;
		}
    </style>
<script type="text/javascript">
	function onloadBody() {
		$.ajax({
			url:"http://localhost:8081/propel/CheckIsLogged",
			type:"GET",
			success:function(data){ 
				if(data.indexOf("0")>=0){
					 window.location.replace('http://localhost:8081/propel/LogOut?page=timeout');		
				}
			},
			error:function(data){
				if(data.indexOf("0")>=0){
					 window.location.replace('http://localhost:8081/propel/LogOut?page=timeout');		
				}
			}		
		}); 
	}
	setInterval(function(){ 
		$.ajax({
			url:"http://localhost:8081/propel/CheckIsLogged",
			type:"GET",
			success:function(data){ 
				if(data.indexOf("0")>=0){
					 window.location.replace('http://localhost:8081/propel/LogOut?page=timeout');		
				}
			},
			error:function(data){
				if(data.indexOf("0")>=0){
					 window.location.replace('http://localhost:8081/propel/LogOut?page=timeout');		
				}
			}		
		}); 
	}, 3600001);
</script>	
</head>
<body class="fixed-sn white-skin" onload="onloadBody();">

    <!--Main Navigation-->
    <header>

        <!-- Sidebar navigation -->
        <div id="slide-out" class="side-nav sn-bg-4 fixed">
            <ul class="custom-scrollbar">
            <!-- Logo -->
            <li class="logo-sn waves-effect">
                <div class="text-center">
                    <a href="http://localhost:8081/propel/JSPs/UserHome.jsp" class="pl-0"><img src="http://localhost:8081/propel/img/CompanyLogo.png" class="CompanyLogo"></a>
                </div>
            </li>
            <!--/. Logo -->

            <!--Search Form-->
            <li>
                <form class="search-form" role="search">
                    <div class="form-group md-form mt-0 pt-1 waves-light">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                </form>
            </li>
            <!--/.Search Form-->
            <!-- Side navigation links -->
            <li>
            	<ul class="collapsible collapsible-accordion">
            		<li id="100001"><a class="collapsible-header waves-effect arrow-r"><i class="fa fa-cogs"></i> Operations <i class="fa fa-angle-down rotate-icon"></i></a>
                        <div class="collapsible-body">
                            <ul>
                                <li id="100002"><a href="http://localhost:8081/propel/JSPs/Admin/JSPs/Projects.jsp?p=1" class="waves-effect">Project</a>
                                </li><!-- 
                                <li id="100003"><a href="http://localhost:8081/propel/JSPs/Interview/JSPs/interview.jsp" class="waves-effect">Evaluation</a>
                                </li> -->
                            </ul>
                        </div>
                    </li>
                    <li id="100001"><a class="collapsible-header waves-effect arrow-r"><i class="fa fa-star"></i> Evaluation <i class="fa fa-angle-down rotate-icon"></i></a>
                      	<div class="collapsible-body">
                      		<ul>
                      			<li id="100003"><a href="http://localhost:8081/propel/JSPs/Admin/JSPs/Projects.jsp?p=2" class="waves-effect">Interview</a>
                                </li>
                                <li id="100003"><a href="http://localhost:8081/propel/JSPs/Interview/JSPs/Interview.jsp?p=1" class="waves-effect">Process</a>
                                </li>
                                <li id="100003"><a href="http://localhost:8081/propel/JSPs/Interview/JSPs/Format.jsp" class="waves-effect">Format</a>
                                </li>
                      		</ul>
                    	</div>
                    </li>
                    <li id="100001"><a class="collapsible-header waves-effect arrow-r"><i class="fa fa-eye"></i> Observations <i class="fa fa-angle-down rotate-icon"></i></a>
                      	<div class="collapsible-body">
                      		<ul id="ObservationsDivH">
                      			<li id="100003"><a href="http://localhost:8081/propel/JSPs/Operations/JSPs/Observations.jsp" class="waves-effect">Observations</a>
                                </li>
                                <li id="100003"><a href="http://localhost:8081/propel/JSPs/Interview/JSPs/Process.jsp?p=2" class="waves-effect">Process wise Observations</a>
                                </li>
                                <li id="100003"><a href="http://localhost:8081/propel/JSPs/Admin/JSPs/Projects.jsp?p=3" class="waves-effect">Project wise Observations</a>
                                </li>
                                <li id="100003"><a href="http://localhost:8081/propel/JSPs/Operations/JSPs/Observations.jsp?d=y" class="waves-effect">Department wise Observations</a>
                                </li>
                      		</ul>
                    	</div>
                    </li>
                    <li id="100001"><a class="collapsible-header waves-effect arrow-r"><i class="fa fa-tasks"></i> Plan Of Action <i class="fa fa-angle-down rotate-icon"></i></a>
                      	<div class="collapsible-body">
                      		<ul id="ObservationsDivH">
                      			<li id="100003"><a href="http://localhost:8081/propel/JSPs/POA/JSPs/PlanOfAction.jsp" class="waves-effect">Plan Of Action</a>
                                </li>
                      		</ul>
                    	</div>
                    </li>
                    <li id="100001"><a class="collapsible-header waves-effect arrow-r"><i class="fas fa-arrows-alt-v" style="margin-right: 18px;"></i> Top Down <i class="fa fa-angle-down rotate-icon"></i></a>
                      	<div class="collapsible-body">
                      		<ul id="ObservationsDivH">
                      			<li id="100003"><a href="http://localhost:8081/propel/JSPs/Admin/JSPs/Projects.jsp?p=4" class="waves-effect">Top Down</a>
                                </li>
                      		</ul>
                    	</div>
                    </li>
            	</ul>
            </li>
            <!--/. Side navigation links -->
            </ul>
            <div class="sidenav-bg mask-strong"></div>
        </div>
        <!--/. Sidebar navigation -->

        <!-- Navbar -->
        <nav class="navbar fixed-top navbar-expand-lg scrolling-navbar double-nav">
            <!-- SideNav slide-out button -->
            <div class="float-left">
                <a href="#" data-activates="slide-out" class="button-collapse black-text"><i class="fa fa-bars"></i></a>
            </div>
            <!-- Breadcrumb-->
            <div class="breadcrumb-dn mr-auto">
                <p id="HomeText">Dashboard v.1</p>
            </div>

            <!--Navbar links-->
            <ul class="nav navbar-nav nav-flex-icons ml-auto">

                <!-- Dropdown -->
               <!--  <li class="nav-item dropdown notifications-nav">
                    <a class="nav-link dropdown-toggle waves-effect" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
                        aria-expanded="false">
                        <span class="badge red">3</span> <i class="fa fa-bell"></i>
                        <span class="d-none d-md-inline-block">Notifications</span>
                    </a>
                    <div class="dropdown-menu dropdown-info" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="#">
                            <i class="fa far fa-money-bill-alt mr-2" aria-hidden="true"></i>
                            <span>New order received</span>
                            <span class="float-right"><i class="fa far fa-clock" aria-hidden="true"></i> 13 min</span>
                        </a>
                        <a class="dropdown-item" href="#">
                            <i class="fa far fa-money-bill-alt mr-2" aria-hidden="true"></i>
                            <span>New order received</span>
                            <span class="float-right"><i class="fa far fa-clock" aria-hidden="true"></i> 33 min</span>
                        </a>
                        <a class="dropdown-item" href="#">
                            <i class="fa far fa-chart-line mr-2" aria-hidden="true"></i>
                            <span>Your campaign is about to end</span>
                            <span class="float-right"><i class="fa far fa-clock" aria-hidden="true"></i> 53 min</span>
                        </a>
                    </div>
                </li> -->
                <!-- <li class="nav-item">
                    <a class="nav-link waves-effect"><i class="fa fa-envelope"></i> <span class="clearfix d-none d-sm-inline-block">Contact</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link waves-effect"><i class="fa far fa-comments"></i> <span class="clearfix d-none d-sm-inline-block">Support</span></a>
                </li> -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle waves-effect" href="#" id="userDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fa fa-user"></i> <span class="clearfix d-none d-sm-inline-block"><%=session.getAttribute("userName") %></span></a>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="http://localhost:8082/propel/LogOut">Log Out</a>
                        <a class="dropdown-item" href="#">My account</a>
                    </div>
                </li>

            </ul>
            <!--/Navbar links-->
        </nav>
        <!-- /.Navbar -->

        <!-- Fixed button -->
        <div class="fixed-action-btn clearfix d-none d-xl-block" style="bottom: 45px; right: 24px;">
            <a class="btn-floating btn-lg red">
                <i class="fa fa-pencil"></i>
            </a>

            <ul class="list-unstyled">
                <li><a class="btn-floating red"><i class="fa fa-star"></i></a></li>
                <li><a class="btn-floating yellow darken-1"><i class="fa fa-user"></i></a></li>
                <li><a class="btn-floating green"><i class="fa fa-envelope"></i></a></li>
                <li><a class="btn-floating blue"><i class="fa fa-shopping-cart"></i></a></li>
            </ul>
        </div>
        <!-- Fixed button -->

    </header>
    <!--Main Navigation-->

	<!-- SCRIPTS -->
    <!-- JQuery -->
    <script src="http://localhost:8081/propel/js/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="http://localhost:8081/propel/js/popper.min.js"></script>
    <script type="text/javascript" src="http://localhost:8081/propel/js/General/IDGenerator.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="http://localhost:8081/propel/js/bootstrap.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="http://localhost:8081/propel/js/mdb.min.js"></script>
    
    <script type="text/javascript" src="http://localhost:8081/propel/js/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="http://localhost:8081/propel/js/vendor/datatables/js/dataTables.bootstrap4.min.js"></script>
	<script type="text/javascript" src="http://localhost:8081/propel/js/vendor/datatables/js/dataTables.buttons.min.js"></script>
    
    <!--Initializations-->
    <script>
    	/* $(document).ready(function(){
    		$.ajax({
    			url:"http://localhost:8081/propel/GetLegendList",
    			type:"GET",
    			success:function(Data){
    				var str="";
	   				 for (i = 0; i < Data.data.length; i++){
	   			        if (Data.data[i].subCategory == "Department") {
	   						str+='<li id="100003"><a href="http://localhost:8081/propel/JSPs/Operations/JSPs/Observations.jsp?deptid='+Data.data[i].rowId+'" class="waves-effect">'+Data.data[i].description+' Observations</a></li>';
	   			        }
	   				 }
					document.querySelector('#ObservationsDivH').insertAdjacentHTML('beforeend', str);
    			}
    		});
    	}); */
        // SideNav Initialization
        $(".button-collapse").sideNav();

        var container = document.querySelector('.custom-scrollbar');
        Ps.initialize(container, {
            wheelSpeed: 2,
            wheelPropagation: true,
            minScrollbarLength: 20
        });

        // Data Picker Initialization
        $('.datepicker').pickadate();

        // Material Select Initialization
        $(document).ready(function () {
            $('.mdb-select').material_select();
        });

        // Tooltips Initialization
        $(function () {
            $('[data-toggle="tooltip"]').tooltip()
        })
    </script>
</body>
</html>