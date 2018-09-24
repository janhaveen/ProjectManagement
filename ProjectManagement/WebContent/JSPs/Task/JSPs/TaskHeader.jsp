<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="shortcut icon" href="http://propelway.com:8080/propel/img/TitleImage.png">
		
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="http://propelway.com:8080/propel/js/popper.min.js"></script>
		<script type="text/javascript" src="http://propelway.com:8080/propel/js/bootstrap.js"></script>
		
		<link href="http://propelway.com:8080/propel/css/style.css" rel="stylesheet">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

	</head>
	<body>
		<nav class="navbar sticky-top navbar-expand-lg navbar-light bg-light" style="background-color: #e3f2fd !important;">
		<!-- <div class="row">
			<div class="col-md-2">
				<a href="http://propelway.com:8080/propel/HomePage.jsp" class="pl-0"><img src="http://propelway.com:8080/propel/img/CompanyLogo.png" class="CompanyLogo" alt="Company Logo"></a>
			</div>
		</div> -->
		  <!-- <a href="" class="pl-0"><img src="http://propelway.com:8080/propel/img/CompanyLogo.png" class="CompanyLogo" alt="Company Logo"></a> -->
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarNavDropdown">
		    <ul class="navbar-nav">
		      <li class="nav-item">
		        <a class="nav-link" href="http://propelway.com:8080/propel/JSPs/Task/JSPs/TaskHomePage.jsp">Home</a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="http://propelway.com:8080/propel/JSPs/UserHome.jsp">Project Management</a>
		      </li>
		      <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Task
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
		          <a class="dropdown-item" href="http://propelway.com:8080/propel/JSPs/Task/JSPs/Task.jsp">Task List</a>
		          <a class="dropdown-item" href="http://propelway.com:8080/propel/JSPs/Task/JSPs/Task.jsp?what=newTask">New Task</a>
		        </div>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="http://propelway.com:8080/propel/JSPs/Support/JSPs/HomePage.jsp">Support </a>
		      </li>
		      <li class="nav-item">
		        <a class="nav-link" href="http://propelway.com:8080/propel/LogOut">Log Out</a>
		      </li>
		      <!-- <li class="nav-item">
		        <a class="nav-link" href="#">Pricing</a>
		      </li> -->
		    </ul>
		  </div>
		</nav>
	
	    <script type="text/javascript">
			function onloadBody() {
				$.ajax({
					url:"http://propelway.com:8080/propel/CheckIsLogged",
					type:"GET",
					success:function(data){
						if(data.indexOf("0")>=0){
							 window.location.replace('http://propelway.com:8080/propel/LogOut');		
						}
					},
					error:function(data){
						if(data.indexOf("0")>=0){
							 window.location.replace('http://propelway.com:8080/propel/LogOut');		
						}
					}		
				}); 
			}
			setInterval(function(){
				$.ajax({
					url:"http://propelway.com:8080/propel/CheckIsLogged",
					type:"GET",
					success:function(data){
						console.log(data);
						if(data == 0){
							/* alert("In If"); */
							 window.location.replace('http://propelway.com:8080/propel/');
						}
						/* else if(data == 1)
						{
							alert("in else of suc");
						} */
					},
					error:function(data){
						 window.location.replace('http://propelway.com:8080/propel/');	
					}		
				}); 
			}, 3600001);
		</script>
		
	    	<script type="text/javascript">
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
