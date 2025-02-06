# Desafio Objective Bank

1. **Pré-requisitos**:
    - Java 17
    - MongoDB

2. **Configuração**:
    - Clone o repositório.
    - Configure o MongoDB no arquivo `application.properties`, por exemplo: spring.data.mongodb.uri=mongodb://localhost:27017/objectiveBank

3. **Execução**:
    - Execute a aplicação Spring Boot.

4. **Endpoints**:
    - `POST /account`: Cria uma nova conta.
    - `POST /transaction`: Realiza uma transação financeira.
    - `GET /account?accountNumber=234`: Retorna informações da conta.

**Exemplos de Json:**

- Para criar uma conta nova:
    {
        "accountNumber": 122,
        "balance": 19876.56
    }
    
- Para fazer uma transação:
   {
       "paymentMethod": "P",
       "accountNumber": 123,
       "value": 10
   }
