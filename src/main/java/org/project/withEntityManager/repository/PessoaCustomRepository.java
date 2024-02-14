package org.project.withEntityManager.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PessoaCustomRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Object[]> getAllCustomResult() {
        Query nativeQuery = (Query) entityManager.createNativeQuery("SELECT * FROM PESSOA;");
        List<Object[]> results = nativeQuery.getResultList();
        return results;
    }

    public List<Object[]> getByIdCustomResult(Long id) {
        Query nativeQuery = (Query) entityManager.createNativeQuery("SELECT * FROM PESSOA p WHERE p.ID = :pessoaId ;");
        nativeQuery.setParameter("pessoaId", id);

        return nativeQuery.getResultList();
    }

}
