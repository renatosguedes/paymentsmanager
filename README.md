# Serviço gerenciador de fluxo de pagamentos
## Este serviço serve para controle do fluxo de pagamentos de uma securitizadora.
### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Java 21](https://www.oracle.com/br/java/technologies/downloads/#java21), [Docker](https://www.docker.com/products/docker-desktop/).

### 🎲 Rodando o Back End (servidor)

```bash
# Clone este repositório
$ git clone https://github.com/renatosguedes/paymentsmanager.git

# Não é necessário fazer docker build, uma vez que a imagem está no meu repositório público, mas caso deseje
$ docker build --build-arg JAR_FILE=build/libs/*.jar -t renatosguedes/paymentsmanager .

# Na pasta raiz do projeto, execute os seguintes comandos
$ docker run -d -p 8080:8080 --name paymentsmanager renatosguedes/paymentsmanager

# O servidor iniciará na porta 8080 - acesse <http://localhost:8080>
```

### 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Java 21](https://www.oracle.com/br/java/technologies/downloads/#java21)
- [Docker](https://www.docker.com/)
- [Gradle](https://gradle.org/)

Feito com ❤️ por Renato Guedes 👋🏽 Entre em contato!

[![Linkedin Badge](https://img.shields.io/badge/-Renato-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/renatosguedes/)](https://www.linkedin.com/in/renatosguedes/)
[![Gmail Badge](https://img.shields.io/badge/-renato.guedes14@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:renato.guedes14@gmail.com)](mailto:renato.guedes14@gmail.com)