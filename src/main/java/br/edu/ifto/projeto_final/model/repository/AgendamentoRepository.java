package br.edu.ifto.projeto_final.model.repository;

import br.edu.ifto.projeto_final.model.entity.Agendamento;
import br.edu.ifto.projeto_final.model.entity.Medico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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

    public List<Agendamento> agendamentos() {
        Query query = em.createQuery("from Agendamento");
        return query.getResultList();
    }

    public Agendamento agendamento(LocalDate data, Medico m) {
        String jpql = "SELECT a FROM Agendamento a WHERE a.data = :data and a.medico.id = :medico";

        TypedQuery<Agendamento> query = em.createQuery(jpql, Agendamento.class);
        query.setParameter("data", data);
        query.setParameter("medico", m.getId());
        try {
            return query.getSingleResult();
        }catch (RuntimeException e){
            Agendamento a = new Agendamento();
            return a;
        }
    }

    public void remove(Long id) {
        Agendamento m = em.find(Agendamento.class, id);
        em.remove(m);
    }

    public void update(Agendamento agendamento) {
        em.merge(agendamento);
    }
}
