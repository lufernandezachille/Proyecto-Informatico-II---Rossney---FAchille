const usuarioId = localStorage.getItem("usuarioId");

console.log("SESION:", usuarioId);

fetch(`http://localhost:8080/armario/${usuarioId}`)

.then(res=>res.json())

.then(lista=>{

console.log("ARMARIO:", lista);

lista.forEach(usuarioPrenda=>{
    crearCard(usuarioPrenda.prenda);
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

case "ACCESORIO":
enedor =
document.getElementById("accesorios-container");
break;

case "CALZADO":
contenedor =
document.getElementById("calzado-container");
break;

case "VESTIDO":
contenedor =
document.getElementById("vestidos-container");
break;
}

if(!contenedor){
console.log(
"No hay categoria:",
prenda.categoria
);
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
onclick="quitarDelArmario(${prenda.id})">
x
</button>
</div>

`;
}

function quitarDelArmario(prendaId){

fetch(
`http://localhost:8080/armario/${usuarioId}/quitar/${prendaId}`,
{
method:"DELETE"
})

.then(res=>{
if(res.ok){
alert("Eliminada 💛");
location.reload();
}else{
alert("No se pudo eliminar");
}
});
}

fetch(`http://localhost:8080/outfits/usuario/${usuarioId}`)
.then(res => res.json())
.then(outfits => {

    const contenedor = document.getElementById("outfits-container");

    outfits.forEach(outfit => {
        contenedor.innerHTML += `
            <div class="item-outfit">
                <p>Outfit ${outfit.tipo}</p>

                <button onclick="verOutfit(${outfit.id})">
                    Ver
                </button>
            </div>
        `;
    });
});

function verOutfit(id) {
    alert("Acá después mostramos el outfit completo 💛");
}