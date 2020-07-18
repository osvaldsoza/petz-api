# Rest API - Petz
## Tecnologias utilizadas
* STS
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
## Base de dados
### Acesse:
_**/petz-api**_ e digite: _**docker-compose up**_. 
Com isso a base,**petz**, será iniciada, com as tabelas **cliente** e **pet**, com alguns registros iniciais.
#
## Levantar a aplicação 
Após clonar o repositório, deverá abri-lo em uma IDE, de sua preferência, para projetos java.
Com a aplicação em execução, a mesma estará disponível na url:http://localhost:8080/nome_do_recurso
### IDE's recomendadas
* Intellij
* Eclipse
* STS
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
