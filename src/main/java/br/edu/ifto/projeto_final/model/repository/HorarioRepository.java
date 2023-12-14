package br.edu.ifto.projeto_final.model.repository;

import br.edu.ifto.projeto_final.model.entity.Horario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 14/12/2023
 */
@Repository
public class HorarioRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Horario horario) {
        em.persist(horario);
    }

    public Horario horario(Long id) {
        return em.find(Horario.class, id);
    }

    public List<Horario> horarios(){
        Query query = em.createQuery("from Horario");
        return query.getResultList();
    }
    public void remove(Long id){
        Horario m = em.find(Horario.class,id);
        em.remove(m);
    }
    public void update(Horario horario){
        em.merge(horario);
    }
}
