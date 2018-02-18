document.addEventListener("DOMContentLoaded", function() {
    var elements = document.getElementsByClassName("form-control");
    for (var i = 0; i < elements.length; i++) {
        elements[i].oninvalid = function(e) {
            e.target.setCustomValidity("");
            if (!e.target.validity.valid) {
                e.target.setCustomValidity("Campo Obbligatorio");
            }
        };
        elements[i].oninput = function(e) {
            e.target.setCustomValidity("");
        };
    }
});

function checkDatiRegistrazione(){

	event.preventDefault();

	var nome = document.getElementById("nome").value;
	var cognome = document.getElementById("cognome").value;
	var dataDiNascita = document.getElementById("dataDiNascita").value;
	var luogoDiNascita = document.getElementById("luogoDiNascita").value;
	var residenza = document.getElementById("residenza").value;
	var matricolaStudente = document.getElementById("matricolaStudente").value;
	var telefono = document.getElementById("telefono").value;
	var matricolaTutorAccademico = document.getElementById("matricolaTutorAccademico").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	var confermaPassword = document.getElementById("confermaPassword").value;
	
	
	
	var emailFilter = /^([a-zA-Z0-9_.-])+@studenti.unisa.it+$/;
	var matricolaFilter = /^051210+([0-9]{4})+$/;

	if (!emailFilter.test(email)) {
		alert('Inserisci una email universitaria!');
		return;
	}
	else if (!matricolaFilter.test(matricolaStudente)) {
		alert('Inserisci una matricola del dipartimento di informatica!');
		return;
	}

	else if (password !== confermaPassword) {
		alert('Inserisci due password corrispondenti!');
			return;
	}
	else{
		
		registrazioneForm.submit();
	}
}


function checkDatiModifica(){

	event.preventDefault();

	var matricolaStudente = document.getElementById("matricolaStudente").value;
	var email = document.getElementById("email").value;
	
	var emailFilter = /^([a-zA-Z0-9_.-])+@studenti.unisa.it+$/;
	var matricolaFilter = /^051210+([0-9]{4})+$/;

	if (!emailFilter.test(email)) {
		alert('Inserisci una email universitaria!');
		return;
	}
	else if (!matricolaFilter.test(matricolaStudente)) {
		alert('Inserisci una matricola del dipartimento di informatica!');
		return;
	}
	else{
		
		registrazioneForm.submit();
	}
}


function checkRicerca(){

	event.preventDefault();

	var nomeAzienda = document.getElementById("nomeAzienda").value;
	var localitaAzienda = document.getElementById("localitaAzienda").value;


	if ((nomeAzienda==="") && (localitaAzienda ==="")) {
		alert('Inserisci almeno un campo!');
		return;
	}
	else{
		
		registrazioneForm.submit();
	}
}
/*
function confermaOperazione() {
    if( confirm("Sicuro?") ) {
        return true;
    }
    else {
        return false;
    }
}

*/