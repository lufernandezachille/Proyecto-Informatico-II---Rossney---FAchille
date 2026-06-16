let ultimoOutfit = null;

const usuarioId = localStorage.getItem("usuarioId");
console.log("usuarioId:", usuarioId);

function generarOutfit(tipo){

    console.log("usuarioId:", usuarioId);
    console.log("tipo:", tipo);

    fetch(`http://localhost:8080/outfits/random/${usuarioId}/${tipo}`)
    .then(res => {
        console.log("STATUS:", res.status);
        return res.json();
    })
    .then(outfit => {
        console.log("OUTFIT FINAL:", outfit);

        ultimoOutfit = outfit;
        mostrarOutfit(outfit);
    })
    .catch(err => {
        console.error("ERROR FETCH:", err);
    });
}

function mostrarOutfit(outfit){

    const contenedor = document.querySelector(".outfit-generado");

    if(!contenedor){
        console.error("No existe .outfit-generado en el HTML");
        return;
    }

    contenedor.innerHTML = "";

    outfit.prendas.forEach(up => {

        const prenda = up?.prenda ?? up;

        if(!prenda){
            console.warn("Prenda inválida:", up);
            return;
        }

        contenedor.innerHTML += `
            <img class="prenda"
                 src="${prenda.imagen || '../img/boxynegra.png'}"
                 alt="${prenda.nombre || 'prenda'}">
        `;
    });
}

function guardarOutfit(){

    if(!ultimoOutfit){
        alert("Generá un outfit primero");
        return;
    }

    if(!ultimoOutfit.id){
        alert("Error: outfit sin ID");
        return;
    }

    fetch(`http://localhost:8080/favoritos/${usuarioId}/${ultimoOutfit.id}`, {
        method: "POST"
    })
    .then(res => {
        if(!res.ok){
            throw new Error("Error guardando favorito");
        }
        return res.text();
    })
    .then(() => {
        alert("Guardado en favoritos 💛");
    })
    .catch(err => {
        console.error("ERROR FAVORITO:", err);
        alert("No se pudo guardar en favoritos");
    });
}

document.addEventListener("DOMContentLoaded", () => {

    const botonGenerar = document.querySelector(".boton-generar-outfit");
    const botonGuardar = document.querySelector("#guardarOutfit");

    console.log("botonGenerar:", botonGenerar);
    console.log("botonGuardar:", botonGuardar);

    if(botonGenerar){
        botonGenerar.addEventListener("click", () => {

            let tipo = window.location.href.includes("vestido")
                ? "VESTIDO"
                : "PARTES";

            generarOutfit(tipo);
        });
    }

    if(botonGuardar){
        botonGuardar.addEventListener("click", () => {
            guardarOutfit();
        });
    }
});