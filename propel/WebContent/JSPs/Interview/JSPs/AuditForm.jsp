<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div class="form-row">
    <div class="form-group col-md-12">
    <form id="newAuditForm" name="newAuditForm">
		<div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
	    <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
	    <div class="alert alert-success HideThisElement" id="successMessage"></div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <div class="md-form">
                	<input type="hidden" id="AuditId" name="AuditId">
          			<input type="hidden" id="action2" name="type">	
          				<input type="hidden" id="action" name="action" value="insert">
          			<label for="InfluencingFactor" id="InfluencingFactorLbl">Influencing Factor</label>          							                    
                    <input type="text" id="InfluencingFactor" name="InfluencingFactor" class="form-control text-capitalize">
                </div>
            </div>
            <div class="form-group col-md-3">
            	<label for="auditMetricName" id="auditMetricNameLbl">Metric Name</label>
               	<input type="text" id="auditMetricName" name="auditMetricName" class="form-control text-capitalize">           	
            </div>
            <div class="form-group col-md-3">
                <label for="auditMetricType" id="auditMetricTypeLbl">Metric Type</label>
	            <select id="auditMetricType" name="auditMetricType" class="form-control">
	         	</select>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12" id="auditItemCommentsDiv">
                 <label for="auditItemComments" id="auditItemCommentsLbl">Comments</label>            
                 <textarea class="md-textarea form-control md-textarea-auto richTextArea" id="auditItemComments" rows="2"></textarea>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                 <input type="button" id="saveAuditForm" value="Save" class="btn btn-primary btn-rounded">
                 <input type="button" id="cancelAuditForm" value="Cancel" class="btn btn-primary btn-rounded back">
            </div>
        </div>
    </form>
  </div>
</div>
</body>
</html>