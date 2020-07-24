function logar(){

    var usuario = document.getElementById("txtUsuario").value;
    var tamanho = usuario.length;
    var validaEmail = usuario.indexOf("@");
 
      if(tamanho==7){
      
        var dados={ 
        
            racf:usuario.toUpperCase(),
            senha:document.getElementById("txtSenha").value
        }
        
    } else{
 
        var dados={ 
        
            email:usuario,
            senha:document.getElementById("txtSenha").value
        }
    }

    var pacote={
        method:"POST",
        body:JSON.stringify(dados),
        headers:{
            "Content-type":"application/json"
        }
    }

    fetch("http://localhost:8080/login", pacote)
    .then(res => res.json())
    .then(res => {
        localStorage.setItem("user", JSON.stringify(res));
        window.location="usuario.html";
    })
    .catch(err => {
        window.alert("Usuario/senha incorreto");
    });
}