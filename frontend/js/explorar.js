const usuarioId =
localStorage.getItem("usuarioId");

fetch("http://localhost:8080/prendas")

.then(res=>res.json())

.then(prendas=>{
    prendas.forEach(prenda=>{
        crearCard(prenda);
    });
});

function crearCard(prenda){

let contenedor;

switch(prenda.categoria){

case "REMERA":
contenedor =
document.getElementById("remeras-container");
break;

case "TOP":
contenedor =
document.getElementById("top-container");
break;

case "ABRIGO":
contenedor =
document.getElementById("abrigos-container");
break;

case "SHORT":
contenedor =
document.getElementById("shorts-container");
break;

case "PANTALON":
contenedor =
document.getElementById("pantalones-container");
break;

case "POLLERA":
contenedor =
document.getElementById("polleras-container");
break;

case "CALZADO":
contenedor =
document.getElementById("calzado-container");
break;

case "ACCESORIO":
contenedor =
document.getElementById("accesorios-container");
break;

case "VESTIDO":
contenedor =
document.getElementById("vestidos-container");
break;
}

if(!contenedor){
    return;
}

contenedor.innerHTML += `
<div class="item-explorar">
<img 
class="img-prenda-explorar"
src="${prenda.imagen || '../img/boxynegra.png'}">
<p class="titulo-prenda">
${prenda.nombre}
</p>
<button 
class="boton-agregar"
onclick="agregarAlArmario(${prenda.id})">
+
</button>
</div>

`;
}

function agregarAlArmario(id){

fetch(
`http://localhost:8080/armario/${usuarioId}/agregar/${id}`,
{

method:"POST"

})

.then(res=>{

if(res.ok){
    alert("Prenda agregada 💛");
}else{
    alert("Ya tenés esta prenda");
}
});
}