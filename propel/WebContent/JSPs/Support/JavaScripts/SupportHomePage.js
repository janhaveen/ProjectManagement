$(document).ready(function(){
	var getListOfCounts = new XMLHttpRequest();
	var data1 = [];
	getListOfCounts.open('GET', '../../../GetNumberOfIssues');
	getListOfCounts.onload = function() {
		if (getListOfCounts.status >= 200 && getListOfCounts.status < 400) {
			data1 = JSON.parse(getListOfCounts.responseText);
			
			$("#totalSupport").html(data1.data[0].totalsupport);
			
			$("#pendingRequestCount").html(data1.data[0].totalpendingrequest);
			$("#inProcessRequestCount").html(data1.data[0].totalinprocessrequest);
			$("#completedRequestCount").html(data1.data[0].totalcompletedrequest);
			$("#onHoldRequestCount").html(data1.data[0].totalonholdrequest);
			$("#disapprovedRequestCount").html(data1.data[0].totaldisapproved);
			
			$("#pendingIssueCount").html(data1.data[0].totalpendingissue);
			$("#inProcessIssueCount").html(data1.data[0].totalinprocessissue);
			$("#completedIssueCount").html(data1.data[0].totalcompletedissue);
			$("#onHoldIssueCount").html(data1.data[0].totalonholdissue);
			
		} else {
			console.log("We connected to the server, but it returned an error.");
		}
	};

	getListOfCounts.onerror = function() {
		console.log("Connection error");
	};
	
    getListOfCounts.send();
});