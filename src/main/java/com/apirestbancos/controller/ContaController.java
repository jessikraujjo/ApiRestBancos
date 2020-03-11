package com.apirestbancos.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestbancos.model.Agencia;
import com.apirestbancos.model.Banco;
import com.apirestbancos.model.Cliente;
import com.apirestbancos.model.Conta;
import com.apirestbancos.model.Extrato;
import com.apirestbancos.model.TipoConta;
import com.apirestbancos.repository.ClienteRepository;
import com.apirestbancos.repository.ContaRepository;
import com.apirestbancos.repository.ExtratoRepository;



@RestController 
@RequestMapping(value = "/conta")
public class ContaController {
	
	@Autowired 
	private ContaRepository contarepository;
	@Autowired 
	private ExtratoRepository extratorepository;
	@Autowired 
	private ClienteRepository clienterepository;
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity <List<Conta>>conta() throws InterruptedException {
		List<Conta> list = (List<Conta>) contarepository.findAll();
		
		return new ResponseEntity<List<Conta>>(list, HttpStatus.OK);

	}
	
	@PostMapping(value = "/cadastrar", produces = "application/json")
	public ResponseEntity<Conta>cadastrar(@RequestBody String jsonconta, Conta conta){
		
		Agencia agencia = new Agencia();
		JSONObject obj = new JSONObject(jsonconta);
		agencia.setId(Long.parseLong(obj.getString("agencia_id")));
		conta.setAgencia(agencia);
		Conta contaSalva = contarepository.save(conta);
		return new ResponseEntity<Conta>(contaSalva, HttpStatus.OK);
	}	
	
	@PostMapping(value = "/saque", produces = "application/json")
	public ResponseEntity<Extrato>saque(@RequestBody String jsonsaque){
		
		JSONObject obj = new JSONObject(jsonsaque);
		Extrato extrato = new Extrato();
		String data = new String();
		data = extrato.dataModificada();
		extrato.setTransacao("Saque");
		extrato.setData(data);
		
		@SuppressWarnings("deprecation")
		Double valor = new Double(obj.getString("valor"));
		extrato.setValor(valor);
		
		//pegando o saldo atual pelo numero da conta
		Conta contaOrigem = contarepository.findUserByConta(obj.getString("num_conta"));
		if(contaOrigem.getSaldo() == null || contaOrigem.getSaldo() <=0 ) {
			ResponseEntity.ok("Saldo insuficiente !");
		}
		valor = contaOrigem.getSaldo() - valor; 
		extrato.setContaorigem(contaOrigem);
		contaOrigem.setSaldo(valor);
		
		Conta contaDestino = contaOrigem;
		extrato.setContadestino(contaDestino);
		
		Extrato extratoSalvo = extratorepository.save(extrato);
		return new ResponseEntity<Extrato>(extratoSalvo, HttpStatus.OK);
	}
	@PostMapping(value = "/deposito", produces = "application/json")
	public ResponseEntity<Extrato>deposito(@RequestBody String jsonsaque){
		
		JSONObject obj = new JSONObject(jsonsaque);
		Extrato extrato = new Extrato();
		String data = new String();
		data = extrato.dataModificada();
		extrato.setTransacao("Deposito");
		extrato.setData(data);
		
		@SuppressWarnings("deprecation")
		Double valor = new Double(obj.getString("valor"));
		System.out.println("valor: "+ valor);
		extrato.setValor(valor);
		
		Conta contaOrigem = contarepository.findUserByConta(obj.getString("num_contaorigem"));
		extrato.setContaorigem(contaOrigem); //setando conta que esta fazendo a transacao
		Conta contaDestino = contarepository.findUserByConta(obj.getString("num_contadestino"));
		valor = valor + contaDestino.getSaldo(); 
		extrato.setContadestino(contaDestino);
		contaDestino.setSaldo(valor);
				
		Extrato extratoSalvo = extratorepository.save(extrato);
		return new ResponseEntity<Extrato>(extratoSalvo, HttpStatus.OK);
	}
	@PostMapping(value = "/transferencia", produces = "application/json")
	public ResponseEntity<Extrato>transferencia(@RequestBody String jsonsaque){
		
		JSONObject obj = new JSONObject(jsonsaque);
		Extrato extrato = new Extrato();
		String data = new String();
		data = extrato.dataModificada();
		extrato.setTransacao("Transferencia");
		extrato.setData(data);
		
		@SuppressWarnings("deprecation")
		Double valorOrigem = new Double(obj.getString("valor"));
		@SuppressWarnings("deprecation")
		Double valorDestino = new Double(obj.getString("valor"));
		extrato.setValor(valorOrigem);
		
		Conta contaOrigem = contarepository.findUserByConta(obj.getString("num_contaorigem"));
		extrato.setContaorigem(contaOrigem);
		valorOrigem = contaOrigem.getSaldo() - valorOrigem; 
		contaOrigem.setSaldo(valorOrigem);
		
		Conta contaDestino = contarepository.findUserByConta(obj.getString("num_contadestino"));
		extrato.setContadestino(contaDestino);
		valorDestino = valorDestino + contaDestino.getSaldo(); 
		contaDestino.setSaldo(valorDestino);
				
		Extrato extratoSalvo = extratorepository.save(extrato);
		return new ResponseEntity<Extrato>(extratoSalvo, HttpStatus.OK);
	}
}

