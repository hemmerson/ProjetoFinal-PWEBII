function colocaPaciente(id, nome) {
    let pacId = document.getElementById("paciente_id");
    let pacNome = document.getElementById("paciente_nome");
    pacNome.value = nome;
    pacId.value = id;
}

function colocaMedico(id, nome) {
    let medId = document.getElementById("medico_id");
    let medNome = document.getElementById("medico_nome");
    medNome.value = nome;
    medId.value = id;
}