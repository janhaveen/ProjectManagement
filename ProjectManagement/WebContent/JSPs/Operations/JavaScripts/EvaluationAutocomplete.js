function EvaluationAutocomplete() {
	var designation=[]; var designationArray=[]; var department=[]; var departmentArray=[];
	var meeting=[]; var meetingArray=[];
	var coaching=[]; var coachingArray=[];
	var training=[]; var trainingArray=[];
	var storage=[]; var storageArray=[];
	var condition=[]; var conditionArray=[];
	var calibration=[]; var calibrationArray=[];
	var maintainance=[]; var maintainanceArray=[];
	var functionName=[]; var functionNameArray=[];
	
	$.ajax({
		url:"../../../GetLegendList",
		type:"GET",
		success:function(data){
			for (var i = 0; i < data.data.length; i++) {
				if(data.data[i].category=="Designation"){
					designation.push(data.data[i].description);
					designationArray.push({id:data.data[i].rowId, desc:data.data[i].description});
				}
				if(data.data[i].category=="Department"){
					department.push(data.data[i].description);
					departmentArray.push({id:data.data[i].rowId, desc:data.data[i].description});
				}
			}
			$("#designationText").mdb_autocomplete({ 
			    data: designation
			});
			$("#departmentText").mdb_autocomplete({ 
				data: department
			});
		}
	});
	
	$.ajax({
		url:"../../../GetEvaluationLegendList",
		type:"GET",
		success:function(data){
			for (var i = 0; i < data.data.length; i++) {
				if(data.data[i].category=="Meeting"){
					meeting.push(data.data[i].description);
					meetingArray.push({id:data.data[i].rowId, desc:data.data[i].description});
				}
				if(data.data[i].category=="Coaching"){
					coaching.push(data.data[i].description);
					coachingArray.push({id:data.data[i].rowId, desc:data.data[i].description});
				}
				if(data.data[i].category=="Training"){
					training.push(data.data[i].description);
					trainingArray.push({id:data.data[i].rowId, desc:data.data[i].description});
				}
				if(data.data[i].category=="Storage"){
					storage.push(data.data[i].description);
					storageArray.push({id:data.data[i].rowId, desc:data.data[i].description});
				}
				if(data.data[i].category=="Condition"){
					condition.push(data.data[i].description);
					conditionArray.push({id:data.data[i].rowId, desc:data.data[i].description});
				}
				if(data.data[i].category=="Calibration"){
					calibration.push(data.data[i].description);
					calibrationArray.push({id:data.data[i].rowId, desc:data.data[i].description});
				}
				if(data.data[i].category=="Maintainance"){
					maintainance.push(data.data[i].description);
					maintainanceArray.push({id:data.data[i].rowId, desc:data.data[i].description});
				}
				if(data.data[i].category=="Function"){
					functionName.push(data.data[i].description);
					functionNameArray.push({id:data.data[i].rowId, desc:data.data[i].description});
				}
				
			}	
			$('#meetingText').mdb_autocomplete({ 
			    data: meeting
			});	
			$('#coachingText').mdb_autocomplete({ 
			    data: coaching
			});	
			$('#trainingText').mdb_autocomplete({ 
			    data: training
			});	
			$('#storageText').mdb_autocomplete({ 
			    data: storage
			});	
			$('#conditionText').mdb_autocomplete({ 
			    data: condition
			});	
			$('#calibrationText').mdb_autocomplete({ 
			    data: calibration
			});	
			$('#maintainanceText').mdb_autocomplete({ 
				data: maintainance
			});	
			$('#functionNameText').mdb_autocomplete({ 
				data: functionName
			});	
		}
	});
	
	
	$('#designationText').on('keyup', function() {	   
		$("#designationDiv .mdb-autocomplete-wrap").click(function(){ $('#designationText').focus(); });
	});
	
	$('#designationDiv').on( 'focusout', '#designationText', function () { 
		if($("#designationText").val()!=""){
			for (var m = 0; m < designationArray.length; m++) {
				if(designationArray[m].desc==$("#designationText").val()){
					$("#designation").val(designationArray[m].id);
				}
			}
		}else{
			$(this).focus();
		}
	});
	
	$('#departmentText').on('keyup', function() {	   
		$("#departmentDiv .mdb-autocomplete-wrap").click(function(){ $('#departmentText').focus(); });
	});
	
	$('#departmentDiv').on( 'focusout', '#departmentText', function () { 
		if($("#departmentText").val()!=""){
			for (var m = 0; m < departmentArray.length; m++) {
				if(departmentArray[m].desc==$("#departmentText").val()){
					$("#department").val(departmentArray[m].id);
				}
			}
		}else{
			$(this).focus();
		}
	});
	
	$('#meetingText').on('keyup', function() {	   
		$("#meetingDiv .mdb-autocomplete-wrap").click(function(){ $('#meetingText').focus(); });
	});
	
	$('#meetingDiv').on( 'focusout', '#meetingText', function () { 
		if($("#meetingText").val()!=""){
			for (var m = 0; m < meetingArray.length; m++) {
				if(meetingArray[m].desc==$("#meetingText").val()){
					$("#meeting").val(meetingArray[m].id);
				}
			}
		}else{
			$(this).focus();
		}
	});
	
	$('#coachingText').on('keyup', function() {	   
		$("#coachingDiv .mdb-autocomplete-wrap").click(function(){ $('#coachingText').focus(); });
	});
	
	$('#coachingDiv').on( 'focusout', '#coachingText', function () { 
		if($("#coachingText").val()!=""){
			for (var m = 0; m < coachingArray.length; m++) {
				if(coachingArray[m].desc==$("#coachingText").val()){
					$("#coaching").val(coachingArray[m].id);
				}
			}
		}else{
			$(this).focus();
		}
	});
	
	$('#trainingText').on('keyup', function() {	   
		$("#trainingDiv .mdb-autocomplete-wrap").click(function(){ $('#trainingText').focus(); });
	});
	
	$('#trainingDiv').on( 'focusout', '#trainingText', function () { 
		if($("#trainingText").val()!=""){
			for (var m = 0; m < trainingArray.length; m++) {
				if(trainingArray[m].desc==$("#trainingText").val()){
					$("#training").val(trainingArray[m].id);
				}
			}
		}else{
			$(this).focus();
		}
	});
	
	$('#storageText').on('keyup', function() {	   
		$("#storageDiv .mdb-autocomplete-wrap").click(function(){ $('#storageText').focus(); });
	});
	
	$('#storageDiv').on( 'focusout', '#storageText', function () { 
		if($("#storageText").val()!=""){
			for (var m = 0; m < storageArray.length; m++) {
				if(storageArray[m].desc==$("#storageText").val()){
					$("#storage").val(storageArray[m].id);
				}
			}
		}else{
			$(this).focus();
		}
	});
	$('#conditionText').on('keyup', function() {	   
		$("#conditionDiv .mdb-autocomplete-wrap").click(function(){ $('#conditionText').focus(); });
	});
	
	$('#conditionDiv').on( 'focusout', '#conditionText', function () { 
		if($("#conditionText").val()!=""){
			for (var m = 0; m < conditionArray.length; m++) {
				if(conditionArray[m].desc==$("#conditionText").val()){
					$("#condition").val(conditionArray[m].id);
				}
			}
		}else{
			$(this).focus();
		}
	});
	
	$('#calibrationText').on('keyup', function() {	   
		$("#calibrationDiv .mdb-autocomplete-wrap").click(function(){ $('#calibrationText').focus(); });
	});
	
	$('#calibrationDiv').on( 'focusout', '#calibrationText', function () { 
		if($("#calibrationText").val()!=""){
			for (var m = 0; m < calibrationArray.length; m++) {
				if(calibrationArray[m].desc==$("#calibrationText").val()){
					$("#calibration").val(calibrationArray[m].id);
				}
			}
		}else{
			$(this).focus();
		}
	});
	
	$('#maintainanceText').on('keyup', function() {	   
		$("#maintainanceDiv .mdb-autocomplete-wrap").click(function(){ $('#maintainanceText').focus(); });
	});
	
	$('#maintainanceDiv').on( 'focusout', '#maintainanceText', function () { 
		if($("#maintainanceText").val()!=""){
			for (var m = 0; m < maintainanceArray.length; m++) {
				if(maintainanceArray[m].desc==$("#maintainanceText").val()){
					$("#maintainance").val(maintainanceArray[m].id);
				}
			}
		}else{
			$(this).focus();
		}
	});
	
	$('#functionNameText').on('keyup', function() {	   
		$("#functionNameDiv .mdb-autocomplete-wrap").click(function(){ $('#functionNameText').focus(); });
	});
	
	$('#functionNameDiv').on( 'focusout', '#functionNameText', function () { 
		if($("#functionNameText").val()!=""){
			for (var m = 0; m < functionNameArray.length; m++) {
				if(functionNameArray[m].desc==$("#functionNameText").val()){
					$("#functionName").val(functionNameArray[m].id);
				}
			}
		}else{
			$(this).focus();
		}
	});
}