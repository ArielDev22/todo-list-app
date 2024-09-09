# Projeto To-Do List

> Este é um projeto de uma aplicação Todo List desenvolvida com Spring Boot.  
> A aplicação permite gerenciar uma lista de
> tarefas com funcionalidades de CRUD (Create, Read, Update, Delete), além de fornecer opções para ordenar e buscar
> tarefas com base em data, prioridade e nome.

## Índice

- [Funcionalidades](#funcionalidades)
- [Arquitetura](#arquitetura)
- [Endpoints](#endpoints)
- [Instalação](#instalação)
- [Configuração](#configuração)
- [Contato](#contato)

## Funcionalidades

- CRUD de Tarefas: Crie, visualize, atualize e delete tarefas.
- Validação de dados
- Ordenação de tarefas:
    - Por nome
    - Por data da tarefa
    - Por prioridade
- Busca de tarefas:
    - Por nome
    - Por data da tarefa
    - Por prioridade

## Arquitetura

> O sistema de tarefas foi desenvolvido seguindo o modelo de arquitetura de pacotes MVC.

## Principais Camadas

### 1. Camada Model

- **Descrição**: Contém a entidade do sistema.

### 2. Camada Repository

- **Descrição**: Interface responsável pela interação com o banco de dados.

### 3. Camada Controller

- **Descrição**: Controlador REST que lida com as requisições HTTP.

### 3. Camada Service

- **Descrição**: Implementa as regras de negócio do sistema e as validações.

## Endpoints

- **POST /todos**: Cria uma nova tarefa
- **GET /todos**: retorna todas as tarefas ordenadas
- **GET /todos/nome?nome=nome_da_tarefa**: Busca todas as tarefas pelo nome passado como parâmetro
- **GET /todos/date?date=data_da_tarefa**: Busca todas as tarefas pela data da tarefa passada como parâmetro
- **GET /todos/priority?priority=prioidade_da_tarefa**: Busca todas as tarefas pela prioridade passada como parâmetro
- **PUT /todos**: Atualiza uma tarefa existente
- **DELETE /todos/{id}**: Deleta uma tarefa pelo id

## Instalação

### Pré-requisitos

> Certifique-se de que você tenha as seguintes ferramentas instaladas:

- [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [MySQL](https://dev.mysql.com/downloads/installer/) ou outro banco de dados relacional compatível
- [MySQL Workbench](https://dev.mysql.com/downloads/workbench/)
- [JDBC](https://downloads.mysql.com/archives/c-j/)

### Configuração

> A aplicação irá usar o H2 Database por padrão para desevolvimento e testes (URL de
> acesso: http://localhost:8080/h2-console).  
> Para usar o MySQL, configure as credenciais do banco de dados no arquivo **application.properties** no diretório *
*resources**:  
> spring.datasource.url=jdbc:mysql://localhost:3306/todos_db  
> spring.datasource.username=seu-usuario  
> spring.datasource.password=sua-senha  
> spring.jpa.hibernate.ddl-auto=update

### Clonar o repositório

- **SSH**: git clone git@github.com:ArielDev22/todo-list-app.git
- **HTTPS**: git clone https://github.com/ArielDev22/todo-list-app.git

## Contato:

- **Email**: ariel.dev22@gmail.com
- **Link do projeto**: https://github.com/ArielDev22/todo-list-app
