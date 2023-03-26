const verVideo = $('#verVideo'),
	camara = $('#camara').css("display", "none"),
	atras = $('#atras_guardar'),
	tomarFoto = $('#tomarFoto').css("display", "none");


//Configure a few settings and attach camera
Webcam.set({
	// live preview size
	width: 320,
	height: 240,

	// device capture size
	dest_width: 640,
	dest_height: 480,

	// final cropped size
	crop_width: 480,
	crop_height: 480,

	// format and quality
	image_format: 'jpeg',
	jpeg_quality: 90,

	// flip horizontal (mirror mode)
	flip_horiz: true
});

verVideo.click(function() {
	Webcam.attach('#camara');
	camara.css("display", "block");
	tomarFoto.css("display", "block");
	verVideo.css("display", "none");
})

//Code to handle taking the snapshot and displaying it locally
function preview_snapshot() {
	// freeze camera so user can preview pic
	Webcam.freeze();

	// swap button sets
	document.getElementById('tomarFoto').style.display = 'none';
	document.getElementById('atras_guardar').style.display = '';
	save_photo();

}

function cancel_preview() {
	// cancel preview freeze and return to live camera feed
	Webcam.unfreeze();
	camara.css("display", "block");
	$('#webcam').css("display", "none");
	tomarFoto.css("display", "block");
	atras.css("display", "none");

}

function save_photo() {
	console.log("entre a guardar la imagen");
	// actually snap photo (from preview freeze) and display it
	Webcam.snap(function(data_uri) {
		// display results in page
		document.getElementById('results').innerHTML =
			'<img width="250" height="250" id="webcam" src="' + data_uri + '"/>';
		camara.css("display", "none")
		// document.getElementById('tomarFoto').style.display = '';
		// document.getElementById('atras_guardar').style.display = 'none';
	});
	// Webcam.reset();
	const visitanteIdentificacion = $("#visitanteIdentificacion").val();
	var base64 = document.getElementById('webcam').src;
	Webcam.upload(base64, "", function() {
		$.ajax({
			url: "/visitantes/savefoto",
			type: "POST",
			data: {
				"foto": base64,
				"visitanteIdentificacion":visitanteIdentificacion
			},
			success:function (response){
				alert("correcto")
			},
			error:function (error){
				alert("error", error)
			}
		});
	});
}

function apagar() {
	Webcam.reset();
	tomarFoto.css("display", "none");
	verVideo.css("display", "block");
	camara.css("display", "none");

}
