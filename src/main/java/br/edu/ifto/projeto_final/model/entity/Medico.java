package br.edu.ifto.projeto_final.model.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 24/08/2023
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class Medico extends Pessoa implements Serializable {
    @NotBlank(message = "Digite o CRM do médico")
    private String crm;
    private String especialidade;

    @OneToMany(mappedBy = "medico")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private List<Consulta> consultas;

    @OneToMany(mappedBy = "medico")
    private List<Agendamento> agendamentos = new ArrayList<>();

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public Double totalConsultas(){
        double total = 0;
        for (Consulta c: getConsultas()){
            total += c.getValor();
        }
        return total;
    }
}
