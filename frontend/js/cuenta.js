const usuarioGuardado =
localStorage.getItem("usuario");

const sinSesion =
document.getElementById("sinSesion");

const conSesion =
document.getElementById("conSesion");

if(usuarioGuardado === null){
    sinSesion.style.display="block";

    conSesion.style.display="none";
}else{
    const usuario =
    JSON.parse(usuarioGuardado);

    sinSesion.style.display="none";

    conSesion.style.display="block";

    document.getElementById("nombreUsuario")
    .innerText = usuario.nombre;

    document.getElementById("emailUsuario")
    .innerText = usuario.email;

    document.getElementById("planUsuario")
    .innerText = usuario.plan;
}

document
.getElementById("cerrarSesion")
.addEventListener("click",()=>{
    localStorage.removeItem("usuario");

    localStorage.removeItem("usuarioId");

    window.location.reload();
});