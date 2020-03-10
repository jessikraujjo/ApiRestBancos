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
   ![auth](https://user-images.githubusercontent.com/28812898/76329900-e9494e00-62cb-11ea-9efe-43680c92ec3d.png)
   - Na aba **Headers**, coloque na **key** Authorization e no **value** Basic, assim como a imagem.
     ![headers](https://user-images.githubusercontent.com/28812898/76329554-7b9d2200-62cb-11ea-91b5-7f7bf602e1f9.png)

   - Na aba **Body**, clique em *form-data* e deixe os campos como na imagem 
   ![body](https://user-images.githubusercontent.com/28812898/76329569-81930300-62cb-11ea-903e-0b31e5207175.png)
   
   - Logo após é só clicar em Send, e com o token em mãos, você ja pode fazer suas requisições.
2. Requisições
- Cadastro de uma Instituição financeira:
   - Enviar requisição do tipo POST com a url: http://localhost:8090/apibanco/banco/cadastrar
   - Na aba **Authorization** selecionar o type *Bearer Token*, coloque seu token e clique em Preview Request
   - Na aba **Body**, clique em *row* e adicione o json no modelo abaixo e clique em *Send*
      - **{ "id": "", "nome": "Itaú" }** ou para cadastro junto com alguma agência
      - **{ "id": "", "nome": "Nubank", "agencias": [{"id": "", "num_agencia": "2021"}] }**
      ![bancoAgencia](https://user-images.githubusercontent.com/28812898/76332899-aa1cfc00-62cf-11ea-9055-974994474917.png)
- Cadastro de uma Agência que pertence a uma instituição:
   - Enviar requisição do tipo POST com a url: http://localhost:8090/apibanco/agencia/cadastrar
   - Na aba **Authorization** selecionar o type *Bearer Token*, coloque seu token e clique em Preview Request
   - Na aba **Body**, clique em *row* e adicione o json no modelo abaixo e clique em *Send*
      - **{ "id": "", "num_agencia": "2020-1", "banco_id": "160"}**
- Cadastro de Clientes juntmente com uma conta bancária:
   - Enviar requisição do tipo POST com a url: http://localhost:8090/apibanco/cliente/cadastrar
   - Na aba **Authorization** selecionar o type *Bearer Token*, coloque seu token e clique em Preview Request
   - Na aba **Body**, clique em *row* e adicione o json no modelo abaixo e clique em *Send*
      - **{ "id": "", "num_agencia": "2020-1", "banco_id": "160"}**
