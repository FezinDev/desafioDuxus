// const fomulario = document.querySelector("form");


// const url = "http://localhost:8080/api/contagem-franquias/";

const url = "http://localhost:8080/api/funcao-mais-comum/";

function buscar(){

    const IdataInicial = document.querySelector(".dataInicial").value;
    const IdataFinal = document.querySelector(".dataFinal").value;

    
    const api = document.querySelector(".api");

    fetch(url + IdataInicial + "/" + IdataFinal).then(result => {

        console.log(result);
        // api.value = String.valueOf(result);
        
    })

}

// fomulario.addEventListener('submit', function (event){


    
//     console.log(IdataInicial)
//     event.preventDefault();


//     console.log(IdataInicial)

//     fetch(url).then(result => {

//         console.log(IdataInicial)
        
//     })

// });

