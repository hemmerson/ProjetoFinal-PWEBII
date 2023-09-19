package br.edu.ifto.projeto_final.model.repository;

import br.edu.ifto.projeto_final.model.entity.Consulta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 25/08/2023
 */
@Repository
public class ConsultaRepository {
    @PersistenceContext
    private EntityManager em;
    private PacienteRepository p;

    public void save(Consulta consulta) {
        em.persist(consulta);
    }

    public Consulta consulta(Long id) {
        return em.find(Consulta.class, id);
    }

    public List<Consulta> consultas(){
        Query query = em.createQuery("from Consulta");
        return query.getResultList();
    }

    public Double totalConsultas(){
        Query query = em.createQuery("select sum(valor) from Consulta");
        return (Double) query.getSingleResult();
    }

    public void remove(Long id){
        Consulta m = em.find(Consulta.class,id);
        em.remove(m);
    }

    public void update(Consulta consulta){
        em.merge(consulta);
    }

}
