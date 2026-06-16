const idSesion = localStorage.getItem("usuarioId");

if(!idSesion){
    window.location.href = "iniciarsesion.html";
}