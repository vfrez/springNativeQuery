package org.project.withEntityManager.service;

import org.project.withEntityManager.dto.PessoaDTO;
import org.project.withEntityManager.repository.PessoaCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonWebServiceEntityManager {

    @Autowired
    private PessoaCustomRepository pessoaCustomRepository;

    public void getAllWithEntityManager(String[] args) {
        findAllWithEManager(args);
        findAllWithEManagerAndDTO(args);
        findByIdWithEManagerAndDTO(args);
    }

    private void findAllWithEManager(String[] args) {
        List<Object[]> items = pessoaCustomRepository.getAllCustomResult();

        for (Object[] item : items) {
            System.out.println(String.format("All Entity manager -> Id: %s Nome: %s", item[0], item[1]));
        }
    }

    private void findAllWithEManagerAndDTO(String[] args) {
        List<Object[]> items = pessoaCustomRepository.getAllCustomResult();
        PessoaDTO pessoaDTO = new PessoaDTO();

        for (Object[] item : items) {
            pessoaDTO.setId(Long.valueOf(item[0].toString()));
            pessoaDTO.setNome(String.valueOf(item[1]));
            System.out.println(String.format("All Entity manager and DTO -> Id: %s Nome: %s", pessoaDTO.getId(), pessoaDTO.getNome()));
        }

    }

    private void findByIdWithEManagerAndDTO(String[] args) {
        List<Object[]> items = pessoaCustomRepository.getByIdCustomResult(11L);
        PessoaDTO pessoaDTO = new PessoaDTO();

        for (Object[] item : items) {
            pessoaDTO.setId(Long.valueOf(item[0].toString()));
            pessoaDTO.setNome(String.valueOf(item[1]));
            System.out.println(String.format("By Id Entity manager -> Id: %s Nome: %s", pessoaDTO.getId(), pessoaDTO.getNome()));
        }

    }


}
