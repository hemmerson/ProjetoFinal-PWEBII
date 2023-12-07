package br.edu.ifto.projeto_final.model.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.util.List;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 24/08/2023
 */

@Entity
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class Paciente extends Pessoa implements Serializable {
    @NotBlank(message = "Digite o CPF do paciente")
    @CPF(message = "Digite um CPF válido")
    private String cpf;
    private String planoSaude;

    @OneToMany(mappedBy = "paciente")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private List<Consulta> consultas;

    @Valid
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Paciente() {
    }

    public Paciente(String cpf, String planoSaude, List<Consulta> consultas) {
        this.cpf = cpf;
        this.planoSaude = planoSaude;
        this.consultas = consultas;
    }


    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(String planoSaude) {
        this.planoSaude = planoSaude;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double totalConsultas(){
        double total = 0;
        for (Consulta c: getConsultas()){
            total += c.getValor();
        }
        return total;
    }
}
