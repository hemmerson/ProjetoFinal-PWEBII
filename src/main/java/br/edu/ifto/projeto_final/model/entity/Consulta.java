package br.edu.ifto.projeto_final.model.entity;

import br.edu.ifto.projeto_final.model.validation.groups.Insert;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 24/08/2023
 */

@Entity
public class Consulta implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotNull(message = "A data é obrigatória", groups = Insert.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime data;
    @NotNull(message = "Digite o valor da consulta", groups = Insert.class)
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser maior que zero.")
    private Double valor;
    @NotBlank(message = "Digite observações da consulta", groups = Insert.class)
    private String observacao;
    @ManyToOne
    @Valid
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Paciente paciente;
    @ManyToOne
    @Valid
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Medico medico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

}