function DropDownForEvaluation() {  
	var ourRequest1 = new XMLHttpRequest();
    var data1 = [];
    ourRequest1.open('GET', '../../../GetEvaluationLegendList');
    ourRequest1.onload = function() {
      if (ourRequest1.status >= 200 && ourRequest1.status < 400) {
    	data1 = JSON.parse(ourRequest1.responseText);
        createHTML1(data1); createHTML2(data1); createHTML3(data1);
        createHTML4(data1); createHTML5(data1); createHTML6(data1);
        createHTML7(data1); createHTML8(data1); createHTML9(data1);
        createHTML10(data1);
      } else {
        console.log("We connected to the server, but it returned an error.");
      }
    };
    ourRequest1.onerror = function() {
      console.log("Connection error");
    };
    ourRequest1.send();
    
    function createHTML1(Data) {
    	var options1;
    	$('#defectType').empty();
        options1 = '<option value="" selected>Select Defect Type</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subCategory == 'Defect Type') {
        		options1 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
       /* options1 += "<option value=Other>Other</option>";*/
        $('#defectType').html(options1);
        //$('#defectType').material_select('refresh');
    }
    
    function createHTML2(Data) {
    	var options2;
    	$('#function').empty();
        options2 = '<option value="" selected>Select Function</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subCategory == "Function") { 
        		options2 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
        $('#function').html(options2);
       // $('#function').material_select('refresh');
    }
    
    function createHTML3(Data) {
    	var options3;
    	$('#meeting').empty();
        options3 = '<option value="" selected>Select Meeting</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subCategory == "Meeting") { 
        		options3 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }console.log(options3);
        $('#meeting').html(options3);
        //$('#meeting').material_select('refresh');
    }
    
    function createHTML4(Data) {
    	var options4;
    	$('#coaching').empty();
        options4 = '<option value="" selected>Select Coaching</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subCategory == "Coaching") { 
        		options4 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
        $('#coaching').html(options4);
        //$('#coaching').material_select('refresh');
    }
    
    function createHTML5(Data) {
    	var options5;
    	$('#training').empty();
        options5 = '<option value="" selected>Select Training</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subCategory == "Training") { 
        		options5 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
        $('#training').html(options5);
        //$('#training').material_select('refresh');
    }
    
    function createHTML6(Data) {
    	var options6;
    	$('#storage').empty();
        options6 = '<option value="" selected>Select Storage</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subCategory == "Storage") { 
        		options6 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
        $('#storage').html(options6);
        //$('#storage').material_select('refresh');
    }
    
    function createHTML7(Data) {
    	var options7;
    	$('#condition').empty();
        options7 = '<option value="" selected>Select Condition</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subCategory == "Condition") { 
        		options7 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
        $('#condition').html(options7);
        //$('#condition').material_select('refresh');
    }
    
    function createHTML8(Data) {
    	var options8;
    	$('#calibration').empty();
        options8 = '<option value="" selected>Select Calibration</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subCategory == "Calibration") { 
        		options8 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
        $('#calibration').html(options8);
        //$('#calibration').material_select('refresh');
    }
    
    function createHTML9(Data) {
    	var options9;
    	$('#maintainance').empty();
        options9 = '<option value="" selected>Select Maintainance</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subCategory == "Maintainance") { 
        		options9 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
        $('#maintainance').html(options9);
        //$('#maintainance').material_select('refresh');
    }
    
    function createHTML10(Data) {
    	var options10;
    	$('#auditMetricType').empty();
        options10 = '<option value="" selected>Select Metric Type</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subCategory == "Metric Type") { 
        		options10 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
        $('#auditMetricType').html(options10);
        //$('#auditMetricType').material_select('refresh');
    }
    
    /*function createHTML11(Data) {
    	var options11;
    	$('#maintainance').empty();
        options11 = '<option value="" selected>Select Maintainance</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subCategory == "Maintainance") { 
        		options11 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
        $('#maintainance').html(options11);
        $('#maintainance').material_select('refresh');
    }*/
}