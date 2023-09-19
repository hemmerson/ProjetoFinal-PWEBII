package br.edu.ifto.projeto_final.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 19/09/2023
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "seq_generator", sequenceName = "SEQ_PESSOA", initialValue = 11, allocationSize = 1)
public class Pessoa implements Serializable {

    @Id
    @Column(unique = true)
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private Long id;

    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
