package org.project.withDTOReturn.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface BasicPessoaDTO {

    Long getId();
    String getNome();
    String getSobrenome();
    LocalDate getDataNascimento();
    LocalDateTime getDataCadastro();
    LocalDateTime getDataAtualizacao();
    String getObservacao();
}