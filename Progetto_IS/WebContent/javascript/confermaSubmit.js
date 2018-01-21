function confermaSubmit(form) {
 if (confirm("Confermi l'operazione ?")) {
  form.submit();
 }
 else {
  alert("Hai annullato l'operazione!");
 }
}