# Rest API - Petz
## Tecnologias utilizadas
* SpringBoot
* Spring Data JPA
* Lombok
* Postgres
* Open API / Swagger
* Rest Assured
* Flyway
* Docker
* Docker Compose
#
## Para iniciar base de dados,acesse: 
_**/petz-api**_ e digite: _**docker-compose up**_. 
Com isso a base,**petz**, será iniciada, com as tabelas **cliente** e **pet**, com alguns registros iniciais.
#
## Links
### Documentação da API
* http://localhost:8080/swagger-ui.html
### Postman(endpooints configurados)
* https://www.getpostman.com/collections/a4207217acc97b365b65
#
## Autneticação
**Utilizei autenticação simples_(Basic Auth), com usuario em memória_, só para não deixar totalmente aberta.**
* Username:petz 
* Password:petz
#
## Obs:Em uma aplicação teria usado OAuth2 com requisição e validação de tokins.
