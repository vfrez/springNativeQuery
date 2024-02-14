package org.project.withDTOReturn.service;

import org.project.withDTOReturn.dto.BaseEntity;
import org.project.withDTOReturn.dto.BasicPessoaDTO;
import org.project.withDTOReturn.repository.PessoaDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonWebServiceDTO {

    @Autowired
    private PessoaDTORepository pessoaDTORepository;

    public void getAllWithDTOResponse(String[] args) {
        findAllBasicPessoaInfo(args);
        findAllPessoa(args);

    }

    private void findAllBasicPessoaInfo(String[] args) {
        List<BasicPessoaDTO> pessoaNative = pessoaDTORepository.findBasicPessoaNative();

        pessoaNative.forEach(pessoa -> {
            System.out.println(String.format("Basic Info -> Id: %s Nome: %s", pessoa.getId(), pessoa.getNome()));
        });
    }

    private void findAllPessoa(String[] args) {
        List<BaseEntity> pessoaNative = pessoaDTORepository.findPessoaNative();

        pessoaNative.forEach(pessoa -> {
            System.out.println(String.format("All Info -> Id: %s Nome: %s", pessoa.getId(), pessoa.getNome()));
        });
    }

}
