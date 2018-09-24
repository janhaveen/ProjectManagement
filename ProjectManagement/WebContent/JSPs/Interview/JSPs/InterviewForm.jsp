<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="card HideThisElement" id="InterviewFormDiv">
    <div class="card-body">
    	<h5 class="card-title">New Interview</h5><hr>
        <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item">
                <a class="nav-link active" id="panelBInfo-tab" data-toggle="tab" href="#panelBInfo" role="tab" aria-controls="panelBInfo" aria-selected="true">Basic Info</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="Who-tab" data-toggle="tab" href="#panelWho" role="tab" aria-controls="Who" aria-selected="true">Who?</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="How-tab" data-toggle="tab" href="#panelHow" role="tab" aria-controls="How" aria-selected="false">How?</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="With-tab" data-toggle="tab" href="#panelWith" role="tab" aria-controls="With" aria-selected="false">With?</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="panelAuditLi" data-toggle="tab" href="#panelAudit" role="tab" aria-controls="panelAudit" aria-selected="false">Audit?</a>
            </li>
        </ul>
        <div class="tab-content" id="myTabContent">
			  <div class="tab-pane fade show active" id="panelBInfo" role="tabpanel" aria-labelledby="panelBInfo">
			  		<div id="add"><%@include file="../../ProjectEmployee/JSPs/ProjectEmployeeList.jsp"%>
			  		<%@include file="../../ProjectEmployee/JSPs/ProjectEmployeeView.jsp"%>
			  		</div>
			  		<div id="upd" class="HideThisElement"><%@include file="../../ProjectEmployee/JSPs/ProjectEmployeeForm.jsp"%></div>
			  		<input type="hidden" id="EmployeeId" name="EmployeeId">
			  		<input type="hidden" id="department" name="department">
			  </div>
			  <div class="tab-pane fade" id="panelWho" role="tabpanel" aria-labelledby="Who">
			  		<%@include file="whoForm.jsp"%>
			  </div>
			  <div class="tab-pane fade" id="panelHow" role="tabpanel" aria-labelledby="How">			  	
			  		<%@include file="howForm.jsp"%>
			  </div>
  			  <div class="tab-pane fade" id="panelWith" role="tabpanel" aria-labelledby="With">
  			  		<%@include file="withForm.jsp"%>
  			  </div>
			  <div class="tab-pane fade" id="panelAudit" role="tabpanel" aria-labelledby="panelAudit">
			  		<%@include file="AuditList.jsp"%>
                    <%@include file="AuditForm.jsp"%>
			  </div>			  
		</div>
     </div>
</div>
</body>
</html>