<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    
    <title>Home</title>
    
    <link rel="shortcut icon" href="img/TitleImage.png">
    
	<script type="text/javascript">
		function clickFunction(type)
		{
			window.location.href = '../JSPs/Issue/IssueList.jsp?type='+type;
		}
	</script>
</head>

<body class="fixed-sn white-skin">
	<%@ include file="SupportHeader.jsp" %>
    <main>
        <div class="container-fluid mb-5">
		  	<section id="issueListCard" class="">
		  		<div class="row">
		              <div class="col-lg-4 col-md-12 mb-4">
		                  <div class="card">
		                      <div class="card-header white-text warning-color" style="background-color: #fb3!important;">
		                          Support
		                      </div>
		                      <div class="card-body pt-0 px-1">
		                          <div class="card-body text-center">
		                              <div class="list-group list-panel">
		                                  <a onClick="clickFunction('support')" class="list-group-item d-flex justify-content-between dark-grey-text"><span style="font-weight: bold;margin-right: 10px" id="totalSupport">0</span> Number Of Support<i class="fa fa-eye ml-auto" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
		                              </div>
		                          </div>
		                      </div>
		                  </div>
		              </div>
		              
		              <div class="col-lg-4 col-md-6 mb-4">
		                  <!--Panel-->
		                  <div class="card">
		                      <div class="card-header white-text warning-color" style="background-color: #fb3!important;">
		                          Requests
		                      </div>
		                      <div class="card-body pt-0 px-1">
		                          <div class="card-body text-center">
		                              <div class="list-group list-panel">
		                                  <a onClick="clickFunction('pendingRequest')" class="list-group-item d-flex justify-content-between dark-grey-text"><span style="font-weight: bold;margin-right: 10px" id="pendingRequestCount">0 </span> Pending<i class="fa fa-eye ml-auto" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
		                                  <a onClick="clickFunction('inProcessRequest')" class="list-group-item d-flex justify-content-between red-text"><span style="font-weight: bold;margin-right: 10px" id="inProcessRequestCount"> 0</span> In Process<i class="fa fa-eye ml-auto" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
		                                  <a onClick="clickFunction('completedRequest')" class="list-group-item d-flex justify-content-between dark-grey-text"><span style="font-weight: bold;margin-right: 10px" id="completedRequestCount">0</span> Completed<i class="fa fa-eye ml-auto" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
		                                  <a onClick="clickFunction('onHoldRequest')" class="list-group-item d-flex justify-content-between dark-grey-text"><span style="font-weight: bold;margin-right: 10px" id="onHoldRequestCount"> 0</span> On Hold<i class="fa fa-eye ml-auto" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
		                                  <a onClick="clickFunction('disapprovedRequest')" class="list-group-item d-flex justify-content-between dark-grey-text"><span style="font-weight: bold;margin-right: 10px" id="disapprovedRequestCount"> 0</span> Disapproved<i class="fa fa-eye ml-auto" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
		                              </div>
		                          </div>
		                      </div>
		                  </div>
		              </div>
		              <div class="col-lg-4 col-md-6 mb-4">
		                  <div class="card">
		                      <div class="card-header white-text warning-color" style="background-color: #fb3!important;">
		                          Issues
		                      </div>
		                      <div class="card-body pt-0 px-1">
		                          <div class="card-body text-center">
		                              <div class="list-group list-panel">
		                                  <a onClick="clickFunction('pendingIssue')" class="list-group-item d-flex justify-content-between dark-grey-text"><span style="font-weight: bold;margin-right: 10px" id="pendingIssueCount">0 </span> Pending<i class="fa fa-eye ml-auto" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
		                                  <a onClick="clickFunction('inProcessIssue')" class="list-group-item d-flex justify-content-between  dark-grey-text"><span style="font-weight: bold;margin-right: 10px" id="inProcessIssueCount"> 0</span> In Process<i class="fa fa-eye ml-auto" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
		                                  <a onClick="clickFunction('completedIssue')" class="list-group-item d-flex justify-content-between red-text"><span style="font-weight: bold;margin-right: 10px" id="completedIssueCount"> 0</span> Completed<i class="fa fa-eye ml-auto" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
		                                  <a onClick="clickFunction('onHoldIssue')" class="list-group-item d-flex justify-content-between dark-grey-text"><span style="font-weight: bold;margin-right: 10px" id="onHoldIssueCount"> 0</span> On Hold<i class="fa fa-eye ml-auto" data-toggle="tooltip" data-placement="top" title="View Details"></i></a>
		                              </div>
		                          </div>
		                      </div>
		                  </div>
		              </div>
		           </div>
		  	</section>
	  	</div>
  	</main>
    <script type="text/javascript" src="../JavaScripts/SupportHomePage.js"></script>
    <script>
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