package br.edu.ifto.projeto_final.model.repository;

import br.edu.ifto.projeto_final.model.entity.Paciente;
import br.edu.ifto.projeto_final.model.entity.Role;
import br.edu.ifto.projeto_final.model.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 25/08/2023
 */
@Repository
public class PacienteRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Paciente paciente) {
        Role role = new Role();
        role.setId(3L);
        paciente.getUsuario().setRoles(role);
        em.persist(paciente);
    }

    public Paciente paciente(Long id) {
        return em.find(Paciente.class, id);
    }

    public List<Paciente> pacientes(){
        Query query = em.createQuery("from Paciente");
        return query.getResultList();
    }

    public void remove(Long id){
        Paciente p = em.find(Paciente.class,id);
        em.remove(p);
    }

    public void update(Paciente paciente){
        em.merge(paciente);
    }

}
