package br.edu.ifto.projeto_final.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 14/12/2023
 */
@Entity
public class Agendamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @FutureOrPresent
    private LocalDate data;
    private boolean disponivel;

    @ManyToOne
    private Medico medico;

    @OneToMany(mappedBy = "agendamento")
    private List<Horario> horarios = new ArrayList<>();

    public Agendamento() {
    }

    public Agendamento(Long id, LocalDate data, boolean disponivel) {
        this.id = id;
        this.data = data;
        this.disponivel = disponivel;
    }

    public Agendamento(Long id, LocalDate data, boolean disponivel, Medico medico, List<Horario> horarios) {
        this.id = id;
        this.data = data;
        this.disponivel = disponivel;
        this.medico = medico;
        this.horarios = horarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
