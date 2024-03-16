Projeto demonstrativo para controle de kitnets cosumindo API externa de ViaCep(https://viacep.com.br/), utilizando Java11, SpringBoot, Rest Api, SpringData, Maven, PostgreSQL, Docker compose, MapStruct, RestTemplate, DTO, Design Patterns, lombok, mensageria com rabbitmq e restassured.

# Projeto Front-End
Após rodas os passos abaixo, rodar o front-end nesse link [FRONT-END](https://github.com/thiago-jv/UI-CONTROLE-DE-KITNETS)

# RabbitMQ MailSend
API para consumir o tópico APARTAMENTO_EMAIL, onde posteriormente irá ser enviado via email com sendgrid, pois o objetivo é manter o cliente informado dos alugueis realizados https://github.com/thiago-jv/API_EMAIL_SENDGRID_RABBITMQ

# Estrutura
![estrutura](https://github.com/thiago-jv/API-CONTROLE-DE-KITNETS/blob/main/estrutura_nova.png)

# Passos

```
1- git clone https://github.com/thiago-jv/API-CONTROLE-DE-KITNETS.git
2- API-CONTROLE-DE-KITNETS\apartamento
3- docker compose up --build backend
```
![docker](https://github.com/thiago-jv/API-CONTROLE-DE-KITNETS/blob/main/dokcer_running.png)
![pg-admin](https://github.com/thiago-jv/API-CONTROLE-DE-KITNETS/blob/main/bancodb.png)
![token](https://github.com/thiago-jv/API-CONTROLE-DE-KITNETS/blob/main/postman.png)
![swagger](https://github.com/thiago-jv/API-CONTROLE-DE-KITNETS/blob/main/Swagger.png)

# Api de terceiros
![viacep](https://github.com/thiago-jv/API-CONTROLE-DE-KITNETS/blob/main/cep.png)

# Arquitetura
![arquitetura](https://github.com/thiago-jv/API-CONTROLE-DE-KITNETS/blob/main/arquitetura_sisapartamento.png)

# Rabbitmq
![rabbitmq](https://github.com/thiago-jv/API-CONTROLE-DE-KITNETS/blob/main/rabbitmq.png)

# Tecnologias utilizadas e outros

 
 1- Java 11 [Sobre](https://www.zup.com.br/blog/java-11-principais-novidades)
 
 2- SpringBoot 2.7.5.RELEASE [Sobre](https://docs.spring.io/spring-boot/docs/current/reference/html/)
 
 3- SpringData [Sobre](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference) 

 4- RestTemplate [Sobre](https://www.baeldung.com/rest-template) 
 
 5- API REST [Sobre](https://www.redhat.com/pt-br/topics/api/what-is-a-rest-api)
 
 6- Maven 3.6.3 [Sobre](https://www.dclick.com.br/2010/09/15/o-que-e-o-maven-e-seus-primeiros-passos-com-a-ferramenta/)
 
 7- PostgreSQL + pgadmin4 - docker [Sobre](https://hub.docker.com/_/postgres)
 
 8- Docker compose [Sobre](https://www.docker.com/)
 
 9- Ireport Designer 6.20 [Sobre](https://sourceforge.net/projects/jasperstudio/files/JaspersoftStudio-6.20.0/) 
 
 10- SpringFox [Sobre](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api)
 
 11- Spring Security - OAuth 2 e JWT [Sobre](https://www.baeldung.com/spring-security-oauth-jwt)
 

