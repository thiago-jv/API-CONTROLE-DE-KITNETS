Projeto demonstrativo para controle de kitnets cosumindo API externa de ViaCep(https://viacep.com.br/), utilizando SpringBoot, Rest Api, SpringData, Maven, PostgreSQL, Docker compose, MapStruct, RestTemplate, DTO e Design Patterns.

# Projeto Front-End
Apos rodas os passos abaixo, rodar o front-end nesse link [FRONT-END](https://github.com/thiago-jv/UI-CONTROLE-DE-KITNETS)

# Pré-requisitos

O maven deve está instalado, caso não esteja segue o link [maven](https://dicasdejava.com.br/como-instalar-o-maven-no-windows/)

Instalar e configurar o java, caso não esteja segue o link [java](https://medium.com/beelabacademy/configurando-vari%C3%A1veis-de-ambiente-java-home-e-maven-home-no-windows-e-unix-d9461f783c26)


# Estrutura do projeto

![Estrutura do Projeto](https://github.com/thiago-jv/API-CONTROLE-DE-KITNETS/blob/main/estrutura-projeto.png)

# ViaCep

![ViaCep](https://github.com/thiago-jv/API-CONTROLE-DE-KITNETS/blob/main/cep.png)

# Documentação do projeto - Swagger API

![Swagger API](https://github.com/thiago-jv/API-CONTROLE-DE-KITNETS/blob/main/Swagger-API.png)


# Tecnologias utilizadas e outros

 
 1- Java 11 [Sobre](https://www.zup.com.br/blog/java-11-principais-novidades)
 
 2- SpringBoot 2.1.4.RELEASE [Sobre](https://docs.spring.io/spring-boot/docs/current/reference/html/)
 
 3- SpringData [Sobre](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference) 

 4- RestTemplate [Sobre](https://www.baeldung.com/rest-template) 
 
 5- API REST [Sobre](https://www.redhat.com/pt-br/topics/api/what-is-a-rest-api)
 
 6- Maven 3.6.3 [Sobre](https://www.dclick.com.br/2010/09/15/o-que-e-o-maven-e-seus-primeiros-passos-com-a-ferramenta/)
 
 7- PostgreSQL + pgadmin4 - docker [Sobre](https://hub.docker.com/_/postgres)
 
 8- Docker compose [Sobre](https://www.docker.com/)
 
 9- Ireport Designer [Sobre](https://community.jaspersoft.com/) 
 
 

# Proceso para rodar o projeto
```
1- git int na sua pasta que irá baixar o projeto, caso não tenha criado o repositorio local.
2- git clone https://github.com/thiago-jv/API-CONTROLE-DE-KITNETS.git
3- Entrar dentro da pasta do projeto sis.apartamentos.com.br
4- mvn dependency:resolve
5- mvn dependency:tree
6- mvn package
7- mvn spring-boot:run
```
