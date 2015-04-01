function load() {

	$.ajax({
		type : 'GET',
		url : 'rest/userlibrary/playlists',
		success : fillImsiSelect,
		error: test,
		contentType : 'application/json'
	});
}

function test(){
	alert("hello");
	console.log("test");
}

/**
 * separate unique numbers from the all imsi and paste to dropdown list
 * 
 */

function fillImsiSelect(data) {
	var select = document.getElementById("imsiNumber");

	for (var i = 0; i < data.length; i++) {
		var opt = data[i];
		var el = document.createElement("option");
		el.textContent = opt;
		el.value = opt;
		select.appendChild(el);
	}
}
