function dropDownForProductLegend(){ 
	    var ourRequest1 = new XMLHttpRequest();
	    var data1 = [];
	    ourRequest1.open('GET', '../../../GetProductLegend');
	    ourRequest1.onload = function() {
	      if (ourRequest1.status >= 200 && ourRequest1.status < 400) {
	    	data1 = JSON.parse(ourRequest1.responseText);
	        createHTML1(data1);createHTML2(data1);	  	       
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
	    	$('#category').empty();
	        options1 = '<option value="" selected>Select Product Category</option>';
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].category == "Product Category") {
	        		options1 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
	    		}
	        }
	        options1 += "<option value=Other>Other</option>";
	        $('#category').html(options1);
	        $('#category').material_select('refresh');
	    }
	    function createHTML2(Data) { 
	    	var options2;
	    	$('#type').empty();
	        options2 = '<option value="" selected>Select Product Type</option>';
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].category == "Product Type") {
	        		options2 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
	    		}
	        }
	        options2 += "<option value=Other>Other</option>";
	        $('#type').html(options2);
	        $('#type').material_select('refresh');
	    }
}	  
