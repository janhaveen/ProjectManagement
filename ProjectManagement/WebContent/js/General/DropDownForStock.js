function DropDownForStock() {
	var ourRequest1 = new XMLHttpRequest();
    var data1 = [];
    ourRequest1.open('GET', '../../../GetStockLegend');
    ourRequest1.onload = function() {
      if (ourRequest1.status >= 200 && ourRequest1.status < 400) {
    	data1 = JSON.parse(ourRequest1.responseText);
        createHTML1(data1); createHTML2(data1);
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
    	$('#floor').empty();
        options1 = '<option value="" selected>Select Floor</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subcategory == 'Floor Number') {
        		options1 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
    		}
        }
       /* options1 += "<option value=Other>Other</option>";*/
        $('#floor').html(options1);
        $('#floor').material_select('refresh');
    }
    
    function createHTML2(Data) {
    	var options2;
    	$('#aisle').empty();
        options2 = '<option value="" selected>Select Aisle</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subcategory == 'Aisle Number') {
        		options2 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
    		}
        }
       /* options1 += "<option value=Other>Other</option>";*/
        $('#aisle').html(options2);
        $('#aisle').material_select('refresh');
    }
 }