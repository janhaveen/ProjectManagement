$(document).ready(function() {
	DropDownForProjectLegend();
	getDepartmentCards("");	
});

function getDepartmentCards(id) {
	/*var str="?1=1";
	if (id!="") {
		str+="&deptId="+
	}*/
	$.ajax({
		url:"../../../GetDepartmentCards?ProjectId="+$("#ProjectId").val(),
		type:"GET",
		success:function(data){
			$('#mainDiv').html('');
			document.querySelector('#mainDiv').insertAdjacentHTML('beforeend', data);
		}		
	});
	
}

