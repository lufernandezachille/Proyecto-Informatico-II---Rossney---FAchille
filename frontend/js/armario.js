const usuarioId = localStorage.getItem("usuarioId");

console.log("SESION:", usuarioId);

fetch(`http://localhost:8080/armario/${usuarioId}`)
.then(res => res.json())
.then(lista => {

    console.log("ARMARIO:", lista);

    lista.forEach(usuarioPrenda => {

        console.log("ITEM:", usuarioPrenda);

        const prenda = usuarioPrenda.prenda ?? usuarioPrenda;

        if(!prenda || !prenda.categoria){
            console.warn("Prenda inválida:", usuarioPrenda);
            return;
        }

        let contenedor = null;

        switch(prenda.categoria){

            case "REMERA":
                contenedor = document.getElementById("remeras-container");
                break;

            case "TOP":
                contenedor = document.getElementById("top-container");
                break;

            case "ABRIGO":
                contenedor = document.getElementById("abrigos-container");
                break;

            case "SHORT":
                contenedor = document.getElementById("shorts-container");
                break;

            case "PANTALON":
                contenedor = document.getElementById("pantalones-container");
                break;

            case "POLLERA":
                contenedor = document.getElementById("polleras-container");
                break;

            case "ACCESORIO":
                contenedor = document.getElementById("accesorios-container");
                break;

            case "CALZADO":
                contenedor = document.getElementById("calzado-container");
                break;

            case "VESTIDO":
                contenedor = document.getElementById("vestidos-container");
                break;
        }

        if(!contenedor){
            console.log("No hay categoria:", prenda.categoria);
            return;
        }

        contenedor.innerHTML += `
            <div class="item-explorar">
                <img 
                    class="img-prenda-explorar"
                    src="${prenda.imagen || '../img/boxynegra.png'}"
                >

                <p class="titulo-prenda">
                    ${prenda.nombre}
                </p>

                <button 
                    class="boton-agregar"
                    onclick="quitarDelArmario(${prenda.id})"
                >
                    x
                </button>
            </div>
        `;
    });
});

function quitarDelArmario(prendaId){

    fetch(`http://localhost:8080/armario/${usuarioId}/quitar/${prendaId}`, {
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

cargarFavoritos();

function cargarFavoritos(){

    fetch(`http://localhost:8080/favoritos/usuario/${usuarioId}`)
    .then(res => res.json())
    .then(favoritos => {

        const contenedor = document.getElementById("outfits-container");

        contenedor.innerHTML = "";

        favoritos.forEach(favorito => {

            console.log("FAVORITO:", favorito);

            const outfit = favorito.outfit;

            if(!outfit || !outfit.prendas){
                console.warn("Outfit inválido:", outfit);
                return;
            }

            let html = `
                <div class="outfit-card">
                    <div class="outfit-prendas">
            `;

            outfit.prendas.forEach(up => {

                const prenda = up.prenda ?? up;

                if(!prenda){
                    return;
                }

                html += `
                    <img
                        class="prenda-outfit"
                        src="${prenda.imagen || '../img/boxynegra.png'}"
                    >
                `;
            });

            html += `
                    </div>
                    <p class="titulo-prenda-outfit">
                        Outfit ${outfit.id}
                    </p>

                    <button
                        class="boton-eliminar-outfit"
                        onclick="eliminarFavorito(${favorito.id})"
                    >
                        x
                    </button>
                </div>
            `;

            contenedor.innerHTML += html;
        });
    });
}

function eliminarFavorito(id){

    fetch(`http://localhost:8080/favoritos/${id}`, {
        method:"DELETE"
    })
    .then(res => {
        if(res.ok){
            location.reload();
        }
    });
}