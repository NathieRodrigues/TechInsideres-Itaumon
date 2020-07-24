function popularTabela(lista){
    var dtEvento = 
        "<div class='row'> <div class='col-12'>" + 
        "<table id='excel' border='1' cellpadding='15' width='80%' align='center'>" + 
        "<tr>" + 
            "<td>Data</td>" + 
            "<td>Alarme</td>"+
            "<td>Equipamento</td>" +
        "</tr>";
 

        for (cont=0; cont<lista.length;cont++){
            dtEvento+=
            "<tr>"+
            "<td>" + lista[cont].data + "</td>" + 
            "<td>" + lista[cont].alarme.nome + "</td>" +
            "<td>" + lista[cont].equipamento.hostname + "</td>" +
            "</tr>";  
        }
        dtEvento+="</table></div></div>";
        document.getElementById("eventos").innerHTML = dtEvento;
}

function filtrarEventos(){
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

    fetch("http://localhost:8080/eventos/intervalo", pacote)
    .then(res => res.json())
    .then(res => popularTabela(res))
    .catch(err => {
        window.alert("Erro pesquisa");
    });
}

function carregarEventos(){
    var usuario = localStorage.getItem("user");
    if (!usuario){
        window.location="index.html";
    }else{
        fetch("http://localhost:8080/eventos")
        .then(res=> res.json())
        .then(res =>popularTabela(res));
    }
}

