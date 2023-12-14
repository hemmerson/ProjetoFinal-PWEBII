package br.edu.ifto.projeto_final.model.repository;

import br.edu.ifto.projeto_final.model.entity.Agendamento;
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
public class AgendamentoRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(Agendamento agendamento) {
        em.persist(agendamento);
    }

    public Agendamento agendamento(Long id) {
        return em.find(Agendamento.class, id);
    }

    public List<Agendamento> agendamentos(){
        Query query = em.createQuery("from Agendamento");
        return query.getResultList();
    }
    public void remove(Long id){
        Agendamento m = em.find(Agendamento.class,id);
        em.remove(m);
    }
    public void update(Agendamento agendamento){
        em.merge(agendamento);
    }
}
