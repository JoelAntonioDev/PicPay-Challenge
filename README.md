
# Desafio Backend - Sistema de Pagamentos

## Índice
- [Descrição](#descrição)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Instalação e Execução](#instalação-e-execução)
- [Endpoints da API](#endpoints-da-api)
- [Testes](#testes)
- [Contribuição](#contribuição)
- [Licença](#licença)

---

## Descrição
Este projeto é uma solução para o desafio backend da PicPay, implementada com **Spring Boot**. A aplicação simula um sistema de pagamentos que permite realizar transferências entre usuários e consultas de saldo. A solução é organizada em uma arquitetura limpa e escalável, com segurança e validações de dados.

## Funcionalidades
- Transferência entre contas de usuários.
- Validações para garantir transações seguras e precisas.

## Tecnologias Utilizadas
- **Java 11+**
- **Spring Boot** - para estrutura do projeto.
- **Spring Data JPA** - para a camada de persistência.
- **H2 Database** - banco de dados em memória para desenvolvimento e testes.

## Estrutura do Projeto
A estrutura básica do projeto é a seguinte:

```
├── src
│   ├── main
│   │   ├── java/com/project/picpayexec
│   │   │   ├── controllers         # Controllers REST
│   │   │   ├── domain              # camada de domínio
|   |   |   |   ├── enums           # enums
|   |   |   |   ├── model           # Modelos de Entidade
|   |   |   ├── dtos                # Objectos de transferência de dados
|   |   |   ├── infra               # Infraestrutura
|   |   |   |   ├── configurations  # Camada para as configurações
|   |   |   |   ├── exceptions      # Execeções personalizadas
│   │   │   ├── repository        # Repositórios (JPA)
│   │   │   ├── service           # Serviços de negócio
│   │   └── resources
│   │       ├── application.properties # Configurações do projeto
│   └── test/java/com/exemplo/picpay  # Testes automatizados
```

## Instalação e Execução
1. Clone o repositório:
   ```bash
   git clone https://github.com/JoelAntonioDev/PicPay-Challenge.git
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd PicPay-Challenge
   ```
3. Instale as dependências e compile o projeto:
   ```bash
   mvn clean install
   ```
4. Inicie a aplicação:
   ```bash
   mvn spring-boot:run
   ```
5. Acesse a API em [`http://localhost:8080`](http://localhost:8080).

## Endpoints da API
A API oferece os seguintes endpoints (a documentação detalhada está disponível com o Swagger em `/swagger-ui.html`):

- `POST /users` - Cadastro de novos usuários.
- `GET /users` - Obter os usuários.
- `GET /users/{id}` - Obter o usuário com o id passado.
- `POST /transactions` - Realiza transferência entre contas.


## Contribuição
Contribuições são bem-vindas! Siga estas etapas para contribuir:
1. Faça um fork do repositório.
2. Crie uma nova branch com suas alterações:
   ```bash
   git checkout -b minha-nova-funcionalidade
   ```
3. Faça commit das suas alterações:
   ```bash
   git commit -m "Descrição da nova funcionalidade"
   ```
4. Envie suas alterações:
   ```bash
   git push origin minha-nova-funcionalidade
   ```
5. Abra um Pull Request.
