package br.edu.ifto.aula02.model.dao;


import br.edu.ifto.aula02.model.entity.Pessoa;
import br.edu.ifto.aula02.model.entity.PessoaFisica;
import br.edu.ifto.aula02.model.entity.PessoaJuridica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PessoaFisicaRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(PessoaFisica pessoaFisica){
        em.persist(pessoaFisica);
    }

    public List<PessoaFisica> pessoas() {
        Query query = em.createQuery("from PessoaFisica");
        return query.getResultList();
    }

    public PessoaFisica pessoa(Long id){
        return em.find(PessoaFisica.class, id);
    }

    public void remove(Long id){
        PessoaFisica pessoaFisica = em.find(PessoaFisica.class, id);
        em.remove(pessoaFisica);
    }

    public void update(PessoaFisica pessoaFisica){
        em.merge(pessoaFisica);
    }






}
