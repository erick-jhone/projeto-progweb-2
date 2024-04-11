package br.edu.ifto.aula02.model.dao;

import br.edu.ifto.aula02.model.entity.PessoaJuridica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PessoaJuridicaRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(PessoaJuridica pessoaJuridica){
        em.persist(pessoaJuridica);
    }

    public List<PessoaJuridica> pessoas(){
        Query query = em.createQuery("from PessoaJuridica");
        return query.getResultList();
    }

    public PessoaJuridica pessoa(Long id){
        return em.find(PessoaJuridica.class, id);
    }

    public void remove(Long id){
        PessoaJuridica p = em.find(PessoaJuridica.class, id);
        em.remove(p);
    }

    public void update(PessoaJuridica pessoaJuridica){
        em.merge(pessoaJuridica);
    }
}
