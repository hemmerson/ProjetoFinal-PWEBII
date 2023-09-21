package br.edu.ifto.projeto_final.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.List;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 24/08/2023
 */

@Entity
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class Paciente extends Pessoa implements Serializable {
    private String telefone;
    @OneToMany(mappedBy = "paciente")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Consulta> consultas;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Double totalConsultas(){
        double total = 0;
        for (Consulta c: getConsultas()){
            total += c.getValor();
        }
        return total;
    }
}
