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
public class Medico extends Pessoa implements Serializable {

    private String crm;
    @OneToMany(mappedBy = "medico")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Consulta> consultas;

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
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
