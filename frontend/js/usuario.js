function carregarUsuario(){

    var usuarioLogado = localStorage.getItem("user");
    if(!usuarioLogado){
        window.location="index.html";
    }else{   
    var usuarioJson = JSON.parse(usuarioLogado);

        document.getElementById("dados").innerHTML=
        "<h3>" + usuarioJson.nome + " (" + usuarioJson.racf + ") </h3>";

        document.getElementById("foto").innerHTML=
        "<img src=images/" + usuarioJson.foto + " width='20%' alt='Imagem não encontrada'>";
    }
}


function logout(){
    localStorage.removeItem("user");
    window.location="index.html";
}