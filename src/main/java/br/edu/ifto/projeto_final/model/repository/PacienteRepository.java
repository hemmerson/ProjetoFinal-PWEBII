package br.edu.ifto.projeto_final.model.repository;

import br.edu.ifto.projeto_final.model.entity.Paciente;
import br.edu.ifto.projeto_final.model.entity.Role;
import br.edu.ifto.projeto_final.model.entity.RolesEnum;
import br.edu.ifto.projeto_final.model.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
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
        role.setId(RolesEnum.ROLE_PACIENTE.getRoleId());
        paciente.getUsuario().setRoles(role);
        em.persist(paciente);
    }

    public Paciente paciente(Long id) {
        return em.find(Paciente.class, id);
    }

    public Paciente paciente(String auth) {
        String sql = "select p from Paciente p JOIN p.usuario u where u.login = :login";
        TypedQuery<Paciente> query = em.createQuery(sql, Paciente.class);
        query.setParameter("login", auth);
        return query.getSingleResult();
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

