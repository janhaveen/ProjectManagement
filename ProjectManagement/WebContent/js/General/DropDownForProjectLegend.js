function DropDownForProjectLegend() {
	var ourRequest1 = new XMLHttpRequest();
    var data1 = [];
    ourRequest1.open('GET', '../../../GetProjectLegendList?projectid='+$("#ProjectId").val());
    ourRequest1.onload = function() {
      if (ourRequest1.status >= 200 && ourRequest1.status < 400) {
    	data1 = JSON.parse(ourRequest1.responseText);
        createHTML3(data1); createHTML4(data1);
      } else {
        console.log("We connected to the server, but it returned an error.");
      }
    };
    ourRequest1.onerror = function() {
      console.log("Connection error");
    };
    ourRequest1.send();
    
    function createHTML3(Data) {
    	console.log("called");
    	var options3;
    	$('#department').empty(); $('#NewFunctionForm #DepartmentId').empty(); 
        options3 = '<option value="">Select Department</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subCategory == "Department") {
        		options3 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
         $('#department').html(options3);  $('#NewFunctionForm #DepartmentId').html(options3); 
        // $('#department').material_select('refresh');  
   }
    
    function createHTML4(Data) { 
    	var options4;
    	$('#designation').empty(); 
        options4 = '<option value="">Select Designation</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].category == "Designation" ) {
        		options4 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].description + "</option>";
    		}
        }
         $('#designation').html(options4); 
         //$('#department').material_select('refresh');  
   }
    
}