# Desafio: CRUD de clientes

### Descrição

Este projeto é uma aplicação Spring Boot que gerencia clientes. Ele fornece endpoints para criar, atualizar, deletar e
listar clientes.

### Requisitos

- Java 21

### Instruções de Execução

1. Clone o repositório:
   ```sh
   git clone https://github.com/dluks-learning/ds-jsp03.git
   cd ds-jsp03
   ```

2. Instale as dependências usando o Maven Wrapper:
   ```sh
   ./mvnw clean install
   ```

3. Execute a aplicação usando o Maven Wrapper:
   ```sh
   ./mvnw spring-boot:run
   ```

### Endpoints

#### Listar todos os clientes

```sh
curl -X GET http://localhost:8080/clients
```

#### Buscar cliente por ID

```sh
curl -X GET http://localhost:8080/clients/{id}
```

#### Inserir um novo cliente

```sh
curl -X POST http://localhost:8080/clients \
-H "Content-Type: application/json" \
-d '{
    "name": "João Silva",
    "cpf": "12345678901",
    "income": 4500.00,
    "birthDate": "1985-05-12",
    "children": 2
}'
```

#### Atualizar um cliente existente

```sh
curl -X PUT http://localhost:8080/clients/{id} \
-H "Content-Type: application/json" \
-d '{
    "name": "João Silva Atualizado",
    "cpf": "12345678901",
    "income": 5000.00,
    "birthDate": "1985-05-12",
    "children": 2
}'
```

#### Deletar um cliente

```sh
curl -X DELETE http://localhost:8080/clients/{id}
```

Substitua `{id}` pelo ID do cliente que você deseja buscar, atualizar ou deletar.

### Licença

Este projeto é licenciado sob a Licença MIT. Veja o arquivo `LICENSE` para mais detalhes.