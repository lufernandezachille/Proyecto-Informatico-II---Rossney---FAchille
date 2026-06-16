const formulario = document.querySelector("form");

formulario.addEventListener("submit", function(e){

    e.preventDefault();

    const email =
    document.querySelector('input[type="email"]').value;

    const password =
    document.querySelector('input[type="password"]').value;

    fetch("http://localhost:8080/usuarios/login", {

        method:"POST",

        headers:{
            "Content-Type":"application/json"
        },

        body:JSON.stringify({
            email:email,
            password:password
        })
    })

    .then(res=>{
        if(!res.ok){
            throw new Error("Datos incorrectos");
        }
        return res.json();
    })

    .then(usuario=>{
        localStorage.setItem(
            "usuarioId",
            usuario.id
        );

        localStorage.setItem(
            "usuario",
            JSON.stringify(usuario)
        );
        window.location.href="explorar.html";
    })

    .catch(error=>{
        alert(error.message);
    });
});