
# 📌 Sistema de Agendamento de Transferências 
## 🏗 Visão Geral do Projeto
#### Este projeto consiste em um sistema de agendamento de transferências financeiras, utilizando Spring Boot para o backend e Vue.js para o frontend. O sistema permite que os usuários agendem transferências entre contas bancárias, calculando taxas conforme regras predefinidas.
# 🛠 Technologies
## Back-end
##### - Spring Boot 3
##### - Spring Data JPA
##### - Spring Web
##### - Maven
##### - H2 Database
## Front-end
##### - Vue 3
##### - Vue Router
##### - Axios
##### - Bootstrap

# 📂 Estrutura de Pastas
## Backend (Spring Boot)
```
backend/
├── src/main/java/com/exemplo/agendamento/
│   ├── controller/   # Controllers REST
│   ├── model/        # Entidades do banco
│   ├── repository/   # Interfaces do JPA
│   ├── service/      # Regras de negócio
│   ├── dto/          # Transfer Objects
│   ├── Application.java # Classe principal (main)
│
├── src/main/resources/
│   ├── application.properties  # Configuração do Spring Boot
```
## Frontend (Vue.js)
```
frontend/
├── src/
│   ├── components/       # Componentes Vue (TransferForm, TransferList)
│   ├── views/            # Páginas principais (HomeView.vue)
│   ├── router/           # Configuração de rotas
│   ├── main.js           # Arquivo principal do Vue
│   ├── App.vue           # Componente raiz
│
├── public/               # Arquivos estáticos
├── package.json          # Dependências do frontend
```

# 🛠 Como Rodar o Projeto

## Back-End
Pre requisitos: Java 11

```
# Clone repository
$ git clone https://github.com/Rafaelxndre/agendamento-transferencias.git

# Enter the project back-end folder
$ cd backend

# Run project
$ ./mvnw spring-boot:run

# A API estará disponível em:
$ http://localhost:8080

# Acessar o banco de dados H2:
$ http://localhost:8080/h2-console
```

## Front-End
Pre requisitos: npm 

```
# Clone repository
$ git clone https://github.com/Rafaelxndre/agendamento-transferencias.git

# Enter the project front-end folder
$ cd frontend

# Install dependencies
$ npm install

# Run project
$ npm runserve

# Access localhost
http://localhost:3000
```

# 📌 Como Testar a API
## Testando a API pelo Postman
**Endpoint:**  
##### | `POST` | Criar uma nova transferência: |
`POST http://localhost:8080/transferencias`
**Headers:**  
`Content-Type: application/json`
**Body:**
```json
{
  "contaOrigem": "1234567890",
  "contaDestino": "0987654321",
  "valor": 1000.00,
  "dataTransferencia": "2025-03-22"
}
```
**Endpoint:**  
##### | `GET` | Buscar todas as transferências: |
`GET http://localhost:8080/transferencias`

# 🏠 Pagina Inicial
![Image](https://github.com/user-attachments/assets/7f199ee5-55a8-4994-9259-21acf77776f6)
# ✔️ Cadastro transferência
![Image](https://github.com/user-attachments/assets/717556cc-0292-46d8-8cdb-d4a3dfa94c4d)
# 🚨 Alerta transferência
![Image](https://github.com/user-attachments/assets/4fd38353-1487-4a0e-b760-671aed5ca2db)
![Image](https://github.com/user-attachments/assets/3fec9089-6d27-4b94-802b-84f6ceeb3489)


### Author: Rafael Alexandre Das Graças

https://www.linkedin.com/in/rafaelxndre/
