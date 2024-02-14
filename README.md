
Projeto rodando spring sem interface web e fazendo consultas SQL com instruções nativas

## Requisitos
Mysql8

## Executar
```bash
mvn spring-boot:run -Dspring-boot.run.arguments="argument1 argument2"
ou
mvn spring-boot:run
```

## Referencias
https://www.baeldung.com/spring-boot-command-line-arguments
https://stackoverflow.com/questions/71177494/is-it-possible-to-use-jparepository-without-entity

JPA with native query
https://www.bezkoder.com/jpa-native-query/

Return DTO on repository
https://thorben-janssen.com/spring-data-jpa-dto-native-queries/


## Configuração

Criar a tabela
```sql
CREATE TABLE `PESSOA` (
  `ID` decimal(10,0) NOT NULL,
  `NOME` varchar(100) NOT NULL,
  `SOBRENOME` varchar(250) DEFAULT NULL,
  `DATA_NASCIMENTO` date DEFAULT NULL,
  `DATA_CADASTRO` datetime NOT NULL,
  `DATA_ATUALIZACAO` datetime DEFAULT NULL,
  `OBSERVACAO` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```

Inserir dados
```sql
INSERT INTO PESSOA (ID,NOME,SOBRENOME,DATA_NASCIMENTO,DATA_CADASTRO,DATA_ATUALIZACAO,OBSERVACAO) VALUES
	 (10,'a','a','1990-01-01','2024-01-24 10:00:00','2024-01-24 10:00:00','1'),
	 (11,'b','b','1990-01-01','2024-01-24 10:00:00','2024-01-24 10:00:00','1');
```

Ajustar `application.yaml` com o database
```yaml
spring:  
  datasource:  
    url: jdbc:mysql://localhost:3306/%database%?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false  
    username: root  
    password: root  
    driver-class-name: com.mysql.cj.jdbc.Driver
```
