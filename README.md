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
   - Na aba **Body**, clique em *row* e adicione o json o modelo abaixo e clique em *Send*
      - **{ "id": "", "nome": "Itaú" }** ou para cadastro junto com alguma agência
      - **{ "id": "", "nome": "Nubank", "agencias": [{"id": "", "num_agencia": "2021"}] }**
      ![bancoAgencia](https://user-images.githubusercontent.com/28812898/76332899-aa1cfc00-62cf-11ea-9055-974994474917.png)
- Cadastro de uma Agência que pertence a uma instituição:
   - Enviar requisição do tipo POST com a url: http://localhost:8090/apibanco/agencia/cadastrar
   - Na aba **Authorization** selecionar o type *Bearer Token*, coloque seu token e clique em Preview Request
   - Na aba **Body**, clique em *row* e adicione o json o modelo abaixo e clique em *Send*
      - **{ "id": "", "num_agencia": "2020-1", "banco_id": "160"}**
      ![agencia](https://user-images.githubusercontent.com/28812898/76337341-fbc88500-62d5-11ea-93ce-330c8f6c47a0.png)
- Cadastro de Clientes juntmente com uma conta bancária:
   - Enviar requisição do tipo POST com a url: http://localhost:8090/apibanco/cliente/cadastrar
   - Na aba **Authorization** selecionar o type *Bearer Token*, coloque seu token e clique em Preview Request
   - Na aba **Body**, clique em *row* e adicione o json o modelo abaixo e clique em *Send*
      - **{	"id": "0", "login":"julio@gmail", "nome": "julio Silva", "senha": "1234", "cpf": "34449902009",
	         "endereco": "Dirceu II", "telefones":[{ "id": "0", "numero": "(86)99978-4512"}],
	         "contas":[{  "id": "0", "num_conta": "2020-2", "tipoconta": [{ "id": "0", "descricao": "conjunta"}]
			     }], "agencia_id": "183"} **
     ![cliente2](https://user-images.githubusercontent.com/28812898/76375122-cc406980-6323-11ea-84d5-8c6bf1e2b1ac.png)
- Extrato bancário mostrando a movimentação bancária de uma conta:
   - Enviar requisição do tipo GET com a url: http://localhost:8090/apibanco/extrato
   - Na aba **Authorization** selecionar o type *Bearer Token*, coloque seu token e clique em Preview Request
   
- Saque:
   - Enviar requisição do tipo POST com a url: http://localhost:8090/apibanco/conta/saque
   - Na aba **Authorization** selecionar o type *Bearer Token*, coloque seu token e clique em Preview Request
   - Na aba **Body**, clique em *row* e adicione o json o modelo abaixo e clique em *Send*
     - **{{ "num_conta": "0000-2", "valor": "200.0"}**
}
- Deposito:
   - Enviar requisição do tipo POST com a url: http://localhost:8090/apibanco/conta/deposito
   - Na aba **Authorization** selecionar o type *Bearer Token*, coloque seu token e clique em Preview Request
   - Na aba **Body**, clique em *row* e adicione o json o modelo abaixo e clique em *Send*
   	- **{{ "num_contaorigem": "0000-2", "num_contadestino": "2020-2", "valor": "100.0"}**
	![deposito](https://user-images.githubusercontent.com/28812898/76375768-5fc66a00-6325-11ea-9b0b-bb8e5f6e7ce3.png)
}
- Transferência:
   - Enviar requisição do tipo POST com a url: http://localhost:8090/apibanco/conta/transferencia
   - Na aba **Authorization** selecionar o type *Bearer Token*, coloque seu token e clique em Preview Request
   - Na aba **Body**, clique em *row* e adicione o json o modelo abaixo e clique em *Send*
      - **{{ "valor": "50.0", "num_contaorigem": "2020-2", "num_contadestino": "0000-2"}**
![transferencia](https://user-images.githubusercontent.com/28812898/76378628-ad92a080-632c-11ea-8b9f-45bbc165b5bd.png)
