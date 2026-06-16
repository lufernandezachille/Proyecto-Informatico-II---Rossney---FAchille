const formulario = document.querySelector("form");

formulario.addEventListener("submit", function(e){

e.preventDefault();

const nombre =
document.getElementById("nombre").value;

const email =
document.getElementById("mail").value;

const password =
document.getElementById("password").value;

fetch("http://localhost:8080/usuarios/registro", {

method:"POST",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify({
nombre:nombre,
email:email,
password:password
})
})

.then(res=>res.json())

.then(()=>{

alert("Cuenta creada");

window.location.href="iniciarsesion.html";

});
});