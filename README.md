Projeto demonstrativo para controle de kitnets, utilizando SpringBoot, Rest Api, SpringData, Mavens, PostgreSQL, RestTemplate, DTO e Design Patterns.


# Pré-requisitos

O maven deve está instalado, caso não esteja segue o link [maven](https://dicasdejava.com.br/como-instalar-o-maven-no-windows/)

Instalar e configurar o java, caso não esteja segue o link [java](https://medium.com/beelabacademy/configurando-vari%C3%A1veis-de-ambiente-java-home-e-maven-home-no-windows-e-unix-d9461f783c26)


# Estrutura do projeto

![Estrutura do Projeto]()


# Tecnologias utilizadas e outros

 
 1- Java 8 [Sobre](https://www.java.com/pt-BR/download/help/java8_pt-br.html)
 
 2- SpringBoot 2.1.4.RELEASE [Sobre](https://docs.spring.io/spring-boot/docs/current/reference/html/)
 
 3- SpringData [Sobre](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference) 

 4- RestTemplate [Sobre](https://www.baeldung.com/rest-template) 
 
 5- API REST [Sobre](https://www.redhat.com/pt-br/topics/api/what-is-a-rest-api)
 
 6- Maven 3.6.3 [Sobre](https://www.dclick.com.br/2010/09/15/o-que-e-o-maven-e-seus-primeiros-passos-com-a-ferramenta/)
 
 7- PostgreSQL 9.6 [Sobre](https://www.postgresql.org/about/)
 
 

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


```
Com a API em no ar, os testes podem ser realizados, porem caso queira testar os testes de integrações e endPoints criados, será necessáio abrir o projeto no IDE-ECLIPSE e testar os itens na seguinte sequencia, no seguinte caminho src/teste/java->
1- Tipo Equipamento
2- Equipamento
3- Profissional
4- Cliente
5- Servico
Os passo acima devem ser seguidos para os testes no PostMan.
```
