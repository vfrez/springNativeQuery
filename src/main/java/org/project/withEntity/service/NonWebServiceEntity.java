package org.project.withEntity.service;

import org.project.withEntity.entity.PessoaEntity;
import org.project.withEntity.repository.PessoaEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonWebServiceEntity {

    @Autowired
    private PessoaEntityRepository pessoaRepository;

    public void callRepositoryWithEntityClass(String[] args) {
        getWithJpaQuery(args);
        getWithNativeQuery(args);
    }

    private void getWithJpaQuery(String[] args) {
        getAllJpaPessoa(args);
    }

    private void getWithNativeQuery(String[] args) {
        getAllNativePessoa(args);
        getByIdNativePessoa(args);
    }

    private void getAllJpaPessoa(String[] args) {
        List<PessoaEntity> pessoaList = pessoaRepository.findAll();
        pessoaList.forEach(pessoa -> {
            System.out.println(String.format("JPA -> Id: %s Nome: %s", pessoa.getId(), pessoa.getNome()));
        });
    }

    private void getAllNativePessoa(String[] args) {
        List<PessoaEntity> pessoaList = pessoaRepository.findAllNative();
        pessoaList.forEach(pessoa -> {
            System.out.println(String.format("Native -> Id: %s Nome: %s", pessoa.getId(), pessoa.getNome()));
        });
    }

    private void getByIdNativePessoa(String[] args) {
        List<PessoaEntity> pessoaList = pessoaRepository.findByIdNative(11L);
        pessoaList.forEach(pessoa -> {
            System.out.println(String.format("Native by Id -> Id: %s Nome: %s", pessoa.getId(), pessoa.getNome()));
        });
    }
}
