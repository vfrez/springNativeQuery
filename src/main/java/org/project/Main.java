package org.project;

import org.project.withDTOReturn.service.NonWebServiceDTO;
import org.project.withEntity.service.NonWebServiceEntity;
import org.project.withEntityManager.service.NonWebServiceEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private NonWebServiceEntity nonWebServiceEntity;

    @Autowired
    private NonWebServiceDTO nonWebServiceDTO;

    @Autowired
    private NonWebServiceEntityManager nonWebServiceEntityManager;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        nonWebServiceEntity.callRepositoryWithEntityClass(args);
//        nonWebServiceDTO.getAllWithDTOResponse(args);
        nonWebServiceEntityManager.getAllWithEntityManager(args);
    }
}