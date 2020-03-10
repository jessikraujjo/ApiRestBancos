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
   - Na aba **Headers**, coloque na **key** Authorization e no **value** Basic, assim como a imagem.
     ![headers](https://user-images.githubusercontent.com/28812898/76329554-7b9d2200-62cb-11ea-91b5-7f7bf602e1f9.png)

   - Na aba **Body**, clique em *form-data* e deixe os campos como na imagem 
   ![body](https://user-images.githubusercontent.com/28812898/76329569-81930300-62cb-11ea-903e-0b31e5207175.png)
   - Logo após é só clicar em send.
2. Requisições
