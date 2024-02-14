package org.project.withEntity.repository;

import org.project.withEntity.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaEntityRepository extends JpaRepository<PessoaEntity, Long> {

    @Query(value = "select * from PESSOA p", nativeQuery=true)
    List<PessoaEntity> findAllNative();

    @Query(value = "select * from PESSOA p where p.id = ?1", nativeQuery=true)
    List<PessoaEntity> findByIdNative(Long idPessoa);
}
