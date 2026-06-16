const usuarioId = localStorage.getItem("usuarioId");

let ultimoOutfit = null;

document.addEventListener("DOMContentLoaded", () => {

    const boton = document.querySelector(".boton-generar-outfit");
    const btnGuardar = document.querySelector("#guardarOutfit");

    if (boton) {
        boton.addEventListener("click", () => {
            const tipo = obtenerTipoOutfit();
            generarOutfit(tipo);
        });
    }

    if (btnGuardar) {
        btnGuardar.addEventListener("click", () => {
            guardarOutfit();
        });
    }
});

function obtenerTipoOutfit(){

    if(window.location.href.includes("vestido")){
        return "VESTIDO";
    } else {
        return "PARTES";
    }
}

function generarOutfit(tipo){

    fetch(`http://localhost:8080/outfits/random/${usuarioId}/${tipo}`)
    .then(res => res.json())
    .then(outfit => {
        mostrarOutfit(outfit);
    })
    .catch(err => {
        console.log("Error generando outfit", err);
    });
}

function mostrarOutfit(outfit){

    const contenedor = document.querySelector(".outfit-generado");

    contenedor.innerHTML = "";

    outfit.prendas.forEach(up => {

        const prenda = up.prenda;

        contenedor.innerHTML += `
            <img 
                class="prenda"
                src="${prenda.imagen || '../img/boxynegra.png'}"
            >
        `;
    });
}

function guardarOutfit() {

    if (!ultimoOutfit) {
        alert("Primero generá un outfit");
        return;
    }

    fetch("http://localhost:8080/outfits/guardar", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(ultimoOutfit)
    })
    .then(res => res.json())
    .then(() => {
        alert("Outfit guardado 💛");
    })
    .catch(err => console.log(err));
}