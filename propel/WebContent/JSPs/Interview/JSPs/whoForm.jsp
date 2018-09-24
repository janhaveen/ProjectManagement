<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
</head>
<body>

<form id="newWhoForm" name="newWhoForm">
	<div class="alert alert-warning HideThisElement" id="alertMessage" style="background-color: #ffbb33"></div>
    <div class="alert alert-danger HideThisElement" id="errorMessage"></div>
    <div class="alert alert-success HideThisElement" id="successMessage"></div>
    <div class="form-row">
        <div class="form-group col-md-4">
           	<input type="hidden" id="isEmpCreate" name="isEmpCreate" value="0">
           	<input type="hidden" id="InterviewId" name="InterviewId">
           	<input type="hidden" id="action" name="action" >
            <label for="meeting" id="meetingTextLbl">Meeting</label>
           	<select id="meeting" name="meeting" class="form-control">
           	</select>
        </div>
        <div class="form-group col-md-4">
            <label for="coaching" id="coachingTextLbl">Coaching</label>
            <select id="coaching" name="coaching" class="form-control">
           	</select>
        </div>
        <div class="form-group col-md-4">
            <label for="training" id="trainingTextLbl">Training</label>
            <select id="training" name="training" class="form-control">
         	</select>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-8"  id="RoleDiv">
         	<label for="empRole" id="empRoleLbl">Role</label>
            <textarea class="md-textarea richTextArea form-control" rows="7" id="empRole"   style="height: 8rem;overflow-y: auto;"></textarea>               
        </div>
        <div class="form-group col-md-4" id="ChallengesDiv">
            <label for="obChallenges" id="obChallengesLbl">Challenges</label>
            <textarea class="md-textarea richTextArea form-control" rows="7"  id="obChallenges"   style="height: 8rem;overflow-y: auto;"></textarea>            
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-12">
            <div class="md-form">
                <input type="button" id="saveWhoForm" value="Submit" class="btn btn-primary btn-rounded">
                <input type="button" id="editWhoForm" value="Update" class="btn btn-primary btn-rounded">
                <input type="button" id="cancelWhoForm" value="Cancel" class="btn btn-primary btn-rounded  back">
            </div>
        </div>

    </div>
</form>
</body>
</html>
