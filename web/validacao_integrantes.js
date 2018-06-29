inputs = document.getElementsByTagName('input');
submit = document.querySelectorAll('input[type=submit]')[0];
submit.disabled = true;
	

for(var i = 0; i < inputs.length; i++) {
	inputs[i].addEventListener("focusout", validaTexto);
}

function validaTexto(){
	var contador = 0
	for(var i = 0; i < inputs.length; i++) {
			if(inputs[i].value != "") {
		       	contador++
		       	console.log(contador);
		    }
	}
	if (contador + 1 == inputs.length) {
		submit.disabled = false;
	}
};