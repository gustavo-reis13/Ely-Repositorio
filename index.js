function novo() {
    var form = document.getElementById("formulario");
    var lista = document.getElementById("lista");

    form.style.display = "block";
    lista.style.display = "none";

    var nome = document.getElementById("nome");
    var cor = document.getElementById("cor");
    var qtd = document.getElementById("qtd");
    var preco = document.getElementById("preco");
    var tamanho = document.getElementById("categoria");
    nome.value = '';
    cor.value = '';
    qtd.value = '';
    preco.value = '';
    categoria.value = '';
}

function salvar() {
    var p = {};
    p.nome = document.getElementById("nome").value;
    p.cor = document.getElementById("cor").value;
    p.qtd = document.getElementById("qtd").value;
    p.preco = document.getElementById("preco").value;
    p.categoria = document.getElementById("categoria").value;

    var body = JSON.stringify(p)
    fetch("http://localhost:8080/Trabalho_Ely/eletronicos",
        {
            method:"POST",
            body: body
        }
    ).then(resp => resp.json())
    .then(function(retorno){
        alert(retorno.mensagem);
    });
}

function cancelar() {
    var form = document.getElementById("formulario");
    var lista = document.getElementById("lista");
    form.style.display = "none";
    lista.style.display = "block";

}

function listar() {
    fetch("http://localhost:8080/Trabalho_Ely/eletronicos")
        .then(resp => resp.json())
        .then(dados => mostrar(dados));
}
function mostrar(dados) {
    var lista = document.getElementById("dados");
    console.log(dados)

    lista.innerHTML = "";
    for (var i in dados) {
        lista.innerHTML += "<tr>"
            + "<td>" + dados[i].nome + "</td>"
        +"<td>" + dados[i].cor + "</td>"
        +"<td>" + dados[i].qtd + "</td>"
        +"<td>" + dados[i].preco + "</td>"
        +"<td>" + dados[i].tamanho + "</td>"
        +"<td>?</td>"
        +"</tr>"
    }
}

listar()