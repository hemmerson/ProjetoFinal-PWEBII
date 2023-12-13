package br.edu.ifto.projeto_final.model.repository;

import br.edu.ifto.projeto_final.model.entity.Medico;
import br.edu.ifto.projeto_final.model.entity.Paciente;
import br.edu.ifto.projeto_final.model.entity.Role;
import br.edu.ifto.projeto_final.model.entity.RolesEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 25/08/2023
 */
@Repository
public class MedicoRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Medico medico) {
        Role role = new Role();
        role.setId(RolesEnum.ROLE_MEDICO.getRoleId());
        medico.getUsuario().setRoles(role);
        em.persist(medico);
    }

    public Medico medico(Long id) {
        return em.find(Medico.class, id);
    }

    public Medico medico(String auth) {
        String sql = "select m from Medico m JOIN m.usuario u where u.login = :login";
        TypedQuery<Medico> query = em.createQuery(sql, Medico.class);
        query.setParameter("login", auth);
        return query.getSingleResult();
    }

    public List<Medico> medicos(){
        Query query = em.createQuery("from Medico");
        return query.getResultList();
    }
    public void remove(Long id){
        Medico m = em.find(Medico.class,id);
        em.remove(m);
    }
    public void update(Medico medico){
        em.merge(medico);
    }

}
