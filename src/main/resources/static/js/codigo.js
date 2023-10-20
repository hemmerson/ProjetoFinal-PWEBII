function colocaPaciente(id, nome) {
    let pacId = document.getElementById("paciente_id");
    let pacNome = document.getElementById("paciente_nome");
    pacNome.value = nome;
    pacId.value = id;
    document.getElementById("pesquisa_paciente").value = "";
}

function colocaMedico(id, nome) {
    let medId = document.getElementById("medico_id");
    let medNome = document.getElementById("medico_nome");
    medNome.value = nome;
    medId.value = id;
}

// Função para filtrar pacientes com base no CPF digitado
function filtrarPacientes() {
    var input = document.getElementById("pesquisa_paciente");
    var filtro = input.value.toLowerCase();
    var pacientes = document.querySelectorAll(".pessoa-item");

    pacientes.forEach(function (paciente) {
        var cpf = paciente.querySelector("td:nth-child(2)").textContent.toLowerCase();
        if (cpf.includes(filtro)) {
            paciente.style.display = "";
        } else {
            paciente.style.display = "none";
        }
    });
}