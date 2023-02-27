let inputNomeNovaTarefa = document.querySelector('#inputNomeNovaTarefa');
let btnAddTarefa = document.querySelector('#btnAddTarefa');
let listaTarefas = document.querySelector('#listaTarefas');
let janelaEdicao = document.querySelector('#janelaEdicao');
let janelaEdicaoFundo = document.querySelector('#janelaEdicaoFundo');
let janelaEdicaoBtnFechar = document.querySelector('#janelaEdicaoBtnFechar');
let btnAtualizarTarefa = document.querySelector('#btnAtualizarTarefa');
let idTarefaEdicao = document.querySelector('#idTarefaEdicao');
let inputTarefaNomeEdicao = document.querySelector('#inputTarefaNomeEdicao');

inputNomeNovaTarefa.addEventListener('keypress', (e) => {
    if(e.key === 'Enter') {
        let tarefa = {
            nome: inputNomeNovaTarefa.value,
            id: gerarId()
        };
        adicionarTarefa(tarefa);
    }
});

btnAddTarefa.addEventListener('click', (e) => {
    let tarefa = {
        nome: inputNomeNovaTarefa.value,
        id: gerarId()
    }
    adicionarTarefa(tarefa);
});

function gerarId() {
    return Math.floor(Math.random() * 3000);
}

janelaEdicaoBtnFechar.addEventListener('click', (e) => {
    alternarJanelaEdicao();
});

btnAtualizarTarefa.addEventListener('click', (e) => {
    e.preventDefault();
    let idTarefa = idTarefaEdicao.innerHTML.replace('#', '');
    let tarefa = {
        nome: inputTarefaNomeEdicao.value,
        id: idTarefa
    }

    let tarefaAtual = document.getElementById('' + idTarefa + '');

    if(tarefaAtual) {
        let li = criaTagLi(tarefa);
        listaTarefas.replaceChild(li, tarefaAtual);
        alternarJanelaEdicao();
    } else {
        alert('Erro interno do sistema!');
    }

});

function adicionarTarefa(tarefa) {
    let li = criaTagLi(tarefa);
    listaTarefas.appendChild(li);
    inputNomeNovaTarefa.value = '';
}

function criaTagLi(tarefa) {
    let li = document.createElement('li');
    li.id = tarefa.id;

    let span = document.createElement('span');
    span.classList.add('textoTarefa');
    span.innerHTML = tarefa.nome;

    let div = document.createElement('div');

    let btnEditar = document.createElement('button');
    btnEditar.classList.add('btnAcao');
    btnEditar.innerHTML = '<i class="fa fa-pencil"></i>';
    btnEditar.setAttribute('onclick', 'editar('+tarefa.id+')');

    let btnExcluir = document.createElement('button');
    btnExcluir.classList.add('btnAcao');
    btnExcluir.innerHTML = '<i class="fa fa-trash"></i>';
    btnExcluir.setAttribute('onclick', 'excluir('+tarefa.id+')');

    div.appendChild(btnEditar);
    div.appendChild(btnExcluir);
    li.appendChild(span);
    li.appendChild(div);

    return li;
}

function editar(idTarefa) {
        let li = document.getElementById('' + idTarefa + '');
        if(li) {
            idTarefaEdicao.innerHTML = '#' + idTarefa;
            inputTarefaNomeEdicao.value = li.innerText;
            alternarJanelaEdicao();
        } else {
            alert('Erro interno do sistema!');
        }
}

function excluir(idTarefa) {
    let confirmacaoExcluir = window.confirm("Tem certeza que deseja excluir a tarefa?");
    if(confirmacaoExcluir) {
        let li = document.getElementById('' + idTarefa + '');
        if(li) {
            listaTarefas.removeChild(li);
        } else {
            alert('Erro interno do sistema!');
        }
    }
}

function alternarJanelaEdicao() {
    janelaEdicao.classList.toggle('abrir');
    janelaEdicaoFundo.classList.toggle('abrir');
}