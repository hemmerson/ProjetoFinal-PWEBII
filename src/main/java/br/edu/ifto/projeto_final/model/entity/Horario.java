package br.edu.ifto.projeto_final.model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 14/12/2023
 */
@Entity
public class Horario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime horario;
    private String nomePaciente;
    private String telefonePaciente;
    private String emailPaciente;
    private String status = "Indisponível";

    @ManyToOne
    private Agendamento agendamento;
    public Horario() {
    }

    public Horario(Long id, LocalTime horario, String nomePaciente, String telefonePaciente, String emailPaciente, String status) {
        this.id = id;
        this.horario = horario;
        this.nomePaciente = nomePaciente;
        this.telefonePaciente = telefonePaciente;
        this.emailPaciente = emailPaciente;
        this.status = status;
    }

    public Horario(Long id, LocalTime horario, String nomePaciente, String telefonePaciente, String emailPaciente, String status, Agendamento agendamento) {
        this.id = id;
        this.horario = horario;
        this.nomePaciente = nomePaciente;
        this.telefonePaciente = telefonePaciente;
        this.emailPaciente = emailPaciente;
        this.status = status;
        this.agendamento = agendamento;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getTelefonePaciente() {
        return telefonePaciente;
    }

    public void setTelefonePaciente(String telefonePaciente) {
        this.telefonePaciente = telefonePaciente;
    }

    public String getEmailPaciente() {
        return emailPaciente;
    }

    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }
}
