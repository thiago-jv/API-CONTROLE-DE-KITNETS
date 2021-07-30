Projeto demonstrativo de ordem de serviço, utilizando Spring Boot, Rest Api, Spring Data JPA, Swagger, Maven e H2 Database.


# Pré-requisitos

O maven deve está instalado, caso não esteja segue o link [maven](https://dicasdejava.com.br/como-instalar-o-maven-no-windows/)

Instalar e configurar o java, caso não esteja segue o link [java](https://medium.com/beelabacademy/configurando-vari%C3%A1veis-de-ambiente-java-home-e-maven-home-no-windows-e-unix-d9461f783c26)


# Diagrama do projeto

![Ordem de Serviço](https://github.com/thiago-jv/thiago-jv-API_Rest-SpringBoot-SpringData-Swagger-TDD-H2/blob/main/Ordem%20de%20Servi%C3%A7o.png)


# Estrutura do projeto

![Estrutura do Projeto](https://github.com/thiago-jv/thiago-jv-API_Rest-SpringBoot-SpringData-Swagger-TDD-H2/blob/main/Estrutura%20do%20projeto.png)


# Tecnologias utilizadas e outros

 
 1- Java 8 [Sobre](https://www.java.com/pt-BR/download/help/java8_pt-br.html)
 
 2- H2 Database [Sobre](https://www.h2database.com/html/main.html)
 
 3- SpringBoot 1.5.4.RELEASE [Sobre](https://docs.spring.io/spring-boot/docs/current/reference/html/)
 
 4- SpringData [Sobre](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference) 
 
 5- Maven 3.6.3 [Sobre](https://www.dclick.com.br/2010/09/15/o-que-e-o-maven-e-seus-primeiros-passos-com-a-ferramenta/)
 
 6- API REST [Sobre](https://www.redhat.com/pt-br/topics/api/what-is-a-rest-api)
 
 7- TDD [Sobre](https://www.treinaweb.com.br/blog/afinal-o-que-e-tdd/)
 
 8- Swagger 2 [Sobre](https://medium.com/@ronilsonribeiro/como-interpretar-um-swagger-cdc331b68804)


# Proceso para rodar o projeto
```
1- git int na sua pasta que irá baixar o projeto, caso não tenha criado o repositorio local.
2- git clone https://github.com/thiago-jv/thiago-jv-API_Rest-SpringBoot-SpringData-Swagger-TDD-H2.git
3- Entrar dentro da pasta do projeto br.com.thiago.servico
4- mvn dependency:resolve
5- mvn dependency:tree
6- mvn package
7- mvn spring-boot:run
```

# Acesso ao banco H2

![Acesso H2](https://github.com/thiago-jv/thiago-jv-API_Rest-SpringBoot-SpringData-Swagger-TDD-H2/blob/main/H2-Home.png)

![Tables H2](https://github.com/thiago-jv/thiago-jv-API_Rest-SpringBoot-SpringData-Swagger-TDD-H2/blob/main/H2-tables.png)

# Documentação do sistema com Swagger
http://localhost:8080/swagger-ui.html#/

![Swagger](https://github.com/thiago-jv/thiago-jv-API_Rest-SpringBoot-SpringData-Swagger-TDD-H2/blob/main/Swagger.png)

```
Com a API em no ar, os testes podem ser realizados, porem caso queira testar os testes de integrações e endPoints criados, será necessáio abrir o projeto no IDE-ECLIPSE e testar os itens na seguinte sequencia, no seguinte caminho src/teste/java->
1- Tipo Equipamento
2- Equipamento
3- Profissional
4- Cliente
5- Servico
Os passo acima devem ser seguidos para os testes no PostMan.
```
