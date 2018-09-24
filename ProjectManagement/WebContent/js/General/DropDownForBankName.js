function DropDownForBankName() {
	var ourRequest1 = new XMLHttpRequest();
    var data1 = [];
    ourRequest1.open('GET', '../../../GetLegendList');
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
    	$('#bankAccount').empty();
        options1 = '<option value="" selected>Select Bank</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subcategory == 'Bank Name') {
        		options1 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
    		}
        }
       /* options1 += "<option value=Other>Other</option>";*/
        $('#bankAccount').html(options1);
        $('#bankAccount').material_select('refresh');
    }
    
    function createHTML2(Data) {
    	var options2;
    	$('#invoicepaymentstatus').empty();$('#invoicepaymentstatus1').empty();
        options2 = '<option value="" selected>Select Cheque Clearance Status</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        	if (Data.data[i].subcategory == "Invoice Payment Status" && Data.data[i].rowid!="6001" && Data.data[i].rowid!="6006" && Data.data[i].rowid!="6002" && Data.data[i].rowid!="6004") { 
        		options2 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
    		}
        }
        $('#invoicepaymentstatus').html(options2);
        $('#invoicepaymentstatus').material_select('refresh');
        options2 += "<option value='6006'>Cancelled</option>";
        $('#invoicepaymentstatus1').html(options2);
        $('#invoicepaymentstatus1').material_select('refresh');
    }
}