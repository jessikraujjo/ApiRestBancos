# ApiRestBancos
API Rest genérica para serviços bancários.
## Ferramentas: 
- PostgreSQL -> 3.6.16; 
- PgAdmin 3 -> 1.22.2;
- Spring-tool-suite -> 3.6.10; 
- Postman ou Insomnia; 
- Java-11.
## Autenticação para requisições
1. Solicitar token
   - Enviar requisição do tipo POST com a url: http://localhost:8090/oauth/token
   - Na aba **Authorization** selecionar o type *Basic Auth* com *username*: admin e *password*:123, depois clique em Preview Request
   - Na aba **Body**, clique em *form-data*, no campo **key** adicione *grant-type* 
  Requisições
