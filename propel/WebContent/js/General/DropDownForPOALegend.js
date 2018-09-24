function dropDownForPOALegend(){ 
	    var ourRequest1 = new XMLHttpRequest();
	    var data1 = [];
	    ourRequest1.open('GET', '../../../GetPOALegendlist');
	    ourRequest1.onload = function() {
	      if (ourRequest1.status >= 200 && ourRequest1.status < 400) {
	    	data1 = JSON.parse(ourRequest1.responseText);
	        createHTML1(data1);   createHTML2(data1);    
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
	    	$('#statusPOA').empty();
	        options1 = '<option value="">Select Status</option>';
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].category == "Status") {
	        		options1 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
	    		}
	        }
	        $('#statusPOA').html(options1);
	        $('#statusPOA').selectpicker();
	        //$('#statusPOA').material_select('refresh');
	    }
	    
	    function createHTML2(Data) { 
	    	var options2;
	    	$('#priorityPOA').empty();
	        options2 = '<option value="">Change Category</option>';
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].category == "Priority") {
	        		options2 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
	    		}
	        }
	        $('#priorityPOA').html(options2);
	        $('#priorityPOA').selectpicker();
	        //$('#statusPOA').material_select('refresh');
	    }
}	  
