package org.project.withDTOReturn.repository;

import org.project.withDTOReturn.dto.BaseEntity;
import org.project.withDTOReturn.dto.BasicPessoaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaDTORepository extends JpaRepository<BaseEntity, Long> {

    @Query(value = "select p.ID as id, p.NOME as nome, p.SOBRENOME as sobrenome, p.DATA_NASCIMENTO as dataNascimento, p.DATA_CADASTRO as dataCadastro, p.DATA_ATUALIZACAO as dataAtualizacao, p.OBSERVACAO as observacao from PESSOA p", nativeQuery=true)
    List<BaseEntity> findPessoaNative();

    @Query(value = "select p.ID as id, p.NOME as nome from PESSOA p", nativeQuery=true)
    List<BasicPessoaDTO> findBasicPessoaNative();

}
