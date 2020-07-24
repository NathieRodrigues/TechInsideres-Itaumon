function popularTabela(lista){
    var dtAlarme = 
        "<div class='row'> <div class='col-12'>" + 
        "<table border='1' cellpadding='15' width='80%' align='center'>" + 
        "<tr>" + 
            "<td>Alarme</td>" + 
            "<td>Quantidade no periodo</td>"+
        "</tr>";
 

        for (cont=0; cont<lista.length;cont++){
            dtAlarme+=
            "<tr>"+
            "<td>" + lista[cont].nomeAlarme + "</td>" +
            "<td>" + lista[cont].soma+ "</td>" +
            "</tr>";  
        }
        dtAlarme+="</table></div></div>";
        document.getElementById("alarmes").innerHTML = dtAlarme;
}

function filtrarAlarmes(){
    var data1 = new Date(document.getElementById("dataInicio").value);
    var dia1 = data1.getDate();
    var mes1 = data1.getMonth()+1;
    var ano1 = data1.getFullYear();
    var data2 = new Date(document.getElementById("dataFim").value);
    var dia2 = data2.getDate();
    var mes2 = data2.getMonth()+1;
    var ano2 = data2.getFullYear();

    data1 = dia1 + "/" +  mes1 + "/"+ ano1;
    data2 = dia2 + "/" +  mes2 + "/"+ ano2;

    var dados = 
    {
        inicio : data1,
        fim : data2
    }

    var pacote = {
        method:"POST",
        body:JSON.stringify(dados),
        headers:{
            "Content-type":"application/json"
        }
    }

    fetch("http://localhost:8080/alarmes/total", pacote)
    .then(res => res.json())
    .then(res => popularTabela(res))
    .catch(err => {
        window.alert("Erro pesquisa");
    });
}

function carregarAlarmes(){
    var usuario = localStorage.getItem("user");
    if (!usuario){
        window.location="index.html";
    }else{
        fetch("http://localhost:8080/alarmes")
        .then(res=> res.json())
        .then(res =>popularTabela(res));
    }
}

