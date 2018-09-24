function DropDownForProjectEmployee(id) {
	var ourRequest1 = new XMLHttpRequest();
    var data1 = [];
    ourRequest1.open('GET', '../../../GetEmployeeForPOA?projectid='+$("#ProjectId").val());
    ourRequest1.onload = function() {
      if (ourRequest1.status >= 200 && ourRequest1.status < 400) {
    	data1 = JSON.parse(ourRequest1.responseText);
        createHTML1(data1); createHTML2(data1);createHTML3(data1);createHTML4(data1);createHTML5(data1);
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
    	$('#responsible').empty(); 
        options1 = '<option value="" >Select Responsible</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	options1 += "<option value='" + Data.data[i].employeeId + "'>" + Data.data[i].empname + "</option>";
        }
        $('#responsible').html(options1); $('#responsible').selectpicker();
       // $('#responsible').material_select('refresh');
    }
    
    function createHTML2(Data) {
    	var options2;
    	$('#accountable').empty();
        options2 = '<option value="" >Select Accountable</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        	options2 += "<option value='" + Data.data[i].employeeId + "'>" + Data.data[i].empname + "</option>";
        }
        $('#accountable').html(options2);$('#accountable').selectpicker();
        //$('#accountable').material_select('refresh');
    }
    
    function createHTML3(Data) {
    	var options3;
    	$('#consulted').empty(); 
        options3 = '<option value="">Select Consulted</option>'
        for (i = 0; i < Data.data.length; i++)
        {
        	options3 += "<option value='" + Data.data[i].employeeId + "'>" + Data.data[i].empname + "</option>";
        }
        $('#consulted').html(options3);
        $('#consulted').selectpicker();
       // $('#consulted').material_select('refresh');
    }
    
    function createHTML4(Data) {
    	var options4;
    	$('#informed').empty();
        options4 = '<option value="">Select Informed</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        	options4 += "<option value='" + Data.data[i].employeeId + "'>" + Data.data[i].empname + "</option>";
        }
        $('#informed').html(options4); $('#informed').selectpicker();
        //$('#informed').material_select('refresh');
    }
    
    function createHTML5(Data) {
    	var options5;
    	$('#reportTo').empty();
        options5 = '<option value="">Select Report To</option>';
        for (i = 0; i < Data.data.length; i++)
        {
        	options5 += "<option value='" + Data.data[i].employeeId + "'>" + Data.data[i].empname + "</option>";
        }
        $('#reportTo').html(options5);
       // $('#reportTo').material_select('refresh');
    }
}