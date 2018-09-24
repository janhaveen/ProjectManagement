    function dropdownFunction(){ 
	    var ourRequest1 = new XMLHttpRequest();
	    var data1 = [];
	    ourRequest1.open('GET', '../../../GetUniqueLegends');
	    ourRequest1.onload = function() {
	      if (ourRequest1.status >= 200 && ourRequest1.status < 400) {
	    	data1 = JSON.parse(ourRequest1.responseText);
	        createHTML1(data1);
	        createHTML2(data1);
	        createHTML3(data1);
	      } else {
	        console.log("We connected to the server, but it returned an error.");
	      }
	    };
	    ourRequest1.onerror = function() {
	      console.log("Connection error");
	    };
	    ourRequest1.send();
	    
	    var ourRequest2 = new XMLHttpRequest();
	    var data2 = [];
	    ourRequest2.open('GET', '../../../GetLegendList');
	    ourRequest2.onload = function() {
	      if (ourRequest2.status >= 200 && ourRequest2.status < 400) { 
	    	data2 = JSON.parse(ourRequest2.responseText);
	        createHTML4(data2);
	        createHTML5(data2);
	        createHTML6(data2);
	        createHTML8(data2);
	        createHTML9(data2); createHTML10(data2); createHTML11(data2); 
	        createHTML12(data2); createHTML13(data2); createHTML14(data2); 
	        createHTML16(data2); createHTML15(data2); 
	        createHTML17(data2); createHTML18(data2); 
	        createHTML19(data2); 
	      } else {
	        console.log("We connected to the server, but it returned an error.");
	      }
	    };
	    ourRequest2.onerror = function() {
	      console.log("Connection error");
	    };
	    ourRequest2.send();
	    
	    var ourRequest3 = new XMLHttpRequest();
	    var data3 = [];
	    ourRequest3.open('GET', '../../../GetHsnId');
	    ourRequest3.onload = function() {
	      if (ourRequest3.status >= 200 && ourRequest3.status < 400) {
	    	data3 = JSON.parse(ourRequest3.responseText);
	        createHTML7(data3);
	      } else {
	        console.log("We connected to the server, but it returned an error.");
	      }
	    };
	    ourRequest3.onerror = function() {
	      console.log("Connection error");
	    };
	    ourRequest3.send();
	
	    function createHTML1(Data) {
	    	var options1;
	    	$('#legendGroupDD').empty();
	        options1 = '<option value="" selected>Select Legend Group</option>'
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].category == "Legend Group") {
	        		options1 += "<option value='" + Data.data[i].legendtype + "'>" + Data.data[i].legendtype + "</option>";
	    		}
	        }
	        options1 += "<option value=Other>Other</option>";
	        $('#legendGroupDD').html(options1);
	        $('#legendGroupDD').material_select('refresh');
	    }
	
	
	    function createHTML2(Data) {
	    	var options2;
	    	$('#categoryDD').empty();
	        options2 = '<option value="" selected>Select Category</option>';
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].category == "Category") {
	        		options2 += "<option value='" + Data.data[i].legendtype + "'>" + Data.data[i].legendtype + "</option>";
	    		}
	        }
	        options2 += "<option value=Other>Other</option>";
	        $('#categoryDD').html(options2);
	        $('#categoryDD').material_select('refresh');
	    }
	    
	    
	    function createHTML3(Data) {
	    	var options2;
	    	$('#subCategoryDD').empty();
	        options2 = '<option value="" selected>Select Sub Category</option>';
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].category == "Sub Category") {
	        		options2 += "<option value='" + Data.data[i].legendtype + "'>" + Data.data[i].legendtype + "</option>";
	    		}
	        }
	        options2 += "<option value=Other>Other</option>";
	        $('#subCategoryDD').html(options2);
	        $('#subCategoryDD').material_select('refresh');
	    }
	    
	    function createHTML4(Data) { 
	    	var options4;
	    	$('#category').empty();
	        options4 = '<option value="" selected>Select Product Category</option>';
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].subcategory == "Product Category") {
	        		options4 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
	    		}
	        }
	        options4 += "<option value=Other>Other</option>";
	        $('#category').html(options4);
	        $('#category').material_select('refresh');
	    }
	    
	    function createHTML5(Data) { 
	    	var options5;
	    	$('#subCategory').empty();
	        options5 = '<option value="" selected>Select Product Brand</option>';
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].subcategory == "Product Sub Category") {
	        		options5 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
	    		}
	        }
	        options5 += "<option value=Other>Other</option>";
	        $('#subCategory').html(options5);
	        $('#subCategory').material_select('refresh');
	    }
	    
	    function createHTML6(Data) { 
	    	var options6;
	    	$('#productType').empty();
	        options6 = '<option value="" selected>Select Product Sub Brand</option>';
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].subcategory == "Product Type") {
	        		options6 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
	    		}
	        }
	        options6 += "<option value=Other>Other</option>";
	        $('#productType').html(options6);
	        $('#productType').material_select('refresh');
	    }
	    
	    function createHTML7(Data) { 
	    	var options7;
	    	$('#hsnIdDD').empty();
	        options7 = '<option value="" selected>Select Hsn ID</option>';
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	options7 += "<option value='" + Data.data[i].rowId + "'>" + Data.data[i].Hsnid + "</option>";
	        }
	        options7 += "<option value=Other>Other</option>";
	        $('#hsnIdDD').html(options7);
	        $('#hsnIdDD').material_select('refresh');
	    }
	    
	    
	    function createHTML8(Data) { 
	    	var options8;
	    	$('#department').empty(); $('#departmentCp').empty();$('#newCustomerForm #department').empty();
	        options8 = '<option value="">Select Department</option>'
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].category == "Department") {
	        		options8 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
	    		}
	        }
	         $('#department').html(options8);  $('#departmentCp').html(options8); $('#newCustomerForm #department').html(options8);
	         $('#department').material_select('refresh'); $('#departmentCp').material_select('refresh'); $('#newCustomerForm #department').material_select('refresh'); 
	        if($("#qDeptCurrent").val()){ 
		     	if($("#qDeptCurrent").val()=="107"){
		     		$('#department').attr("disabled",true);
		    		$('#department').val("107").material_select('refresh');
		    	}else{
		    		$('#department').attr("disabled",true);
		    		$('#department').val("106").material_select('refresh');
		    	}
	        }
	   }
	    
	    function createHTML9(Data) {
	    	var options9;
	    	$('#designation').empty(); $('#designationCp').empty();
	        options9 = '<option value="" selected>Select Designation</option>';
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].category == "Designation") {
	        		options9 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
	    		}
	        }
	        $('#designation').html(options9); $('#designationCp').html(options9);
	        $('#designation').material_select('refresh'); $('#designationCp').material_select('refresh');
	    }
	    
	    function createHTML10(Data) {
	    	var options10;
	    	$('#customersegment').empty();
	        options10 = '<option value="" selected>Select Customer Segment</option>';
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].category == "Segment" && parseInt(Data.data[i].rowid) <=110004 && parseInt(Data.data[i].rowid) >110001) { 
	        		options10 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
	    		}
	        }
	        $('#customersegment').html(options10);
	        $('#customersegment').material_select('refresh');
	    }
	    
	    function createHTML11(Data) {
	    	var options11;
	    	$('#modeofPay').empty();
	        options11 = '<option value="" selected>Select Mode of Payment</option>';
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].subcategory == "Mode of Payment" && Data.data[i].legendgroup=="Order") { 
	        		options11 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
	    		}
	        }
	        $('#modeofPay').html(options11);
	        $('#modeofPay').material_select('refresh');
	    }

	    function createHTML12(Data) {
	    	var options12;
	    	$('#invoice').empty();
	        options12 = '<option value="" selected>Select Invoice Type</option>';
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].subcategory == "Invoice Type") { 
	        		options12 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
	    		}
	        }
	        $('#invoice').html(options12);
	        $('#invoice').material_select('refresh');
	    }
	    
	    function createHTML13(Data) {
	    	var options13;
	    	$('#priority').empty();
	        options13 = '<option value="" selected>Select Priority</option>';
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].subcategory == "Priority") { 
	        		options13 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
	    		}
	        }
	        $('#priority').html(options13);
	        $('#priority').material_select('refresh');
	    }
	    
	    function createHTML14(Data) { 
	    	var options14;
	    	$('#customersegment1').empty();
	        options14 = '<option value="" selected>Select Customer Type</option>';
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].subcategory == "Customer Type") { 
	        		options14 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
	    		}
	        }
	        $('#customersegment1').html(options14);
	        $('#customersegment1').material_select('refresh');
	    }
	    
	    function createHTML15(Data) {
	    	var options15;
	    	$('#industrytype').empty();
	        options1 = '<option value="" selected>Select Industry Type</option>'
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].category == "Industry Type") {
	        		options15 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
	    		}
	        }
	        options15 += "<option value=Other>Other</option>";
	        $('#industrytype').html(options15);
	        $('#industrytype').material_select('refresh');
	    }

	    function createHTML16(Data) {
	    	var options16;
	    	$('#source').empty();
	        options16 = '<option value="" selected>Select Source</option>';
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].category == "Source") {
	        		options16 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
	    		}
	        }
	        options16 += "<option value=Other>Other</option>";
	        $('#source').html(options16);
	        $('#source').material_select('refresh');
	    }
	    
	    function createHTML17(Data) {
	    	var options17;
	    	$('#modeOfPaymentInvoice').empty();
	        options17 = '<option value="" selected>Select Mode of Payment</option>';
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].subcategory == "Mode of Payment" && Data.data[i].legendgroup=="Invoice") { 
	        		options17 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
	    		}
	        }
	        $('#modeOfPaymentInvoice').html(options17);
	        $('#modeOfPaymentInvoice').material_select('refresh');
	    }
	    
	    function createHTML18(Data) {
	    	var options18;
	    	$('#invoicepaymentstatus').empty();
	        options18 = '<option value="" selected>Select Invoice Payment Status</option>';
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].subcategory == "Invoice Payment Status") { 
	        		options18 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
	    		}
	        }
	        $('#invoicepaymentstatus').html(options18);
	        $('#invoicepaymentstatus').material_select('refresh');
	    }
	    
	    function createHTML19(Data) {
	    	var options19;
	    	$('#followupstatus').empty();
	        options19 = '<option value="" selected>Select Invoice Payment Status</option>';
	        for (i = 0; i < Data.data.length; i++)
	        {
	        	if (Data.data[i].subcategory == "Follow Up Status") { 
	        		options19 += "<option value='" + Data.data[i].rowid + "'>" + Data.data[i].description + "</option>";
	    		}
	        }
	        $('#followupstatus').html(options19);
	        $('#followupstatus').material_select('refresh');
	    }
    }