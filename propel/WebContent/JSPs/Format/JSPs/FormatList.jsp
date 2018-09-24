<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<div class="col-md-12 card" id="FormatTableDiv">
		<div class="card-body">
			<h5 class="card-title">Format List</h5><hr>
	    	<div class="alert alert-success alert-dismissible fade show HideThisElement successMsg" role="alert">
			 <p id="successMsg"></p>
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
			<div class="alert alert-danger alert-dismissible fade show HideThisElement errorMsg" role="alert">
			 <p id="errorMsg"></p>
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
              <table class="table table-hover mb-0 nowrap" cellspacing="0" width="100%" id="FormatTable">
                  <!--Table head-->
                  <thead >
                      <tr>
                         <th id="FtH">#</th>
                         <th>Format Name</th>
                         <th>Control Type</th>
                         <th>File Name</th>
                         <th></th>
                      </tr>
                  </thead>
                  <!--Table head-->
                  <!--Table body-->
                  <tbody>
                  </tbody>
                  <!--Table body-->
              </table>
              <!--Table-->
          </div>
      </div>
</body>
</html>